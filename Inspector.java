import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Inspector extends GBMan
{
    GreenfootImage frame2 = new GreenfootImage("frame1.png");
    GreenfootImage frame1 = new GreenfootImage("frame2.png");
    GreenfootImage frame3 = new GreenfootImage("angryagent_fkcoin3.png");
    private boolean isBusy;
    Point initialLocation = new Point(266,216);
    
    public void getCoin(Coin c) {
        Boolean trueCoin = inspectCoin(c);
        isBusy = true;
        if(!trueCoin) {
            getWorld().removeObjects(getWorld().getObjects(Message.class));
            displayMessage("Only Quarters please !",670,300);
            setImage(frame3);
            getWorld().addObject(c, getX()+100, getY()-50);
        } else {
            displayMessage("Quarter Accepted",670,300);
            Greenfoot.delay(50);
            selectPicker();
        }
        isBusy = false;
    }
    
    public boolean isBusy(){
        return isBusy;
    }
    
    private void selectPicker(){
        
        if(ButtonRedGM.redBallFecthStatus)
        {
            List<RedGumBallFetcher> pickerList = (List<RedGumBallFetcher>)getWorld().getObjects(RedGumBallFetcher.class);
            if(pickerList != null && pickerList.size() > 0)
            {
                RedGumBallFetcher redGumBallFetcher = pickerList.get(0);
                redGumBallFetcher.getGumball();
            }
        }
        else
        {
             List<GBFetcher> pickerList = (List<GBFetcher>)getWorld().getObjects(GBFetcher.class);// check if coin is in the coin insert area
             if(pickerList.size() > 0) {
                 displayMessage("Selecting Picker..",670,300);
                 Greenfoot.delay(40);
                 pickerList.get(Greenfoot.getRandomNumber(pickerList.size())).getGumball();
             }
        }
    }
    
    private boolean inspectCoin(Coin c){
           while(getX()<=492)
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
        
        if(c == null || c.getCoinValue() == 0 ){
            return false;
        }
        switch(c.getCoinValue()) {
            case CoinValue.QUARTER:return true;
            default:return false;
        }
    }
    
    public void displayMessage(String msg, int x, int y) {
        Message msgbox = new Message(msg);
        if (!getWorld().getObjectsAt(x, y, Message.class).isEmpty())  
        {  
            getWorld().removeObject((Message)getWorld().getObjectsAt(x, y, Message.class).get(0));  
        }
        getWorld().addObject(msgbox, x, y);   
    }
    
    public void resetPosition()
    {
        setImage(frame1);
        setLocation(initialLocation.getXLocation(), initialLocation.getYLocation());
        isBusy = false;
    }
}
