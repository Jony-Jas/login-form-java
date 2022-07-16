import db.dbStore;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {
    JLabel l1, l2;
    JButton b;
    JTextField t1;
    JPasswordField t2;
    JTabbedPane p1;

    Main() {
        Container co = getContentPane();
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        l1 = new JLabel("Username");
        l1.setBounds(90, 50, 150, 100);
        t1 = new JTextField();
        t1.setBounds(90, 115, 150, 30);
        l2 = new JLabel("Password");
        l2.setBounds(90, 110, 150, 100);
        t2 = new JPasswordField();
        t2.setBounds(90, 175, 150, 30);
        t2.setEchoChar('*');
        b = new JButton("Submit");
        b.setBounds(90, 220, 100, 30);

        b.addActionListener(this);

        co.add(l1);
        co.add(t1);
        co.add(l2);
        co.add(t2);
        co.add(b);

        setResizable(false);
        setSize(400, 450);
        setLocation(500, 200);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = t1.getText();
        String pass = t2.getText();
        dbStore obj = new dbStore(name, pass);

        if (obj.insertUser()) {
            new Dialog("Logged in Successfully.");
            t1.setText("");
            t2.setText("");
        }
        else
        {
            new Dialog("Something went wrong");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
