import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipal {
    private JPanel panel1;
    private JButton button1;

    public VentanaPrincipal() {
        button1.addActionListener(e -> {
            JOptionPane.showMessageDialog(null, "Hola Mundo");
        });
    }

    private void clickerBtnMouseClicked(MouseEvent e) {
        int counter = Integer.parseInt(counterLbl.getText());
        counter++;
        counterLbl.setText(String.valueOf(counter));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("VentanaPrincipal");
        frame.setContentPane(new VentanaPrincipal().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
