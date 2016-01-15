
/**
 * ChipotleTortilla describes a tortilla made of chipotle for the burrito ordering system.
 * 
 * @author Cody Moffitt
 * @version 1.0
 */
public class ChipotleTortilla extends Tortilla
{

    /**
     * Constructor for objects of class ChipotleTortilla
     */
    public ChipotleTortilla()
    {
        // initialise instance variables
       super();
    }
    
     /**
     * cost - Returns the cost of this Tortilla
     * 
     * @param         None    
     * @return        Returns the cost of this Tortilla
     */
    public double cost()
    {
        return 2.29;
    }
     /**
     * toString -  Returns the String description of this Tortilla.
     * 
     * @param         None    
     * @return        Returns the String description of this Tortilla.
     */
    public String toString()
    {
        return super.toString() + "Chipotle\r\n";
    }
}
