package com.coronetti.agendadigital.ui.tarefas.criacaoTarefas;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.coronetti.agendadigital.R;
import com.coronetti.agendadigital.ui.tarefas.Tarefa;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import android.content.Context;
import android.content.SharedPreferences;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

public class CriacaoTarefasFragment extends Fragment {

    private Spinner spinnerTipoDestinatario;
    private Spinner spinnerTurma;
    private Spinner spinnerDisciplina;
    private EditText editTextData;
    private EditText editTextNome;
    private EditText editTextTitulo;
    private EditText editTextDescricao;
    private ImageButton buttonAnexar;
    private Button buttonEnviar;

    private Calendar calendar;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_criacao_tarefas, container, false);

        // Inicializando os elementos
        spinnerTipoDestinatario = view.findViewById(R.id.spinnerTipoDestinatario);
        spinnerTurma = view.findViewById(R.id.spinnerTurma);
        spinnerDisciplina = view.findViewById(R.id.spinnerDisciplina);
        editTextData = view.findViewById(R.id.editTextData);
        editTextNome = view.findViewById(R.id.editTextNome);
        editTextTitulo = view.findViewById(R.id.editTextTitulo);
        editTextDescricao = view.findViewById(R.id.editTextDescricao);
        buttonEnviar = view.findViewById(R.id.buttonEnviar);

        calendar = Calendar.getInstance(); // Inicializa o calendário

        // Configurando o campo de data para abrir o DatePickerDialog
        editTextData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(getContext(), dateSetListener,
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        // Preenchendo os spinners com dados do strings.xml (mesma lógica que você já tem)
        ArrayAdapter<CharSequence> adapterTipoDestinatario = ArrayAdapter.createFromResource(
                getContext(),
                R.array.tipo_destinatario_array,
                android.R.layout.simple_spinner_item);
        adapterTipoDestinatario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoDestinatario.setAdapter(adapterTipoDestinatario);

        ArrayAdapter<CharSequence> adapterTurma = ArrayAdapter.createFromResource(
                getContext(),
                R.array.turmas_array,
                android.R.layout.simple_spinner_item);
        adapterTurma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTurma.setAdapter(adapterTurma);

        ArrayAdapter<CharSequence> adapterDisciplina = ArrayAdapter.createFromResource(
                getContext(),
                R.array.disciplinas_array,
                android.R.layout.simple_spinner_item);
        adapterDisciplina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDisciplina.setAdapter(adapterDisciplina);

        // Configurando o clique no botão de enviar
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Capturando os dados
                String titulo = editTextTitulo.getText().toString();
                String turma = spinnerTurma.getSelectedItem().toString();
                String data = editTextData.getText().toString();
                String disciplina = spinnerDisciplina.getSelectedItem().toString();
                String status = "em andamento"; // Status inicial

                // Criando a nova tarefa
                Tarefa novaTarefa = new Tarefa(titulo, turma, data, disciplina, status);

                // Salvando a tarefa
                salvarTarefa(novaTarefa);

                // Limpar os campos e mostrar o retorno
                limparCampos();
                Toast.makeText(getContext(), "Tarefa criada com sucesso!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }

    // Listener para quando o usuário selecionar a data
    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            editTextData.setText(dateFormat.format(calendar.getTime()));
        }
    };

    private void salvarTarefa(Tarefa tarefa) {
        SharedPreferences prefs = getActivity().getSharedPreferences("tarefas", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();

        // Carregando a lista atual de tarefas
        String json = prefs.getString("lista_tarefas", "[]");
        List<Tarefa> listaTarefas = gson.fromJson(json, new TypeToken<List<Tarefa>>(){}.getType());

        // Adicionando a nova tarefa à lista
        listaTarefas.add(tarefa);

        // Salvando a lista atualizada no SharedPreferences
        editor.putString("lista_tarefas", gson.toJson(listaTarefas));
        editor.apply();
    }

    private void limparCampos() {
        spinnerTipoDestinatario.setSelection(0);
        spinnerTurma.setSelection(0);
        spinnerDisciplina.setSelection(0);
        editTextData.setText("");
        editTextNome.setText("");
        editTextTitulo.setText("");
        editTextDescricao.setText("");
    }
}
