import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class RedGumBallFetcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RedGumBallFetcher extends GBFetcher
{
    GreenfootImage frame2 = new GreenfootImage("frame1.png");
    GreenfootImage frame1 = new GreenfootImage("frame2.png");
    GreenfootImage frame3 = new GreenfootImage("EmjoyGB.png");
    Point initialLocation = new Point(171,364);
    
    
    public void getGumball()
    {
      while(getX()<=440)
      {
            if(getImage() == frame2)
            {
              Greenfoot.delay(150); 
              setImage(frame1);
            }
            else
            {
             Greenfoot.delay(150); 
             setImage(frame2);         
            }
            setLocation (getX() + 1, getY());
            Greenfoot.delay(150);  
      }
      
      Greenfoot.delay(500); 
      setImage(frame3); 
      
      List<RedGumBall> redGumballList = (List<RedGumBall>)getWorld().getObjects(RedGumBall.class);
            if(redGumballList != null && redGumballList.size() > 0)
            {               
              RedGumBall objGumBall =  redGumballList.get(Greenfoot.getRandomNumber(redGumballList.size()));
              objGumBall.getImage().scale(60,60);
              objGumBall.setBallLocationStatus(true);
              objGumBall.setLocation(this.getX()+50, this.getY()-70);
            }
      
      displayMessage("Enjoy your Gumball !!", this.getX(), this.getY() + 120);
    }
    
    public void resetPosition()
    {
        setImage(frame1);
        setLocation(initialLocation.getXLocation(), initialLocation.getYLocation());
    }
}
