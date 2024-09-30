package com.coronetti.agendadigital.ui.mural;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MuralViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public MuralViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Este é o Mural de Avisos");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
