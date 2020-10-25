import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerScore extends Actor
{
    
    public PlayerScore(int score) 
    {
        setScore(score);
    }    
    
    public void setScore(int score){
        setImage(new GreenfootImage(String.valueOf(score), 18, Color.GRAY, new Color(0,0,0,0), Color.GRAY));
    }
}
