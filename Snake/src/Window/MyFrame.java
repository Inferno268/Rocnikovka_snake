package Window;

import Menu.MainMenu;
import Menu.Reset;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame /*implements Runnable*/ {
  //  public Thread t2;

    public MyFrame(){

    }

    public void create(int delay){
        MyPanel panel = new MyPanel(delay);
        this.add(panel);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        System.out.println("Easy");

    }


   /* @Override
    public void run() {
        create();
    }*/
}
