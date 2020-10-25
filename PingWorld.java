import greenfoot.*;

public class PingWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;
    
    private int level  = 1;
    private GameLevelImage gli;
    public boolean endGame = false;
    
    public PingWorld()
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); 
        
        setBackground("background.png");
           
        addObject(new Ball(), getWidth()/2, WORLD_HEIGHT/2);
        addObject(new Paddle(100,20), getWidth()/2, WORLD_HEIGHT - 50); // padle dependent on the use
        addObject(new RandomPaddle(100, 20, 2), Greenfoot.getRandomNumber(getWidth()),
                Greenfoot.getRandomNumber(getHeight() - 150) );
        addObject(new SmartPaddle(100, 20), getWidth()/2, 40);
        
        addObject(new Label(), 400, 19);
        //addObject(new GameLevelImage(), 480, 19);
        
        gli = new GameLevelImage();
        addObject(gli, 480, 19);
        
        setPaintOrder(GameLevelImage.class, Label.class, Ball.class);
        
    }
    /*private void checkLose(){
        if (endGame = true){
            Greenfoot.setWorld(new GameOverWorld(true));
        } 
    }*/
   
    public void act()
    {
        /*removeObjects(getObjects(GameLevelImage.class));
        addObject(new Label(), 400, 19);
        addObject(new GameLevelImage(), 480, 19);*/
    }
    
    public void addLevel(int amount){
        level += amount;
        gli.setLevel(level);        
    }
}
