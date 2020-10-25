import greenfoot.*;


public class PvPPaddle extends Actor
{
    private int width ;
    private int height ;
    //private int dx;

    public PvPPaddle(int width, int height)
    {
        this.width = width;
        this.height = height;
        setImage("paddle2.png"); 
    }

    public void act() 
    {
       PaddlesBehaviour();
    }    
  
    private void PaddlesBehaviour()
    {     // user's control
      if(Greenfoot.isKeyDown("a"))
        move(-2);
      if(Greenfoot.isKeyDown("d"))
        move(2);
       
    }


}
