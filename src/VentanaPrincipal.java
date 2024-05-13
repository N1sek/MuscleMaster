import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author denisc
 */
public class VentanaPrincipal extends JPanel {
    public VentanaPrincipal() {
        initComponents();
    }

    private void clickerBtnMouseClicked(MouseEvent e) {
        int counter = Integer.parseInt(counterLbl.getText());
        counter++;
        counterLbl.setText(String.valueOf(counter));
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

        //---- clickerBtn ----
        clickerBtn.setText("CLICK");
        clickerBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                clickerBtnMouseClicked(e);
            }
        });

        //---- clicksLbl ----
        clicksLbl.setText("Clicks:");
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
                        .addGroup(layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(clicksLbl, GroupLayout.PREFERRED_SIZE, 94, GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(counterLbl, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(clickerBtn, GroupLayout.PREFERRED_SIZE, 234, GroupLayout.PREFERRED_SIZE))
                                .addGap(298, 768, Short.MAX_VALUE))
                        .addComponent(menuBar, GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup()
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(menuBar, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(clicksLbl, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(counterLbl, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE))
                                .addGap(78, 78, 78)
                                .addComponent(clickerBtn, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(321, Short.MAX_VALUE))
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