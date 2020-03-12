package com.roth.cs.bottomnavigation.ui.lecturer;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class LecturerViewModel {
    private MutableLiveData<String> mText;

    public LecturerViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is university fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
