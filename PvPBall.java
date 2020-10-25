import greenfoot.*;

public class PvPBall extends SmoothMover
{
    private static final int pvpBALL_SIZE = 25;
    private static final int BOUNCE_DEVIANCE_MAX = 10;
    private static final int STARTING_ANGLE_WIDTH = 90;
    private static final int DELAY_TIME = 100;
    
    public static int pvpBallX;

    private int speed;
    private boolean hasBouncedHorizontally;
    private boolean hasBouncedVertically;
    private boolean towardsP1;
    private boolean topDown;
    private int delay;
    
    private int level = 0;
    private int ballSpeedCount = 0;

    public PvPBall()
    {
        setImage("ball.png");
        init();
        this.towardsP1 = true;
    }

    public void act() 
    {
        pvpBallX();
        if (delay > 0)
        {
            delay--;
        }
        else
        {
            move(speed);
            bounceOffPaddle1(Paddle.class);
            bounceOffPaddle2(PvPPaddle.class);
            checkBounceOffWalls();
            speedAndLevel();            
            checkIfScoreP1();
            checkIfScoreP2();            
            checkRestartP1();
            checkRestartP2();
        }
    }      
  
    public void bounceOffPaddle1(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) 
        {
            Greenfoot.playSound("hit v2.mp3");
            int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX);
            setRotation((360 - getRotation()+ randomness + 360) % 360);
                       
            move(speed);        
                        
            ballSpeedCount = ballSpeedCount+1;
            topDown = false;
        }
    }
    
    public void bounceOffPaddle2(Class clss)
    {
        Actor actor = getOneObjectAtOffset(0, 0, clss);
        if(actor != null) 
        {
            Greenfoot.playSound("hit v1.mp3");
            int randomness = Greenfoot.getRandomNumber(BOUNCE_DEVIANCE_MAX);
            setRotation((360 - getRotation()+ randomness + 360) % 360);
                       
            move(speed);        
                        
            ballSpeedCount = ballSpeedCount+1;
            
            topDown = true;
        }
    }
    
    private void speedAndLevel()
    {
        if (ballSpeedCount == 10)
        {
            speed = speed+1;
            level = level +1;
            ballSpeedCount = 0;
        }
    }
   
    private boolean isTouchingSides()
    {
        return (getX() <= pvpBALL_SIZE/2 || getX() >= getWorld().getWidth() - pvpBALL_SIZE/2);
    }

    private boolean isTouchingCeiling()
    {
        return (getY() <= pvpBALL_SIZE/2);
    }

    private boolean isTouchingFloor()
    { 
        return (getY() >= getWorld().getHeight() - pvpBALL_SIZE/2);
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

    private void checkRestartP2()
    {
        if (isTouchingCeiling())
        {
            init();
            setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
    }
    
    private void checkIfScoreP1()
    {
       if(isTouchingFloor()) 
       {
           PlayerPlayerWorld ppw = (PlayerPlayerWorld)getWorld();
           ppw.addScoreP1(1);
       }
    }
    
    private void checkIfScoreP2()
    {
       if(isTouchingCeiling()) 
       {
           PlayerPlayerWorld ppw = (PlayerPlayerWorld)getWorld();
           ppw.addScoreP2(1);
       }
    }
  
    
    private void checkRestartP1()
    {
        if (isTouchingFloor())
        {
            init();
            setLocation(getWorld().getWidth() / 2, getWorld().getHeight() / 2);
        }
    }

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
       if (towardsP1 == true)
       {
           setRotation(Greenfoot.getRandomNumber(STARTING_ANGLE_WIDTH)+STARTING_ANGLE_WIDTH/2);
           towardsP1 = false;           
       }
       else      
       {
           setRotation(Greenfoot.getRandomNumber(STARTING_ANGLE_WIDTH)+225);
           towardsP1 = true;           
       }
    }
    
    public void pvpBallX()
    {
        pvpBallX = getX();
    }   
}
