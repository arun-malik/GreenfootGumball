import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class GumBallMachine extends Actor
{    
    private Inspector inspector = null;
    private boolean cranked = true;
    private Coin c = null;
    private boolean busy = false;
    
    public GumBallMachine()
    {
        GreenfootImage image = getImage() ;
    }

    public void act() 
    {
            
            if(getOneIntersectingObject(Coin.class) != null) {
                c = (Coin)getOneIntersectingObject(Coin.class);
                if(c.getX() > this.getX() - 100 && c.getX() < this.getX() && c.getY() > this.getY() && c.getY() < this.getY() +100)// check if coin is in the coin insert area
                {
                    displayMessage("Have Coin",this.getX(),this.getY());
                    if(Greenfoot.mouseDragEnded(c)) {
            
                        if(isMachineReady(c)) {
                            getWorld().removeObject(c);
                            displayMessage("Crank It!!!",this.getX(),this.getY());
                            cranked = false;
                        }
                    }
                }
            }
            
            
            
         if(!cranked && !busy && Greenfoot.mouseClicked(this)) {          
            MouseInfo mouse = Greenfoot.getMouseInfo();  
            
            int mouseX=mouse.getX();  
            int mouseY=mouse.getY();  
            if(mouseX > this.getX()-130 && mouseX < this.getX()+130 ) {
                 //displayMessage("cranked",350,500);
                 cranked = true;
                 if (!getWorld().getObjectsAt(this.getX(), this.getY(), Message.class).isEmpty())  
                {  
                    getWorld().removeObject((Message)getWorld().getObjectsAt(this.getX(), this.getY(), Message.class).get(0));  
                }
                c.setCoinUsed(true);
                inspector.getCoin(c);
                 //clean();
            }
         }
    }
    
   boolean isMachineReady(Coin c){
        List<Inspector> inspect = null;
        if(inspector == null ){
            inspect = (List<Inspector>)getWorld().getObjects(Inspector.class);
            if(inspect.size() == 1) {
                inspector = (Inspector)inspect.get(0);
            } else {
                displayMessage("Gumball machine not ready. Please try again later!",400,500);
                return false;
            }
        }
        
        if(inspector.isBusy()) {
            displayMessage("Gumball machine not ready. Please try again later!",400,500);
            return false;
        } 
        
        if(busy) {
            return false;
        }
        return true;
    }    
   
    public void displayMessage(String msg, int x, int y) {
        Message msgbox = new Message(msg);
        if (!getWorld().getObjectsAt(x, y, Message.class).isEmpty())  
        {  
            getWorld().removeObject((Message)getWorld().getObjectsAt(x, y, Message.class).get(0));  
        }
        getWorld().addObject(msgbox, x, y);   
    }   
}
