import javax.swing.*;

public class Main {
    private static VentanaPrincipal ventana = new VentanaPrincipal(new Usuario(1, "Manuel"));
    public static void main(String[] args) {
        JFrame dialog = new InicioSesion();
        dialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        dialog.setResizable(false);
        dialog.pack();
        dialog.setVisible(true);
    }

    public static void AbrirJuego() {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000,655);
        Main main = new Main();
        frame.add(main.getVentana());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static VentanaPrincipal getVentana() {
        return ventana;
    }

    public static void setVentana(VentanaPrincipal ventana) {
        Main.ventana = ventana;
    }
}