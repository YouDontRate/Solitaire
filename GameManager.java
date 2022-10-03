import java.util.ArrayList;

class GameManager
{   
   private final int EMPTY = 0;
   private final int ACE = 1;
   private final int KING = 13;  
   private Card drawCard;
   private Deck myDeck;   
   private int pileSize;
   private int pileCardValue;      
   private char pileCardColor;
   private SuitType suit;
      
   private ArrayList <Card> stockPile;
   private ArrayList <Card> discardPile;
   private ArrayList <Card> heartsPile;
   private ArrayList <Card> clubsPile;
   private ArrayList <Card> diamondsPile;
   private ArrayList <Card> spadesPile;   
   
   private ArrayList <Card> pileOne;
   private ArrayList <Card> pileTwo;
   private ArrayList <Card> pileThree;
   private ArrayList <Card> pileFour;
   private ArrayList <Card> pileFive;
   private ArrayList <Card> pileSix;
   private ArrayList <Card> pileSeven;   
   
   private ArrayList <Card> displayPileTwo;
   private ArrayList <Card> displayPileThree;
   private ArrayList <Card> displayPileFour;
   private ArrayList <Card> displayPileFive;
   private ArrayList <Card> displayPileSix;
   private ArrayList <Card> displayPileSeven;    

//----------------------------------------------

   GameManager()
   {      
      initialize();           
           
   }// End constructor
   
//-----------------------------------------------

   private void initialize()
   {
   
      myDeck = new Deck();
      stockPile = new ArrayList <Card>();
      discardPile = new ArrayList <Card>();
      heartsPile = new ArrayList <Card>();
      clubsPile = new ArrayList <Card>();
      diamondsPile = new ArrayList <Card>();
      spadesPile = new ArrayList <Card>();
      
      pileOne = new ArrayList <Card>();
      pileTwo = new ArrayList <Card>();
      pileThree = new ArrayList <Card>();
      pileFour = new ArrayList <Card>();
      pileFive = new ArrayList <Card>();
      pileSix = new ArrayList <Card>();
      pileSeven = new ArrayList <Card>();
      
      displayPileTwo = new ArrayList <Card>();
      displayPileThree = new ArrayList <Card>();
      displayPileFour = new ArrayList <Card>();
      displayPileFive = new ArrayList <Card>();
      displayPileSix = new ArrayList <Card>();
      displayPileSeven = new ArrayList <Card>();
   
   }// End initialize method
   
//----------------------------------------

   public void dealCards()
   {     
      initialize();         
      myDeck.shuffle();     
      
      pileOne.add(myDeck.deal());     
      pileTwo.add(myDeck.deal());
      pileThree.add(myDeck.deal());
      pileFour.add(myDeck.deal());
      pileFive.add(myDeck.deal());
      pileSix.add(myDeck.deal());
      pileSeven.add(myDeck.deal());
      
      displayPileTwo.add(myDeck.deal());
      pileThree.add(myDeck.deal());
      pileFour.add(myDeck.deal());
      pileFive.add(myDeck.deal());
      pileSix.add(myDeck.deal());
      pileSeven.add(myDeck.deal());
      
      displayPileThree.add(myDeck.deal());
      pileFour.add(myDeck.deal());
      pileFive.add(myDeck.deal());
      pileSix.add(myDeck.deal());
      pileSeven.add(myDeck.deal());
      
      displayPileFour.add(myDeck.deal());
      pileFive.add(myDeck.deal());
      pileSix.add(myDeck.deal());
      pileSeven.add(myDeck.deal());
      
      displayPileFive.add(myDeck.deal());
      pileSix.add(myDeck.deal());
      pileSeven.add(myDeck.deal());
      
      displayPileSix.add(myDeck.deal());
      pileSeven.add(myDeck.deal());
      
      displayPileSeven.add(myDeck.deal());
      
      pileSize = myDeck.getDealIndex() + 1;     
      
      for (int i = 0; i < pileSize; i++)
         stockPile.add(myDeck.deal());
      
      drawCard();     
   
   }// End dealCards
   
//--------------------------------------------------

