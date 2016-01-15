
/**
 * BlackBean is a class describing a kind of BurritoFiller
 * 
 * @author Cody Moffitt
 * @version 1.0
 */
public class BlackBean extends BurritoFiller
{

     /**
     * Constructor for objects of class BlackBean, attaches it to a BurritoFiller.
     * @param         BurritoFiller upperLayer
     */
    public BlackBean(BurritoFiller upperLayer)
    {
        super(upperLayer); //Attach this as the lowest layer so far in the BurritoItems
    }
     /**
     * Overloaded constructor for objects of class BlackBean, attaches it to a Tortilla.
     * @param         Tortilla upperLayer
     */
    public BlackBean(Tortilla upperLayer)
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
        return super.toString() + "Black Bean\r\n";
    }
}

