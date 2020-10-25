import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class GameOverWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;
    private int chosenMode;
    private GreenfootImage playAgain1;
    private GreenfootImage playAgain2;
    private GreenfootImage exit1;
    private GreenfootImage exit2;
    private int delay;
    private boolean p1Wins;

    public GameOverWorld(boolean p1Wins, int mode)
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); 
        Greenfoot.playSound("loose.mp3");
        delay = 0;
        chosenMode = 1;
        playAgain1 = new GreenfootImage("again1.png");
        playAgain2 = new GreenfootImage("again2.png");
        exit1 = new GreenfootImage("exit1.png");
        exit2 = new GreenfootImage("exit2.png");
        setBackground(playAgain1);
        
        
        String winner = null;
        if (p1Wins == true && mode == 2) {
            winner = "win1.png";
        } 
        
        if (p1Wins == false && mode == 2) {
            winner = "win2.png";
        }
        
        if (winner != null) {
            addObject( new WinningPlayerImage(winner), WORLD_WIDTH/2, 210);
        }
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
            Greenfoot.stop();
        } else if (key != null && key.equals("enter") && chosenMode == 1) {
            Greenfoot.setWorld(new IntroWorld());
        }
    }

    private void backgroundChange()
    {
        delay++;
        if (chosenMode == 1 && delay == 30) {
            if(getBackground() == playAgain1) {
                setBackground(playAgain2);
                delay = 0;
            } else {
                setBackground(playAgain1);
                delay = 0;
            }
        }
        if (chosenMode == 2 && delay == 30) {
            if(getBackground() == exit1) {
                setBackground(exit2);
                delay = 0;
            } else {
                setBackground(exit1);
                delay = 0;
            }
        }
        
    }
}
