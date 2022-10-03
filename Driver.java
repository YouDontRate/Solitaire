import java.util.Scanner;

class Driver
{
   
   public static void main(String[] args)
   {
   
      handleGame();
      
   }// End main
   
//---------------------------------------
   
   private static void handleGame()
   {
      Scanner input = new Scanner(System.in);
      GameManager myGame = new GameManager();
      boolean winner = false;
      char userInput;
      int currentPile;
      int newPileNumber;
      int numberOfCards;     
      
      menu();
      userInput = input.nextLine().charAt(0);
      
      while (userInput != '0' && winner != true)
      {
         
         switch (userInput)
         {
            case '1':
            {
               myGame.dealCards();
               break;
               
            }// End case
            
            case '2':
            {                
               myGame.drawCard();             
               break;
               
            }// End case
            
            case '3':
            {                
               myGame.discardDealtCard();             
               break;
               
            }// End case
            
            case '4':
            {  
               System.out.print("Enter the pile number >> ");
               newPileNumber = input.nextInt();
               myGame.moveDealtCardToTableau(newPileNumber);
               input.nextLine();
               break;
               
            }// End case 
            
            case '5':
            {
               myGame.moveDealtCardToFoundation();           
               break;
               
            }// End case
            
            case '6':
            {
               System.out.print("Enter the pile number of the card you wish to move >> ");
               currentPile = input.nextInt();
               myGame.moveTableauCardToFoundation(currentPile);
               input.nextLine();           
               break;
               
            }// End case
            
            case '7':
            {
               System.out.print("Enter the pile number of the card you wish to move >> ");
               currentPile = input.nextInt();
               System.out.println();
               System.out.print("Enter the new pile number for the card >> ");
               newPileNumber = input.nextInt();
               myGame.moveTableauCard(currentPile, newPileNumber);
               input.nextLine();           
               break;
               
            }// End case
            
            case '8':
            {
               System.out.print("Enter the pile number of the cards you wish to move >> ");
               currentPile = input.nextInt();
               System.out.println();
               System.out.print("Enter the number of cards you want to move >> ");
               numberOfCards = input.nextInt();
               System.out.println();
               System.out.print("Enter the new pile number for the cards >> ");
               newPileNumber = input.nextInt();
               myGame.moveTableauPile(currentPile, numberOfCards, newPileNumber); 
               input.nextLine();          
               break;
               
            }// End case            
            
            default:            
               System.out.println("Invalid choice");        
         
         }// End switch 
         
         winner = myGame.checkWinner();        
         
         if (winner)
            break;
         else
         {         
            myGame.checkTableauPiles();         
            myGame.displayBoard();
            menu();
            userInput = input.nextLine().charAt(0);           
         }// End else        
      
      }// End while  
      
      if (winner)
         winner();        
   
   }// End handleGame method
   
//---------------------------------------------------

   private static void menu()
   {
      System.out.println();
      
      System.out.println("Press 1 to start a new game");
      System.out.println("Press 2 to draw a new card");
      System.out.println("Press 3 to discard the draw card");
      System.out.println("Press 4 to move draw card to a pile");
      System.out.println("Press 5 to move draw card to a foundation pile");
      System.out.println("Press 6 to move a table card to a foundation pile");
      System.out.println("Press 7 to move a table card to another pile");
      System.out.println("Press 8 to move more then one card to another pile");
      System.out.print("Press 0 to exit game >> ");
   
   }// End startMenu
   
//------------------------------------------------

   private static void winner()
   {      
      System.out.println("***********************************");
      System.out.println("***********************************");
      System.out.println("*WINNER WINNER CHICKEN DINNER!!!!!*");
      System.out.println("***********************************");
      System.out.println("***********************************"); 
   
   }// End winner method

}// End class
