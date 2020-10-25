import greenfoot.*;

public class PlayerPlayerWorld extends World
{
    private static final int WORLD_WIDTH = 500;
    private static final int WORLD_HEIGHT = 700;
    private int scoreP1 = 0;
    private int scoreP2 = 0;
    private PlayerScore ps1;
    private PlayerScore ps2;
    

    public PlayerPlayerWorld()
    {
        super(WORLD_WIDTH, WORLD_HEIGHT, 1); 
        
        setBackground("background.png");
        addObject(new PvPBall(), getWidth()/2, WORLD_HEIGHT/2);
        //user's paddle:
        addObject(new Paddle(100,20), getWidth()/2, WORLD_HEIGHT - 50);
        //enemy player's paddle:
        addObject(new PvPPaddle(100, 20), getWidth()/2, 40);
        addObject(new PlayerImage("player1score.png"), 55, 20);
        addObject(new PlayerImage("player2score.png"), 55, 680);
        
        ps1 = new PlayerScore(scoreP1);
        addObject(ps1, 120, 20);
        
        ps2 = new PlayerScore(scoreP2);
        addObject(ps2, 120, 680);
        
        setPaintOrder(PlayerImage.class, PlayerScore.class, PvPBall.class);
        
    }
    
    private void checkWin(){
       if(scoreP1 >= 5) 
            Greenfoot.setWorld(new GameOverWorld(true, 2));
       else if(scoreP2 >= 5) 
            Greenfoot.setWorld(new GameOverWorld(false, 2));
           
    }

    public void act()
    {/*
        removeObjects(getObjects(PlayerScore.class));
        addObject(new PlayerScore(scoreP1), 120, 20);
        addObject(new PlayerScore(scoreP2), 120, 680);*/
        
       
        
    }
    
    public void addScoreP1(int amount){
        scoreP1 += amount;
        ps1.setScore(scoreP1);
        checkWin();
    }
    
    public void addScoreP2(int amount){
        scoreP2 += amount;
        ps2.setScore(scoreP2);
        checkWin();
    }
}
