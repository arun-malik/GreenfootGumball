import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Coin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Coin extends Actor
{
    private int coinValue= 0;
    private boolean coinUsed = false;
    
    public void setCoinUsed(boolean value) {
        this.coinUsed = value;
    }
    
    public boolean getCoinUsed() {
        return this.coinUsed;
    }
    
    public Coin()
    {
       GreenfootImage image = getImage();
       image.scale(50,50);
    }
    
    public void act() 
    {
        
        if(Greenfoot.mouseDragged(this)) 
        { 
            GumBallWorld gmworld = (GumBallWorld) getWorld();
            gmworld.removeObjects(getWorld().getObjects(Message.class));
            gmworld.resetWorldActors();
            MouseInfo mouse = Greenfoot.getMouseInfo();
            setLocation(mouse.getX(), mouse.getY()); 
        
        }
        
        if(Greenfoot.mouseClicked(this) && this.getCoinUsed())  
            { 
                GumBallWorld gmworld = (GumBallWorld) getWorld();
                gmworld.removeObjects(getWorld().getObjects(Message.class));
                gmworld.resetWorldActors();
            } 
            
         
    }  
    
    public int getCoinValue()
    {
        return coinValue;
    }
    
    public void setCoinValue(int coinValue)
    {
        this.coinValue = coinValue ;
    }
}
