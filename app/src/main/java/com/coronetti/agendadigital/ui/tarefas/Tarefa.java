package com.coronetti.agendadigital.ui.tarefas;

public class Tarefa {
    private String titulo;
    private String turma;
    private String data;
    private String disciplina;
    private String status;

    public Tarefa(String titulo, String turma, String data, String disciplina, String status) {
        this.titulo = titulo;
        this.turma = turma;
        this.data = data;
        this.disciplina = disciplina;
        this.status = status;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getTurma() {
        return turma;
    }
    public String getData() {
        return data;
        }
    public String getDisciplina() {
        return disciplina;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public void setTurma(String turma) {
        this.turma = turma;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

}

