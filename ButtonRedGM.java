import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ButtonRedGM here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ButtonRedGM extends Actor
{
    GumBallWorld gmworld = (GumBallWorld) getWorld();
    GreenfootImage btnChecked = new GreenfootImage("buttonredchecked.png");
    GreenfootImage btnUnChecked = new GreenfootImage("button-red.png");
    public static boolean redBallFecthStatus;
    
    public ButtonRedGM()
    {
        GreenfootImage image = getImage();
    }
        
    
    
    public void act() 
    { 
        if (!redBallFecthStatus && Greenfoot.mouseClicked(this)) 
        {    
            setImage(btnChecked);  
            redBallFecthStatus = true;
        } 
        else if (redBallFecthStatus && Greenfoot.mouseClicked(this)) {  
            setImage(btnUnChecked);  
            redBallFecthStatus = false;
        }  
    } 
    
    
}
