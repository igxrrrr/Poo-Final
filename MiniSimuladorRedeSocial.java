import javax.swing.JOptionPane;

public class MiniSimuladorRedeSocial {
    public static void main(String[] args) {
        RedeSocial redeSocial = new RedeSocial();

        String[] opcoes = {
                "Cadastrar Usuário",
                "Login",
                "Adicionar Amigo",
                "Consultar Amigos",
                "Enviar Mensagem",
                "Imprimir Mensagens",
                "Remover Amigo",
                "Logout",
                "Sair"
        };

        int opcao;
        do {
            opcao = JOptionPane.showOptionDialog(
                    null,
                    "Escolha uma opção:",
                    "Rede Social",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[0]
            );

            String nome, email, senha, mensagem;
            switch (opcao) {
                case 0:
                    nome = JOptionPane.showInputDialog("Informe o nome do usuário:");
                    email = JOptionPane.showInputDialog("Informe o email do usuário:");
                    senha = JOptionPane.showInputDialog("Informe a senha do usuário:");
                    redeSocial.cadastrarUsuario(nome, email, senha);
                    break;
                case 1:
                    email = JOptionPane.showInputDialog("Informe o email para login:");
                    senha = JOptionPane.showInputDialog("Informe a senha para login:");
                    redeSocial.login(email, senha);
                    break;
                case 2:
                    email = JOptionPane.showInputDialog("Informe o email do amigo a ser incluído:");
                    redeSocial.incluirAmigo(email);
                    break;
                case 3:
                    redeSocial.consultarAmigos();
                    break;
                case 4:
                    email = JOptionPane.showInputDialog("Informe o email do amigo para o qual enviar a mensagem:");
                    mensagem = JOptionPane.showInputDialog("Informe a mensagem a ser enviada:");
                    redeSocial.enviarMensagem(email, mensagem);
                    break;
                case 5:
                    redeSocial.imprimirMensagens();
                    break;
                case 6:
                    email = JOptionPane.showInputDialog("Informe o email do amigo a ser excluído:");
                    redeSocial.excluirAmigo(email);
                    break;
                case 7:
                    redeSocial.logout();
                    break;
            }

        } while (opcao != 8);

        System.exit(0);
    }
}
