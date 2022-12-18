public class Project2 {
    // Create empty variables to store the information from file
    static String originalInput = "";
    static UnsortedWordList unsortedList = new UnsortedWordList();
    static SortedWordList sortedList = new SortedWordList();
    
    public static void main(String[] args) {
        WordGUI frame = new WordGUI();
        readFile("input.txt");
        frame.printToGUI(originalInput, unsortedList, sortedList); // Send all information to the GUI
    }
    
    public static void readFile(String filename) {
        TextFileInput file = new TextFileInput(filename);
        String currentLine = file.readLine();
        while(currentLine != null) { // While there are more lines to be read,
            originalInput += currentLine + "\n"; // Save the current line (with a line break)
            addToLists(currentLine);
            currentLine = file.readLine();
        }
        file.close(); // We are done reading the file, so we can close it now
    }
    
    public static void addToLists(String line) {
        String word[] = line.split(" "); // Splits the string based on delimiter, which is a whitespace in this case
        for(int i = 0; i < word.length; i++) { // word.length will tell us how many words there are in line
            if(word[i].equals(""))
                continue; // If the string is empty, skip adding it to the lists.
            unsortedList.append(word[i]);
            sortedList.add(word[i]);
        }
    }
}
