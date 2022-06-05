package Window;

import javax.swing.*;

public class PracticeFrame extends MyFrame{
    public PracticeFrame(){

    }

    public void create(){
        PracticePanel pPanel = new PracticePanel();
        this.add(pPanel);
        this.setTitle("Snake");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);


    }
}
