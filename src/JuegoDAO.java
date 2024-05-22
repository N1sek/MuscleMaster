import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JuegoDAO {

    static String getUsuario() {
        BufferedReader br;
        String USUARIO;
        String CONTRASEÑA;
        {
            try {
                br = new BufferedReader(new FileReader("credenciales.txt"));
                USUARIO = br.readLine();
                CONTRASEÑA = br.readLine();
                br.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return USUARIO;
    }

    static String getContraseña() {
        BufferedReader br;
        String USUARIO;
        String CONTRASEÑA;
        {
            try {
                br = new BufferedReader(new FileReader("credenciales.txt"));
                USUARIO = br.readLine();
                CONTRASEÑA = br.readLine();
                br.close();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return CONTRASEÑA;
    }
    private static String URL = "jdbc:mysql://localhost/muscle_master";

    public static void ReescribirGuardado(Juego juego, int NumPartida, int UserID) {
        try (Connection connection = DriverManager.getConnection(URL, getUsuario(), getContraseña())) {
            String sql = "select * from PartidasGuardadas where IDUsuario = " + UserID;
            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(sql);
                for (int i = 0; i<NumPartida; i++) {
                    rs.next();
                }
                sql = "update PartidasGuardadas " +
                        "set Fecha = CURRENT_TIMESTAMP" +
                        ", NumClicks = " + juego.getRealValue() +
                        ", BarritaEnergetica = " + juego.getMejoras().get(0).getNivel() +
                        ", BatidoProteico = " + juego.getMejoras().get(1).getNivel() +
                        ", Creatina = " + juego.getMejoras().get(2).getNivel() +
                        ", Testosterona = " + juego.getMejoras().get(3).getNivel() +
                        ", Peso = " + juego.getMejoras().get(4).getNivel() +
                        "where ID = " + rs.getInt("ID");
                try (Statement statement2 = connection.createStatement()) {
                    statement2.executeUpdate(sql);
                    System.out.println("guardado");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void NuevoGuardado(Juego juego, int UserID) {
        try (Connection connection = DriverManager.getConnection(URL, getUsuario(), getContraseña())) {
            // CONSULTAS AQUI
            String sql = "insert into PartidasGuardadas values (" +
                    UserID +
                    ",null" +
                    ",CURRENT_TIMESTAMP" +
                    "," + juego.getRealValue() +
                    "," + juego.getMejoras().get(0).getNivel() +
                    "," + juego.getMejoras().get(1).getNivel() +
                    "," + juego.getMejoras().get(2).getNivel() +
                    "," + juego.getMejoras().get(3).getNivel() +
                    "," + juego.getMejoras().get(4).getNivel() +
                    ")";
            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List getGuardados(int UserID) {
        try (Connection connection = DriverManager.getConnection(URL, getUsuario(), getContraseña())) {
            String sql = "select * from PartidasGuardadas where IDUsuario = " + UserID;
            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(sql);
                ArrayList<String> guardados = new ArrayList<>();
                int i = 0;
                while (rs.next()) {
                    i++;
                    guardados.add("Partida " + i + " - " + rs.getTimestamp("Fecha") + " - " + rs.getInt("NumClicks") + " Reps");
                }
                return guardados;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void cargarJuego(int numPartida, int UserID) {
        try (Connection connection = DriverManager.getConnection(URL, getUsuario(), getContraseña())) {
            String sql = "select * from PartidasGuardadas where IDUsuario = " + UserID;
            try (Statement statement = connection.createStatement()) {
                ResultSet rs = statement.executeQuery(sql);
                for (int i = 0; i<numPartida; i++) {
                    rs.next();
                }
                 VentanaPrincipal.getJuego().setRealValue(rs.getInt("NumClicks"));
                VentanaPrincipal.getJuego().getMejoras().get(0).setNivel(rs.getInt("BarritaEnergetica"));
                VentanaPrincipal.getJuego().getMejoras().get(1).setNivel(rs.getInt("BatidoProteico"));
                VentanaPrincipal.getJuego().getMejoras().get(2).setNivel(rs.getInt("Creatina"));
                VentanaPrincipal.getJuego().getMejoras().get(3).setNivel(rs.getInt("Testosterona"));
                VentanaPrincipal.getJuego().getMejoras().get(4).setNivel(rs.getInt("Peso"));
                System.out.println("Cargado");
             } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}

