package com.coronetti.agendadigital.ui.tarefas.criacaoTarefas;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.coronetti.agendadigital.R;

public class CriacaoDeTarefasActivity extends AppCompatActivity {

    private Spinner spinnerTipoDestinatario;
    private Spinner spinnerTurma;
    private Spinner spinnerDisciplina;
    private EditText editTextData, editTextNome, editTextTitulo, editTextDescricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_criacao_tarefas);

        spinnerTipoDestinatario = findViewById(R.id.spinnerTipoDestinatario);
        spinnerTurma = findViewById(R.id.spinnerTurma);
        spinnerDisciplina = findViewById(R.id.spinnerDisciplina);
        editTextData = findViewById(R.id.editTextData);
        editTextNome = findViewById(R.id.editTextNome);
        editTextTitulo = findViewById(R.id.editTextTitulo);
        editTextDescricao = findViewById(R.id.editTextDescricao);

        // Dados para o spinnerTipoDestinatario
        String[] tiposDestinatarios = {
                getString(R.string.destinatario_aluno),
                getString(R.string.destinatario_pais),
                getString(R.string.destinatario_professor)
        };

        // Adapter para spinnerTipoDestinatario
        ArrayAdapter<String> adapterDestinatario = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, tiposDestinatarios);
        adapterDestinatario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoDestinatario.setAdapter(adapterDestinatario);

        // Dados para o spinnerTurma
        String[] turmas = {
                getString(R.string.turma1),
                getString(R.string.turma2),
                getString(R.string.turma3)
        };

        // Adapter para spinnerTurma
        ArrayAdapter<String> adapterTurma = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, turmas);
        adapterTurma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTurma.setAdapter(adapterTurma);

        // Dados para o spinnerDisciplina
        String[] disciplinas = {
                getString(R.string.disciplina1),
                getString(R.string.disciplina2),
                getString(R.string.disciplina3)
        };

        // Adapter para spinnerDisciplina
        ArrayAdapter<String> adapterDisciplina = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, disciplinas);
        adapterDisciplina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDisciplina.setAdapter(adapterDisciplina);

        Button buttonEnviar = findViewById(R.id.buttonEnviar);
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Capturando os dados selecionados
                String tipoSelecionado = spinnerTipoDestinatario.getSelectedItem().toString();
                String turmaSelecionada = spinnerTurma.getSelectedItem().toString();
                String disciplinaSelecionada = spinnerDisciplina.getSelectedItem().toString();
                String data = editTextData.getText().toString();
                String nome = editTextNome.getText().toString();
                String titulo = editTextTitulo.getText().toString();
                String descricao = editTextDescricao.getText().toString();

                // Lógica para enviar a tarefa
                enviarTarefa(tipoSelecionado, turmaSelecionada, disciplinaSelecionada, data, nome, titulo, descricao);
            }
        });
    }

    private void enviarTarefa(String tipoDestinatario, String turma, String disciplina, String data, String nome, String titulo, String descricao) {
        Toast.makeText(this, "Tarefa criada com sucesso!", Toast.LENGTH_SHORT).show();

        // Limpando os campos do formulário
        spinnerTipoDestinatario.setSelection(0);
        spinnerTurma.setSelection(0);
        spinnerDisciplina.setSelection(0);
        editTextData.setText("");
        editTextNome.setText("");
        editTextTitulo.setText("");
        editTextDescricao.setText("");
    }
}
