import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(840,655);
        frame.add(new VentanaPrincipal());
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}