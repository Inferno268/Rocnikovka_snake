package Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.sql.Time;

import Window.MyFrame;
import Window.MyPanel;
import com.sun.tools.javac.Main;

public class MainMenu extends JFrame implements ActionListener,Runnable {


    static final int DELAY = 75;

    JButton play = new JButton("Play");
    JButton easy = new JButton("Easy");
    public Thread t1;

    public void thread(){
        t1 = new Thread(this);
        t1.start();
    }

    public void menu(){
        play.setBounds(250,250,200,40);
        play.addActionListener(this);
        this.add(play);
        easy.setBounds(350,80,200,40);
        easy.addActionListener(this);
        this.add(easy);
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
           new MyFrame().create(75);

        }
       /* else if(e.getSource()==easy){
            this.dispose();
            new MyFrame().create(100);
        }
        else if(e.getSource()==easy){
            this.dispose();
            new MyFrame().create(100);
        }
        else if(e.getSource()==easy){
            this.dispose();
            new MyFrame().create(100);
        }*/
    }

    @Override
    public void run() {
        menu();
    }
}
