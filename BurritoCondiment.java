
/**
 * BurritoCondiment describes a condiment that would be placed on a burrito. They can be attached to BurritoFiller and BurritoCondiment, but not Tortilla.
 * 
 * @author Cody Moffitt
 * @version 1.0
 */
public abstract class BurritoCondiment extends BurritoItem
{

    /**
     * Constructor for objects of class BurritoCondiment, attaches this object to a BurritoFiller.
     * @param         BurritoFiller upperLayer
     * @return        None
     */
    public BurritoCondiment(BurritoFiller upperLayer)
    {
        super(upperLayer);
    }
    /**
     * Overloaded constructor for objects of class BurritoCondiment, attaches this object to a BurritoCondiment.
     * @param         BurritoCondiment upperLayer
     * @return        None
     */
    public BurritoCondiment(BurritoCondiment upperLayer)
    {
        super(upperLayer);
    }
     /**
     * cost - Returns the cost of this condiment plus the layers above it.
     * 
     * @param         None    
     * @return        Returns the cost of this filler plus the layers above it.
     */
    public double cost()
    {
        return super.cost() + 0.11;
    }
     /**
     * toString -  Returns the String description of those BurritoItems above it, plus itself.
     * 
     * @param         None    
     * @return        Returns the String description of those BurritoItems above it, plus "Condiment: ".
     */
    public String toString()
    {
        return super.toString() + "Condiment: ";
    }
     /**
     * isDuplicate -  Checks to see if a specific BurritoCondiment is already in our burrito. Uses recursion.
     * 
     * @param         None    
     * @return        Returns true if the burrito already has that condiment, false otherwise
     */
    public boolean isDuplicate()
    {
        return super.isDuplicate(this);
    }
     /**
     * equals -  Checks to see if two BurritoCondiments are of the same type. This method is defined in each condiment subclass
     * 
     * @param         BurritoCondiment bc 
     * @return        Returns true if they are, false if they are not. 
     */
    abstract public boolean equals(BurritoCondiment bc);

}
