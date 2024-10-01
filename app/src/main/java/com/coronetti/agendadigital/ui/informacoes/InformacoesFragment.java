package com.coronetti.agendadigital.ui.informacoes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.coronetti.agendadigital.databinding.FragmentInformacoesBinding;

public class InformacoesFragment extends Fragment {

    private FragmentInformacoesBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        InformacoesViewModel informacoesViewModel =
                new ViewModelProvider(this).get(InformacoesViewModel.class);

        binding = FragmentInformacoesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.textInformacoes;
        //informacoesViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}