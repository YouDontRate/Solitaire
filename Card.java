class Card
{
   private NameType name;
   private SuitType suit;
   private int value;
   private char color;

   Card(NameType name, SuitType suit, int value, char color)
   {  
      this.name = name;
      this.suit = suit;
      this.value = value;
      this.color = color;
   
   }// End constructor
   
//--------------------------------------------------
   
   @Override
   public String toString()
   {
      String card = "[" + name + " of " + suit + " - (" + color + ")" + "]";
      return card;                         
                          
   }// End toString method
   
//----------------------------------------------------
   
   public NameType getName()
   {     
      return name;
   }// End getName method

//-----------------------------------------------------

   public SuitType getSuit()
   {     
      return suit;
   }// End getSuit method

//-----------------------------------------------------

   public int getValue()
   {      
      return value;
   }// End getValue method   
   
//---------------------------------------

   public char getColor()
   {
      return color;
   }// End getColor
   
} // End class
