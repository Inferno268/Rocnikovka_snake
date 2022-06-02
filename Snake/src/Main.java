import Menu.MainMenu;
import Window.MyFrame;
import Window.MyPanel;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        MainMenu menu = new MainMenu();
        menu.thread();
    }
}
