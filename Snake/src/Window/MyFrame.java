package Window;

import Menu.MainMenu;
import Menu.Reset;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame /*implements Runnable*/ {
    MyPanel panel = new MyPanel();
  //  public Thread t2;

    public MyFrame(){
        this.add(panel);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        System.out.println("fafga");
    }

    public void create(){


    }


   /* @Override
    public void run() {
        create();
    }*/
}
