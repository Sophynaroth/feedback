package com.roth.cs.bottomnavigation.ui.university;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class UniversityViewModel{
    private MutableLiveData<String> mText;

    public UniversityViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is university fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
