/*
By Shekhar Maharaj
BCAD1 G1
20108780
 */
package scrabble;

/**
 *
 * @author SHEKHAR
 */
import java.util.Arrays;
import java.util.Scanner;

public class Gameplay {
   private Scanner input = new Scanner(System.in);
   private String name [] = new String[2];
   private char AlphabetsControl []={'B','C','D','F','G','H','J','K','L','M','N','P','Q','R','S','T','V','W','X','Y','Z'};
   private char Alphabets []={'B','C','D','F','G','H','J','K','L','M','N','P','Q','R','S','T','V','W','X','Y','Z'};
   private int p1Points = 0;
   private int p2Points = 0;
   
    protected final String [] start(){
    System.out.println("Welcome to Word Wars"+"\nPress (1) to start game");
    System.out.println("Press any other key to exit the game");
    System.out.print("\nYour Selection : " );
    int start = input.nextInt();
    if(start != 1){
        System.exit(0);
    }
    
    System.out.print("\nEnter Player 1's name : ");
        name[0] = input.next();
        name[0] = name[0].toUpperCase();
            System.out.println("Welcome "+name[0]);
    System.out.print("\nEnter Player 2's name : ");
        name[1] = input.next();
        name[1] = name[1].toUpperCase();
        System.out.println("Welcome "+name[1]);
        
        System.out.println("\nRULES :"
                + "\n- Both players must agree on the word being used"
                + "\n- Letters that are used will be removed from the Alphabet list"
                + "\n- Only vowels will not be removed"
                + "\n- Have fun\n");
        return name;
        
    }
    
    public void play(){
    P1play();
    }
    
    private void P1play(){
        //Notes:
        // -The 2 control varibales are used to get the numeric output from the Character.compare operation used to compare two characters
    //Declarations  
    int used= 0;
    char [] wordIndex = {};
    char xy = '-';
    int lettersUsed = 0;
    int p2turn = 0;
    int control = 0;
    int control2 =0;
    String userInput = "";
    
    System.out.println("\nAlphabets left : ");
    //code
    //prints Alphabets
    for(int i = 0;i<21;i++){
    System.out.print(Alphabets[i]+" ");}
    System.out.println("\nVowels are not included in the above list"
            + "\nA E I O U");
    //user enters word
    System.out.print("\n"+name[0]+" enter your word : ");
    userInput = input.next();
    userInput = userInput.toUpperCase();
    
    //sentinal value 
    if(userInput.equals("???")){Results();
    }
    
    //sets the users' input to the wordIndex array so that it can be alphabetically sorted and checked appropriately
    wordIndex = userInput.toCharArray();
     Arrays.sort(wordIndex);    
     
    //checks if users word matches alphabets
     for( int a = 0;a<21;a++){  
       
         for(int y = 0;y<userInput.length();y++){
    control = Character.compare(Alphabets[a],wordIndex[y]);
    if(control==0){
    Alphabets[a]=xy;
    }}
     
  //checks if all letters are used
    for(int c = 0;c<21;c++){  
        control2 = Character.compare(Alphabets[c],xy);
        if(control2 == 0){
        lettersUsed ++;
        }
    }
    if(lettersUsed >= 21){
    Results();
    return;
    }

    //confirms both players agree on the word
   System.out.println("\nEnter (1) if both players agree on the word ");
   p2turn = input.nextInt();
    if(p2turn==1){
        p1Points++;
        P2play();
    }
    else{
    p1Points--;
    P1play();
    }
    }
    }
      private void P2play(){
        //Notes:
        // -The 2 control varibales are used to get the numeric output from the Character.compare operation used to compare two characters
    //Declarations  
    char [] wordIndex = {};
    char xy = '-';
    int lettersUsed = 0;
    int p2turn = 0;
    int control = 0;
    int control2 =0;
    String userInput = "";
    
    System.out.println("\nAlphabets left : ");
    //code
    //prints Alphabets
    for(int i = 0;i<21;i++){
    System.out.print(Alphabets[i]+" ");}
    System.out.println("\nVowels are not included in the above list"
            + "\nA E I O U");
    //user enters word
    System.out.print("\n"+name[1]+" enter your word : ");
    userInput = input.next();
    userInput = userInput.toUpperCase();
    
    //sentinal value 
    if(userInput.equals("???")){Results();
    }
    
    //sets the users' input to the wordIndex array so that it can be alphabetically sorted and checked appropriately
    wordIndex = userInput.toCharArray();
     Arrays.sort(wordIndex);    
     
    //checks if users word matches alphabets
     for( int a = 0;a<21;a++){  
       
         for(int y = 0;y<userInput.length();y++){
    control = Character.compare(Alphabets[a],wordIndex[y]);
    if(control==0){
    Alphabets[a]=xy;
    }
    }}
     
  //checks if all letters are used
    for(int c = 0;c<21;c++){  
        control2 = Character.compare(Alphabets[c],xy);
        if(control2 == 0){
        lettersUsed ++;
        }
    }
    if(lettersUsed >= 21){
    Results();
    return;
    }

    //confirms both players agree on the word
   System.out.println("\nEnter (1) if both players agree on the word ");
   p2turn = input.nextInt();
    if(p2turn==1){
        p2Points++;
        P1play();
    }
    else{
    p2Points--;
    P2play();
    }
    }
    
    private void Results(){
    String userInput;
    System.out.println("\n"+name[0]+"'s points : " + p1Points);
    System.out.println(name[1]+"'s points : " + p2Points+"\n");
    if(p1Points > p2Points){
    System.out.println(name[0]+" is the WINNER!!!");}
    else if (p2Points > p1Points)
    {System.out.println(name[1]+" is the WINNER!!!");}
    else{System.out.println("!!!Congratulation!!!\nIt's a Tie :)");}
    //asks the player if they want to play again
    System.out.println("Press (1) to play again...");
    userInput = input.next();
    if(userInput.equals("1")){
        p1Points=0;
        p2Points=0;
        for(int a = 0;a<21;a++){
            Alphabets[a]=AlphabetsControl[a];
        }
        
    start();
    }
    else{System.exit(0);}
    }
    }