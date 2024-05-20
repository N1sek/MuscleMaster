import java.sql.*;

public class JuegoDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/muscle_master";
    private static final String USUARIO = "root";
    private static final String CONTRASEÑA = "admin";

    public static void guardarJuego(Juego juego) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
            // CONSULTAS AQUIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII
            String query = "INSERT INTO PartidasGuardadas(IDUsuario, NumClics, BarritaEnergetica, BatidoProteico, Creatina, Testosterona, Peso) VALUES(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
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

