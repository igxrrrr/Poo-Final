import java.util.ArrayList;
import java.util.List;

class RedeSocial {
    private List<Usuario> usuarios;
    private Usuario usuarioLogado;

    public RedeSocial() {
        usuarios = new ArrayList<>();
        usuarioLogado = null;
    }

    public void cadastrarUsuario(String nome, String email, String senha) {
        Usuario novoUsuario = new Usuario(nome, email, senha);
        usuarios.add(novoUsuario);
    }

    public void login(String email, String senha) {
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email) && usuario.getSenha().equals(senha)) {
                usuarioLogado = usuario;
                System.out.println("Usuário " + usuario.getNome() + " logado com sucesso!");
                return;
            }
        }
        System.out.println("E-mail ou senha incorretos. Tente novamente.");
    }

    public void logout() {
        if (usuarioLogado != null) {
            System.out.println("Usuário " + usuarioLogado.getNome() + " deslogado com sucesso!");
            usuarioLogado = null;
        } else {
            System.out.println("Nenhum usuário está logado no momento.");
        }
    }

    public void incluirAmigo(String email) {
        if (usuarioLogado == null) {
            System.out.println("Nenhum usuário está logado no momento.");
            return;
        }

        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                Amigo amigo = new Amigo(usuario.getNome(), usuario.getEmail());
                usuarioLogado.adicionarAmigo(amigo);
                System.out.println(amigo.getNome() + " foi adicionado como amigo.");
                return;
            }
        }
        System.out.println("Usuário com o e-mail " + email + " não encontrado.");
    }

    public void consultarAmigos() {
        if (usuarioLogado == null) {
            System.out.println("Nenhum usuário está logado no momento.");
            return;
        }

        usuarioLogado.imprimirAmigos();
    }

    public void excluirAmigo(String email) {
        if (usuarioLogado == null) {
            System.out.println("Nenhum usuário está logado no momento.");
            return;
        }

        for (Amigo amigo : usuarioLogado.getAmigos()) {
            if (amigo.getEmail().equals(email)) {
                usuarioLogado.removerAmigo(amigo);
                System.out.println(amigo.getNome() + " foi removido como amigo.");
                return;
            }
        }
        System.out.println("Usuário com o e-mail " + email + " não encontrado na lista de amigos.");
    }

    public void enviarMensagem(String email, String mensagem) {
        if (usuarioLogado == null) {
            System.out.println("Nenhum usuário está logado no momento.");
            return;
        }

        for (Amigo amigo : usuarioLogado.getAmigos()) {
            if (amigo.getEmail().equals(email)) {
                usuarioLogado.enviarMensagem(amigo, mensagem);
                System.out.println("Mensagem enviada para " + amigo.getNome());
                return;
            }
        }
        System.out.println("Usuário com o e-mail " + email + " não encontrado na lista de amigos.");
    }

    public void imprimirMensagens() {
        if (usuarioLogado == null) {
            System.out.println("Nenhum usuário está logado no momento.");
            return;
        }

        usuarioLogado.imprimirMensagens();
    }
}