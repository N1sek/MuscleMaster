import java.sql.*;

public class JuegoDAO {
    private static String URL = "jdbc:mysql://localhost/muscle_master";
    private static String USUARIO = "root";
    private static String CONTRASEÑA = "root";

    public static void guardarJuego(Juego juego) {
        try (Connection connection = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA)) {
            // CONSULTAS AQUI
            String sql = String.format("insert into PartidasGuardadas values (1,null,%2d,%2d,%2d,%2d,%2d,%2d);", juego.getRealValue(), juego.getMejoras().get(0), juego.getMejoras().get(1), juego.getMejoras().get(2), juego.getMejoras().get(3), 0);
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

