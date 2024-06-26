import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author denisc
 */

public class VentanaPrincipal extends JPanel {
    private static Juego juego;
    private static Usuario usuario;
    public VentanaPrincipal(Usuario usuario) {
        initComponents();
        this.usuario = usuario;
        juego = new Juego(this); // Pasar la referencia de la UI al crear el juego
        // Setup UI components and listeners
    }

    public static Usuario getUsuario() {
        return usuario;
    }

    public void actualizarContador(double valor) {
        counterLbl.setText(String.valueOf((int) valor));
    }

    public void actualizarCPS(double cps) {
        label1.setText((String) String.format("%.2f", cps));
    }

    public void activarBotonMejora(Mejora mejora) {
        if (mejora instanceof BarritaEnergetica) {
            barritaEnergetica.setEnabled(true);
        } else if (mejora instanceof BatidoProteico) {
            batidoProteico.setEnabled(true);
        } else if (mejora instanceof Creatina) {
            creatina.setEnabled(true);
        } else if (mejora instanceof Testosterona) {
            testosterona.setEnabled(true);
        } else if (mejora instanceof Peso) {
            if (((Peso) mejora).getCantidadNombres()-1 > mejora.getNivel()) {
                Peso.setEnabled(true);
            }
        }
    }

    public void desactivarBotonMejora(Mejora mejora) {
        if (mejora instanceof BarritaEnergetica) {
            barritaEnergetica.setEnabled(false);
        } else if (mejora instanceof BatidoProteico) {
            batidoProteico.setEnabled(false);
        } else if (mejora instanceof Creatina) {
            creatina.setEnabled(false);
        } else if (mejora instanceof Testosterona) {
            testosterona.setEnabled(false);
        } else if (mejora instanceof Peso) {
            Peso.setEnabled(false);
        }
    }

    public void actualizarPrecioYNivelMejora(Mejora mejora) {
        if (mejora instanceof BarritaEnergetica) {
            barritaEnergetica.setText("<html><b>BARRITA ENERGETICA</b><br>" + String.valueOf(mejora.getPrecio()) + " repes </html>");
            numBarritas.setText("x" + mejora.getNivel());
        } else if (mejora instanceof BatidoProteico) {
            batidoProteico.setText("<html><b>BATIDO PROTEICO</b><br>" + String.valueOf(mejora.getPrecio()) + " repes </html>");
            numBatidos.setText("x" + mejora.getNivel());
        } else if (mejora instanceof Creatina) {
            creatina.setText("<html><b>CREATINA</b><br>" + String.valueOf(mejora.getPrecio()) + " repes </html>");
            numCreatina.setText("x" + mejora.getNivel());
        } else if (mejora instanceof Testosterona) {
            testosterona.setText("<html><b>TESTOSTERONA</b><br>" + String.valueOf(mejora.getPrecio()) + " repes </html>");
            numTestosterona.setText("x" + mejora.getNivel());
        } else if (mejora instanceof Peso) {
            if (((Peso) mejora).getCantidadNombres()-1 > mejora.getNivel()) {
                Peso.setText("<html><b>" + mejora.getNombre() + "</b><br>" + String.valueOf(mejora.getPrecio()) + " repes </html>");
            } else {
                Peso.setText("<html><b>" + mejora.getNombre() + "</b><br>Maximo de Peso</html>");
            }
        }
    }

