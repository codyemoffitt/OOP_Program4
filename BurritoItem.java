
/**
 * Abstract class BurritoItem - This is the class all parts of a burrito will descend from.
 * It has a variable, private BurritoItem upperLayer, which is a reference to the next layer in the Burrito.
 * 
 * @author Cody Moffitt
 * @version 1.0
 */
public abstract class BurritoItem
{
    // instance variables
    private BurritoItem upperLayer;

    /**
     * Constructor - Links this BurritoItem with a chain of BurritoItems
     * 
     * @param  upperLayer    The reference to the next layer of the Burrito, another BurritoItem.
     * @return               None, its the constructor 
     */
    public BurritoItem(BurritoItem upperLayer)
    {
        this.upperLayer = upperLayer;
    }
     /**
     * cost -  Returns the cost of the next BurritoItem        
     * 
     * @param         None    
     * @return        Returns the cost of the next BurritoItem
     */
    public double cost()
    {
        return upperLayer.cost();
    }
     /**
     * toString -  Returns the String description of the next burrito item
     * 
     * @param         None    
     * @return        Returns the String description of the next burrito item
     */
    public String toString()
    {
        return upperLayer.toString();
    }
     /**
     * isDuplicate -  Checks to see if a BurritoCondiment is already in our burrito
     * 
     * @param         None    
     * @return        Returns true if the burrito already has that condiment, false otherwise
     */
    public boolean isDuplicate(BurritoCondiment check)
    {
        if(upperLayer instanceof BurritoCondiment)
        {
            if(check.equals((BurritoCondiment)upperLayer)) //Check to see if they are the same sub-class
            {
                return true;
            }    
            else
            {
                return upperLayer.isDuplicate(check); //If they aren't the same sub-class, pass it up for the next check
            }    
        }    
        else //If upperLayer is not a BurritoCondiment, we've run out of condiments to check, and we are done
            return false;
  
    }

}