   public void drawCard()
   { 
      Card pileCard;
      int numberOfCards = stockPile.size();
              
      if (discardPile.size() == EMPTY && stockPile.size() == EMPTY)
         drawCard = null;
      
      else if (stockPile.size() == EMPTY)
      {         
         for (int i = 0; i < discardPile.size(); i++)
         {
            pileCard = discardPile.get(i);            
            stockPile.add(pileCard);            
         }// End for loop
         
         discardPile.clear();
         numberOfCards = stockPile.size();         
         drawCard = stockPile.get(numberOfCards - 1);
      }// End if      
      
      else
         drawCard = stockPile.get(numberOfCards - 1);                       
   
   }// End drawCard
   
//----------------------------------------

   public void moveDealtCardToTableau(int pile)
   {           
      boolean validMove = false;;
           
      if (drawCard != null)             
         validMove = addCardToPile(drawCard, pile);                
               
      if (validMove)
      {
         stockPile.remove(drawCard);
         drawCard = null;
      }// End if    
      
   }// End moveDealtCardToTableau
   
//------------------------------------------

   public void moveDealtCardToFoundation()
   {     
      boolean validMove = false;;
           
      if (drawCard != null)             
         validMove = moveCardToFoundation(drawCard);
      
      if (validMove)
      {
         stockPile.remove(drawCard);
         drawCard = null;
      }// End if      
         
   }// End moveDealtCardToFoundation
   
//------------------------------------------

   public void discardDealtCard()
   {
      if (drawCard == null)
         System.out.println("Draw new card");
      else
      {
         stockPile.remove(drawCard);
         discardPile.add(drawCard);
         drawCard = null;
      }// End else
   
   }// End discardDealtCard
   
//---------------------------------------

   public void moveTableauCardToFoundation(int pileNumber)
   {
      Card pileCard = null;   
      boolean validMove = false;
   
      switch (pileNumber)
      {     
         case 1:
         {
            pileSize = pileOne.size();
         
            if (pileSize > EMPTY)
            {
               pileCard = pileOne.get(pileSize - 1);            
               validMove = moveCardToFoundation(pileCard);              
            }// End if
            
            else
               System.out.println("Pile Empty");
               
            if (validMove)
               pileOne.remove(pileCard);
               
            break;
         }// End case      
         
         case 2:
         {
            pileSize = displayPileTwo.size();
         
            if (pileSize > EMPTY)
            {
               pileCard = displayPileTwo.get(pileSize - 1);            
               validMove = moveCardToFoundation(pileCard);            
            }// End if
            
            else
               System.out.println("Pile Empty");
               
            if (validMove)
               displayPileTwo.remove(pileCard);
               
            break;
         }// End case        
         
         case 3:
         {
            pileSize = displayPileThree.size();
         
            if (pileSize > EMPTY)
            {
               pileCard = displayPileThree.get(pileSize - 1);            
               validMove = moveCardToFoundation(pileCard);           
            }// End if
            
            else
               System.out.println("Pile Empty");
               
            if (validMove)
               displayPileThree.remove(pileCard);
               
            break;
         }// End case
         
         case 4:
         {
            pileSize = displayPileFour.size();
         
            if (pileSize > EMPTY)
            {
               pileCard = displayPileFour.get(pileSize - 1);            
               validMove = moveCardToFoundation(pileCard);            
            }// End if
            
            else
               System.out.println("Pile Empty");
               
            if (validMove)
               displayPileFour.remove(pileCard);
               
            break;
         }// End case
         
         case 5:
         {
            pileSize = displayPileFive.size();
         
            if (pileSize > EMPTY)
            {
               pileCard = displayPileFive.get(pileSize - 1);            
               validMove = moveCardToFoundation(pileCard);           
            }// End if
            
            else
               System.out.println("Pile Empty");
               
            if (validMove)
               displayPileFive.remove(pileCard);
               
            break;
         }// End case
         
         case 6:
         {
            pileSize = displayPileSix.size();
         
            if (pileSize > EMPTY)
            {
               pileCard = displayPileSix.get(pileSize - 1);            
               validMove = moveCardToFoundation(pileCard);           
            }// End if
            
            else
               System.out.println("Pile Empty");
               
            if (validMove)
               displayPileSix.remove(pileCard);
               
            break;
         }// End case
         
         case 7:
         {
            pileSize = displayPileSeven.size();
         
            if (pileSize > EMPTY)
            {
               pileCard = displayPileSeven.get(pileSize - 1);            
               validMove = moveCardToFoundation(pileCard);                              
            }// End if
            
            else
               System.out.println("Pile Empty");
               
            if (validMove)
               displayPileSeven.remove(pileCard);
               
            break;
         }// End case      
         
         default:           
            System.out.println("Invalid Pile");     
      
      }// End switch      
   
   }// End moveTableauCardToFoundation
   
//-------------------------------------

