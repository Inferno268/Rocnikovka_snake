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

    JButton normal = new JButton("Normal");
    JButton easy = new JButton("Easy");
    JButton very_hard = new JButton("Very Hard");
    JButton hard = new JButton("Hard");
    JButton practice = new JButton("Practice close moves");
    final Font font = new Font("Comic sans", Font.BOLD, 25);

    public Thread t1;

    public void thread(){
        t1 = new Thread(this);
        t1.start();
    }

    public void menu(){
        easy.setBounds(250,200,200,40);
        easy.addActionListener(this);
        this.add(easy);

        normal.setBounds(250,250,200,40);
        normal.addActionListener(this);
        this.add(normal);

        hard.setBounds(250,300,200,40);
        hard.addActionListener(this);
        this.add(hard);

        very_hard.setBounds(250,350,200,40);
        very_hard.addActionListener(this);
        this.add(very_hard);

        practice.setBounds(250,400,200,40);
        practice.addActionListener(this);
        this.add(practice);

        this.setBackground(Color.black);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700,700);
        this.setLayout(null);
        this.setVisible(true);
        this.setLocationRelativeTo(null);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==easy){
            this.dispose();
            new MyFrame().create(100);
        }
        else if(e.getSource()==normal) {
            this.dispose();
            new MyFrame().create(75);
        }
        else if(e.getSource()==hard){
            this.dispose();
            new MyFrame().create(50);
        }
        else if(e.getSource()==very_hard){
            this.dispose();
            new MyFrame().create(25);
        }
        else if(e.getSource()==practice){
            this.dispose();
            new MyFrame().create(11);
        }
    }

    @Override
    public void run() {
        menu();
    }
}
