import java.sql.*;

public class JuegoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "admin";

    public void guardarJuego(Juego juego) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
            // CONSULTAS AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Juego cargarJuego() {
        Juego juego = null;
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
             Statement statement = connection.createStatement()) {
            // CONSULTAS AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return juego;
    }


}

