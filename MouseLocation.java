import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.MouseInfo;
import javax.swing.*;

/**
 *
 * @author Brian Sutton
 */
public class MouseLocation extends JFrame {

    static JTextField text = new JTextField();
    static JPanel panel = new JPanel();

    public MouseLocation() {

        getContentPane().setLayout(new FlowLayout());
        panel.setSize(200, 150);
        text.setPreferredSize(new Dimension(200,50));
        Font f = new Font("SansSerif", Font.BOLD, 20);
        text.setFont(f);
        panel.add(text);
        getContentPane().add(panel);
        text.setText(MouseInfo.getPointerInfo().getLocation() + "");
    }


    public static void main(String[] args) {

        MouseLocation m = new MouseLocation();
        m.setSize(400, 150);
        m.setTitle("Mouse Location");
        m.setVisible(true);
        m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        int x;
        int y;
        while (true) {
            x = (int) MouseInfo.getPointerInfo().getLocation().getX() ;
            y = (int)( MouseInfo.getPointerInfo().getLocation().getY() );
            text.setText("X = " + x + " Y = " + y);
            try {
                Thread.sleep(150);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
