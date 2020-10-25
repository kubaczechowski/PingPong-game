import greenfoot.*;


public class Paddle extends Actor
{
    private int width ;
    private int height ;
    //private int dx;

    public Paddle(int width, int height)
    {
        this.width = width;
        this.height = height;
        setImage("paddle1.png");
        
    }

    public void act() 
    {
       PaddlesBehaviour();
    }    
  
    private void PaddlesBehaviour()
    {     // user's control
      if(Greenfoot.isKeyDown("left"))
        move(-2);
      if(Greenfoot.isKeyDown("right"))
        move(2);
       
    }


}
