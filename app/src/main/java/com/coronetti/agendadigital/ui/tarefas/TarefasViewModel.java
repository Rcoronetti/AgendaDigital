package com.coronetti.agendadigital.ui.tarefas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TarefasViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TarefasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}