   public void moveTableauCard(int currentPile, int newPile)
   {
      Card pileCard = null;
      boolean validMove = false;
      
      switch (currentPile)
      {
         case 1:
         {
            if (currentPile == newPile)
            {
               System.out.println("Invalid Move");
               break;
            }// End if           
         
            if (pileOne.size() == EMPTY)           
               System.out.println("Pile Empty");            
            
            else
            {               
               pileCard = pileOne.get(pileOne.size() - 1);               
               validMove = addCardToPile(pileCard, newPile);              
            }// End else 
            
            if (validMove)
               pileOne.remove(pileCard);          
               
            break;
         }// End case
         
         case 2:
         {
            if (currentPile == newPile)
            {
               System.out.println("Invalid Move");
               break;
            }// End if           
         
            if (displayPileTwo.size() == EMPTY)           
               System.out.println("Pile Empty");
                          
            else
            {               
               pileCard = displayPileTwo.get(displayPileTwo.size() - 1);               
               validMove = addCardToPile(pileCard, newPile);              
            }// End else 
            
            if (validMove)
               displayPileTwo.remove(pileCard);           
               
            break;
         }// End case
         
         case 3:
         {
            if (currentPile == newPile)
            {
               System.out.println("Invalid Move");
               break;
            }// End if           
         
            if (displayPileThree.size() == EMPTY)           
               System.out.println("Pile Empty");            
            
            else
            {               
               pileCard = displayPileThree.get(displayPileThree.size() - 1);               
               validMove = addCardToPile(pileCard, newPile);
            }// End else
            
            if (validMove)
               displayPileThree.remove(pileCard);          
               
            break;
         }// End case
         
         case 4:
         {
            if (currentPile == newPile)
            {
               System.out.println("Invalid Move");
               break;
            }// End if           
         
            if (displayPileFour.size() == EMPTY)           
               System.out.println("Pile Empty");            
            
            else
            {               
               pileCard = displayPileFour.get(displayPileFour.size() - 1);               
               validMove = addCardToPile(pileCard, newPile);
            }// End else
            
            if (validMove)
               displayPileFour.remove(pileCard);          
               
            break;
         }// End case
         
         case 5:
         {
            if (currentPile == newPile)
            {
               System.out.println("Invalid Move");
               break;
            }// End if           
         
            if (displayPileFive.size() == EMPTY)           
               System.out.println("Pile Empty");            
            
            else
            {               
               pileCard = displayPileFive.get(displayPileFive.size() - 1);               
               validMove = addCardToPile(pileCard, newPile);
            }// End else if  
            
            if (validMove)
               displayPileFive.remove(pileCard);         
               
            break;
         }// End case
         
         case 6:
         {
            if (currentPile == newPile)
            {
               System.out.println("Invalid Move");
               break;
            }// End if           
         
            if (displayPileSix.size() == EMPTY)           
               System.out.println("Pile Empty");            
            
            else
            {               
               pileCard = displayPileSix.get(displayPileSix.size() - 1);               
               validMove = addCardToPile(pileCard, newPile);
            }// End else
            
            if (validMove)
               displayPileSix.remove(pileCard);          
               
            break;
         }// End case
         
         case 7:
         {
            if (currentPile == newPile)
            {
               System.out.println("Invalid Move");
               break;
            }// End if           
         
            if (displayPileSeven.size() == EMPTY)           
               System.out.println("Pile Empty");            
            
            else
            {               
               pileCard = displayPileSeven.get(displayPileSeven.size() - 1);               
               validMove = addCardToPile(pileCard, newPile);
            }// End else if 
            
            if (validMove)
               displayPileSeven.remove(pileCard);          
               
            break;
         }// End case        
         
         default:           
            System.out.println("Invalid Pile");   
      
      }// End switch     
   
   }// End moveTableauCard
   
//-------------------------------------  

