package com.coronetti.agendadigital.ui.tarefas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.coronetti.agendadigital.databinding.FragmentTarefasBinding;

public class TarefasFragment extends Fragment {

    private FragmentTarefasBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TarefasViewModel tarefasViewModel =
                new ViewModelProvider(this).get(TarefasViewModel.class);

        binding = FragmentTarefasBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTarefas;
        tarefasViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}