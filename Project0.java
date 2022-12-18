import javax.swing.JOptionPane;

public class Project0 {
  public static void main(String[] args) {
    String inputWord;
    
    while(true) {
      // This line asks the user for input by popping out a single window with text input
      inputWord = JOptionPane.showInputDialog(null, "Please enter a sentence, or STOP to exit:");
      
      // If the user types any variation of "STOP", terminate the program.
      if(inputWord.equalsIgnoreCase("STOP")) {
        System.exit(0);
      }
      
      int lowerEcount = countLowerEs(inputWord);
      int upperEcount = countUpperEs(inputWord);
      
      // Output to a JOptionPane window to count how many E's and e's there are
      JOptionPane.showMessageDialog(null, "Number of lower case e's: " + lowerEcount + "\nNumber of upper case E's: " + upperEcount);
    }
  }

  public static int countLowerEs(String theSentence) {
    int count = 0;
    
    // for loop will check the character at every position of the string and see if it matches 'e'
    for(int i = 0; i < theSentence.length(); i++) { 
      if(theSentence.charAt(i) == 'e') {
        count++; // If there is a match, increase the counter
      }
    }
    return count;
  }
  
public static int countUpperEs(String theSentence) {
    int count = 0;
    
 // for loop will check the character at every position of the string and see if it matches 'E'
    for(int i = 0; i < theSentence.length(); i++) {
      if(theSentence.charAt(i) == 'E') {
        count++; // If there is a match, increase the counter
      }
    }
    return count;
  }
}
