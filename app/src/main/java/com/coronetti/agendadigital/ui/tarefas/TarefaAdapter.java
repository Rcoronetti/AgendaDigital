package com.coronetti.agendadigital.ui.tarefas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.coronetti.agendadigital.R;

import java.util.List;

public class TarefaAdapter extends ArrayAdapter<Tarefa> {
    private Context context;
    private List<Tarefa> tarefas;

    public TarefaAdapter(Context context, List<Tarefa> tarefas) {
        super(context, R.layout.fragment_item_tarefa, tarefas);
        this.context = context;
        this.tarefas = tarefas;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Verifica se a view já foi criada
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.fragment_item_tarefa, parent, false);
        }

        // Obtém a tarefa atual
        Tarefa tarefa = tarefas.get(position);

        // Configura os elementos do item_tarefa.xml
        TextView textTitulo = convertView.findViewById(R.id.textTitulo);
        TextView textTurma = convertView.findViewById(R.id.textTurma);
        TextView textData = convertView.findViewById(R.id.textData);
        TextView textDisciplina = convertView.findViewById(R.id.textDisciplina);
        TextView textStatus = convertView.findViewById(R.id.textStatus);

        // Define os valores para os TextViews
        textTitulo.setText(tarefa.getTitulo());
        textTurma.setText(tarefa.getTurma());
        textData.setText(tarefa.getData());
        textDisciplina.setText(tarefa.getDisciplina());
        textStatus.setText(tarefa.getStatus());

        return convertView;
    }
}
