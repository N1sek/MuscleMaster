import java.awt.*;
import java.awt.event.*;
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

    public VentanaPrincipal() {
        initComponents();
        click.setClickValue(1);
        click.setClickMultiplier(1);
        click.setCps(0);
    }

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

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        clickerBtn = new JButton();
        clicksLbl = new JLabel();
        counterLbl = new JLabel();
        menuBar = new JMenuBar();
        menuBarItem = new JMenu();
        menuItem1 = new JMenuItem();
        menuItem2 = new JMenuItem();

        //======== this ========
        setBackground(Color.white);

        //---- clickerBtn ----
        clickerBtn.setText("Press Banca");
        clickerBtn.setIcon(new ImageIcon(getClass().getResource("/assets/press1.png")));
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

        GroupLayout layout = new GroupLayout(this);
        setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup()
                .addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE)
                .addGroup(layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addGroup(layout.createParallelGroup()
                        .addComponent(clickerBtn, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(clicksLbl, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                            .addGap(33, 33, 33)
                            .addComponent(counterLbl, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(768, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup()
                .addGroup(layout.createSequentialGroup()
                    .addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                    .addGap(26, 26, 26)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(clicksLbl, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                        .addComponent(counterLbl, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
                    .addGap(57, 57, 57)
                    .addComponent(clickerBtn, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(316, Short.MAX_VALUE))
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
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on


}