   public void moveTableauPile(int currentPile, int numberOfCards, int newPile)
   {  
      Card pileCard = null;
      boolean validMove = false;
      int cardCount;           
      
      switch (currentPile)
      {
         case 1:
         {       
            pileSize = pileOne.size();
         
            if (currentPile == newPile)
            {
               System.out.println("Invalid Move");
               break;
            }// End if 
            
            if (pileSize < numberOfCards)
            {
               System.out.println("Invalid Move");
               break;
            }// End if          
         
            if (pileSize == EMPTY)           
               System.out.println("Pile Empty");            
            
            else
            {                             
               pileCard = pileOne.get(pileOne.size() - numberOfCards);                              
               validMove = addCardToPile(pileCard, newPile);                                       
            }// End else             
            
            if (validMove)
            {
               cardCount = numberOfCards;
               pileOne.remove(pileCard);               
               numberOfCards--;
               
               for (int i = 0; i < cardCount - 1; i++)
               {                  
                  pileCard = pileOne.get(pileOne.size() - numberOfCards);                                 
                  validMove = addCardToPile(pileCard, newPile);
                  pileOne.remove(pileCard);
                  numberOfCards--;               
               }// End for loop              
               
            }// End if                        
               
            break;
         }// End case
         
         case 2:
         {       
            pileSize = displayPileTwo.size();
         
            if (currentPile == newPile)
            {
               System.out.println("Invalid Move");
               break;
            }// End if 
            
            if (pileSize < numberOfCards)
            {
               System.out.println("Invalid Move");
               break;
            }// End if          
         
            if (pileSize == EMPTY)           
               System.out.println("Pile Empty");            
            
            else
            {                             
               pileCard = displayPileTwo.get(displayPileTwo.size() - numberOfCards);                              
               validMove = addCardToPile(pileCard, newPile);                                       
            }// End else             
            
            if (validMove)
            {
               cardCount = numberOfCards;
               displayPileTwo.remove(pileCard);               
               numberOfCards--;
               
               for (int i = 0; i < cardCount - 1; i++)
               {                  
                  pileCard = displayPileTwo.get(displayPileTwo.size() - numberOfCards);                                 
                  validMove = addCardToPile(pileCard, newPile);
                  displayPileTwo.remove(pileCard);
                  numberOfCards--;               
               }// End for loop              
               
            }// End if                        
               
            break;
         }// End case
         
         case 3:
         {       
            pileSize = displayPileThree.size();
         
            if (currentPile == newPile)
            {
               System.out.println("Invalid Move");
               break;
            }// End if 
            
            if (pileSize < numberOfCards)
            {
               System.out.println("Invalid Move");
               break;
            }// End if          
         
            if (pileSize == EMPTY)           
               System.out.println("Pile Empty");            
            
            else
            {                             
               pileCard = displayPileThree.get(displayPileThree.size() - numberOfCards);                              
               validMove = addCardToPile(pileCard, newPile);                                       
            }// End else             
            
            if (validMove)
            {
               cardCount = numberOfCards;
               displayPileThree.remove(pileCard);               
               numberOfCards--;
               
               for (int i = 0; i < cardCount - 1; i++)
               {                  
                  pileCard = displayPileThree.get(displayPileThree.size() - numberOfCards);                                 
                  validMove = addCardToPile(pileCard, newPile);
                  displayPileThree.remove(pileCard);
                  numberOfCards--;               
               }// End for loop              
               
            }// End if                        
               
            break;
         }// End case
         
         case 4:
         {       
            pileSize = displayPileFour.size();
         
            if (currentPile == newPile)
            {
               System.out.println("Invalid Move");
               break;
            }// End if 
            
            if (pileSize < numberOfCards)
            {
               System.out.println("Invalid Move");
               break;
            }// End if          
         
            if (pileSize == EMPTY)           
               System.out.println("Pile Empty");            
            
            else
            {                             
               pileCard = displayPileFour.get(displayPileFour.size() - numberOfCards);                              
               validMove = addCardToPile(pileCard, newPile);                                       
            }// End else             
            
            if (validMove)
            {
               cardCount = numberOfCards;
               displayPileFour.remove(pileCard);               
               numberOfCards--;
               
               for (int i = 0; i < cardCount - 1; i++)
               {                  
                  pileCard = displayPileFour.get(displayPileFour.size() - numberOfCards);                                 
                  validMove = addCardToPile(pileCard, newPile);
                  displayPileFour.remove(pileCard);
                  numberOfCards--;               
               }// End for loop              
               
            }// End if                        
               
            break;
         }// End case
         
         case 5:
         {       
            pileSize = displayPileFive.size();
         
            if (currentPile == newPile)
            {
               System.out.println("Invalid Move");
               break;
            }// End if 
            
            if (pileSize < numberOfCards)
            {
               System.out.println("Invalid Move");
               break;
            }// End if          
         
            if (pileSize == EMPTY)           
               System.out.println("Pile Empty");            
            
            else
            {                             
               pileCard = displayPileFive.get(displayPileFive.size() - numberOfCards);                              
               validMove = addCardToPile(pileCard, newPile);                                       
            }// End else             
            
            if (validMove)
            {
               cardCount = numberOfCards;
               displayPileFive.remove(pileCard);               
               numberOfCards--;
               
               for (int i = 0; i < cardCount - 1; i++)
               {                  
                  pileCard = displayPileFive.get(displayPileFive.size() - numberOfCards);                                 
                  validMove = addCardToPile(pileCard, newPile);
                  displayPileFive.remove(pileCard);
                  numberOfCards--;               
               }// End for loop              
               
            }// End if                        
               
            break;
         }// End case
         
         case 6:
         {       
            pileSize = displayPileSix.size();
         
            if (currentPile == newPile)
            {
               System.out.println("Invalid Move");
               break;
            }// End if 
            
            if (pileSize < numberOfCards)
            {
               System.out.println("Invalid Move");
               break;
            }// End if          
         
            if (pileSize == EMPTY)           
               System.out.println("Pile Empty");            
            
            else
            {                             
               pileCard = displayPileSix.get(displayPileSix.size() - numberOfCards);                              
               validMove = addCardToPile(pileCard, newPile);                                       
            }// End else             
            
            if (validMove)
            {
               cardCount = numberOfCards;
               displayPileSix.remove(pileCard);               
               numberOfCards--;
               
               for (int i = 0; i < cardCount - 1; i++)
               {                  
                  pileCard = displayPileSix.get(displayPileSix.size() - numberOfCards);                                 
                  validMove = addCardToPile(pileCard, newPile);
                  displayPileSix.remove(pileCard);
                  numberOfCards--;               
               }// End for loop              
               
            }// End if                        
               
            break;
         }// End case
         
         case 7:
         {       
            pileSize = displayPileSeven.size();
         
            if (currentPile == newPile)
            {
               System.out.println("Invalid Move");
               break;
            }// End if 
            
            if (pileSize < numberOfCards)
            {
               System.out.println("Invalid Move");
               break;
            }// End if          
         
            if (pileSize == EMPTY)           
               System.out.println("Pile Empty");            
            
            else
            {                             
               pileCard = displayPileSeven.get(displayPileSeven.size() - numberOfCards);                              
               validMove = addCardToPile(pileCard, newPile);                                       
            }// End else             
            
            if (validMove)
            {
               cardCount = numberOfCards;
               displayPileSeven.remove(pileCard);               
               numberOfCards--;
               
               for (int i = 0; i < cardCount - 1; i++)
               {                  
                  pileCard = displayPileSeven.get(displayPileSeven.size() - numberOfCards);                                 
                  validMove = addCardToPile(pileCard, newPile);
                  displayPileSeven.remove(pileCard);
                  numberOfCards--;               
               }// End for loop              
               
            }// End if                        
               
            break;
         }// End case        
      
      }// End switch 
   
   }// End moveTableauPile
   
//-------------------------------------

