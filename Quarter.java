import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Quarter extends Coin
{
    Point initialLocation;
    
    public Quarter() {
        initialLocation = new Point(480,100);
        setCoinValue(CoinValue.QUARTER);
    }
    public Quarter (Point location)
    {
        initialLocation = location;
        setCoinValue(CoinValue.QUARTER);
       
    }
    
    public void resetPosition()
    {
        setLocation(initialLocation.getXLocation(), initialLocation.getYLocation());
        setCoinUsed(false);
    }
}
