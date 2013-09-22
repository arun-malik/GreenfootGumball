import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Penny extends Coin
{
    Point initialLocation = new Point(700,100);
    
    public Penny()
    {
        setCoinValue(CoinValue.PENNY);
    }
    
    public void resetPosition()
    {
        setLocation(initialLocation.getXLocation(), initialLocation.getYLocation());
        setCoinUsed(false);
    }
}
