
/**
 * TortillaImproved encapsulates different kinds of tortillas.
 * It has two variables, String tortillaName, double tortillaCost, which are self-explanatory.
 * 
 * @author Cody Moffitt
 * @version 1.0
 */
public class TortillaImproved extends Tortilla
{
    String tortillaName;
    double tortillaCost;
    /**
     * Constructor for objects of class TortillaImproved. Takes a cost and name.
     * @param         double tortillaCost
     * @param         String tortillaName    
     * 
     */
    public TortillaImproved(double tortillaCost, String tortillaName)
    {
       super();
       // initialise instance variables
       this.tortillaName = tortillaName;
       this.tortillaCost = tortillaCost;

    }
    
     /**
     * cost - Returns the cost of this Tortilla
     * 
     * @param         None    
     * @return        Returns the cost of this Tortilla
     */
    public double cost()
    {
        return tortillaCost;
    }
     /**
     * toString -  Returns the String description of this Tortilla.
     * 
     * @param         None    
     * @return        Returns the String description of this Tortilla.
     */
    public String toString()
    {
        return super.toString() + tortillaName +"\r\n";
    }
}
