package com.coronetti.agendadigital.ui.tarefas.acompanhamentoTarefas;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.coronetti.agendadigital.R;

import com.coronetti.agendadigital.ui.tarefas.Tarefa;
import com.coronetti.agendadigital.ui.tarefas.TarefaAdapter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class AcompanhamentoTarefasFragment extends Fragment {

    private ListView listViewTarefas; // ou qualquer componente que você use para exibir a tabela

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_acompanhamento_tarefas, container, false);

        ListView listViewTarefas = view.findViewById(R.id.listViewTarefas);

        if (listViewTarefas == null) {
            Log.e("AcompanhamentoTarefasFragment", "listViewTarefas é nulo!");
        } else {
            Log.d("AcompanhamentoTarefasFragment", "listViewTarefas encontrado com sucesso!");
            carregarTarefas(listViewTarefas); // Carregar as tarefas no ListView
        }

        return view;
    }

    private void carregarTarefas(ListView listView) {
        SharedPreferences prefs = getActivity().getSharedPreferences("tarefas", Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString("lista_tarefas", "[]");

        // Converte o JSON para uma lista de tarefas
        List<Tarefa> listaTarefas = gson.fromJson(json, new TypeToken<List<Tarefa>>() {
        }.getType());

        if (listaTarefas.isEmpty()) {
            // Exibe uma mensagem ou layout indicando que não há tarefas
            Log.d("AcompanhamentoTarefasFragment", "Nenhuma tarefa encontrada.");

        } else {
            // Cria e define o adaptador
            TarefaAdapter adapter = new TarefaAdapter(getContext(), listaTarefas);
            listView.setAdapter(adapter);
        }
    }
}

