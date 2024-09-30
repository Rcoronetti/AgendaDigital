package com.coronetti.agendadigital.ui.comunicacao;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.coronetti.agendadigital.databinding.FragmentComunicacaoBinding;

public class ComunicacaoFragment extends Fragment {

    private FragmentComunicacaoBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ComunicacaoViewModel comunicacaoViewModel =
                new ViewModelProvider(this).get(ComunicacaoViewModel.class);

        binding = FragmentComunicacaoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textComunicacao;
        comunicacaoViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}