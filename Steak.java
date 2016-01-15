
/**
 * Steak is a class describing a kind of BurritoFiller.
 * 
 * @author Cody Moffitt
 * @version 1.0
 */
public class Steak extends BurritoFiller
{

     /**
     * Overloaded constructor for objects of class Steak, attaches it to a BurritoFiller.
     * @param         BurritoFiller upperLayer  
     */
    public Steak(BurritoFiller upperLayer)
    {
        super(upperLayer); //Attach this as the lowest layer so far in the BurritoItems
    }
     /**
     * Overloaded constructor for objects of class Steak, attaches it to a Tortilla.
     * @param         Tortilla upperLayer
     */
    public Steak(Tortilla upperLayer)
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
        return super.toString() + "Steak\r\n";
    }
}
