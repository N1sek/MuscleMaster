import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author denisc
 */
public class VentanaPrincipal extends JPanel {
    Click click = new Click();
    double realValue;
    Timer timer;
    boolean timerOn = false;
    int timerSpeed;
    Timer ticks;
    Map<String, Integer> mejoras = new HashMap<>();

    public VentanaPrincipal() {
        initComponents();
        click.setClickValue(1);
        click.setClickMultiplier(1);
        click.setCps(0);
        setTicksTimer();
    }

    public void setTicksTimer() {
        ticks = new Timer(timerSpeed, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (realValue >= getUpgradePrice("Barrita Energetica")) {
                    barritaEnergetica.setEnabled(true);
                } else {barritaEnergetica.setEnabled(false);}
                if (realValue >= getUpgradePrice("Batido Proteico")) {
                    batidoProteico.setEnabled(true);
                } else {batidoProteico.setEnabled(false);}
                numBarritas.setText("x" + mejoras.getOrDefault("Barrita Energetica", 0));
                barritaPrice.setText(String.valueOf((int) getUpgradePrice("Barrita Energetica")));
                numBatidos.setText("x" + mejoras.getOrDefault("Batido Proteico", 0));
                batidoPrice.setText(String.valueOf((int) getUpgradePrice("Batido Proteico")));
            }
        });
        ticks.start();
    };

    public void setTimer() {
         timer = new Timer(timerSpeed, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realValue += click.getClickValue();
                counterLbl.setText(""+(int) realValue);
            }
        });
    }

    public void timerUpdate() {
        if (click.getCps() != 0) {
            if (timerOn == false) {
                timerOn = true;
            } else if (timerOn == true) {
                timer.stop();
            }
            timerSpeed = (int) Math.round(1 / click.getCps() * 1000);
            setTimer();
            timer.start();
        }
    }

    private void button1MouseClicked(MouseEvent e) {
        realValue += click.click();
        int counter = (int) realValue;
        counterLbl.setText(String.valueOf(counter));
        timerUpdate();
    }

    private void menuBarItemBugMouseClicked(MouseEvent e) {
        // TODO add your code here
    }

    public void UpdateCPS() {
        double mult = 0;
        for (Map.Entry<String, Integer> entry : mejoras.entrySet()) {
            switch (entry.getKey()) {
                case "Barrita Energetica":
                    mult += entry.getValue() * 0.1;
                    break;
                case "Batido Proteico":
                    mult += entry.getValue() * 0.5;
                    break;
                default:
                    break;
            }
        }
        click.setCps(mult);
        label1.setText(String.format("%.2f", click.getCps()));
        timerUpdate();
    }

    private void barritaEnergeticaMouseClicked(MouseEvent e) {
        mejoraCPS("Barrita Energetica", 10, barritaEnergetica);
    }

    private void batidoProteicoMouseClicked(MouseEvent e) {
        mejoraCPS("Batido Proteico", 100, batidoProteico);
    }

    public double getUpgradePrice(String mejora) {
        switch (mejora) {
            case "Barrita Energetica":
                return 10 * ((mejoras.getOrDefault(mejora, 0) + 1));
            case "Batido Proteico":
                return 100 * ((mejoras.getOrDefault(mejora, 0) + 1));
            default:
                return 0;
        }
    }

    private void mejoraCPS(String mejora, int precioBase, JButton boton) {
        if (realValue >= getUpgradePrice(mejora)) {
            realValue -= getUpgradePrice(mejora);
            counterLbl.setText(String.valueOf((int) realValue));
            if (mejoras.containsKey(mejora)) {
                mejoras.put(mejora, mejoras.get(mejora) + 1);
            } else {
                mejoras.put(mejora, 1);
            }
            UpdateCPS();
            boton.setEnabled(false);
        }
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        clickerBtn = new JButton();
        clicksLbl = new JLabel();
        counterLbl = new JLabel();
        menuBar = new JMenuBar();
        menuBarItem = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();
        barritaEnergetica = new JButton();
        Mejoras = new JLabel();
        numBarritas = new JLabel();
        batidoProteico = new JButton();
        numBatidos = new JLabel();
        barritaPrice = new JLabel();
        batidoPrice = new JLabel();
        RPS = new JLabel();
        label1 = new JLabel();

        //======== this ========
        setBackground(new Color(0x375184));

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
        clicksLbl.setText("REPS:");
        clicksLbl.setFont(new Font("JetBrains Mono", Font.PLAIN, 20));

        //---- counterLbl ----
        counterLbl.setText("0");
        counterLbl.setFont(new Font("JetBrains Mono", Font.PLAIN, 18));

        //======== menuBar ========
        {

            //======== menuBarItem ========
            {
                menuBarItem.setText("File");
                menuBarItem.setFont(new Font("JetBrains Mono", Font.PLAIN, 15));

                //---- menuItem1 ----
                menuItem1.setText("Guardar");
                menuItem1.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
                menuBarItem.add(menuItem1);

                //---- menuItem2 ----
                menuItem2.setText("Cargar");
                menuItem2.setFont(new Font("JetBrains Mono", Font.PLAIN, 14));
                menuBarItem.add(menuItem2);
            }
            menuBar.add(menuBarItem);
        }

        //---- barritaEnergetica ----
        barritaEnergetica.setText("Barrita Energetica");
        barritaEnergetica.setEnabled(false);
        barritaEnergetica.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                barritaEnergeticaMouseClicked(e);
            }
        });

        //---- Mejoras ----
        Mejoras.setText("Mejoras");
        Mejoras.setFont(new Font("JetBrains Mono", Font.ITALIC, 16));

        //---- numBarritas ----
        numBarritas.setText("x0");

        //---- batidoProteico ----
        batidoProteico.setText("Batido Proteico");
        batidoProteico.setEnabled(false);
        batidoProteico.setActionCommand("Batido Proteico");
        batidoProteico.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                batidoProteicoMouseClicked(e);
            }
        });

        //---- numBatidos ----
        numBatidos.setText("x0");

        //---- barritaPrice ----
        barritaPrice.setText("10");

        //---- batidoPrice ----
        batidoPrice.setText("100");

        //---- RPS ----
        RPS.setText("RPS:");
        RPS.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));

        //---- label1 ----
        label1.setText("0");
        label1.setFont(new Font("JetBrains Mono", Font.PLAIN, 11));

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(clickerBtn, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup()
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(RPS)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(label1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(clicksLbl, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(counterLbl, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(126, 126, 126)
                            .addComponent(Mejoras))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(55, 55, 55)
                            .addComponent(barritaPrice)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(barritaEnergetica)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(numBarritas))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addComponent(batidoPrice)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(batidoProteico)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(numBatidos)))
                    .addContainerGap(566, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(counterLbl, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                        .addComponent(clicksLbl, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                        .addComponent(Mejoras))
                    .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(barritaEnergetica)
                                .addComponent(numBarritas)
                                .addComponent(barritaPrice))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(batidoProteico)
                                .addComponent(batidoPrice)
                                .addComponent(numBatidos)))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(RPS)
                                .addComponent(label1))
                            .addGap(51, 51, 51)
                            .addComponent(clickerBtn, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(300, Short.MAX_VALUE))
        );
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JButton clickerBtn;
    private JLabel clicksLbl;
    private JLabel counterLbl;
    private JMenuBar menuBar;
    private JMenu menuBarItem;
    private JMenuItem menuItem1;
    private JMenuItem menuItem2;
    private JButton barritaEnergetica;
    private JLabel Mejoras;
    private JLabel numBarritas;
    private JButton batidoProteico;
    private JLabel numBatidos;
    private JLabel barritaPrice;
    private JLabel batidoPrice;
    private JLabel RPS;
    private JLabel label1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


}