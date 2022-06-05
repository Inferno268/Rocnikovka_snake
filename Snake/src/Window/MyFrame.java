package Window;

import javax.swing.*;

public class MyFrame extends JFrame {

    public MyFrame(){

    }
//Method with DELAY parameter
    public void create(int delay){
        MyPanel panel = new MyPanel(delay);
        this.add(panel);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }

}
