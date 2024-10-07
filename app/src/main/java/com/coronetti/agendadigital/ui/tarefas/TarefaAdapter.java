package com.coronetti.agendadigital.ui.tarefas;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.coronetti.agendadigital.R;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.fragment_item_tarefa, parent, false);
        }

        // Obtém a tarefa atual
        Tarefa tarefa = tarefas.get(position);

        // Configura os elementos
        TextView textTitulo = convertView.findViewById(R.id.textTitulo);
        TextView textTurma = convertView.findViewById(R.id.textTurma);
        TextView textData = convertView.findViewById(R.id.textData);
        TextView textDisciplina = convertView.findViewById(R.id.textDisciplina);
        TextView textStatus = convertView.findViewById(R.id.textStatus);
        Button buttonExcluir = convertView.findViewById(R.id.buttonExcluir);
        Button btnAlterarStatus = convertView.findViewById(R.id.btnAlterarStatus);

        // Define os valores para os TextViews
        textTitulo.setText(tarefa.getTitulo());
        textTurma.setText(tarefa.getTurma());
        textData.setText(tarefa.getData());
        textDisciplina.setText(tarefa.getDisciplina());
        textStatus.setText(tarefa.getStatus());

        // Ação para excluir a tarefa
        buttonExcluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Exibe um AlertDialog de confirmação
                new AlertDialog.Builder(context)
                        .setTitle("Excluir Tarefa")
                        .setMessage("Você tem certeza que deseja excluir esta tarefa?")
                        .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                // Remover a tarefa da lista
                                tarefas.remove(position);
                                // Notifica o adapter da alteração
                                notifyDataSetChanged();
                                // Atualiza o SharedPreferences
                                atualizarSharedPreferences();
                            }
                        })
                        .setNegativeButton("Não", null)
                        .show();
            }
        });

        // Ação para editar o status
        btnAlterarStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Exibe um AlertDialog para escolher o novo status
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Alterar Status");

                // Opções de status
                String[] statusOptions = {"Em andamento", "Concluído", "Cancelada", "Encerrada"};

                builder.setItems(statusOptions, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Atualiza o status da tarefa com a opção escolhida
                        String novoStatus = statusOptions[which];
                        tarefa.setStatus(novoStatus);
                        textStatus.setText(novoStatus);
                    }
                });

                builder.show();
            }
        });

        return convertView;
    }

    private void atualizarSharedPreferences() {
        SharedPreferences prefs = context.getSharedPreferences("tarefas", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        // Salva a lista atualizada de tarefas no SharedPreferences
        Gson gson = new Gson();
        editor.putString("lista_tarefas", gson.toJson(tarefas));
        editor.apply();
    }
}
