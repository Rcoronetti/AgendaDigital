package com.coronetti.agendadigital.ui.comunicacao;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ComunicacaoViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public ComunicacaoViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}