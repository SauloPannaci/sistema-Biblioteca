import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Adicionar um livro");
            System.out.println("2. Listar todos os livros existentes");
            System.out.println("3. Buscar o livro por ID");
            System.out.println("4. Remover o livro por ID");
            System.out.println("5. Adicionar um usuário");
            System.out.println("6. Listar todos os usuários existentes");
            System.out.println("7. Buscar o usuário por ID");
            System.out.println("8. Remover o usuário por ID");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção desejada: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID do livro: ");
                    int idLivro = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Digite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    System.out.print("Digite o ano de publicação do livro: ");
                    int ano = scanner.nextInt();
                    biblioteca.adicionarLivro(new Livro(idLivro, titulo, autor, ano));
                    break;
                case 2:
                    biblioteca.listarLivros();
                    break;
                case 3:
                    System.out.print("Digite o ID do livro: ");
                    int idLivroBusca = scanner.nextInt();
                    Livro livroEncontrado = biblioteca.buscarLivroPorId(idLivroBusca);
                    if (livroEncontrado != null) {
                        System.out.println("Livro encontrado: " + livroEncontrado);
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o ID do livro que deseja remover: ");
                    int idLivroRemover = scanner.nextInt();
                    biblioteca.removerLivroPorId(idLivroRemover);
                    break;
                case 5:
                    System.out.print("Digite o ID do usuário: ");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Digite o nome do usuário: ");
                    String nome = scanner.nextLine();
                    System.out.print("Digite o email do usuário: ");
                    String email =scanner.nextLine(); 
                    biblioteca.adicionarUsuario(new Usuario(idUsuario, nome, email));
                    break;
                case 6:
                    biblioteca.listarUsuarios();
                    break;
                case 7:
                    System.out.print("Digite o ID do usuário: ");
                    int idUsuarioBusca = scanner.nextInt();
                    Usuario usuarioEncontrado = biblioteca.buscarUsuarioPorId(idUsuarioBusca);
                    if (usuarioEncontrado != null) {
                        System.out.println("Usuário encontrado: " + usuarioEncontrado);
                    } else {
                        System.out.println("Usuário não encontrado.");
                    }
                    break;
                case 8:
                    System.out.print("Digite o ID do usuário que deseja a remover: ");
                    int idUsuarioRemover = scanner.nextInt();
                    biblioteca.removerUsuarioPorId(idUsuarioRemover);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}