package model;
import javax.swing.JOptionPane;
import view.Tela;

public class Agenda {

    // Métodos
    public void iniciarAgenda() {
        // Cria o objeto da classe Tela
        Tela tela = new Tela();

        // Mostra o Menu
        String menu = ":: Agenda de Contatos ::\n\n" + 
                      "1. Cadastrar\n" + 
                      "2. Buscar\n" + 
                      "3. Editar\n" + 
                      "4. Excluir\n\n";

        // Mantém o Menu ativo
        boolean isAtivo = true;

        // Loop principal do Sistema
        while (isAtivo) {
            String opcao = tela.informar(menu, "Informe uma opção de Menu", -1);

            switch (opcao) {
                case "1":
                    cadastrarContato(tela);
                    break;

                case "2":
                    buscarContato(tela);
                    break;

                case "3":
                    editarContato(tela);
                    break;

                case "4":
                    deletarContato(tela);
                    break;

                default:
                    int sair = tela.confirmar("Deseja sair", "Encerrar", 3);

                    if (sair == 0) {
                        isAtivo = false;
                        tela.mostrar("Encerrando o sistema", "Encerrando", 1);
                    }
            } // fecha o switch
        } // fecha o while
    } // fecha o método iniciarAgenda()

    private void cadastrarContato(Tela tela) {

        // Usuário informa os dados
        String nome = tela.informar("Informe o Nome", "Nome", 1);
        String email = tela.informar("Informe o E-mail", "E-mail", 1);
        String fone = tela.informar("Informe o Telefone", "Fone", 1);

        // Cria o objeto da classe Contato
        Contato contato = new Contato(nome, email, fone);

        // Forma encurtada
        /*
         * Contato contato = new Contato( tela.informar("Informe o Nome", "Nome", 1),
         * tela.informar("Informe o E-mail", "E-mail", 1),
         * tela.informar("Informe o Telefone", "Fone", 1) );
         */

        // Adiciona o Contato (preenchido) na Lista de contatos da Agenda
        Lista.getInstance().add(contato);
    } // fecha o método cadastrarContato()

    private void buscarContato(Tela tela) {

        // Guarda o número de registros na Lista
        int numeroRegistros = Lista.getInstance().size();

        if (numeroRegistros > 0) {
            String listaContatos = "";

            for (int i = 0; i < numeroRegistros; i++) {
                listaContatos += "ID: " + (i + 1) + 
                                 "\nNome: " + Lista.getInstance().get(i).getNome() + 
                                 "\nE-mail: " + Lista.getInstance().get(i).getEmail() + 
                                 "\nFone: " + Lista.getInstance().get(i).getFone() + 
                                 "\n\n";
            }

            // Mostra o resultado da busca
            tela.mostrar(listaContatos, "Contatos", 1);

        } else {
            tela.mostrar("Nehum contato registrado", "Contatos", 1);
        }
    } // fecha o método buscarContato()
    
    private void editarContato(Tela tela) {

        buscarContato(tela);

        // variável onde o ID informado será guardado
        int id;

        // Pede para informar um ID para edição do contato e tranformar o valor em um int
        id = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o Id do usuario que deseja editar", "Editar Contato", 1));

        // Pede novas informações para que as informações antigas do usuarios sejam reescritas
        String _nome = tela.informar("informe um novo nome", "Editar", 1);

        String _email = tela.informar("informe um novo email", "Editar", 1);

        String _fone = tela.informar("informe um novo telefone", "Editar", 1);

        Contato contato = new Contato(_nome, _email, _fone);
        //Lista.getInstance().add(contato);
        contatoEditado(contato, id);


    } // fecha o método editarContato()

     private void contatoEditado(Contato contato, int id) {

         // rescreve o metodos da informação do usuario registrado
         Lista.getInstance().get(id -1).setNome(contato.getNome());
         Lista.getInstance().get(id -1).setFone(contato.getFone());
         Lista.getInstance().get(id -1).setEmail(contato.getEmail());;
     } // Final do método contatoEditado()

     private void deletarContato(Tela tela) {

         buscarContato(tela);

         // variável onde o valor do ID infomado é guardado
         int idClear;

         // Pede para que o usuario informe o id para deletar e tranforma o valor em um int
         idClear = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe o ID do usuario que deseja deletar", "Deletar Usuario", 2));

         // Deleta o Id especifico ao qual foi informado
         Lista.getInstance().remove(idClear -1);
     }
}
