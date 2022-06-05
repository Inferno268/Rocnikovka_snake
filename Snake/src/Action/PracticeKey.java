package Action;

import Window.PracticePanel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PracticeKey extends KeyAdapter {

    final PracticePanel pPanel;


    public PracticeKey(PracticePanel pPanel) {
        this.pPanel = pPanel;
    }

    public void keyPressed(KeyEvent e){
        if (pPanel.isRunning()) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (pPanel.getDirection() != 'R') {
                        pPanel.setDirection('L');
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (pPanel.getDirection() != 'L') {
                        pPanel.setDirection('R');
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (pPanel.getDirection() != 'D') {
                        pPanel.setDirection('U');
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (pPanel.getDirection() != 'U') {
                        pPanel.setDirection('D');
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    if (!pPanel.isRunning()){
                        pPanel.startGame();
                    }
            }
        }else{
            pPanel.startGame();
        }
    }
}
