
/**
 * BurritoBuilder is a class to safely build a burrito, ensuring that the process is done correctly and 
 * input is validated.
 * 
 * @author Cody Moffitt
 * @version 1.0
 */
public class BurritoBuilder
{
    // instance variables
    private BurritoItem burrito; //Reference to the last item added to our burrito
    private boolean hasTortilla;
    private boolean hasFiller;
    /**
     * Constructor for objects of class BurritoBuilder
     */
    public BurritoBuilder()
    {
        hasTortilla = false;
        hasFiller = false;
    }

    /**
     * buildTortilla - Adds the tortilla to the burrito
     * 
     * @param  char tortillaChar   Specifies which type of tortilla to build
     * @return                     true if success, false if fail
     */
    public boolean buildTortilla(char tortillaChar) //creates the Tortilla if the input is okay, else does nothing and returns false
    {
        if(hasTortilla()) //Check to see whether this burrito has a tortilla yet
            return false;
            
        switch(tortillaChar) //Switch on char to determine which type of tortilla to make.
        {
            case 'w': case 'W':
                                //burrito = new WheatTortilla();
                                burrito = new TortillaImproved(0.79, "Wheat");
                                break;
            case 'c': case 'C':
                                //burrito = new ChipotleTortilla();
                                burrito = new TortillaImproved(2.29, "Chipotle");
                                break;
            case 's': case 'S':
                                //burrito = new SpinachTortilla();
                                burrito = new TortillaImproved(1.89, "Spinach");
                                break;
            default:
                                return false;
        }
        
        if(burrito != null) //See if we were successful, if so return true.
        {
            setTortilla(true);
            return true;
        }
        else //If we weren't successful
            return false;

    }
     /**
     * buildFiller - Adds a filler to the burrito
     * 
     * @param  char fillerChar     Specifies which type of filler to build
     * @return                     true if success, false if fail
     */
    public boolean buildFiller(char fillerChar) //creates a BurritoFiller and adds it to the order if the input is okay
    {
        if(!hasTortilla()) //We can't add fillers without a tortilla
            return false;
            
        switch(fillerChar) //Switch on char to determine which type of filler to create
        {
            case 'g': case 'G':
                                if(burrito instanceof Tortilla)
                                    burrito = new GrilledChicken((Tortilla)burrito);
                                else if(burrito instanceof BurritoFiller)
                                    burrito = new GrilledChicken((BurritoFiller)burrito);
                                break;
            case 's': case 'S':
                                if(burrito instanceof Tortilla)
                                    burrito = new Steak((Tortilla)burrito);
                                else if(burrito instanceof BurritoFiller)
                                    burrito = new Steak((BurritoFiller)burrito);
                                break;
            case 'b': case 'B':
                                if(burrito instanceof Tortilla)
                                    burrito = new BlackBean((Tortilla)burrito);
                                else if(burrito instanceof BurritoFiller)
                                    burrito = new BlackBean((BurritoFiller)burrito);
                                break;
           default:
                                return false; 
                             
        }
        
        setFiller(true);
        return true; //We've successfully added the filler
    }
     /**
     * buildCondiment - Adds a condiment to the burrito
     * 
     * @param  char condiChar      Specifies which type of filler to build
     * @return                     true if success, false if fail
     */
    public boolean buildCondiment(char condiChar) //creates a BurritoCondiment and adds it to the order if the input is okay
    {
        if(!hasTortilla() || !hasFiller()) //We can't add condiments without a tortilla/filler
            return false;
        
        BurritoItem copyOfBurrito = burrito; //Copy the burrito, so we can test if the condiment isDuplicate or not.
            
        switch(condiChar) //Switch on char to determine which type of filler to create
        {
            case 'p': case 'P':
                                if(burrito instanceof Tortilla)
                                    return false; //Condiments can't go on a tortilla
                                else if(burrito instanceof BurritoFiller)
                                    copyOfBurrito = new PicoDeGallo((BurritoFiller)burrito);
                                else if(burrito instanceof BurritoCondiment)
                                    copyOfBurrito = new PicoDeGallo((BurritoCondiment)burrito);    
                                break;
            case 'g': case 'G':
                                if(burrito instanceof Tortilla)
                                    return false; //Condiments can't go on a tortilla
                                else if(burrito instanceof BurritoFiller)
                                    copyOfBurrito = new Guacamole((BurritoFiller)burrito);
                                else if(burrito instanceof BurritoCondiment)
                                    copyOfBurrito = new Guacamole((BurritoCondiment)burrito);    
                                break;
            case 'o': case 'O':
                                if(burrito instanceof Tortilla)
                                    return false; //Condiments can't go on a tortilla
                                else if(burrito instanceof BurritoFiller)
                                    copyOfBurrito = new Onion((BurritoFiller)burrito);
                                else if(burrito instanceof BurritoCondiment)
                                    copyOfBurrito = new Onion((BurritoCondiment)burrito);    
                                break;
            case 'j': case 'J':
                                if(burrito instanceof Tortilla)
                                    return false; //Condiments can't go on a tortilla
                                else if(burrito instanceof BurritoFiller)
                                    copyOfBurrito = new Jalapeno((BurritoFiller)burrito);
                                else if(burrito instanceof BurritoCondiment)
                                    copyOfBurrito = new Jalapeno((BurritoCondiment)burrito);    
                                break;   
           default:
                                return false;  
                             
        }
        
        //Here we check to see if the condiment is already on the burrito, if not we add it to the real burrito.
        //We do this buy setting burrito to copyOfBurrito.
        //Unfortunately, we must do this for each type of condiment.
        //If there is a faster/more elegant way, please let me know.
        if(copyOfBurrito instanceof PicoDeGallo)
        {
            PicoDeGallo copy = (PicoDeGallo)copyOfBurrito; //Copy the copy, so we can use the right isDuplicate method
            if(copy.isDuplicate())
            {
                return false;
            }    
            else
            {
                burrito = copyOfBurrito;
            }
        }
        else if(copyOfBurrito instanceof Guacamole)
        {
            Guacamole copy = (Guacamole)copyOfBurrito;
            if(copy.isDuplicate())
            {
                return false;
            }    
            else
            {
                burrito = copyOfBurrito;
            }
        }
        else if(copyOfBurrito instanceof Onion)
        {
            Onion copy = (Onion)copyOfBurrito;
            if(copy.isDuplicate())
            {
                return false;
            }    
            else
            {
                burrito = copyOfBurrito;
            }
        }
        else if(copyOfBurrito instanceof Jalapeno)
        {
            Jalapeno copy = (Jalapeno)copyOfBurrito;
            if(copy.isDuplicate())
            {
                return false;
            }    
            else
            {
                burrito = copyOfBurrito;
            }
        }
        
        return true; //We've successfully added the condiment
    }
    /**
     * hasTortilla - Checks the hasTortilla boolean variable to see if we have a tortilla yet/already
     * 
     * @return                     true if we have a tortilla, false if we don't.
     */
    private boolean hasTortilla()
    {
        return hasTortilla;
    }
    /**
     * hasFiller - Checks the hasFiller boolean variable to see if we have any fillers yet.
     * 
     * @return                     true if we have a filler, false if we don't.
     */
    private boolean hasFiller()
    {
        return hasFiller;
    }
     /**
     * setTortilla - Sets hasTortilla to parameter.
     * 
     * @param                     boolean option
     */
    private void setTortilla(boolean option)
    {
        hasTortilla = option;
    }
     /**
     * setFiller - Sets hasFiller to parameter.
     * 
     * @param                     boolean option
     */
    private void setFiller(boolean option)
    {
        hasFiller = option;
    }
     /**
     * orderBurrito - Returns the finished burrito.
     * 
     * @return                     Returns the finished burrito as a BurritoItem, or null if order is incomplete
     */
    public BurritoItem orderBurrito() //returns the finished burrito or null if the order is incomplete
    {
        if(hasFiller() && hasTortilla())
            return burrito;
        else
            return null;
    }
}
