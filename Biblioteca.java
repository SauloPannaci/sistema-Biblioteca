import java.util.LinkedList;

public class Biblioteca {
    private LinkedList<Livro> livros;
    private LinkedList<Usuario> usuarios;

    public Biblioteca() {
        this.livros = new LinkedList<>();
        this.usuarios = new LinkedList<>();
    }

    

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
        System.out.println("Livro adicionado: " + livro.getTitulo());
    }

    public void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("Nenhum livro na biblioteca.");
        } else {
            livros.sort((l1, l2) -> Integer.compare(l1.getId(), l2.getId()));
            System.out.println("Lista de livros na biblioteca:");
            for (Livro livro : livros) {
                System.out.println(livro);
            }
        }
    }

    public Livro buscarLivroPorId(int id) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                return livro;
            }
        }
        return null;
    }

    public void removerLivroPorId(int id) {
        Livro livro = buscarLivroPorId(id);
        if (livro != null) {
            livros.remove(livro);
            System.out.println("Livro removido: " + livro.getTitulo());
        } else {
            System.out.println("Livro com ID " + id + " não encontrado.");
        }
    }

    

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário adicionado: " + usuario.getNome());
    }

    public void listarUsuarios() {
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário registrado.");
        } else {
            usuarios.sort((u1, u2) -> Integer.compare(u1.getId(), u2.getId()));
            System.out.println("Lista de usuários:");
            for (Usuario usuario : usuarios) {
                System.out.println(usuario);
            }
        }
    }

    public Usuario buscarUsuarioPorId(int id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public void removerUsuarioPorId(int id) {
        Usuario usuario = buscarUsuarioPorId(id);
        if (usuario != null) {
            usuarios.remove(usuario);
            System.out.println("Usuário removido: " + usuario.getNome());
        } else {
            System.out.println("Usuário com ID " + id + " não encontrado.");
        }
    }
}