   public void displayBoard()
   {
      final int NUMBER_OF_PILES = 7;
      final int FOUNDATION_PILES = 4;
      String[] pileNumbers = {"Pile One", "Pile Two", "Pile Three", "Pile Four", "Pile Five", "Pile Six", "Pile Seven"};
      ArrayList <ArrayList <Card>> tableauPiles = new ArrayList <ArrayList <Card>>();
      ArrayList <ArrayList <Card>> foundationPiles = new ArrayList <ArrayList <Card>>();      
      ArrayList <Card> tempPile;
      int largestPile = 0;
      int pileSize;
      
      foundationPiles.add(spadesPile);
      foundationPiles.add(diamondsPile);
      foundationPiles.add(clubsPile);
      foundationPiles.add(heartsPile);
      
      tableauPiles.add(pileOne);
      tableauPiles.add(displayPileTwo);
      tableauPiles.add(displayPileThree);
      tableauPiles.add(displayPileFour);
      tableauPiles.add(displayPileFive);
      tableauPiles.add(displayPileSix);
      tableauPiles.add(displayPileSeven);      
      
      System.out.println();
      
      if (drawCard == null)
         System.out.printf("Draw Card: " + "%s", "Draw New Card       ");              
      else
         System.out.printf("Draw Card: " + "%25s", drawCard);
      
      for(int i = 0; i < FOUNDATION_PILES; i++)
      {         
         tempPile = foundationPiles.get(i);
         pileSize = tempPile.size();
         
         if (pileSize == EMPTY)
            System.out.printf("%24s ", "Empty");
         else
            System.out.printf("%24s ", tempPile.get(tempPile.size() - 1));
         
      }// End loop   
      
      System.out.println();
      System.out.println();
      System.out.println();      
      
      for (int i = 0; i < NUMBER_OF_PILES; i++)
         System.out.printf("%23s ", pileNumbers[i]);         
         
      System.out.println();
      
      for (int i = 0; i < NUMBER_OF_PILES; i++)
      {      
         tempPile = tableauPiles.get(i);
         pileSize = tempPile.size();
         
         if (pileSize > largestPile) 
            largestPile = pileSize;              
         
      }// End loop      
      
      for (int i = 0; i < largestPile; i++)
      {            
         for (int j = 0; j < NUMBER_OF_PILES; j++)
         {
            tempPile = tableauPiles.get(j);            
            pileSize = tempPile.size();
            
            if (i == 0 && pileSize == EMPTY)
               System.out.printf("%20s ", "EMPTY");
            else if (i != 0 && pileSize == EMPTY)
               System.out.printf("%25s ", " ");
            else if (i  >= pileSize)
               System.out.printf("%25s ", " ");
            else
               System.out.printf("%25s ", tempPile.get(i));                       
         
         }// End inner loop
         
         System.out.println();
         
      }// End outer loop
         
         System.out.println();        
   
   }// End displayBoard
   
//-------------------------------------------