    private void button1MouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            juego.getClick().setClickValue(((Peso) juego.getMejoras().get(4)).getInclementoClicks());
            juego.incrementarValorReal(juego.getClick().click());
            actualizarContador(juego.getRealValue());
        }
    }

    private void barritaEnergeticaMouseClicked(MouseEvent e) {
        juego.comprarMejora(juego.getMejoras().get(0)); // Barrita Energetica
    }

    private void batidoProteicoMouseClicked(MouseEvent e) {
        juego.comprarMejora(juego.getMejoras().get(1)); // Batido Proteico
    }

    private void creatinaMouseClicked(MouseEvent e) {
        juego.comprarMejora(juego.getMejoras().get(2)); // Creatina
    }

    private void testosteronaMouseClicked(MouseEvent e) {
        juego.comprarMejora(juego.getMejoras().get(3)); // Testosterona
    }

    private void menuItemSaveMouseClicked(ActionEvent e) {
        Guardar guardar = new Guardar(null);
        guardar.actualizarGuardados();
        guardar.setVisible(true);
    }

    public static Juego getJuego() {
        return juego;
    }

    public void loadGameFile(int numPartida) {
        JuegoDAO.cargarJuego(numPartida, usuario.getId());
        for (Mejora mejora : juego.getMejoras()) {
            actualizarPrecioYNivelMejora(mejora);
        }
        actualizarContador(juego.getRealValue());
        juego.actualizarCPS();
        juego.timerUpdate();
    }

    private void load(ActionEvent e) {
        Cargar cargar = new Cargar(null);
        cargar.actualizarGuardados();
        cargar.setVisible(true);
    }

    private void PesoMouseClicked(MouseEvent e) {
        if (juego.getMejoras().get(4).getNivel() < (((Peso) juego.getMejoras().get(4)).getCantidadNombres() - 1)) {
            juego.comprarMejora(juego.getMejoras().get(4)); // Peso
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        clickerBtn = new JButton();
        clicksLbl = new JLabel();
        counterLbl = new JLabel();
        menuBar = new JMenuBar();
        menuBarItem = new JMenu();
        menuItemSave = new JMenuItem();
        menuItemLoad = new JMenuItem();
        barritaEnergetica = new JButton();
        Mejoras = new JLabel();
        numBarritas = new JLabel();
        batidoProteico = new JButton();
        numBatidos = new JLabel();
        RPS = new JLabel();
        label1 = new JLabel();
        creatina = new JButton();
        numCreatina = new JLabel();
        testosterona = new JButton();
        numTestosterona = new JLabel();
        MejorasBarra = new JLabel();
        Peso = new JButton();

        //======== this ========
        setBackground(new Color(0x1a4654));

        //---- clickerBtn ----
        clickerBtn.setText("Press Banca");
        clickerBtn.setIcon(new ImageIcon(getClass().getResource("/assets/press1.png")));
        clickerBtn.setBorder(null);
        clickerBtn.setBorderPainted(false);
        clickerBtn.setFocusPainted(false);
        clickerBtn.setContentAreaFilled(false);
        clickerBtn.setPressedIcon(new ImageIcon(getClass().getResource("/assets/press2.png")));
        clickerBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        clickerBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                button1MouseClicked(e);
            }
        });

        //---- clicksLbl ----
        clicksLbl.setText("REPETICIONES:");
        clicksLbl.setFont(new Font("JetBrains Mono", Font.PLAIN, 26));
        clicksLbl.setForeground(Color.white);

        //---- counterLbl ----
        counterLbl.setText("0");
        counterLbl.setFont(new Font("JetBrains Mono", Font.PLAIN, 24));
        counterLbl.setForeground(Color.white);

        //======== menuBar ========
        {

            //======== menuBarItem ========
            {
                menuBarItem.setText("File");
                menuBarItem.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));
                menuBarItem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

                //---- menuItemSave ----
                menuItemSave.setText("Guardar");
                menuItemSave.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
                menuItemSave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                menuItemSave.addActionListener(e -> menuItemSaveMouseClicked(e));
                menuBarItem.add(menuItemSave);

                //---- menuItemLoad ----
                menuItemLoad.setText("Cargar");
                menuItemLoad.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
                menuItemLoad.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                menuItemLoad.addActionListener(e -> load(e));
                menuBarItem.add(menuItemLoad);
            }
            menuBar.add(menuBarItem);
        }

        //---- barritaEnergetica ----
        barritaEnergetica.setText("<html><b>BARRITA ENERGETICA</b><br>10 repes</html>");
        barritaEnergetica.setEnabled(false);
        barritaEnergetica.setToolTipText("Aumenta el valor de tus RPS en 0,5");
        barritaEnergetica.setFont(new Font("Inter", Font.PLAIN, 18));
        barritaEnergetica.setBackground(new Color(0x232323));
        barritaEnergetica.setForeground(Color.green);
        barritaEnergetica.setBorderPainted(false);
        barritaEnergetica.setMargin(new Insets(0, 40, 0, 0));
        barritaEnergetica.setBorder(null);
        barritaEnergetica.setHorizontalAlignment(SwingConstants.LEADING);
        barritaEnergetica.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        barritaEnergetica.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                barritaEnergeticaMouseClicked(e);
            }
        });

        //---- Mejoras ----
        Mejoras.setText("Mejoras");
        Mejoras.setFont(new Font("JetBrains Mono", Font.BOLD, 40));
        Mejoras.setForeground(Color.white);

        //---- numBarritas ----
        numBarritas.setText("x0");
        numBarritas.setFont(new Font("Inter", Font.PLAIN, 20));
        numBarritas.setForeground(Color.white);

        //---- batidoProteico ----
        batidoProteico.setText("<html><b>BATIDO PROTEICO</b><br>100 repes</html>");
        batidoProteico.setEnabled(false);
        batidoProteico.setActionCommand("Batido Proteico");
        batidoProteico.setFont(new Font("Inter", Font.PLAIN, 18));
        batidoProteico.setForeground(Color.green);
        batidoProteico.setToolTipText("Aumenta el valor de tus RPS en 1");
        batidoProteico.setBackground(new Color(0x232323));
        batidoProteico.setBorder(null);
        batidoProteico.setMargin(new Insets(0, 40, 0, 0));
        batidoProteico.setHorizontalAlignment(SwingConstants.LEADING);
        batidoProteico.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        batidoProteico.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                batidoProteicoMouseClicked(e);
            }
        });

        //---- numBatidos ----
        numBatidos.setText("x0");
        numBatidos.setFont(new Font("Inter", Font.PLAIN, 20));
        numBatidos.setForeground(Color.white);

        //---- RPS ----
        RPS.setText("RPS:");
        RPS.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));
        RPS.setForeground(Color.white);

        //---- label1 ----
        label1.setText("0");
        label1.setFont(new Font("JetBrains Mono", Font.PLAIN, 16));
        label1.setForeground(Color.white);

        //---- creatina ----
        creatina.setText("<html><b>CREATINA</b><br>1000 repes</html>");
        creatina.setEnabled(false);
        creatina.setActionCommand("Batido Proteico");
        creatina.setFont(new Font("Inter", Font.PLAIN, 18));
        creatina.setForeground(Color.green);
        creatina.setToolTipText("Aumenta el valor de tus RPS en 2");
        creatina.setBackground(new Color(0x232323));
        creatina.setBorder(null);
        creatina.setMargin(new Insets(0, 40, 0, 0));
        creatina.setHorizontalAlignment(SwingConstants.LEADING);
        creatina.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        creatina.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                creatinaMouseClicked(e);
            }
        });

        //---- numCreatina ----
        numCreatina.setText("x0");
        numCreatina.setFont(new Font("Inter", Font.PLAIN, 20));
        numCreatina.setForeground(Color.white);

        //---- testosterona ----
        testosterona.setText("<html><b>TESTOSTERONA</b><br>10.000 repes</html>");
        testosterona.setEnabled(false);
        testosterona.setActionCommand("Batido Proteico");
        testosterona.setFont(new Font("Inter", Font.PLAIN, 18));
        testosterona.setForeground(Color.green);
        testosterona.setToolTipText("Aumenta el valor de tus RPS en 4");
        testosterona.setBackground(new Color(0x232323));
        testosterona.setBorder(null);
        testosterona.setMargin(new Insets(0, 40, 0, 0));
        testosterona.setHorizontalAlignment(SwingConstants.LEADING);
        testosterona.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        testosterona.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                testosteronaMouseClicked(e);
            }
        });

        //---- numTestosterona ----
        numTestosterona.setText("x0");
        numTestosterona.setFont(new Font("Inter", Font.PLAIN, 20));
        numTestosterona.setForeground(Color.white);

        //---- MejorasBarra ----
        MejorasBarra.setText("Mejoras Barra");
        MejorasBarra.setFont(new Font("JetBrains Mono", Font.BOLD, 14));
        MejorasBarra.setForeground(Color.white);

        //---- Peso ----
        Peso.setText("<html><b>Pesa 5Kg</b><br>200 repes</html>");
        Peso.setEnabled(false);
        Peso.setActionCommand("Batido Proteico");
        Peso.setFont(new Font("Inter", Font.PLAIN, 18));
        Peso.setForeground(Color.green);
        Peso.setToolTipText("Mientras mas peso mas repeticiones consigues por click");
        Peso.setBackground(new Color(0x232323));
        Peso.setBorder(null);
        Peso.setMargin(new Insets(0, 40, 0, 0));
        Peso.setHorizontalAlignment(SwingConstants.LEADING);
        Peso.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        Peso.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PesoMouseClicked(e);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(menuBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(RPS)
                    .addGap(18, 18, 18)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(739, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(clicksLbl)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(counterLbl, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
                        .addComponent(clickerBtn, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Peso, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                        .addComponent(MejorasBarra, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addComponent(batidoProteico, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                .addComponent(barritaEnergetica, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                .addComponent(creatina, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE)
                                .addComponent(testosterona, GroupLayout.PREFERRED_SIZE, 271, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(numCreatina)
                                .addComponent(numBatidos)
                                .addComponent(numBarritas)
                                .addComponent(numTestosterona))
                            .addGap(76, 76, 76))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(Mejoras)
                            .addGap(172, 172, 172))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(Mejoras)
                                    .addGap(12, 12, 12)
                                    .addComponent(barritaEnergetica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(27, 27, 27)
                                    .addComponent(batidoProteico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(33, 33, 33)
                                    .addComponent(creatina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(89, 89, 89)
                                    .addComponent(numBarritas)
                                    .addGap(48, 48, 48)
                                    .addComponent(numBatidos)
                                    .addGap(55, 55, 55)
                                    .addComponent(numCreatina)))
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(30, 30, 30)
                                    .addComponent(testosterona, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(40, 40, 40)
                                    .addComponent(numTestosterona))))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(clicksLbl, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                .addComponent(counterLbl, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(RPS)
                                .addComponent(label1))
                            .addGap(13, 13, 13)
                            .addComponent(clickerBtn, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                            .addGap(40, 40, 40)
                            .addComponent(MejorasBarra)
                            .addGap(18, 18, 18)
                            .addComponent(Peso, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(95, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }



    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton clickerBtn;
    private JLabel clicksLbl;
    private JLabel counterLbl;
    private JMenuBar menuBar;
    private JMenu menuBarItem;
    private JMenuItem menuItemSave;
    private JMenuItem menuItemLoad;
    private JButton barritaEnergetica;
    private JLabel Mejoras;
    private JLabel numBarritas;
    private JButton batidoProteico;
    private JLabel numBatidos;
    private JLabel RPS;
    private JLabel label1;
    private JButton creatina;
    private JLabel numCreatina;
    private JButton testosterona;
    private JLabel numTestosterona;
    private JLabel MejorasBarra;
    private JButton Peso;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
