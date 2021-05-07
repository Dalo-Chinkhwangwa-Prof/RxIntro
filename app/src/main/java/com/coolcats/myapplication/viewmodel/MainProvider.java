package com.coolcats.myapplication.viewmodel;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainProvider implements ViewModelProvider.Factory {

    private MainProvider(){}
    private static MainProvider instance;

    private UserViewModel userViewModel;

    public static MainProvider getInstance() {
        if(instance == null)
            instance = new MainProvider();
        return instance;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if(userViewModel == null)
            userViewModel = new UserViewModel();
        return (T)userViewModel;
    }
}