   public void checkTableauPiles()
   {
      Card pileCard;
      
      if (displayPileTwo.size() == EMPTY && pileTwo.size() != EMPTY)
      {
         pileCard = pileTwo.get(pileTwo.size() - 1);
         displayPileTwo.add(pileCard);
         pileTwo.remove(pileCard);
      }// End if
      
      if (displayPileThree.size() == EMPTY && pileThree.size() != EMPTY)
      {
         pileCard = pileThree.get(pileThree.size() - 1);
         displayPileThree.add(pileCard);
         pileThree.remove(pileCard);
      }// End if
      
      if (displayPileFour.size() == EMPTY && pileFour.size() != EMPTY)
      {
         pileCard = pileFour.get(pileFour.size() - 1);
         displayPileFour.add(pileCard);
         pileFour.remove(pileCard);
      }// End if
      
      if (displayPileFive.size() == EMPTY && pileFive.size() != EMPTY)
      {
         pileCard = pileFive.get(pileFive.size() - 1);
         displayPileFive.add(pileCard);
         pileFive.remove(pileCard);
      }// End if
      
      if (displayPileSix.size() == EMPTY && pileSix.size() != EMPTY)
      {
         pileCard = pileSix.get(pileSix.size() - 1);
         displayPileSix.add(pileCard);
         pileSix.remove(pileCard);
      }// End if
      
      if (displayPileSeven.size() == EMPTY && pileSeven.size() != EMPTY)
      {
         pileCard = pileSeven.get(pileSeven.size() - 1);
         displayPileSeven.add(pileCard);
         pileSeven.remove(pileCard);
      }// End if      
      
   }// End checkTableauPiles
   
//-------------------------------------

   public boolean checkWinner()
   {
      final int FULL_PILE = 13;
      boolean winner = false;
      int spades;
      int clubs;
      int hearts;
      int diamonds;     
      
      spades = spadesPile.size();
      clubs = clubsPile.size();
      hearts = heartsPile.size();
      diamonds = heartsPile.size();
      
      if (spades == FULL_PILE && clubs == FULL_PILE && hearts == FULL_PILE && diamonds == FULL_PILE)
         winner = true;   
      
      return winner;
   }// End checkWinner
   
//----------------------------------------------------------  
   
