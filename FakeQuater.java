import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class FakeQuater extends Quarter
{
    Point initialLocation = new Point(590,100);
    
    public FakeQuater(){
        setCoinValue(0);
    }
    
    public void resetPosition()
    {
        setLocation(initialLocation.getXLocation(), initialLocation.getYLocation());
        setCoinUsed(false);
    }
}
