
/**
 * A class describing the filler part of a Burrito. It is abstract.
 * 
 * @author Cody Moffitt
 * @version 1.0
 */
public abstract class BurritoFiller extends BurritoItem
{

    /**
     * Constructor for objects of class BurritoFiller, attaches it to a Tortilla
     * @param         Tortilla tortillaItem   
     * @return        None
     */
    public BurritoFiller(Tortilla tortillaItem)
    {
       super(tortillaItem);
    }
    
    /**
     * Another overloaded constructor for objects of class BurritoFiller, attaches it to a BurritoFiller
     * @param         BurritoFiller burritoFiller  
     * @return        None
     */
    public BurritoFiller(BurritoFiller burritoFiller)
    {
       super(burritoFiller);
    }
     /**
     * cost - Returns the cost of this filler plus the layers above it.
     * 
     * @param         None    
     * @return        Returns the cost of this filler plus the layers above it.
     */
    public double cost()
    {
        return super.cost() + 0.77;
    }
     /**
     * toString -  Returns the String description of those BurritoItems above it, and itself.
     * Children of this class will use it.
     * 
     * @param         None    
     * @return        Returns the String description of those BurritoItems above it, plus "Filler: ".
     */
    public String toString()
    {
        return super.toString() + "Filler: ";
    }
}