   private boolean moveCardToFoundation(Card tempCard)
   {
      Card pileCard;
      boolean validMove = false;     
      int tempCardValue;
           
      suit = tempCard.getSuit();
      tempCardValue = tempCard.getValue();         
      
      switch (suit)
      {
         case HEARTS:
         {         
            if (heartsPile.size() == EMPTY && tempCardValue == ACE)
            {
               heartsPile.add(tempCard);           
               validMove = true;
            }// End if
            
            else if (heartsPile.size() > EMPTY)
            {
               pileCard = heartsPile.get(heartsPile.size() - 1);            
               pileCardValue = pileCard.getValue();
               
               if (tempCardValue == pileCardValue + 1)
               {
                  heartsPile.add(tempCard);
                  validMove = true;
               }// End if   
                  
            }// End else if
               
            else
               System.out.println("Invalid Move!");              
            
            break;
         }// End hearts case
         
         case SPADES:
         {                    
            if (spadesPile.size() == EMPTY && tempCardValue == ACE)
            {
               spadesPile.add(tempCard);           
               validMove = true;
            }// End if
            
            else if (spadesPile.size() > EMPTY)
            {
               pileCard = spadesPile.get(spadesPile.size() - 1);            
               pileCardValue = pileCard.getValue();
               
               if (tempCardValue == pileCardValue + 1)
               {
                  spadesPile.add(tempCard);
                  validMove = true;
               }// End if
                  
            }// End else if
               
            else
               System.out.println("Invalid Move!");              
            
            break;
         }// End spades case
         
         case DIAMONDS:
         {        
            if (diamondsPile.size() == EMPTY && tempCardValue == ACE)
            {
               diamondsPile.add(tempCard);
               validMove = true;
            }// End if                          
            
            else if (diamondsPile.size() > EMPTY)
            {
               pileCard = diamondsPile.get(diamondsPile.size() - 1);            
               pileCardValue = pileCard.getValue();
               
               if (tempCardValue == pileCardValue + 1)
               {
                  diamondsPile.add(tempCard);
                  validMove = true;   
               }// End if
                  
            }// End else if
               
            else
               System.out.println("Invalid Move!");              
            
            break;
         }// End diamonds case
         
         case CLUBS:
         {         
            if (clubsPile.size() == EMPTY && tempCardValue == ACE)
            {
               clubsPile.add(tempCard);
               validMove = true;           
            }// End if
            
            else if (clubsPile.size() > EMPTY)
            {
               pileCard = clubsPile.get(clubsPile.size() - 1);            
               pileCardValue = pileCard.getValue();
               
               if (tempCardValue == pileCardValue + 1)
               {
                  clubsPile.add(tempCard);
                  validMove = true; 
               }// End if
                  
            }// End else if
               
            else
               System.out.println("Invalid Move!");              
            
            break;
         }// End clubs case        
      
      }// End switch     
      
      return validMove;
      
   }// End moveCardToFoundation
     
//-------------------------------------
   
