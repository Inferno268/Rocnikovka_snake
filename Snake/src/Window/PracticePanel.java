 package Window;
 import Action.PracticeKey;
 import javax.swing.*;
 import java.awt.*;

 public class PracticePanel extends MyPanel{

     PracticeKey key = new PracticeKey(this);

     public PracticePanel() {
         startGame();
     }


 //display JPanel and set the body to 1000
     public void startGame(){
         this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
         this.setBackground(Color.white);
         this.setFocusable(true);
         this.addKeyListener(key);
         direction= 'R';
         x = new int[UNITS];
         y = new int[UNITS];
         body =1000;
         running =true;
         timer = new Timer(DELAY,this);
         timer.start();

     }

     public void draw(Graphics g){
         if(running){
//snake itself
             for (int i=0; i<body; i++){
                 if(i == 0){
                     g.setColor(new Color(0,204,0));
                     g.fillRect(x[i],y[i],TILE,TILE);
                 }
                 else{
                     g.setColor(new Color(0,255,0));
                     g.fillRect(x[i],y[i], TILE,TILE);
                 }
             }
//text
             g.setColor(Color.black);
             g.setFont(font);
             FontMetrics metrics = getFontMetrics(g.getFont());
             g.drawString("PRACTICE",( WIDTH - metrics.stringWidth("PRACTICE:"))/2,g.getFont().getSize());
         }
         else{
             end(g);
         }
     }
 //only changes the text
     public void end(Graphics g){
         String endText = " Press anything to reset";
         this.setBackground(Color.BLACK);
         g.setColor(Color.blue);
         g.setFont(font);
         g.drawString(endText,(WIDTH-getFontMetrics(g.getFont()).stringWidth(endText))/2,HEIGHT/2);
     }
}
