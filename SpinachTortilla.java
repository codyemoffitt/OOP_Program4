
/**
 * This class. SpinachTortilla, is an implementation of a Spinach Tortilla, descended from Tortilla.
 * 
 * @author Cody Moffitt 
 * @version 1.0
 */
public class SpinachTortilla extends Tortilla 
{


    /**
     * Constructor for objects of class SpinachTortilla
     */
    public SpinachTortilla()
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
        return 1.89;
    }
     /**
     * toString -  Returns the String description of this Tortilla.
     * 
     * @param         None    
     * @return        Returns the String description of this Tortilla.
     */
    public String toString()
    {
        return super.toString() + "Spinach\r\n";
    }

}
