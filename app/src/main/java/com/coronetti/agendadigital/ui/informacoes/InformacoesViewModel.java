package com.coronetti.agendadigital.ui.informacoes;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class InformacoesViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public InformacoesViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is slideshow fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}