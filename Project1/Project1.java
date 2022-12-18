/**Mohammad Bhuiyan
 * Lab Section: 22D
 * This program counts the vowels in a file.
 */

public class Project1 {
    static String inputLines[] = new String[50]; // Create a String array to store the lines from the file
    static int inputSize = 0; // Counter for how many lines the file has
    static int vowelCount[] = new int[5];
     
    public static void main(String[] args) {
        VowelGUI vowelFrame = new VowelGUI(950,375); // Create a new JFrame with size of 550x250 pixels
        readFile("input.txt");
        vowelFrame.printToGUI(inputLines, inputSize, vowelCount);
    }
    
    public static void readFile(String filename) {
        TextFileInput inFile = new TextFileInput(filename); // Open the file
        String currentLine = inFile.readLine();
        while(currentLine != null) { // As long as there are more lines to read,
            inputLines[inputSize++] = currentLine; // Store the current line in the array, and increment the size counter
            countVowels(currentLine);
            currentLine = inFile.readLine(); // Advance the line
        }
    }
    
    public static void countVowels(String line) {
        int len = line.length();
        char letter;
        for(int i = 0; i < len; i++) { // Traverse the String and count how many vowels it has
            letter = line.charAt(i);
            if(letter == 'A' || letter == 'a')
                vowelCount[0]++; 
            if(letter == 'E' || letter == 'e')
                vowelCount[1]++;
            if(letter == 'I' || letter == 'i')
                vowelCount[2]++;
            if(letter == 'O' || letter == 'o')
                vowelCount[3]++;
            if(letter == 'U' || letter == 'u')
                vowelCount[4]++;
        }
    }
    
}
