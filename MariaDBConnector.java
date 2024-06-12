import java.sql.*;

public class MariaDBConnector {
    private static final String URL = "jdbc:mysql://localhost:3306/seu_banco_de_dados";
    private static final String USER = "seu_usuario";
    private static final String PASSWORD = "sua_senha";

    public static void main(String[] args) {
        try {
            
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexão bem-sucedida!");

        
            Statement statement = connection.createStatement();

            
            String query = "SELECT * FROM livros";
            ResultSet resultSet = statement.executeQuery(query);

        
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String titulo = resultSet.getString("titulo");
                String autor = resultSet.getString("autor");
                int ano = resultSet.getInt("ano");
                System.out.println("ID: " + id + ", Título: " + titulo + ", Autor: " + autor + ", Ano: " + ano);
            }

            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
