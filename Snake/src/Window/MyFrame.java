package Window;

import Menu.MainMenu;
import com.sun.tools.javac.Main;

import javax.swing.*;

public class MyFrame extends JFrame {
    MyPanel panel = new MyPanel();
    MainMenu menu = new MainMenu();
    public void createMenu(){
        this.add(menu);
        this.pack();
        this.setVisible(true);

    }
    public void create(){
        this.add(panel);
        this.setTitle("Snake");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
