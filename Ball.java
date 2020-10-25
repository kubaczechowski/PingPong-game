import greenfoot.*;

public class Ball extends SmoothMover
{
    private static final int BALL_SIZE = 25;
    private static final int BOUNCE_DEVIANCE_MAX = 10;
    private static final int STARTING_ANGLE_WIDTH = 90;
    private static final int DELAY_TIME = 100;
    
    public static int ballX;

    private int speed;
    private boolean hasBouncedHorizontally;
    private boolean hasBouncedVertically;
    public static boolean topDown;
    private int delay;
    private int level = 0;
    private int ballSpeedCount = 0;

    public Ball()
    {
        setImage("ball.png");
        init();
        topDown = true;
    }

    public void act() 
    {
        ballX();
        if (delay > 0)
        {
            delay--;
        }
        else
        {
            move(speed);
            bounceOffPaddle(Paddle.class);
            bounceOffEnemy(RandomPaddle.class);
            bounceOffEnemy(SmartPaddle.class);
            checkBounceOffWalls();
            checkBounceOffCeiling();
            speedAndLevel();
            gameOver();
        }
    }    

    public void bounceOffEnemy(Class clss)
    {        
        Actor actor = getOneObjectAtOffset(0, 0, clss);    
        if(actor != null) 
        {  
           
           if (topDown != true)
           {
               Greenfoot.playSound("hit v1.mp3");
               int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX);
               setRotation((360 - getRotation()+ randomness + 360) % 360);
               topDown = true;
           }
           else
           {
                move(speed);
           }
        }
    }
    
    public void bounceOffPaddle(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) 
        {
            Greenfoot.playSound("hit v2.mp3");
            int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX);
            setRotation((360 - getRotation()+ randomness + 360) % 360);
            
            topDown = false;
            
            move(speed);        
                        
            ballSpeedCount = ballSpeedCount+1;
        }
    }
    
    private void speedAndLevel()
    {
        if (ballSpeedCount == 10)// remember to change it to 10
        {
           speed = speed+1;
           
           PingWorld pw = (PingWorld)getWorld();
           pw.addLevel(1);
           //level = level +1;
           ballSpeedCount = 0;
        }
    }
   
    private boolean isTouchingSides()
    {
        return (getX() <= BALL_SIZE/2 || getX() >= getWorld().getWidth() - BALL_SIZE/2);
    }

    private boolean isTouchingCeiling()
    {
        return (getY() <= BALL_SIZE/2);        
    }

    private boolean isTouchingFloor()
    { 
        return (getY() >= getWorld().getHeight() - BALL_SIZE/2);
    }
    
    private void gameOver(){
        if (isTouchingFloor()){
           Greenfoot.setWorld(new GameOverWorld(false, 1));
        }
    }          
    
    
    private void checkBounceOffWalls()
    {
        if (isTouchingSides())
        {
            if (! hasBouncedHorizontally)
            {
                revertHorizontally();
            }
        }
        else
        {
            hasBouncedHorizontally = false;
        }
    }

    private void checkBounceOffCeiling()
    {
        if (isTouchingCeiling())
        {
            if (! hasBouncedVertically)
            {
                revertVertically();
                topDown = true;
            }
        }
        else
        {
            hasBouncedVertically = false;
        }
    }
 
    
    /*private void checkRestart()
    {
        if (isTouchingFloor())
        {
            init();
            setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
    }*/

    private void revertHorizontally()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX);
        setRotation((180 - getRotation()+ randomness + 360) % 360);
        hasBouncedHorizontally = true;
    }

    private void revertVertically()
    {
        int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX);
        setRotation((360 - getRotation()+ randomness + 360) % 360);
        hasBouncedVertically = true;
        /*if (topDown == true)
        {   
    if (getX() >= 250)
    {
        if (getRotation() >= 89)
        {
            setRotation((89 - randomness));
        }
    }
    else
    if (getX() <= 250)
    {
        if (getRotation() <= 91)
        {
            setRotation((91 + randomness));
                }
    }
        }
        else
        if (topDown != true)
        {
    if (getX() >= 250)
    {
        if (getRotation() <= 271)
        {
            setRotation((271 + randomness));
        }
    }
    else
    if (getX() <= 250)
        {
        if (getRotation() >= 269)
        {
            setRotation((269 - randomness));
        }
                }
        }*/
    
    }

    private void init()
    {
        speed = 3;
        delay = DELAY_TIME;
        hasBouncedHorizontally = false;
        hasBouncedVertically = false;
        setRotation(Greenfoot.getRandomNumber(STARTING_ANGLE_WIDTH)+STARTING_ANGLE_WIDTH/2);
    }
    
    public void ballX()
    {
         ballX = getX();
    }
    
    /*public static int ReturnLevel()
    {
        return level;
    }*/
    

}
