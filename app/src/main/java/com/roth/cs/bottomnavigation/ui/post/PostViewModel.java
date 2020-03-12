package com.roth.cs.bottomnavigation.ui.post;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class PostViewModel {
    private MutableLiveData<String> mText;

    public PostViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is university fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
