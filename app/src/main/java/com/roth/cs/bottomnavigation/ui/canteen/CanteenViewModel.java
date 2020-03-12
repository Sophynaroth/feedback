package com.roth.cs.bottomnavigation.ui.canteen;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class CanteenViewModel {
    private MutableLiveData<String> mText;

    public CanteenViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is university fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
