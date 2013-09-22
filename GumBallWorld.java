import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 *Gum Ball World will have all actors initialized
 * 
 * @author Arun, Pravin 
 * @version 1.0
 */
public class GumBallWorld extends World
{
    /**
     * constructor for objects of class GumBallWorld
     * create world for all objects
     */
    Point locationQuarter = new Point(500,100);
    private  GumBallMachine gumBallMachine = new GumBallMachine();
    private  Quarter quarter = new Quarter(locationQuarter);
    Point location = new Point(450,100);
    private  Quarter quarter2 = new Quarter(location);
    private  FakeQuater fakeCoin = new FakeQuater();  
    private  Penny penny = new Penny();
    private  Inspector inspector = new Inspector();        
    private  RedGumBallFetcher redGumBallFetcher = new RedGumBallFetcher();        
    private  RandomGumBallFetcher randomGumBallFetcher = new RandomGumBallFetcher();  
    private  ButtonRedGM btnRedGumBall = new ButtonRedGM();
    

    
    public GumBallWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        CreateWorld();
            
    }
    
    /**
     * Create Initial World, add objects to the world
     */
    public void CreateWorld()
    {
        addObject(gumBallMachine,661,373);
        addObject(quarter,quarter.initialLocation.getXLocation(),quarter.initialLocation.getYLocation());
        addObject(quarter2,quarter2.initialLocation.getXLocation(),quarter2.initialLocation.getYLocation());
        addObject(fakeCoin,fakeCoin.initialLocation.getXLocation(),fakeCoin.initialLocation.getYLocation());
        addObject(penny,penny.initialLocation.getXLocation(),penny.initialLocation.getYLocation());
        addObject(inspector,inspector.initialLocation.getXLocation(),inspector.initialLocation.getYLocation());
        addObject(redGumBallFetcher,redGumBallFetcher.initialLocation.getXLocation(),redGumBallFetcher.initialLocation.getYLocation());     
        addObject(randomGumBallFetcher,randomGumBallFetcher.initialLocation.getXLocation(),randomGumBallFetcher.initialLocation.getYLocation());
        addObject(btnRedGumBall,205,32);
        
        //display all gum balls in GumBall Machine
         for (int i = 0; i < 35; i+=5)
            {
                addObject(new  GreenGumBall(),545+4*i,245);
                addObject(new  RedGumBall(),535+(i*5),265);
                addObject(new  YellowGumBall(),530+(i*5),285);
                
                addObject(new  GreenGumBall(),530+5*i,310);
                addObject(new  RedGumBall(),535+(i*5),330);
                addObject(new  YellowGumBall(),530+(i*5),350);
            }    
           
    }
    
    public  void resetWorldActors()
    {
        inspector.resetPosition();
        redGumBallFetcher.resetPosition();
        randomGumBallFetcher.resetPosition();
        quarter.resetPosition();
        penny.resetPosition();
        fakeCoin.resetPosition();
        List<GumBall> allGumBall = (List<GumBall>) getObjects(GumBall.class);
        if(allGumBall!=null && allGumBall.size() > 0) {
            for(int i=0; i < allGumBall.size();i++){
                if(allGumBall.get(i).getBallLocationStatus()) {
                    removeObject(allGumBall.get(i));
                }
            }
        }
    }
    
}
