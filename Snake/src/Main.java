import Menu.MainMenu;
import Window.MyFrame;
import Window.MyPanel;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //MyFrame frame = new MyFrame();
        //frame.create();
        MainMenu menu = new MainMenu();
        menu.thread();
    }
}
