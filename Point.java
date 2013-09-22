/**
 * Write a description of class Point here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Point  
{
    private int xLocation;
    private int yLocation;

    /**
     * Constructor for objects of class Point
     */
    public Point(int x , int y)
    {
        setXLocation(x);
        setYLocation(y);
    }

    public int getXLocation()
    {
        return xLocation;
    }
    
    public void setXLocation(int x)
    {
        this.xLocation = x;
    }
    
    public int getYLocation()
    {
        return yLocation;
    }
    
    public void setYLocation(int y)
    {
        this.yLocation = y;
    }
    
   
}
