package me.mrsherobrine.naomatchtracker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    this program is made by github.com/mrsherobrine
    please read the licensing information in the readme
    thanks for using my tool
 */

public class Main {

    public JTextField textField = new JTextField("mm:ss");
    public JFrame window = new JFrame("naoMatchTracker");
    public JButton button = new JButton("Insert");
    public JPanel panel = new JPanel();

    public Main() {
        Dimension a = new Dimension();
        a.setSize(400, 400);
        System.getProperty("user.dir");
        Image icon = Toolkit.getDefaultToolkit().getImage("files/icon.png");

        window.setMinimumSize(a);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setIconImage(icon);
        //window.setLayout(new GridBagLayout());

        button.setBounds(0,0, 200, 50);
        button.addActionListener(this::insertButtonActionPerformed);

        textField.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        textField.setSize(300, 120);

        panel.setSize(400,400);
        panel.add(button);
        panel.add(textField);
        window.add(panel/*, new GridBagConstraints()*/);
        window.pack();
        window.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    public void insertButtonActionPerformed(ActionEvent e) {
        textField.setText("lol u dum");
    }
}
