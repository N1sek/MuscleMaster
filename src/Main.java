import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280,768);
        frame.add(new VentanaPrincipal());
        frame.setVisible(true);
    }
}