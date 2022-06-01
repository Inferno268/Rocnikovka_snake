package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Time;

import Window.MyFrame;
import Window.MyPanel;

public class MainMenu extends JFrame implements ActionListener {


    static final int DELAY = 75;

    JButton play = new JButton("Play");
    MyFrame MyFrame = new MyFrame();
    MyPanel panel = new MyPanel();



    public MainMenu(){
        play.setBounds(250,250,200,40);
        play.addActionListener(this);
        this.add(play);
        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==play) {
            this.dispose();
        MyFrame.create();
        }
    }
}
