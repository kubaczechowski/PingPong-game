import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class RandomPaddle extends Actor
{
    private int width;
    private int height;
    private int speed;
    
    public RandomPaddle(int width, int height, int speed)
    {
        this.width = width;
        this.height = height;
        this.speed = speed;
        setImage("paddle2.png");
        GreenfootImage image = getImage();
        image.scale(width, height);
        setImage(image);
    }
    
    public void act() 
    {
       behaviour();
    } 
    
    private void behaviour()
    {
      move(speed);
      
      if (Greenfoot.getRandomNumber(150) == 2 && this.getX() > 50 && this.getX() < 450) {
        speed = speed*(-1);
      }
      
      if(isAtEdge())
      { 
           int currentWidth = this.getX();
           int x = 0;
           int y = Greenfoot.getRandomNumber(200) + 150;
           boolean changeWall = false;
           PingWorld pw = (PingWorld)getWorld();
           
           if(currentWidth == 0) {
               x = pw.getWidth() - 1;
               changeWall = true;
           } else if (currentWidth == pw.getWidth() - 1) {
               x = 0;
               changeWall = true;
           }
           
           if (changeWall) {
               pw.removeObject(this); // remove old object
               int newWidth = Greenfoot.getRandomNumber(200) + 50;
               pw.addObject(new RandomPaddle(newWidth, 20, speed), x, y);
               changeWall = false;
            }
         
      }
    } 
    
}
