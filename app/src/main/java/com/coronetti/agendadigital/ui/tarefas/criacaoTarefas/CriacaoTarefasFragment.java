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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;



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
    private Button buttonEnviar;

    private Calendar calendar; // Para armazenar a data selecionada

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
        buttonEnviar = view.findViewById(R.id.buttonEnviar);

        calendar = Calendar.getInstance(); // Inicializa o calendário com a data atual

        // Configurando o campo de data para abrir o DatePickerDialog
        editTextData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir o DatePickerDialog
                new DatePickerDialog(getContext(), dateSetListener,
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
        // Preenchendo o Spinner Tipo de Destinatário com os valores do strings.xml
        ArrayAdapter<CharSequence> adapterTipoDestinatario = ArrayAdapter.createFromResource(
                getContext(),
                R.array.tipo_destinatario_array, // Nome do array no strings.xml
                android.R.layout.simple_spinner_item);
        adapterTipoDestinatario.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTipoDestinatario.setAdapter(adapterTipoDestinatario);

        // Preenchendo o Spinner Turma com os valores do strings.xml
        ArrayAdapter<CharSequence> adapterTurma = ArrayAdapter.createFromResource(
                getContext(),
                R.array.turmas_array, // Nome do array no strings.xml
                android.R.layout.simple_spinner_item);
        adapterTurma.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTurma.setAdapter(adapterTurma);

        // Preenchendo o Spinner Disciplina com os valores do strings.xml
        ArrayAdapter<CharSequence> adapterDisciplina = ArrayAdapter.createFromResource(
                getContext(),
                R.array.disciplinas_array, // Nome do array no strings.xml
                android.R.layout.simple_spinner_item);
        adapterDisciplina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDisciplina.setAdapter(adapterDisciplina);

        // Lógica para o botão de enviar (por exemplo, validar ou enviar os dados)
        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Implementar lógica para enviar a tarefa
            }
        });

        return view;
    }
    // Listener para quando o usuário selecionar a data no DatePickerDialog
    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(android.widget.DatePicker view, int year, int month, int dayOfMonth) {
            // Atualizar o calendário com a data selecionada
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            // Formatar a data e exibir no campo de texto
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
            editTextData.setText(dateFormat.format(calendar.getTime()));
        }
    };
}
