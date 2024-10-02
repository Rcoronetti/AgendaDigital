package com.coronetti.agendadigital.ui.tarefas.criacaoTarefas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.coronetti.agendadigital.R;

public class CriacaoTarefasFragment extends Fragment {

    // Definindo os elementos da interface
    private Spinner spinnerTipoDestinatario;
    private Spinner spinnerTurma;
    private Spinner spinnerDisciplina;
    private EditText editTextData;
    private EditText editTextNome;
    private EditText editTextTitulo;
    private EditText editTextDescricao;
    private ImageButton buttonAnexar;

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
        buttonAnexar = view.findViewById(R.id.buttonAnexar);

        // Declare buttonEnviar como uma variável local
        Button buttonEnviar = view.findViewById(R.id.buttonEnviar); // Mudamos aqui para ser uma variável local

        // Lógica para o botão de enviar
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementar lógica para enviar a tarefa
            }
        });

        return view;
    }
}
