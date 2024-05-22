import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {
    private static String URL = "jdbc:mysql://localhost/muscle_master";

    public static Usuario getUsuario(String username, String password) throws SQLException {
        Connection connection = DriverManager.getConnection(URL, JuegoDAO.getUsuario(), JuegoDAO.getContraseña());
        String sql = "select * from usuarios where Username = '" + username + "' and Password = '" + password + "'";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        if (rs.next()) {
            return new Usuario(rs.getInt("ID"), rs.getString("Username"));
        } else {
            return null;
        }
    }

    public static void insertUsuario(String username, String password) throws SQLException {
        if (getUsuario(username, password) != null) {
            throw new SQLException("Usuario ya existente");
        } else {
            Connection connection = DriverManager.getConnection(URL, JuegoDAO.getUsuario(), JuegoDAO.getContraseña());
            String sql = "insert into usuarios (Username, Password) values ('" + username + "', '" + password + "')";
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        }
    }
}
