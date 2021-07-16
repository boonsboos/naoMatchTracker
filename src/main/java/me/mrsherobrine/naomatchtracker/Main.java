package me.mrsherobrine.naomatchtracker;

/*
    this program is made by github.com/mrsherobrine
    please read the licensing information in the readme
    thanks for using my tool
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Main {

    public void makeDir() throws IOException {
        String b = System.getProperty("user.dir") + "\\trackerfiles";
        boolean a = new File(b).mkdir();
        boolean c = new File(b+"\\timespent.db").createNewFile();
    }

    public JTextField textField = new JTextField("");
    public JFrame window = new JFrame("naoMatchTracker");
    public JButton button = new JButton("Insert");
    public JLabel howtoLabel = new JLabel("Input your match time in mm:ss format here ^");
    public JLabel averageLabel = new JLabel("Average match duration: ");
    public JLabel totalLabel = new JLabel("Total time spent in game: ");
    public Container cp = window.getContentPane();
    public String averageDurationToStopDeletionBecauseIAmLazy = "Average match duration: ";
    public String totalDurationToStopWipingItEveryButtonClick = "Total time spent in game: ";
    public String h = "";

    public Main() throws IOException {

        makeDir();

        window.setSize(500,400);
        Dimension a = Toolkit.getDefaultToolkit().getScreenSize();
        window.setLocation(((a.width - window.getSize().width)/2), ((a.height - window.getSize().height)/2));

        URL iconLocation = this.getClass().getResource("/files/icon.png");
        Image icon = ImageIO.read(iconLocation);
        window.setIconImage(icon);
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        button.setBounds(48, 256, 153, 33);
        button.addActionListener(this::insertButtonActionPerformed);
        button.setBackground(new Color(0x5f5f5f));
        button.setForeground(Color.white);
        button.setBorder(BorderFactory.createLineBorder(Color.white, 1, true));
        button.setFocusable(false);

        textField.setBounds(240, 256, 145, 33);
        textField.setBackground(new Color(0x212121));
        textField.setForeground(Color.white);
        averageLabel.setBounds(48, 72, 400, 57);
        averageLabel.setBackground(new Color(0x212121));
        averageLabel.setForeground(Color.white);
        totalLabel.setBounds(48, 152, 400, 65);
        totalLabel.setBackground(new Color(0x212121));
        totalLabel.setForeground(Color.white);
        howtoLabel.setBounds(48, 304, 400, 33);
        howtoLabel.setBackground(new Color(0x212121));
        howtoLabel.setForeground(Color.white);

        cp.setLayout(null);
        cp.setBackground(new Color(0x212121));
        cp.add(button);
        cp.add(textField);
        cp.add(averageLabel);
        cp.add(totalLabel);
        cp.add(howtoLabel);
        window.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            new Main();
        } catch (IOException exc) {
            exc.printStackTrace();
        }
    }

    public void insertButtonActionPerformed(ActionEvent e){
        try {
            h = textField.getText();
            if (!h.contains(":")) throw new Error();
            DatabaseMagic.databaseMagicInsert(h);
            System.out.println(DatabaseMagic.databaseMagicTotal(h) + " from main");
            System.out.println(DatabaseMagic.databaseMagicAverage(h) + " from main");
            textField.setText("");
            howtoLabel.setText("Input your match time in mm:ss format here ^");
            howtoLabel.setForeground(Color.white);
            textField.setBackground(new Color(0x212121));
        } catch (Exception | Error whoops) {
            howtoLabel.setText("That's not in mm:ss format!");
            howtoLabel.setForeground(new Color(0xdf1310));
            textField.setBackground(Color.red);
            textField.setText("");
        }
    }

}
