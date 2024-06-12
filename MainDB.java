import java.util.Scanner;

public class MainDB {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        while (opcao != 0) {
            try {
                System.out.println("\nMenu:");
                System.out.println("1. Adicionar livro");
                System.out.println("2. Listar todos os livros");
                System.out.println("3. Buscar livro por ID");
                System.out.println("4. Remover livro por ID");
                System.out.println("5. Adicionar usuário");
                System.out.println("6. Listar todos os usuários");
                System.out.println("7. Buscar usuário por ID");
                System.out.println("8. Remover usuário por ID");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                    scanner.nextLine(); // Consumir a nova linha

                    switch (opcao) {
                        case 1:
                            System.out.print("Digite o ID do livro: ");
                            int idLivro = scanner.nextInt();
                            scanner.nextLine(); // Consumir a nova linha
                            System.out.print("Digite o título do livro: ");
                            String titulo = scanner.nextLine();
                            System.out.print("Digite o autor do livro: ");
                            String autor = scanner.nextLine();
                            System.out.print("Digite o ano de publicação: ");
                            int ano = scanner.nextInt();
                            scanner.nextLine(); // Consumir a nova linha
                            biblioteca.adicionarLivro(new Livro(idLivro, titulo, autor, ano));
                            break;
                        case 2:
                            biblioteca.listarLivros();
                            break;
                        case 3:
                            System.out.print("Digite o ID do livro: ");
                            int idLivroBusca = scanner.nextInt();
                            scanner.nextLine(); // Consumir a nova linha
                            Livro livroEncontrado = biblioteca.buscarLivroPorId(idLivroBusca);
                            if (livroEncontrado != null) {
                                System.out.println("Livro encontrado: " + livroEncontrado);
                            } else {
                                System.out.println("Livro não encontrado.");
                            }
                            break;
                        case 4:
                            System.out.print("Digite o ID do livro a remover: ");
                            int idLivroRemover = scanner.nextInt();
                            scanner.nextLine(); // Consumir a nova linha
                            biblioteca.removerLivroPorId(idLivroRemover);
                            break;
                        case 5:
                            System.out.print("Digite o ID do usuário: ");
                            int idUsuario = scanner.nextInt();
                            scanner.nextLine(); // Consumir a nova linha
                            System.out.print("Digite o nome do usuário: ");
                            String nome = scanner.nextLine();
                            System.out.print("Digite o email do usuário: ");
                            String email = scanner.nextLine();
                            biblioteca.adicionarUsuario(new Usuario(idUsuario, nome, email));
                            break;
                        case 6:
                            biblioteca.listarUsuarios();
                            break;
                        case 7:
                            System.out.print("Digite o ID do usuário: ");
                            int idUsuarioBusca = scanner.nextInt();
                            scanner.nextLine(); // Consumir a nova linha
                            Usuario usuarioEncontrado = biblioteca.buscarUsuarioPorId(idUsuarioBusca);
                            if (usuarioEncontrado != null) {
                                System.out.println("Usuário encontrado: " + usuarioEncontrado);
                            } else {
                                System.out.println("Usuário não encontrado.");
                            }
                            break;
                        case 8:
                            System.out.print("Digite o ID do usuário a remover: ");
                            int idUsuarioRemover = scanner.nextInt();
                            scanner.nextLine(); // Consumir a nova linha
                            biblioteca.removerUsuarioPorId(idUsuarioRemover);
                            break;
                        case 0:
                            System.out.println("Saindo...");
                            break;
                        default:
                            System.out.println("Opção inválida.");
                    }
                } else {
                    System.out.println("Entrada inválida. Por favor, insira um número.");
                    scanner.next(); // Consumir a entrada inválida
                }
            } catch (Exception e) {
                System.out.println("Ocorreu um erro: " + e.getMessage());
                scanner.nextLine(); // Consumir a linha para evitar loop infinito
            }
        }

        scanner.close();
    }
}