import greenfoot.*;

public class IntroWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;
    private int chosenMode;
    private GreenfootImage player1;
    private GreenfootImage player2;
    private GreenfootImage computer1;
    private GreenfootImage computer2;
    private int delay;
    static GreenfootSound backgroundMusic = new GreenfootSound("background.mp3");
    
    public IntroWorld()
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1);
        backgroundMusic.playLoop();
        chosenMode = 1;
        delay = 0;
        player1 = new GreenfootImage("player1.png");
        player2 = new GreenfootImage("player2.png");
        computer1 = new GreenfootImage("computer1.png");
        computer2 = new GreenfootImage("computer2.png");
        setBackground(player1);
    }

    public void act() 
    {
        backgroundChange();
        checkKeys();
    }
    
    private void checkKeys()
    {
        String key = Greenfoot.getKey();
        if (key != null && key.equals("right")) {
            chosenMode = 2;
            Greenfoot.playSound("menu select.mp3");
        } else if (key != null && key.equals("left")) {
            chosenMode = 1;
            Greenfoot.playSound("menu select.mp3");
        } else if (key != null && key.equals("enter") && chosenMode == 2) {
            Greenfoot.setWorld(new PingWorld());
        } else if (key != null && key.equals("enter") && chosenMode == 1) {
            Greenfoot.setWorld(new PlayerPlayerWorld());
        }
    }

    private void backgroundChange()
    {
        delay++;
        if (chosenMode == 1 && delay == 30) {
            if(getBackground() == player1) {
                setBackground(player2);
                delay = 0;
            } else {
                setBackground(player1);
                delay = 0;
            }
        }
        if (chosenMode == 2 && delay == 30) {
            if(getBackground() == computer1) {
                setBackground(computer2);
                delay = 0;
            } else {
                setBackground(computer1);
                delay = 0;
            }
        }
        
    }
}
