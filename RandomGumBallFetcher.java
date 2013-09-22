import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class RandomGumBallFetcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RandomGumBallFetcher extends GBFetcher
{
    GreenfootImage frame2 = new GreenfootImage("frame1.png");
    GreenfootImage frame1 = new GreenfootImage("frame2.png");
    GreenfootImage frame3 = new GreenfootImage("EmjoyGB.png");
    Point initialLocation = new Point(279,510);
    
    public void act() 
    {
               
    }
    
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
        
        setImage(frame3);        
        
        List<GumBall> gumballList = (List<GumBall>)getWorld().getObjects(GumBall.class);
            if(gumballList != null && gumballList.size() > 0)
            {               
              GumBall objGumBall =  gumballList.get(Greenfoot.getRandomNumber(gumballList.size()));
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
