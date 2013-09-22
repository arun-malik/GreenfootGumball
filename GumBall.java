import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Color;
/**
 * Gum Ball 
 * 
 * @author Arun, Pravin 
 * @version 1.0
 */
public abstract class GumBall extends Actor
{
    private boolean ballLocationStatus ;
    
   public boolean getBallLocationStatus()
   {
       return ballLocationStatus;
   }
   
   
   public void setBallLocationStatus( boolean ballLocationStatus)
   {
       this.ballLocationStatus = ballLocationStatus;
   }
   
   public void act()
   {
            if(!this.getBallLocationStatus())
            {
                setLocation(getX()-1,getY()+2);
                Greenfoot.delay(8);
                setLocation(getX()-1,getY()-4);
                 Greenfoot.delay(8);          
                setLocation(getX()+2,getY()+2);
            }
            
            if(Greenfoot.mouseClicked(this) && this.getBallLocationStatus())  
            { 
                GumBallWorld gmworld = (GumBallWorld) getWorld();
                gmworld.removeObjects(getWorld().getObjects(Message.class));
                gmworld.removeObject(this);
                gmworld.resetWorldActors();
            } 
    }
   
}
