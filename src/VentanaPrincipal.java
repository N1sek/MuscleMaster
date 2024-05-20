import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author denisc
 */

public class VentanaPrincipal extends JPanel {
    private Juego juego;

    public VentanaPrincipal() {
        initComponents();
        juego = new Juego(this); // Pasar la referencia de la UI al crear el juego
        // Setup UI components and listeners
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
        }
    }

    public void actualizarPrecioYNivelMejora(Mejora mejora) {
        if (mejora instanceof BarritaEnergetica) {
            barritaPrice.setText(String.valueOf(mejora.getPrecio()));
            numBarritas.setText("x" + mejora.getNivel());
        } else if (mejora instanceof BatidoProteico) {
            batidoPrice.setText(String.valueOf(mejora.getPrecio()));
            numBatidos.setText("x" + mejora.getNivel());
        } else if (mejora instanceof Creatina) {
            numCreatina.setText("x" + mejora.getNivel());
        } else if (mejora instanceof Testosterona) {
            numTestosterona.setText("x" + mejora.getNivel());
        }
    }

    private void button1MouseClicked(MouseEvent e) {
        juego.incrementarValorReal(juego.getClick().click());
        actualizarContador(juego.getRealValue());
        juego.timerUpdate();
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

    private void menuItemSaveMouseClicked(MouseEvent e) {
        Guardar guardar = new Guardar(null);
        guardar.setVisible(true);
    }


    private void menuItemSaveMouseClicked(ActionEvent e) {
        Guardar guardar = new Guardar(null);
        guardar.setVisible(true);

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
        barritaPrice = new JLabel();
        batidoPrice = new JLabel();
        RPS = new JLabel();
        label1 = new JLabel();
        creatina = new JButton();
        numCreatina = new JLabel();
        testosterona = new JButton();
        numTestosterona = new JLabel();

        //======== this ========
        setBackground(new Color(0x112d36));

        //---- clickerBtn ----
        clickerBtn.setText("Press Banca");
        clickerBtn.setIcon(new ImageIcon(getClass().getResource("/assets/press1.png")));
        clickerBtn.setBorder(null);
        clickerBtn.setBorderPainted(false);
        clickerBtn.setFocusPainted(false);
        clickerBtn.setContentAreaFilled(false);
        clickerBtn.setPressedIcon(new ImageIcon(getClass().getResource("/assets/press2.png")));
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

                //---- menuItemSave ----
                menuItemSave.setText("Guardar");
                menuItemSave.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
                menuItemSave.addActionListener(e -> menuItemSaveMouseClicked(e));
                menuBarItem.add(menuItemSave);

                //---- menuItemLoad ----
                menuItemLoad.setText("Cargar");
                menuItemLoad.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
                menuBarItem.add(menuItemLoad);
            }
            menuBar.add(menuBarItem);
        }

        //---- barritaEnergetica ----
        barritaEnergetica.setText("<html><b>BARRITA ENERGETICA</b><br>10 repes</html>");
        barritaEnergetica.setEnabled(false);
        barritaEnergetica.setToolTipText("Aumenta el valor de tu repeticion en 0,1 por cada click");
        barritaEnergetica.setFont(new Font("Inter", Font.PLAIN, 18));
        barritaEnergetica.setBackground(new Color(0x141414));
        barritaEnergetica.setForeground(Color.green);
        barritaEnergetica.setBorderPainted(false);
        barritaEnergetica.setMargin(new Insets(0, 40, 0, 0));
        barritaEnergetica.setHorizontalAlignment(SwingConstants.LEFT);
        barritaEnergetica.setBorder(null);
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
        batidoProteico.setToolTipText("Aumenta el valor de tu repeticion en 0,5 por cada click");
        batidoProteico.setBackground(new Color(0x141414));
        batidoProteico.setBorder(null);
        batidoProteico.setHorizontalAlignment(SwingConstants.LEFT);
        batidoProteico.setMargin(new Insets(0, 40, 0, 0));
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

        //---- barritaPrice ----
        barritaPrice.setText("10");
        barritaPrice.setForeground(Color.white);

        //---- batidoPrice ----
        batidoPrice.setText("100");
        batidoPrice.setForeground(Color.white);

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
        creatina.setToolTipText("Aumenta el valor de tu repeticion en 0,5 por cada click");
        creatina.setBackground(new Color(0x141414));
        creatina.setBorder(null);
        creatina.setHorizontalAlignment(SwingConstants.LEFT);
        creatina.setMargin(new Insets(0, 40, 0, 0));
        creatina.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                batidoProteicoMouseClicked(e);
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
        testosterona.setToolTipText("Aumenta el valor de tu repeticion en 0,5 por cada click");
        testosterona.setBackground(new Color(0x141414));
        testosterona.setBorder(null);
        testosterona.setHorizontalAlignment(SwingConstants.LEFT);
        testosterona.setMargin(new Insets(0, 40, 0, 0));
        testosterona.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                batidoProteicoMouseClicked(e);
            }
        });

        //---- numTestosterona ----
        numTestosterona.setText("x0");
        numTestosterona.setFont(new Font("Inter", Font.PLAIN, 20));
        numTestosterona.setForeground(Color.white);

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(menuBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(clicksLbl)
                            .addGap(18, 18, 18)
                            .addComponent(counterLbl, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                        .addComponent(clickerBtn, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 188, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(Mejoras)
                            .addGap(152, 152, 152))
                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(barritaPrice)
                                    .addGap(18, 18, 18)
                                    .addComponent(barritaEnergetica, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(batidoPrice)
                                    .addGap(18, 18, 18)
                                    .addComponent(batidoProteico, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE))
                                .addComponent(creatina, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE)
                                .addComponent(testosterona, GroupLayout.PREFERRED_SIZE, 318, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup()
                                .addComponent(numBarritas)
                                .addComponent(numCreatina)
                                .addComponent(numBatidos)
                                .addComponent(numTestosterona))
                            .addGap(35, 35, 35))))
                .addGroup(layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(RPS)
                    .addGap(18, 18, 18)
                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(740, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(Mejoras)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(numBarritas))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(barritaEnergetica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                            .addGap(1, 1, 1)
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(26, 26, 26)
                                    .addComponent(batidoProteico, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18))
                                .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(numBatidos)
                                    .addGap(30, 30, 30)))
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(numCreatina))
                                .addComponent(creatina, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(clicksLbl, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                .addComponent(counterLbl, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(27, 27, 27)
                                    .addComponent(barritaPrice))
                                .addGroup(layout.createSequentialGroup()
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(RPS)
                                        .addComponent(label1))))
                            .addGroup(layout.createParallelGroup()
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(18, 18, 18)
                                    .addComponent(clickerBtn, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(51, 51, 51)
                                    .addComponent(batidoPrice)))))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(testosterona, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addComponent(numTestosterona)))
                    .addContainerGap(149, Short.MAX_VALUE))
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
    private JLabel barritaPrice;
    private JLabel batidoPrice;
    private JLabel RPS;
    private JLabel label1;
    private JButton creatina;
    private JLabel numCreatina;
    private JButton testosterona;
    private JLabel numTestosterona;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
}
