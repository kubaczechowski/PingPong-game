import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameLevelImage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameLevelImage extends Actor
{
    private static int level = 1;

    public GameLevelImage()
    {
        setLevel(level);
        /*level = Ball.ReturnLevel();
        setImage(new GreenfootImage(String.valueOf(level), 18, Color.GRAY, new Color(0,0,0,0), Color.GRAY));*/
    }   
    
    public void setLevel(int level){
        setImage(new GreenfootImage(String.valueOf(level), 18, Color.GRAY, new Color(0,0,0,0), Color.GRAY));
    }
}