   private boolean addCardToPile(Card tempCard, int newPileNumber)
   {            
      Card pileCard;
      int tempCardValue;
      char tempCardColor; 
      boolean validMove = false;    
      
      switch (newPileNumber)
      {
         case 1:
         {
            pileSize = pileOne.size();
            tempCardValue = tempCard.getValue();            
            
            if (pileSize == EMPTY && tempCardValue == KING)
            {
               pileOne.add(tempCard);
               validMove = true;
            }// End if              
               
            else if (pileSize > EMPTY)
            {
               pileCard = pileOne.get(pileSize - 1);
               pileCardValue = pileCard.getValue();
               pileCardColor = pileCard.getColor();
               tempCardColor = tempCard.getColor();
               
               if (tempCardValue == pileCardValue - 1 && tempCardColor != pileCardColor)
               {
                  pileOne.add(tempCard);                  
                  validMove = true; 
               }// End if
               
               else
                  System.out.println("Invalid Move");
            
            }// End else if           
         
            break;
         
         }// End case
         
         case 2:
         {
            pileSize = displayPileTwo.size();
            tempCardValue = tempCard.getValue();            
            
            if (pileSize == EMPTY && pileTwo.size() == EMPTY && tempCardValue == KING) 
            {
               displayPileTwo.add(tempCard);
               validMove = true;
            }// End if               
               
            else if (pileSize > EMPTY)
            {
               pileCard = displayPileTwo.get(pileSize - 1);
               pileCardValue = pileCard.getValue();
               pileCardColor = pileCard.getColor();
               tempCardColor = tempCard.getColor();
               
               if (tempCardValue == pileCardValue - 1 && tempCardColor != pileCardColor)
               {
                  displayPileTwo.add(tempCard);                  
                  validMove = true; 
               }// End if
               
               else
                  System.out.println("Invalid Move");
            
            }// End else if 
            
            break;          
         
         }// End case
         
         case 3:
         {
            pileSize = displayPileThree.size();
            tempCardValue = tempCard.getValue();            
            
            if (pileSize == EMPTY && pileThree.size() == EMPTY && tempCardValue == KING)
            {  
               displayPileThree.add(tempCard);
               validMove = true;
            }// End if              
               
            else if (pileSize > EMPTY)
            {
               pileCard = displayPileThree.get(pileSize - 1);
               pileCardValue = pileCard.getValue();
               pileCardColor = pileCard.getColor();
               tempCardColor = tempCard.getColor();
               
               if (tempCardValue == pileCardValue - 1 && tempCardColor != pileCardColor)
               {
                  displayPileThree.add(tempCard);                  
                  validMove = true; 
               }// End if
               
               else
                  System.out.println("Invalid Move");
            
            }// End else if   
            
            break;        
         
         }// End case
         
         case 4:
         {
            pileSize = displayPileFour.size();
            tempCardValue = tempCard.getValue();            
            
            if (pileSize == EMPTY && pileFour.size() == EMPTY && tempCardValue == KING) 
            {  
               displayPileFour.add(tempCard);
               validMove = true;
            }// End if              
               
            else if (pileSize > EMPTY)
            {
               pileCard = displayPileFour.get(pileSize - 1);
               pileCardValue = pileCard.getValue();
               pileCardColor = pileCard.getColor();
               tempCardColor = tempCard.getColor();
               
               if (tempCardValue == pileCardValue - 1 && tempCardColor != pileCardColor)
               {
                  displayPileFour.add(tempCard);                  
                  validMove = true; 
               }// End if
               
               else
                  System.out.println("Invalid Move");
            
            }// End else if  
            
            break;         
         
         }// End case
         
         case 5:
         {
            pileSize = displayPileFive.size();
            tempCardValue = tempCard.getValue();            
            
            if (pileSize == EMPTY && pileFive.size() == EMPTY && tempCardValue == KING)
            {
               displayPileFive.add(tempCard);
               validMove = true;
            }// End if              
               
            else if (pileSize > EMPTY)
            {
               pileCard = displayPileFive.get(pileSize - 1);
               pileCardValue = pileCard.getValue();
               pileCardColor = pileCard.getColor();
               tempCardColor = tempCard.getColor();
               
               if (tempCardValue == pileCardValue - 1 && tempCardColor != pileCardColor)
               {
                  displayPileFive.add(tempCard);                  
                  validMove = true; 
               }// End if
               
               else
                  System.out.println("Invalid Move");
            
            }// End else if  
            
            break;         
         
         }// End case
         
         case 6:
         {
            pileSize = displayPileSix.size();
            tempCardValue = tempCard.getValue();            
            
            if (pileSize == EMPTY && pileSix.size() == EMPTY && tempCardValue == KING)
            {
               displayPileSix.add(tempCard);
               validMove = true;
            }// End if               
               
            else if (pileSize > EMPTY)
            {
               pileCard = displayPileSix.get(pileSize - 1);
               pileCardValue = pileCard.getValue();
               pileCardColor = pileCard.getColor();
               tempCardColor = tempCard.getColor();
               
               if (tempCardValue == pileCardValue - 1 && tempCardColor != pileCardColor)
               {
                  displayPileSix.add(tempCard);                  
                  validMove = true; 
               }// End if
               
               else
                  System.out.println("Invalid Move");
            
            }// End else if 
            
            break;          
         
         }// End case
         
         case 7:
         {
            pileSize = displayPileSeven.size();
            tempCardValue = tempCard.getValue();            
            
            if (pileSize == EMPTY && pileSeven.size() == EMPTY && tempCardValue == KING)
            {
               displayPileSeven.add(tempCard);
               validMove = true;
            }// End if               
               
            else if (pileSize > EMPTY)
            {
               pileCard = displayPileSeven.get(pileSize - 1);
               pileCardValue = pileCard.getValue();
               pileCardColor = pileCard.getColor();
               tempCardColor = tempCard.getColor();
               
               if (tempCardValue == pileCardValue - 1 && tempCardColor != pileCardColor)
               {
                  displayPileSeven.add(tempCard);                  
                  validMove = true; 
               }// End if
               
               else
                  System.out.println("Invalid Move");
            
            }// End else if 
            
            break;          
         
         }// End case  
         
         default:           
            System.out.println("Invalid Pile");      
      
      }// End switch
      
      return validMove;      
   
   }// End moveCardToPile 
   

}// End class
