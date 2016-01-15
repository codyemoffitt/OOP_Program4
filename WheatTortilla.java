
/**
 * WheatTortilla describes a tortilla made of wheat for the burrito ordering system.
 * 
 * @author Cody Moffitt
 * @version 1.0
 */
public class WheatTortilla extends Tortilla
{

    /**
     * Constructor for objects of class WheatTortilla
     */
    public WheatTortilla()
    {
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
        return 0.79;
    }
     /**
     * toString -  Returns the String description of this Tortilla.
     * 
     * @param         None    
     * @return        Returns the String description of this Tortilla.
     */
    public String toString()
    {
        return super.toString() + "Wheat\r\n";
    }
}
