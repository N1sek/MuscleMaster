import javax.swing.*;
import java.awt.*;

public class Main {
    private static VentanaPrincipal ventana = new VentanaPrincipal(new Usuario(1, "Manuel"));
    public static void main(String[] args) {
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
}