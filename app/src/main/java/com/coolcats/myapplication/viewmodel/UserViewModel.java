package com.coolcats.myapplication.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.coolcats.myapplication.model.User;
import com.coolcats.myapplication.model.UsersResponse;
import com.coolcats.myapplication.model.network.UsersRetrofit;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class UserViewModel extends ViewModel {

    private CompositeDisposable cD = new CompositeDisposable();

    private UsersRetrofit usersRetrofit = new UsersRetrofit();

    public MutableLiveData<List<User>> userData = new MutableLiveData<>();

    public void getData(int count) {
        cD.add(
                usersRetrofit
                        .getRandomUsers(count)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .map(UsersResponse::getUsers)
                        .subscribe(userList -> {
                                    Log.d("TAG_X", userList.size() + "on thread " + Thread.currentThread().getId() + " state " + Thread.currentThread().getState());
                                    userData.postValue(userList);
                                    cD.clear();
                                }, throwable -> {
                                    Log.d("TAG_X", "" + throwable.toString());
                                }
                        ));

    }

    @Override
    protected void onCleared() {
        cD.clear();
        super.onCleared();
    }
}
