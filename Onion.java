
/**
 * Onion is a type of condiment on a burrito, this class describes that.
 * 
 * @author Cody Moffitt
 * @version 1.0
 */
public class Onion extends BurritoCondiment
{

    /**
     * Constructor for objects of class Onion, attaches it to a BurritoFiller.
     * @param         BurritoFiller upperLayer
     */
    public Onion(BurritoFiller upperLayer)
    {
        super(upperLayer); //Attach this as the lowest layer so far in the BurritoItems
    }
     /**
     * Overloaded constructor for objects of class Onion, attaches it to a BurritoCondiment.
     * @param         BurritoCondiment upperLayer
     */
    public Onion(BurritoCondiment upperLayer)
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
        return super.toString() + "Onion\r\n";
    }
     /**
     * equals -  Checks to see if two BurritoCondiments are of the same type. Defined in each condiment subclass
     * 
     * @param         BurritoCondiment bc    
     * @return        Returns true if they are, false if they are not. 
     */
    public boolean equals(BurritoCondiment bc)
    {
        if(bc instanceof Onion)
            return true;
        return false;    
    }
}
