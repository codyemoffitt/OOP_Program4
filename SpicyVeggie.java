
/**
 * SpicyVeggie is a child of BurritoBuilder that builds a specific type of burrito with one command
 * 
 * @author Cody Moffitt
 * @version 1.0
 */
public class SpicyVeggie extends BurritoBuilder
{

    /**
     * Constructor for objects of class SpicyVeggie
     */
    public SpicyVeggie()
    {
        super();
    }
    /**
     * orderBurrito - Returns the finished SpicyVeggie burrito.
     * 
     * @return                     Returns the finished burrito as a BurritoItem, or null if order is incomplete
     */
    public BurritoItem orderBurrito() //returns the finished burrito or null if the order is incomplete
    {
        if(super.orderBurrito() == null) //Check to make sure this burrito isn't made yet
        {
            super.buildTortilla('c');
            super.buildFiller('b');
            super.buildCondiment('p');
            super.buildCondiment('j');
        }
        return super.orderBurrito();
    }

}
