import java.awt.event.*;
import javax.swing.*;
import net.miginfocom.swing.*;

import java.awt.*;
/*
 * Created by JFormDesigner on Mon Jul 18 20:03:08 CDT 2022
 */



/**
 * @author unknown
 */
public class pointTest extends JFrame {
    public pointTest() {
        initComponents();
      //ActionListener taskPerformer = e -> {
      //    draw1.repaint();
      //   // System.out.println("Test");
      //};
      //new Timer(200,taskPerformer).start();
    }

    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(()-> new pointTest().setVisible(true));
    }

    private void draw1MouseClicked(MouseEvent e) {
        //System.out.println("Click");
    }





    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        draw1 = new draw();

        //======== this ========
        var contentPane = getContentPane();

        //---- draw1 ----
        draw1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                draw1MouseClicked(e);
            }
        });

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(draw1, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(draw1, GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE)
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private draw draw1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
