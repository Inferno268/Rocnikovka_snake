package Window;
import Action.Key;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyPanel extends JPanel implements ActionListener{

    static final int WIDTH = 700;
    static final int HEIGHT = 700;
    static final int TILE = 25;
    static final int UNITS = ((WIDTH *HEIGHT)/TILE);
    public int DELAY;   //fps
    public int y[] = new int[UNITS];    //y snake coordinates
    public int x[] = new int[UNITS];    //x snake coordinates


    int body;
    int apples =0;
    int applex;                         //x apple coordinates
    int appley;                         //y apple coordinates
    int pApplex;                         //x apple coordinates
    int pAppley;
    public char direction;
    boolean running= false;


    final Font font = new Font("Comic sans", Font.BOLD, 25);

    public Timer timer;

    Key key = new Key(this);
    Random rd = new Random();

//Setters and Getters
        public void setDirection(char direction) {
            this.direction = direction;
        }

        public char getDirection() {
            return direction;
        }

        public boolean isRunning() {
            return running;
        }

    //Constructor with int parameter that sets fps, and then start the game
        public MyPanel(int DELAY){
            this.DELAY = DELAY;
            startGame();
        }


    public void startGame(){
        this.setPreferredSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.white);
        this.setFocusable(true);
        this.addKeyListener(key);
        direction= 'R';
        x = new int[UNITS];
        y = new int[UNITS];
        poisonApple();
        apple();
        appleError();
        apples = 0;
        body =4;
        running =true;
        timer = new Timer(DELAY,this);
        timer.start();


        }
//drawing objects on the screen
        public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
        }

            public void draw(Graphics g){
            if(running){
//apple
                g.setColor(Color.red);
                g.fillOval(applex,appley,TILE,TILE);
                g.setColor(Color.blue);
                g.fillOval(pApplex,pAppley,TILE,TILE);
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
                g.drawString("SCORE:"+ apples,( WIDTH - metrics.stringWidth("SCORE:"))/2,g.getFont().getSize());
            }
            else{
//if running equals false this will display end screen
               end(g);
            }
        }
//spawns an apple
        public void apple(){
            applex = rd.nextInt((WIDTH/TILE))*TILE;
            appley = rd.nextInt((HEIGHT/TILE))*TILE;
        }
//spawns an poison apple
        public void poisonApple(){
            pApplex = rd.nextInt((WIDTH/TILE))*TILE;
            pAppley = rd.nextInt((HEIGHT/TILE))*TILE;
        }
//if both apples spawn at the same coor normal apple will change position
    public void appleError(){
            if ((applex== pApplex) && (appley == pAppley)){
                applex = rd.nextInt((WIDTH/TILE))*TILE;
                appley = rd.nextInt((HEIGHT/TILE))*TILE;
            }
    }

//moving snake
        public void move(){
            if (body >1){
            for(int i=body; i>0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }
            }else{
                running =false;
            }


        System.out.println(direction);

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
//method that checks if head of snake match coors of an apple, and if it does body and score will get bigger
        public void check(){
        if((x[0] == applex) && (y[0] == appley)){
            body++;
            apples++;
            apple();
        }
            if((x[0] == pApplex) && (y[0] == pAppley)){
                body--;
                apples--;
                poisonApple();
            }
        }
//checks if the snake crossed the frame border or if it crashes into itself
    //itself:
        public void collison(){
            for (int i = body; i>0; i--){
                if ((x[0] == x[i]) && (y[0] == y[i])){
                    running= false;
                    break;
                }
            }
        //frame border:
                if (x[0] < 0 || x[0] >= WIDTH || y[0] < 0 || y[0] >= HEIGHT)  {
                    running= false;

                }
                if (!running){
                    timer.stop();
                }

        }
//End screen text
        public void end(Graphics g){
            String endText = "The end. Your score was: " + apples + " Press anything to reset";
            this.setBackground(Color.BLACK);
            g.setColor(Color.blue);
            g.setFont(font);
            g.drawString(endText,(WIDTH-getFontMetrics(g.getFont()).stringWidth(endText))/2,HEIGHT/2);

        }
//all the methods related to moving
        @Override
        public void actionPerformed(ActionEvent e) {
            if(running){
            move();
            check();
            collison();

        }
        repaint();
        }


    }

