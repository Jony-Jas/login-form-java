import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dialog extends JFrame implements ActionListener {
    private static JDialog d1;
    private static JButton b;
    private static JLabel l;
    Dialog(String msg){
        d1 = new JDialog(new JFrame(),"Status");
        d1.setLayout(null);
        d1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        l = new JLabel(msg);
        l.setBounds(80, 50, 200, 20);
        b = new JButton("Ok");
        b.setBounds(90, 100, 100, 20);
        b.addActionListener(this);

        d1.add(b);
        d1.add(l);

        d1.setLocation(550, 300);
        d1.setResizable(false);
        d1.setSize(300,200);
        d1.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        d1.dispose();
    }

}
