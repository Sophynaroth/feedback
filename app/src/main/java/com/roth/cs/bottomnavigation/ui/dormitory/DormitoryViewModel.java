package com.roth.cs.bottomnavigation.ui.dormitory;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class DormitoryViewModel {
    private MutableLiveData<String> mText;

    public DormitoryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is university fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
