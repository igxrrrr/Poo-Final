import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class Usuario extends Pessoa {
    private String senha;
    private List<Amigo> amigos;
    private List<String> mensagens;

    public Usuario(String nome, String email, String senha) {
        super(nome, email);
        this.senha = senha;
        this.amigos = new ArrayList<>();
        this.mensagens = new ArrayList<>();
    }

    public String getSenha() {
        return senha;
    }

    public List<Amigo> getAmigos() {
        return amigos;
    }

    public List<String> getMensagens() {
        return mensagens;
    }

    public void adicionarAmigo(Amigo amigo) {
        amigos.add(amigo);
    }

    public void removerAmigo(Amigo amigo) {
        amigos.remove(amigo);
    }

    public void enviarMensagem(Amigo amigo, String mensagem) {
        mensagens.add(mensagem);
    }

    public void imprimirAmigos() {
        StringBuilder amigosStr = new StringBuilder("Amigos de " + getNome() + ":\n");
        for (Amigo amigo : amigos) {
            amigosStr.append(amigo.getNome()).append("\n");
        }
        JOptionPane.showMessageDialog(null, amigosStr.toString());
    }

    public void imprimirMensagens() {
        StringBuilder mensagensStr = new StringBuilder("Mensagens de " + getNome() + ":\n");
        for (String mensagem : mensagens) {
            mensagensStr.append(mensagem).append("\n");
        }
        JOptionPane.showMessageDialog(null, mensagensStr.toString());
    }
}

