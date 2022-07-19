import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
/*
 * Created by JFormDesigner on Mon Jul 18 20:09:31 CDT 2022
 */



/**
 * @author unknown
 */
public class draw extends JPanel {
    public draw() {
        initComponents();
        repaint();
        carPos.add(new Dimension(0,0));
        carPos.add(new Dimension(10,10));

    }
    ArrayList<Dimension> carPos = new ArrayList<>();
    Dimension startFinish = new Dimension(150,150);

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawOval(startFinish.width-5,startFinish.height-5,10,10);
        g.setColor(Color.BLACK);
        for(int i = 1 ; i<carPos.size();i++){
            g.drawLine(carPos.get(i).width,carPos.get(i).height,carPos.get(i-1).width,carPos.get(i-1).height);
        }

        Dimension intersect = intersect();
        g.setColor(isOnSegment(intersect)? Color.BLUE:Color.red);
        g.drawOval(intersect.width-5,intersect.height-5,10,10);
    }

    public boolean isOnSegment(Dimension point){
        int i=carPos.size()-1;
        if(Math.min(carPos.get(i).width,carPos.get(i-1).width)<point.width
            && Math.max(carPos.get(i).width,carPos.get(i-1).width)>point.width
            &&  Math.min(carPos.get(i).height,carPos.get(i-1).height)<point.height
                && Math.max(carPos.get(i).height,carPos.get(i-1).height)>point.height ){
            return true;
        }
        return false;
    }
    public Dimension intersect(){
        int i=carPos.size()-1;
        double mCar = (double)(carPos.get(i).height-carPos.get(i-1).height) / (double)(carPos.get(i).width-carPos.get(i-1).width);

        //System.out.println("Slope: "+mCar);
        double x = (startFinish.height + (startFinish.width/mCar) + carPos.get(i).width*mCar - carPos.get(i).height)
                / (mCar+1.0/mCar);
        double y = mCar * ( x - carPos.get(i).width)+ carPos.get(i).height;
        Dimension intersect = new Dimension((int)x,(int)y);
        //System.out.println(isOnSegment(intersect)?"True":"False");
        //System.out.println("Intersect X: "+ x + "  Y: "+y);
        return intersect;
    }

    private void thisMouseClicked(MouseEvent e) {
        carPos.add(new Dimension(e.getX(),e.getY()));
        repaint();
    }

    private void thisMouseDragged(MouseEvent e) {
        int i=carPos.size();
        carPos.get(i-1).width=e.getX();
        carPos.get(i-1).height=e.getY();
        repaint();

    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents

        //======== this ========
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                thisMouseClicked(e);
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                thisMouseDragged(e);
            }
        });
        setLayout(null);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
