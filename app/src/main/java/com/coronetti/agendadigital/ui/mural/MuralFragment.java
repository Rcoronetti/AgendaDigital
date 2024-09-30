package com.coronetti.agendadigital.ui.mural;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.coronetti.agendadigital.databinding.FragmentMuralBinding;

public class MuralFragment extends Fragment {

    private FragmentMuralBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        MuralViewModel muralViewModel =
                new ViewModelProvider(this).get(MuralViewModel.class);

        binding = FragmentMuralBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textMural;
        muralViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
