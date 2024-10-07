# App Mobile de uma Agenda Digital

Esse app foi criado com o intuito de entender a criação de um app utilizando Android Studio. Foi desenvolvido em Java. Também é um componente obrigatório para aprovação na disciplina de desenvolvimento mobile do curso de Engenharia da Computação - UNOESC. O sistema foi projetado para permitir a criação, acompanhamento e exclusão de tarefas, além de possibilitar o envio de e-mails para os usuários selecionados.

## Estrutura do Projeto

A estrutura do projeto foi organizada em pacotes com base em suas funcionalidades, como segue:

```com.coronetti.agendadigital ├── ui 
│├── tarefas 
│├── criacaoTarefas: Contém a atividade e fragmento responsável pela criação de novas tarefas.
││ └── acompanhamentoTarefas: Gerencia a visualização e manipulação das tarefas existentes.
├── model: Contém a classe Tarefa, que representa os dados da tarefa. └── utils: Funções auxiliares e constantes.```


## Desenvolvimento

### 1. Criação da Interface do Usuário

A interface foi projetada utilizando XML para definir a estrutura visual e a disposição dos elementos. Foram utilizados Layouts como `LinearLayout` e `ConstraintLayout` para criar uma experiência de usuário fluida e responsiva.

- **CriacaoTarefasFragment**:
  - Contém campos de entrada (EditText) para título, data, descrição e Spinners para seleção de destinatário, turma e disciplina.
  - Um botão "Enviar" que captura os dados e os envia para armazenamento.

- **AcompanhamentoTarefasFragment**:
  - Uma lista que exibe as tarefas criadas, permitindo a visualização dos detalhes da tarefa, alteração de status e exclusão.

### 2. Lógica de Negócio

#### 2.1 Criação de Tarefas

A lógica para criar tarefas foi implementada na classe `CriacaoDeTarefasActivity`. Os dados inseridos pelo usuário são capturados e armazenados em um objeto `Tarefa`, que é então serializado em formato JSON e salvo usando `SharedPreferences`.

#### 2.2 Acompanhamento de Tarefas

No `AcompanhamentoTarefasFragment`, a lista de tarefas é carregada a partir do `SharedPreferences`. O adapter `TarefaAdapter` é utilizado para apresentar os dados de forma estruturada e dinâmica.

### 3. Funcionalidade de Exclusão e Alteração de Status

Cada tarefa na lista tem opções para alterar seu status ou ser excluída. A interação com o usuário é realizada por meio de `AlertDialog`, permitindo que o usuário escolha entre opções predefinidas para o status da tarefa.

### 4. Envio de E-mails

O envio de e-mails foi implementado usando um `Intent` que abre o cliente de e-mail padrão no dispositivo. Um Spinner foi utilizado para permitir a seleção do destinatário antes de disparar o e-mail.

### 5. Testes e Debugging

Testes foram realizados para garantir que as funcionalidades de criação, edição e exclusão de tarefas estavam operacionais. O `Logcat` foi utilizado para debugar erros e garantir que as interações de usuário funcionassem como esperado.

## Conclusão

O sistema de gerenciamento de tarefas foi desenvolvido com foco na simplicidade e funcionalidade. Foram implementadas diversas funcionalidades que permitiram ao usuário criar, visualizar e gerenciar suas tarefas de forma intuitiva. As escolhas tecnológicas, como o uso de `SharedPreferences` para armazenamento e `Gson` para manipulação de JSON, facilitaram a implementação e manutenção do sistema.

Recomendações para melhorias futuras incluem a implementação de um banco de dados para persistência de dados mais robusta e a adição de notificações para lembretes de tarefas.

