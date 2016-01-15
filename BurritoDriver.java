
/**
 * BurritoDriver is the program driver. It uses other classes to create and display burrito orders.
 * 
 * @author Cody Moffitt
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.Iterator;

public class BurritoDriver
{
     /**
     * main - Loops as we create burritos until we specify to stop.
     * 
     * @param                      String[] args
     * @return                     void
     */
    public static void main(String[] args)
    {

        boolean done = false;
        while(!done)
        {
            BurritoBuilder bb = new BurritoBuilder();
            int choice = menu();
            if(choice == 1) //Build your own
            {
                requestTortilla(bb);
                requestFillers(bb);
                requestCondiments(bb);
                Globals.burritoCount++; //Increment our global burrito total, done for each option.
            }
            else if(choice == 2) //SpicyVeggie
            {
                bb = new SpicyVeggie();
                 Globals.burritoCount++;
            }
            else if(choice == 3) //DoubleSteak
            {
                bb = new DoubleSteak();
                Globals.burritoCount++;
            }
            else if(choice == 0) //Quit the program
            {
                done = true;
            }
            if(bb.orderBurrito() != null) //Null check, then show the order, and add up our totals.
            {
                showOrder(bb.orderBurrito());
                Globals.totalCost += bb.orderBurrito().cost(); //Update our overall total cost of all orders
            }
            
        }
        System.out.println("You ordered " + Globals.burritoCount + " burrito(s) for a grand total of " + Currency.formatCurrency(Globals.totalCost) + "."); //Our sign off for program exit.
    }
     /**
     * menu - Displays the first part of our menu.
     * 
     * @return                     int choice, will be 1 for build your own, 2 for SpicyVeggie, 3 for DoubleSteak, and 0 for program exit.
     */
    private static int menu() //displays pre-built burrito options or "build your own", returns user menu selection (burrito is not built here)
    {
       String order = "l"; //Set this so we enter loop for yes/no
       
       while((order.toLowerCase().charAt(0) != 'y')) //Loop until we get a yes or no, or y or n, or Y or N
       {
           if(Globals.burritoCount == 0) //Determin which sentence to print, based on how many burritos we've made.
           {
               order = Keyboard.getKeyboard().readString("Would you like to order a burrito (y/n)? ");
           }    
           else if(Globals.burritoCount > 0)
           {
               order = Keyboard.getKeyboard().readString("Would you like to order another burrito (y/n)? ");
           }    
           if((order.toLowerCase().charAt(0) == 'n')) //We quit, lets return our quit int
              return 0;
       }
       int choice = 0; //Force the following loop to run atleast once  
       while((choice < 1) || (choice > 3))
       {
           System.out.println("1. Build Your Own \n2. Spicy Veggie \n3. Double Steak \n\n");
           choice = Keyboard.getKeyboard().readInt("Select from the above: ");
       }
       return choice;   
    }
     /**
     * requestTortilla - Menu for selecting which kind of tortilla you want, when you build your own.
     * @param                      BurritoBuilder bb  
     *
     */
    private static void requestTortilla(BurritoBuilder bb) //calls the appropriate method on the builder until input is accepted by the builder
    {
        String choice = new String();
        System.out.println("\n");
        while(!choice.toLowerCase().equals("w") && !choice.toLowerCase().equals("wheat") && !choice.toLowerCase().equals("c") && !choice.toLowerCase().equals("chipotle") && !choice.toLowerCase().equals("s")  && !choice.toLowerCase().equals("spinach"))
        {
            choice = Keyboard.getKeyboard().readString("(W)heat, (C)hipotle, (S)pinach: ");
        }
        bb.buildTortilla(choice.charAt(0));
    }
     /**
     * requestFillers - Menu for selecting which kind of fillers you want, when you build your own burrito. You can add as many fillers as you want.
     * @param                      BurritoBuilder bb  
     *
     */
    private static void requestFillers(BurritoBuilder bb) //adds fillers until user specifies done (at least one filler MUST be selected)
    {
        String choice = new String();
        boolean done = false;
        int fillerCount = 0;
        System.out.println("\nSelect the fillers for your burrito.");
        while(!done)
        {
            choice = Keyboard.getKeyboard().readString("(G)rilled Chicken, (S)teak, (B)lack Bean, (D)one: ");
            if(bb.buildFiller(choice.toLowerCase().charAt(0)))
                fillerCount++;
            if(choice.toLowerCase().charAt(0) == 'd' && fillerCount > 0)
                done = true;
        }
   
    }
     /**
     * requestCondiments - Menu for selecting which kind of condiments you want, when you build your own burrito. You can only add one of each type.
     * @param                      BurritoBuilder bb  
     *
     */
    private static void requestCondiments(BurritoBuilder bb) //adds condiments until user specifies done (note how options disappear after selection)
    {
        ArrayList<String> list = new ArrayList<String>();
        String output = new String(); //Where we will store the concatenated list of condiment options
        String choice = new String(); //The user's choice
        boolean done = false; //Loop variable
        //Add all of the menu options to an ArrayList
        list.add("(P)ico De Gallo, ");
        list.add("(G)uacamole, ");
        list.add("(O)nion, ");
        list.add("(J)alapeno, ");
        list.add("(D)one: ");
        
        while(!done) //Loop until the user is done.
        {
            output = ""; //reset output string
            //Prints our list of condiments
            for(String str: list)
            {
                output += str;
            }
    
            choice = Keyboard.getKeyboard().readString(output);
            if(choice.length() == 0) //null checking/arrayindex out of bounds checking in case user just hits enter
                choice = " ";
            switch(choice.toLowerCase().charAt(0)) //This removes each condiment from the list of choices after they are added to the burrito.
            {
                case 'p':
                            list.remove("(P)ico De Gallo, ");
                            break;
                case 'g':
                            list.remove("(G)uacamole, ");
                            break;
                case 'o':
                            list.remove("(O)nion, ");
                            break;
                case 'j':
                            list.remove("(J)alapeno, ");
                            break;
                case 'd':
                            done = true;
            }
            
            bb.buildCondiment(choice.toLowerCase().charAt(0)); //Actually add the condiment, no need to input validate further as buildCondiment rejects bad input
        }
    }
     /**
     * requestCondiments - Shows the sepcified burrito, with all of its tortilla, condiments, fillers, and cost.
     * @param                      BurritoItem bi
     *
     */
    private static void showOrder(BurritoItem bi) //displays the finished burrito order
    {
        System.out.println("\n");
        System.out.println(bi);
        System.out.println("\nYour burrito cost is " + Currency.formatCurrency(bi.cost()) + ".");
        
    }
}
