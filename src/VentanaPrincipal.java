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
                if (realValue >= 10) {
                    barritaEnergetica.setEnabled(true);
                }
                numBarritas.setText("x" + mejoras.getOrDefault("Barrita Energetica", 0));
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
        mejoras.forEach((k, v) -> {
            double mult = 0.1;
            switch (k) {
                case "Barrita Energetica":
                    mult = mult * 4;
                    break;
                case "Batido Proteico":
                default:
                    break;
            }
            click.setCps(click.getCps() + (mejoras.get(k) * mult));
        });
        timerUpdate();
    }

    private void barritaEnergeticaMouseClicked(MouseEvent e) {
        if (realValue >= 10) {
            realValue -= 10;
            counterLbl.setText(String.valueOf((int) realValue));
            if (mejoras.containsKey("Barrita Energetica")) {
                mejoras.put("Barrita Energetica", mejoras.get("Barrita Energetica") + 1);
            } else {
                mejoras.put("Barrita Energetica", 1);
            }
            UpdateCPS();
            barritaEnergetica.setEnabled(false);
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

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addComponent(clickerBtn, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(clicksLbl, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(counterLbl, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addGap(126, 126, 126)
                            .addComponent(Mejoras))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(95, 95, 95)
                            .addComponent(barritaEnergetica)
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(numBarritas)))
                    .addContainerGap(543, Short.MAX_VALUE))
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
                    .addGroup(layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                .addComponent(barritaEnergetica)
                                .addComponent(numBarritas)))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(clickerBtn, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(355, Short.MAX_VALUE))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


}