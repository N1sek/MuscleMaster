import java.awt.*;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;
import javax.swing.GroupLayout;
import javax.swing.border.*;
/*
 * Created by JFormDesigner on Sun May 19 22:37:22 CEST 2024
 */



/**
 * @author denisc
 */
public class Guardar extends JDialog {
    private Usuario usuario = VentanaPrincipal.getUsuario();
    public Guardar(JFrame owner) {
        super(owner);
        initComponents();
        setModal(true);
    }

    public void actualizarGuardados() {
        List guardados = JuegoDAO.getGuardados(usuario.getId());
        try {
            Guardado1.setText(guardados.get(0).toString());
        } catch (Exception e) {
            Guardado1.setText("Sin Partida 1");
        }
        try {
            Guardado2.setText(guardados.get(1).toString());
        } catch (Exception e) {
            Guardado2.setText("Sin Partida 2");
        }
        try {
            Guardado3.setText(guardados.get(2).toString());
        } catch (Exception e) {
            Guardado3.setText("Sin Partida 3");
        }
    }

    private void cancelButtonMouseClicked(MouseEvent e) {
        dispose();
    }

    private void Guardado3MouseClicked(MouseEvent e) {
        try {
            JuegoDAO.getGuardados(usuario.getId()).get(2);
            JuegoDAO.ReescribirGuardado(VentanaPrincipal.getJuego(), 3, usuario.getId());
        } catch (Exception a) {
            JuegoDAO.NuevoGuardado(VentanaPrincipal.getJuego(), usuario.getId());
        }
        actualizarGuardados();
    }

    private void Guardado1MouseClicked(MouseEvent e) {
        try {
            JuegoDAO.getGuardados(usuario.getId()).get(0);
            JuegoDAO.ReescribirGuardado(VentanaPrincipal.getJuego(), 1, usuario.getId());
        } catch (Exception a) {
            JuegoDAO.NuevoGuardado(VentanaPrincipal.getJuego(), usuario.getId());
        }
        actualizarGuardados();
    }

    private void Guardado2MouseClicked(MouseEvent e) {
        try {
            JuegoDAO.getGuardados(usuario.getId()).get(1);
            JuegoDAO.ReescribirGuardado(VentanaPrincipal.getJuego(), 2, usuario.getId());
        } catch (Exception a) {
            JuegoDAO.NuevoGuardado(VentanaPrincipal.getJuego(), usuario.getId());
        }
        actualizarGuardados();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        dialogPane = new JPanel();
        contentPanel = new JPanel();
        Guardado1 = new JButton();
        Guardado2 = new JButton();
        Guardado3 = new JButton();
        buttonBar = new JPanel();
        cancelButton = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setLayout(new BorderLayout());

            //======== contentPanel ========
            {

                //---- Guardado1 ----
                Guardado1.setText("PARTIDA 1");
                Guardado1.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Guardado1MouseClicked(e);
                    }
                });

                //---- Guardado2 ----
                Guardado2.setText("PARTIDA 2");
                Guardado2.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Guardado2MouseClicked(e);
                    }
                });

                //---- Guardado3 ----
                Guardado3.setText("PARTIDA 3");
                Guardado3.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        Guardado3MouseClicked(e);
                    }
                });

                GroupLayout contentPanelLayout = new GroupLayout(contentPanel);
                contentPanel.setLayout(contentPanelLayout);
                contentPanelLayout.setHorizontalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(contentPanelLayout.createParallelGroup()
                                .addComponent(Guardado1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(contentPanelLayout.createSequentialGroup()
                                    .addGroup(contentPanelLayout.createParallelGroup()
                                        .addComponent(Guardado2, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Guardado3, GroupLayout.PREFERRED_SIZE, 462, GroupLayout.PREFERRED_SIZE))
                                    .addGap(0, 0, Short.MAX_VALUE)))
                            .addContainerGap())
                );
                contentPanelLayout.setVerticalGroup(
                    contentPanelLayout.createParallelGroup()
                        .addGroup(contentPanelLayout.createSequentialGroup()
                            .addGap(78, 78, 78)
                            .addComponent(Guardado1)
                            .addGap(18, 18, 18)
                            .addComponent(Guardado2)
                            .addGap(18, 18, 18)
                            .addComponent(Guardado3)
                            .addContainerGap(79, Short.MAX_VALUE))
                );
            }
            dialogPane.add(contentPanel, BorderLayout.CENTER);

            //======== buttonBar ========
            {
                buttonBar.setBorder(new EmptyBorder(12, 0, 0, 0));
                buttonBar.setLayout(new GridBagLayout());
                ((GridBagLayout)buttonBar.getLayout()).columnWidths = new int[] {0, 85, 80};
                ((GridBagLayout)buttonBar.getLayout()).columnWeights = new double[] {1.0, 0.0, 0.0};

                //---- cancelButton ----
                cancelButton.setText("Done");
                cancelButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        cancelButtonMouseClicked(e);
                    }
                });
                buttonBar.add(cancelButton, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0,
                    GridBagConstraints.CENTER, GridBagConstraints.BOTH,
                    new Insets(0, 0, 0, 0), 0, 0));
            }
            dialogPane.add(buttonBar, BorderLayout.SOUTH);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel dialogPane;
    private JPanel contentPanel;
    private JButton Guardado1;
    private JButton Guardado2;
    private JButton Guardado3;
    private JPanel buttonBar;
    private JButton cancelButton;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
