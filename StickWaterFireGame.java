import java.util.Random;

/* This class ecapsulates the state and logic required to play the 
   Stick, Water, Fire game. The game is played between a user and the computer. 
   A user enters their choice, either S for stick, F for fire, W for water, and 
   the computer generates one of these choices at random- all equally likely.
   The two choices are evaluated according to the rules of the game and the winner
   is declared.
   
   Rules of the game:
   S beats W
   W beats F
   F beats S
   no winner on a tie.
   
   Each round is executed by the playRound method. In addition to generating the computer 
   choice and evaluating the two choices, this class also keeps track of the user and computer
   scores, the number of wins, and the total number of rounds that have been played. In the case
   of a tie, neither score is updated, but the number of rounds is incremented.
   
*/
public class StickWaterFireGame {
   private Random rand; 
   private int playerScore; // Integer variable storing the player's cumulative score through the game
   private int computerScore; // Integer variable storing computer's cumulative score through the game
   private String computerChoice; // String Variable keeping the computer's choice 
   private int numRounds; // Integer variable storing the number of rounds played throughout the game
   private boolean playerWins; // Boolean variable stating whether the round has been won by the user or not
   private boolean isTie; //Boolean variable stating whether the round has been tied or not
   
  /*  This constructor assigns the member Random variable, rand, to 
   *  a new, unseeded Random object.
   *  It also initializes the instance variables to their default values:
   *  rounds, player and computer scores will be 0, the playerWins and isTie
   *  variables should be set to false.
   */ 
   
   public StickWaterFireGame() {
      rand = new Random ();
      playerScore = 0;
      computerScore = 0;
      computerChoice = "";
      numRounds = 0;
      playerWins = false;
      isTie = false;
   }     
  /*  This constructor assigns the member Random variable, rand, to 
   *  a new Random object using the seed passed in.
   *  It also initializes the instance variables to their default values:
   *  rounds, player and computer scores will be 0, the playerWins and isTie
   *  variables should be set to false.
   */    
   public StickWaterFireGame(int seed) {
      rand = new Random();
      rand.setSeed(seed);
      playerScore = 0;
      computerScore = 0;
      computerChoice = "";
      numRounds = 0;
      playerWins = false;
      isTie = false;
   }   
  /*  This method returns true if the inputStr passed in is
   *  either "S", "W", or "F", false otherwise.
   *  Note that the input can be upper or lower case.
   */ 
   public boolean isValidInput(String inputStr) {
      return ((inputStr.equalsIgnoreCase("S") || inputStr.equalsIgnoreCase("W") || inputStr.equalsIgnoreCase("F"))) ; 
   }
  /*  This method carries out a single round of play of the SWF game. 
   *  It calls the isValidInput method and the getRandomChoice method. 
   *  It implements the rules of the game and updates the instance variables
   *  according to those rules.
   */
   public void playRound(String playerChoice) {
      computerChoice = getRandomChoice();
      if (isValidInput(playerChoice)) {
         if (playerChoice.equalsIgnoreCase("S")) {
            if (computerChoice.equalsIgnoreCase("W"))
               playerScore++;
            else if (computerChoice.equalsIgnoreCase("F"))
               computerScore++;
         }
         else if (playerChoice.equalsIgnoreCase("W")) {
            if (computerChoice.equalsIgnoreCase("F"))
               playerScore++;
            else if (computerChoice.equalsIgnoreCase("S"))
               computerScore++;
         }
         else if (playerChoice.equalsIgnoreCase("F")) {
            if (computerChoice.equalsIgnoreCase("S"))
               playerScore++;
            else if (computerChoice.equalsIgnoreCase("W"))
               computerScore++;
         }
      }
      else 
         ++computerScore; 
      ++numRounds;    
   }
   // Returns the choice of the computer for the most recent round of play
   public String getComputerChoice(){
      return computerChoice;
   }
   // Returns true if the player has won the last round, false otherwise.    
   public boolean playerWins(){
      return (playerScore > computerScore);
   }
   // Returns the player's cumulative score.    
   public int getPlayerScore(){
      return playerScore;
   }
   
   // Returns the computer's cumulative score.   
   public int getComputerScore(){
      return computerScore;
   }
   // Returns the total nuber of rounds played.   
   public int getNumRounds(){
      return numRounds;
   }
   // Returns true if the player and computer have the same score on the last round, false otherwise.    
   public boolean isTie(){
      return (playerScore == computerScore);
   }
  /*  This "helper" method uses the instance variable of Random to generate an integer
   *  which it then maps to a String: "S", "W", "F", which is returned.
   *  This method is called by the playRound method.
   */
   private String getRandomChoice() {
      String tempStr = "";
      int tempVal = rand.nextInt(3);
      if (tempVal == 0) 
         tempStr = "S";
      else if (tempVal == 1)
         tempStr = "W";
      else 
         tempStr = "F"; 
      return tempStr;
   }
}