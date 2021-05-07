package com.coolcats.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.coolcats.myapplication.model.User;
import com.coolcats.myapplication.view.UserAdapter;
import com.coolcats.myapplication.viewmodel.MainProvider;
import com.coolcats.myapplication.viewmodel.UserViewModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class MainActivity extends AppCompatActivity {

    //Types of Observables in RxJava
    //Observable - emit 1 to many emissions
    //Single - emit 1  emission
    //Flowable - just like the observable but with back pressure handling

    //Maybe - can emit multiple or none at all
    //Completable - returns success or failure

    private Single<String> stringSingle = Single.just("123456");

    private Observable<String> stringObservable = Observable.just("Dalo", "Chinkhwangwa");

    private Flowable<String> stringFlowable = Flowable.just("Dalo", "Chinkhwangwa", "Tony");

    private UserViewModel userViewModel;

    private UserAdapter userAdapter = new UserAdapter(new ArrayList<>());

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.user_recyclerview);
        recyclerView.setAdapter(userAdapter);

        Log.d("TAG_X", "Activity thread "+Thread.currentThread().getId());
        userViewModel = MainProvider.getInstance().create(UserViewModel.class);

        userViewModel.getData(50);

        userViewModel.userData.observe(this, users -> {
            Log.d("TAG_X", "users retrieved..."+users.size()+ " "+Thread.currentThread().getId());
            userAdapter.setUserList(users);
        });


    }
}