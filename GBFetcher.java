import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GBFetcher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GBFetcher extends GBMan
{
   public void getGumball(){
        
        }
    
        public void displayMessage(String msg, int x, int y) 
        {
            Message msgbox = new Message(msg);
            if (!getWorld().getObjects(Message.class).isEmpty())  
            {  
                getWorld().removeObjects(getWorld().getObjects(Message.class));
                //((message)getWorld().getObjectsAt(x, y, message.class).get(0));  
            }
            getWorld().addObject(msgbox, x, y);   
        } 
        
        public void resetPosition(){}
}
