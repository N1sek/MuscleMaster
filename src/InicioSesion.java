import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/*
 * Created by JFormDesigner on Wed May 22 09:09:57 CEST 2024
 */

/**
 * @author manue
 */
public class InicioSesion extends JFrame {
    public InicioSesion() {
        initComponents();
    }

    private void BotonIniciarSesionMouseClicked(MouseEvent e) {
        try {
            UsuarioDAO.getUsuario(UsernameInput.getText(), PasswdInput.getText());
            if (UsuarioDAO.getUsuario(UsernameInput.getText(), PasswdInput.getText()) == null) {
                IniciarSesion.setText("Usuario no encontrado");
                throw new Exception("Usuario no encontrado");
            } else {
                Main.setVentana(new VentanaPrincipal(UsuarioDAO.getUsuario(UsernameInput.getText(), PasswdInput.getText())));
                Main.AbrirJuego();
                dispose();
            }
        } catch (Exception a) {
            a.printStackTrace();
        }
    }

    private void BotonRegistrarMouseClicked(MouseEvent e) {
        if (UsernameInput.getText() == "" || PasswdInput.getText() == "") {
            try {
                UsuarioDAO.insertUsuario(UsernameInput.getText(), PasswdInput.getText());
                Main.setVentana(new VentanaPrincipal(UsuarioDAO.getUsuario(UsernameInput.getText(), PasswdInput.getText())));
                Main.AbrirJuego();
                dispose();
            } catch (Exception a) {
                IniciarSesion.setText("Ese usuario ya existe");
                a.printStackTrace();
            }
        } else {
            new Exception("En blanco").printStackTrace();
        }
    }


    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        IniciarSesion = new JLabel();
        Username = new JLabel();
        UsernameInput = new JTextField();
        Passwd = new JLabel();
        PasswdInput = new JTextField();
        BotonRegistrar = new JButton();
        BotonIniciarSesion = new JButton();

        //======== this ========
        var contentPane = getContentPane();

        //---- IniciarSesion ----
        IniciarSesion.setText("Iniciar Sesi\u00f3n");
        IniciarSesion.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
        IniciarSesion.setHorizontalAlignment(SwingConstants.CENTER);

        //---- Username ----
        Username.setText("Nombre de Usuario");
        Username.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
        Username.setHorizontalAlignment(SwingConstants.CENTER);

        //---- Passwd ----
        Passwd.setText("Contrase\u00f1a");
        Passwd.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
        Passwd.setHorizontalAlignment(SwingConstants.CENTER);

        //---- BotonRegistrar ----
        BotonRegistrar.setText("Registrarse");
        BotonRegistrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        BotonRegistrar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BotonRegistrarMouseClicked(e);
            }
        });

        //---- BotonIniciarSesion ----
        BotonIniciarSesion.setText("Iniciar Sesion");
        BotonIniciarSesion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        BotonIniciarSesion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                BotonIniciarSesionMouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addGroup(contentPaneLayout.createParallelGroup()
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(84, 84, 84)
                            .addComponent(BotonRegistrar)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(BotonIniciarSesion))
                        .addGroup(contentPaneLayout.createSequentialGroup()
                            .addGap(42, 42, 42)
                            .addGroup(contentPaneLayout.createParallelGroup()
                                .addComponent(IniciarSesion, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                .addComponent(PasswdInput, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Passwd, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                .addComponent(UsernameInput, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE)
                                .addComponent(Username, GroupLayout.PREFERRED_SIZE, 201, GroupLayout.PREFERRED_SIZE))))
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(IniciarSesion)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                    .addComponent(Username)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(UsernameInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18, 18, 18)
                    .addComponent(Passwd)
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(PasswdInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(43, 43, 43)
                    .addGroup(contentPaneLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(BotonIniciarSesion)
                        .addComponent(BotonRegistrar))
                    .addContainerGap())
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JLabel IniciarSesion;
    private JLabel Username;
    private JTextField UsernameInput;
    private JLabel Passwd;
    private JTextField PasswdInput;
    private JButton BotonRegistrar;
    private JButton BotonIniciarSesion;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
