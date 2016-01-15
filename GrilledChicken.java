
/**
 * This class is for a specific type of BurritoFiller, GrilledChicken.
 * 
 * @author Cody Moffitt
 * @version 1.0
 */
public class GrilledChicken extends BurritoFiller
{

    /**
     * Constructor for objects of class GrilledChicken, attaches it to a BurritoFiller.
     * @param         BurritoFiller upperLayer
     */
    public GrilledChicken(BurritoFiller upperLayer)
    {
        super(upperLayer); //Attach this as the lowest layer so far in the BurritoItems
    }
     /**
     * Overloaded constructor for objects of class GrilledChicken, attaches it to a Tortilla.
     * @param         Tortilla upperLayer
     */
    public GrilledChicken(Tortilla upperLayer)
    {
        super(upperLayer); //Attach this as the lowest layer so far in the BurritoItems
    }

     /**
     * toString -  Returns the String description of those BurritoItems above it, plus itself.
     * 
     * @param         None    
     * @return        Returns the String description of those BurritoItems above it, plus itself.
     */
    public String toString()
    {
        return super.toString() + "Grilled Chicken\r\n";
    }
}
