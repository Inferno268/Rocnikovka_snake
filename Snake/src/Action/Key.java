package Action;

import Menu.MainMenu;
import Window.MyPanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Key extends KeyAdapter {

    final MyPanel panel;
    public Key(MyPanel panel){
        this.panel = panel;
    }
//sets the values of direction
    public void keyPressed(KeyEvent e){
        if (panel.isRunning()) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (panel.getDirection() != 'R') {
                        panel.setDirection('L');
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (panel.getDirection() != 'L') {
                        panel.setDirection('R');
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (panel.getDirection() != 'D') {
                        panel.setDirection('U');
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (panel.getDirection() != 'U') {
                        panel.setDirection('D');
                    }
                    break;
            }
//if the game isn't running it will reset on any key input
        }else{
           panel.startGame();
        }
    }
}