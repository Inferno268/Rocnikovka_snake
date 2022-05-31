package Window;
import Action.Key;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Time;
import java.util.Random;

public class MyPanel extends JPanel implements ActionListener  {

    static final int WIDTH = 700;
    static final int HEIGHT = 700;
    static final int TILE = 25;
    static final int UNITS = ((WIDTH *HEIGHT)/TILE);
    static final int DELAY = 60;
    public final int y[] = new int[UNITS];
    public final int x[] = new int[UNITS];
    int body = 1;
    int apples =0;
    int applex;
    int appley;
    int pApplex;
    int pAppley;
    public char direction = 'D';
    boolean running;
    Timer timer;
    Key key = new Key(this);
    Random rd = new Random();

    public void setDirection(char direction) {
        this.direction = direction;
    }

    public char getDirection() {
        return direction;

    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public boolean isRunning() {
        return running;
    }

    public MyPanel(){
    this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
    this.setBackground(Color.white);
    this.setFocusable(true);
    this.addKeyListener(key);
    startGame ();
    }
    public void startGame(){
    apple();
    poisonApple();
    running =true;
    timer = new Timer(DELAY,this);
    timer.start();


    }

    public void paintComponent(Graphics g){
    super.paintComponent(g);
    draw(g);
    }

        public void draw(Graphics g){
        if(running){

            g.setColor(Color.red);
            g.fillOval(applex,appley,TILE,TILE);
            g.setColor(Color.blue);
            g.fillOval(pApplex,pAppley,TILE,TILE);

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
            g.setColor(Color.red);
            g.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));

            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("SCORE:"+ apples,( WIDTH - metrics.stringWidth("SCORE:"))/2,g.getFont().getSize());
        }
        else{
            end(g);
        }
    }
    public void apple(){
        applex = rd.nextInt((WIDTH/TILE))*TILE;
        appley = rd.nextInt((HEIGHT/TILE))*TILE;
    }
    public void poisonApple(){
        pApplex = rd.nextInt((WIDTH/TILE))*TILE;
        pAppley = rd.nextInt((HEIGHT/TILE))*TILE;
    }


    public void move(){
    for(int i=body; i>0; i--) {
        x[i] = x[i - 1];
        y[i] = y[i - 1];
    }


    switch  (direction){
        case 'U':
            y[0] = y[0] - TILE;
            break;
        case 'D':
            y[0] = y[0] + TILE;
            break;
        case 'L':
            x[0] = x[0] - TILE;
            break;
        case 'R':
            x[0] = x[0] + TILE;
            break;

    }
    }

    public void check(){
    if((x[0] == applex) && (y[0] == appley)){
        body++;
        apples++;
        apple();
    }
    }
    public void pCheck(){
        if((x[0] == pApplex) && (y[0] == pAppley)){
            body--;
            apples--;
            apple();
        }
    }
    public void collison(){
        for (int i = body; i>0; i--){
            if ((x[0] == x[i]) && (y[0] == y[i])){
                running =false;
            }
        }
            if (x[0] < 0){
                running=false;
            }
            if (x[0] > WIDTH){
                running=false;
            }
            if (y[0] < 0){
                running=false;
            }
            if (y[0] > HEIGHT){
                running = false;
            }
            if (!running){
                timer.stop();
            }

    }

    public void end(Graphics g){
        g.setColor(Color.red);
        g.setFont(new Font("Comic Sans MS", Font.PLAIN, 75));
        FontMetrics metrics = getFontMetrics(g.getFont());
        g.drawString("GAME OVER",( WIDTH - metrics.stringWidth("GAME OVER"))/2,HEIGHT/2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    if(running){
        move();
        check();
        pCheck();
        collison();
    }
    repaint();
    }

}

