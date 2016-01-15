import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

/**
 * This is the GUI implementation of the Burrito program
 * 
 * @author Cody Moffitt
 * @version 1.0
 */
public class BurritoGUI extends JFrame
{
    BurritoBuilder bb; //The burrito
    ImageIcon icon; //The icon of this program
    private JPanel leftPanel; //The left panel, holds buttons
    private JPanel burritoPanel; //Hold main burrito buttons
    private JButton buildYourOwnBtn, spcyVegBtn, dblStkBtn, orderBtn, quitBtn; //The burrito panel buttons
    private JPanel tortillaPanel; //Hold tortilla specific buttons
    private JButton chipBtn, spnchBtn, whtBtn; //The tortilla panel buttons
    private JPanel fillerPanel; //Hold meat/bean buttons
    private JButton bbeanBtn, chikBtn, stkBtn; //Filler buttons
    private JPanel condPanel; //Hold condiment buttons
    private JButton guacBtn, jalaBtn, onionBtn, picoBtn; //Buttons for the condiments
    private JPanel rightPanel; //The right panel, holds info pane (text area, infoArea)
    private JTextArea infoArea; //The panel holding the scrolling text
    
    /**
    * This is the constructor for the BurritoGUI.
    * It sets up all the panels and buttons.
    * 
    */
    BurritoGUI()
    {
        //Initialize bb, the Burrito
        bb = new BurritoBuilder();
        Globals.burritoCount = 0; //Initialize globals, I could have made them members of this class, but I'd already implemented them in Program1 under the Globals class
        Globals.totalCost = 0.00; //So I figured I should keep that consistent
        //Arrange main panel
        this.setSize(640, 640); //Set the resolution
        this.addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent we) { System.exit(0);}}); //Exit when the X is clicked
        this.setLayout(new GridLayout(1, 2)); //1 pane vertically, 2 panes horizontally
        
        icon = new ImageIcon("images/burritoPic.gif"); // The icon for the program, it is a burrito.
        this.setIconImage(icon.getImage()); //Set the icon
        
        //Arrange left panel, with buttons on it
        leftPanel = new JPanel(); 
        leftPanel.setLayout(new GridLayout(4, 1)); //The left panel will consist of 4 other vertical panels
        
        //burrito panel, the first panel in the left panel
        burritoPanel = new JPanel();
        
        buildYourOwnBtn = new JButton("Build Your Own"); //Name button
        buildYourOwnBtn.addActionListener(new buildYourOwnListener()); //Add the listener for that button
        burritoPanel.add(buildYourOwnBtn); //Add it to the panel
        
        
        spcyVegBtn = new JButton("Spicy Veggie"); //Same pattern as the button before
        spcyVegBtn.addActionListener( new spcyVegListener());
        burritoPanel.add(spcyVegBtn);
        
        dblStkBtn = new JButton("Double Steak"); //Same
        dblStkBtn.addActionListener( new dblStkListener());
        burritoPanel.add(dblStkBtn);

        orderBtn = new JButton("Order"); //Same
        orderBtn.addActionListener( new orderListener());
        burritoPanel.add(orderBtn);
        orderBtn.setEnabled(false); //Can't order a burrito without making it first!
        
        quitBtn = new JButton("Quit"); //Same
        quitBtn.addActionListener( new quitListener());
        burritoPanel.add(quitBtn);
        
        burritoPanel.setBackground(Color.GREEN); //Set this panel to be green, like in the example GUI
        leftPanel.add(burritoPanel); //Add this panel to the left panel
        
        //tortilla panel, the next panel to add to the left panel
        tortillaPanel = new JPanel();
        
        tortListener tortAction = new tortListener(); //The action listener for all tortilla buttons, made sense to instantiate it, so I didn't have 3 new action listeners
        
        chipBtn = new JButton("Chipotle");
        chipBtn.addActionListener(tortAction);
        tortillaPanel.add(chipBtn);
        chipBtn.setEnabled(false); //These buttons will all be disabled until the Build Your Own button is clicked
        
        spnchBtn = new JButton("Spinach");
        spnchBtn.addActionListener(tortAction);
        tortillaPanel.add(spnchBtn);
        spnchBtn.setEnabled(false);
        
        whtBtn = new JButton("Wheat");
        whtBtn.addActionListener(tortAction);
        tortillaPanel.add(whtBtn);
        whtBtn.setEnabled(false);

        tortillaPanel.setBackground(Color.BLUE); //Set this panel to blue
        leftPanel.add(tortillaPanel); //Add it to the left panel
        
        //filler panel bbeanBtn, chikBtn, stkBtn. This is the third panel to add to the left panel.
        //Its buttons will be disable until a tortilla is chosen
        fillerPanel = new JPanel();
        
        fillerListener fillerAction = new fillerListener(); //Same listener for all the fillers
        
        bbeanBtn = new JButton("Black Bean");
        bbeanBtn.addActionListener(fillerAction);
        fillerPanel.add(bbeanBtn);
        bbeanBtn.setEnabled(false);
        
        chikBtn = new JButton("Grilled Chicken");
        chikBtn.addActionListener(fillerAction);
        fillerPanel.add(chikBtn);
        chikBtn.setEnabled(false);
        
        stkBtn = new JButton("Steak");
        stkBtn.addActionListener(fillerAction);
        fillerPanel.add(stkBtn);
        stkBtn.setEnabled(false);
        
        fillerPanel.setBackground(Color.RED); //Set panel color to red
        leftPanel.add(fillerPanel); //Add it to the left panel
        
        //condiment panel, the fourth panel to add to left panel
        //All buttons are disabled until a filler is chosen
        condPanel = new JPanel();
        condListener condAction = new condListener(); //Same listener for all condiments
        
        guacBtn = new JButton("Guacamole");
        guacBtn.addActionListener(condAction);
        condPanel.add(guacBtn);
        guacBtn.setEnabled(false);
        
        jalaBtn = new JButton("Jalapeno");
        jalaBtn.addActionListener(condAction);
        condPanel.add(jalaBtn);
        jalaBtn.setEnabled(false);
        
        onionBtn = new JButton("Onion");
        onionBtn.addActionListener(condAction);
        condPanel.add(onionBtn);
        onionBtn.setEnabled(false);
        
        picoBtn = new JButton("Pico de Gallo");
        picoBtn.addActionListener(condAction);
        condPanel.add(picoBtn);
        picoBtn.setEnabled(false);
        
        condPanel.setBackground(Color.YELLOW); //Set this panel to yellow
        leftPanel.add(condPanel); //Add it to the left panel
        
        
        //Arrange right panel, which has text scroller
        rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(1, 1)); //Just one slot on the right panel
        infoArea = new JTextArea(); //Create scroller for text messages
        JScrollPane taScroller = new JScrollPane(infoArea); 
        rightPanel.add(taScroller);//Add scroller to the right panel
        
        //Add left and right panel to main window
        this.add(leftPanel);
        this.add(rightPanel);
        
        setResizable(true); //Lets make it resizable, because why not?
    }
    
    /**
    * The main method for Program 4. Creates the GUI and makes it visible. Very simple. 
    * @param args Not used in this program
    */
    public static void main(String[] args)
    {
        BurritoGUI gui;
        gui = new BurritoGUI();
        gui.setVisible(true);
    }  
    
    /**
    * This subclass has the action listener for the Build Your Own button.
    * 
    */
    private class buildYourOwnListener implements ActionListener
    {
        /**
        * This is the override method, containing what happens when Build Your Own is clicked.
        * @param e The action event generated
        * 
        */
        public void actionPerformed(ActionEvent e)
        {
           infoArea.append("Build your own: \n"); //Put this in the text area so the user knows whats going on
           
           //Disable all the main burrito panel buttons, these will ruin the current burrito order
           spcyVegBtn.setEnabled(false);
           dblStkBtn.setEnabled(false);
           orderBtn.setEnabled(false);
           quitBtn.setEnabled(false);
           buildYourOwnBtn.setEnabled(false);
           
           //Enable the tortilla buttons
           chipBtn.setEnabled(true);
           spnchBtn.setEnabled(true);
           whtBtn.setEnabled(true);
           
        }
    }
    
    /**
    * This subclass has the action listener for the Spicy Veggie button
    * 
    */
    private class spcyVegListener implements ActionListener
    {
        /**
        * This is the override method, containing what happens when Spicy Veggie is clicked.
        * @param e The action event generated
        * 
        */
        public void actionPerformed(ActionEvent e)
        {
           infoArea.append("Spicy Veggie ordered.\n"); //Tell the user whats up
           bb = new SpicyVeggie(); //Make the burrito
           infoArea.append(bb.orderBurrito().toString()); //Tell them the Burrito order
           infoArea.append("Cost: " + Currency.formatCurrency(bb.orderBurrito().cost()) + "\n\n"); //Tell the user the cost
           
           //Update globals
           Globals.burritoCount++;
           Globals.totalCost += bb.orderBurrito().cost();
           
           //Reset bb
           bb = new BurritoBuilder();
           
        }
    }
    
   /**
    * This subclass has the action listener for the Double Steak button
    * 
    */ 
    private class dblStkListener implements ActionListener
    {
       /**
        * This is the override method, containing what happens when Double Steak is clicked.
        * Basically the same as the Spicy Veggie button, but with a Double Steak burrito.
        * @param e The action event generated
        * 
        */
        public void actionPerformed(ActionEvent e)
        {
           infoArea.append("Double Steak ordered.\n");
           bb = new DoubleSteak();
           infoArea.append(bb.orderBurrito().toString());
           infoArea.append("Cost: " + Currency.formatCurrency(bb.orderBurrito().cost()) + "\n\n");
           
           //Update globals
           Globals.burritoCount++;
           Globals.totalCost += bb.orderBurrito().cost();
           
           //Reset bb
           bb = new BurritoBuilder();
           
        }
    }
    
    /**
    * This subclass has the action listener for the quit button
    * 
    */  
    private class quitListener implements ActionListener
    {
       /**
        * This is the override method, containing what happens when quit is clicked. 
        * It opens a window where you can choose where to save the text from the text scroll box.
        * @param e The ActionEvent generated when the user does something
        * 
        */ 
        public void actionPerformed(ActionEvent e)
        {
               
           File dir = new File("./saves"); //Make saves directory if it doesn't exist
           dir.mkdir(); //Make the directories if they don't exist, if they do, it seems to have no effect. Doesn't erase files or anything.
           JFileChooser chooser = new JFileChooser("./saves"); //Open the JFileChooser in saves directory
           chooser.setMultiSelectionEnabled(false); //Only save one file at a time, might be default but set it just in case
           
           int returnVal = chooser.showSaveDialog(BurritoGUI.this); //get user's choice of file name
           if(returnVal == JFileChooser.APPROVE_OPTION) //if the user wants to save, do it!
           {
               try
               {
                   infoArea.append("You ordered " + Globals.burritoCount + " burrito(s) for a grand total of " + Currency.formatCurrency(Globals.totalCost) + ".\n"); 
                   File file = chooser.getSelectedFile();
                   String fileName = file.getAbsolutePath(); //This is kind of a goofy way to do this, but I like using FileIO much better than the regular File class
                   FileIO fileToWrite = new FileIO(fileName, FileIO.FOR_WRITING);
                   fileToWrite.writeLine(infoArea.getText()); //Get the infoArea string and write
                   fileToWrite.close();
                   System.exit(0);
               }
               catch(FileIOException fe)
               {
                   JOptionPane.showMessageDialog(BurritoGUI.this, fe.getMessage());
               }
           }
           else
           {
               JOptionPane.showMessageDialog(BurritoGUI.this, "File not saved."); //Notify the user that the file was not saved
           }
        }
     }
     
   /**
    * This subclass has the action listener for the order button
    * 
    */    
     private class orderListener implements ActionListener
    {
       /**
        * This is the override method, containing what happens when order is clicked.
        * It updates the text scroller, the globals, and grays and ungrays the right buttons to get us back the starting state.
        * @param e The ActionEvent generated when the user does something
        * 
        */  
        public void actionPerformed(ActionEvent e)
        {
           infoArea.append("Burrito ordered.\n");
           infoArea.append(bb.orderBurrito().toString());
           infoArea.append("Cost: " + Currency.formatCurrency(bb.orderBurrito().cost()) + "\n\n");
           
           //Update globals
           Globals.burritoCount++;
           Globals.totalCost += bb.orderBurrito().cost();
           grayButtons();
           ungrayButtons();
           
           //Reset bb
           bb = new BurritoBuilder();
           
           
        }
        
       /**
        * Deactivates the buttons that this event needs grayed. 
        * 
        */   
        public void grayButtons()
        {
           guacBtn.setEnabled(false);
           jalaBtn.setEnabled(false);
           onionBtn.setEnabled(false);
           picoBtn.setEnabled(false);
           
           bbeanBtn.setEnabled(false);
           chikBtn.setEnabled(false);
           stkBtn.setEnabled(false);
           
           orderBtn.setEnabled(false);
        }
        
       /**
        * Activates the buttons that this event needs grayed. 
        * 
        */   
        public void ungrayButtons()
        {
           spcyVegBtn.setEnabled(true);
           dblStkBtn.setEnabled(true);
           orderBtn.setEnabled(true);
           quitBtn.setEnabled(true);
           buildYourOwnBtn.setEnabled(true);
        }
    }
   
   /**
    * This subclass has the action listener for the tortilla buttons.
    * 
    */    
    private class tortListener implements ActionListener
    {
       /**
        * This is the override method, containing what happens when a tortilla button is clicked.
        * It decides which button was clicked, then takes appropriate action.
        * @param e The ActionEvent generated when the user does something
        * 
        */   
        public void actionPerformed(ActionEvent e)
        {
           
           if(e.getSource() == chipBtn)
           {
               infoArea.append("Chipotle tortilla chosen.\n");
               bb.buildTortilla('c');
           }
           
           else if(e.getSource() == spnchBtn)
           {
               infoArea.append("Spinach tortilla chosen.\n");
               bb.buildTortilla('s');
           }
           
           else if(e.getSource() == whtBtn)
           {
               infoArea.append("Wheat tortilla chosen.\n");
               bb.buildTortilla('w');
           }
           
           grayButtons();
           ungrayButtons();
           
           
        }
       
       /**
        * Deactivates the buttons that this event needs grayed. 
        * 
        */    
        public void grayButtons()
        {
            chipBtn.setEnabled(false);
            spnchBtn.setEnabled(false);
            whtBtn.setEnabled(false);
        }
        
       /**
        * Activates the buttons that this event needs grayed. 
        * 
        */    
        public void ungrayButtons()
        {
            bbeanBtn.setEnabled(true);
            chikBtn.setEnabled(true);
            stkBtn.setEnabled(true);
        }
    }
    
   /**
    * This subclass has the action listener for the filler buttons.
    * 
    */    
    private class fillerListener implements ActionListener
    {
       /**
        * This is the override method, containing what happens when a filler button is clicked.
        * It decides what action to take based on which filler was clicked.
        * @param e The ActionEvent generated when the user does something
        * 
        */   
        public void actionPerformed(ActionEvent e)
        {
           
           if(e.getSource() == bbeanBtn)
           {
               infoArea.append("Black bean added.\n");
               bb.buildFiller('b');
           }
           
           else if(e.getSource() == chikBtn)
           {
               infoArea.append("Grilled chicken added.\n");
               bb.buildFiller('g');
           }
           
           else if(e.getSource() == stkBtn)
           {
               infoArea.append("Steak added.\n");
               bb.buildFiller('s');
           }
           
           ungrayButtons(); //Once first filler is added, we can add condiments, or order
           
           
           
        }
        
       /**
        * Deactivates the buttons that this event needs grayed. In this case none.
        * Left this method here just to remind myself of that point.
        * 
        */  
        public void grayButtons()
        {
            
        }
       
       /**
        * Activates the buttons that this event needs grayed. 
        * 
        */  
        public void ungrayButtons()
        {
           guacBtn.setEnabled(true);
           jalaBtn.setEnabled(true);
           onionBtn.setEnabled(true);
           picoBtn.setEnabled(true);
           orderBtn.setEnabled(true); //You can order with no condiments
           
        }
    }
    
   /**
    * This subclass has the action listener for the condiment buttons.
    * 
    */     
    private class condListener implements ActionListener
    {
       /**
        * This is the override method, containing what happens when a condiment button is clicked.
        * It decides what action to take based on which condiment was clicked.
        * Each condiment deactivates itself after it is clicked.
        * @param e The ActionEvent generated when the user does something
        * 
        */    
        public void actionPerformed(ActionEvent e)
        {
           //guacBtn, jalaBtn, onionBtn, picoBtn
           if(e.getSource() == guacBtn)
           {
               infoArea.append("Guacamole added.\n");
               bb.buildCondiment('g');
               guacBtn.setEnabled(false);
           }
           
           else if(e.getSource() == jalaBtn)
           {
               infoArea.append("Jalapenos added.\n");
               bb.buildCondiment('j');
               jalaBtn.setEnabled(false);
           }
           
           else if(e.getSource() == onionBtn)
           {
               infoArea.append("Onion added.\n");
               bb.buildCondiment('o');
               onionBtn.setEnabled(false);
           }
           
           else if(e.getSource() == picoBtn)
           {
               infoArea.append("Pico de Gallo added.\n");
               bb.buildCondiment('p');
               picoBtn.setEnabled(false);
           }
           
           grayButtons(); //Once first condiment is added, no more fillers
           ungrayButtons();
           
           
        }
        
       /**
        * Deactivates the buttons that this event needs grayed. 
        * 
        */   
        public void grayButtons()
        {
            bbeanBtn.setEnabled(false); //No fillers after condiments
            chikBtn.setEnabled(false);
            stkBtn.setEnabled(false);
        }
        
       /**
        * Activates the buttons that this event needs grayed. 
        * 
        */   
        public void ungrayButtons()
        {
           orderBtn.setEnabled(true); //This really should be enabled by this point anyway
        }
    }
}
