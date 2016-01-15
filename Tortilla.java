
/**
 * Abstract class Tortilla - The abstract class that all Tortillas will descend from.
 * 
 * @author Cody Moffitt
 * @version 1.0
 */
public abstract class Tortilla extends BurritoItem
{
    /**
     * Constructor - Links this Tortilla to a null, its the first in the chain of layers.
     * 
     * @param                None
     * @return               None, its the constructor 
     */
    public Tortilla()
    {
        super(null);
    }
     /**
     * cost - Abstract method, to be defined in subclasses. Will get total cost of burrito, by
     * adding up all the layers recursviely.
     * 
     * @param         None    
     * @return        Returns the cost of the next BurritoItem
     */
    abstract public double cost();
     /**
     * toString -  Returns the String description "Tortilla: ", child classes will use this.
     * 
     * @param         None    
     * @return        Returns the String description "Tortilla: "
     */
    public String toString()
    {
        return "Tortilla: ";
    }
}
