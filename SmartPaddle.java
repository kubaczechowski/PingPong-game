import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class SmartPaddle extends Actor
{
     private int width ;
    private int height ;
    
    public SmartPaddle(int width, int height)
    {
        this.width = width;
        this.height = height;
        setImage("paddle2.png");
    }
    
    public void act() 
    {
        behaviour();
    } 
    
    private void behaviour()
    { //Ball b = new Ball();
        
        if(Ball.ballX> getX() && Ball.topDown ==false)
            move(2);
        
        if(Ball.ballX< getX() && Ball.topDown ==false)
            move(-2);
       
        if(Ball.topDown)
        {
            int defaultPosition = getWorld().getWidth() / 2;
            if(getX()> defaultPosition)
                move(-1);
            if(getX()< defaultPosition)
                move(1);
                
        }
            // non static method ballX cannot be referenced from a static context so i will make a staic varaibel
            
    }
    
   
}
