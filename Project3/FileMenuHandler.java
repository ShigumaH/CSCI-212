import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
 * Handles all the processes for opening a file and creating the List of WordLines.
 * 
 * Creates the JFrame and Container containing the two colums that will display the
 * contents of the file on the left, and words that start with a particular vowel on the right.
 */
public class FileMenuHandler implements ActionListener {
    JFrame jframe;
    Container myContentPane;
    TextArea originalText = new TextArea();
    TextArea vowelWords = new TextArea();
    ArrayList<WordLine> arrayOfWordLines;

    /**
     * Creates the JFrame
     * 
     * @param jf The JFrame
     */
    public FileMenuHandler(JFrame jf) {
        jframe = jf;
    }

    /**
     * Listens for a menu option being clicked, and doing the appropriate action.
     */
    public void actionPerformed(ActionEvent event) {
        String menuName = event.getActionCommand();
        
        if(menuName.equals("Open"))
            openFile();
        else if(menuName.equals("Quit"))
            System.exit(0);
        else if(menuName.matches("[AEIOU]")) { // Regex to check if the menu name is a vowel.
            openVowels(menuName);
        }
    }

    /**
     * Checks to see if the user opens a file or cancels the dialog.
     */
    private void openFile() {
        JFileChooser chooser = new JFileChooser();
        int status = chooser.showOpenDialog(null);
        
        if(status == JFileChooser.APPROVE_OPTION)
            readSource(chooser.getSelectedFile());
        else
            JOptionPane.showMessageDialog(null, "Open File dialog canceled");
    }

    /**
     * Reads the file, breaking it into lines,
     * then adding words that start with a vowel into an ArrayList.
     * The ArrayList is sorted after all words have been inserted.
     * 
     * @param chosenFile The File chosen by the user
     */
    private void readSource(File chosenFile) {
        Scanner inFile = null;
        try {
            inFile = new Scanner(chosenFile);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        int count = 0;
        resetDisplay(); // Re-initialize the contents of the TextAreas and ArrayList
        
        while(inFile.hasNextLine()) {
            String line = inFile.nextLine();
            originalText.append("Line " + ++count + ": " + line + "\n");
            String word[] = line.split(" "); // Splits the string based on delimiter, which is a whitespace in this case.
            
            boolean isEmptyLine = (word.length == 1) && (word[0].length() == 0); // A check to see if the line is blank
            for(int i = 0; !isEmptyLine && i < word.length; i++) { // If it is, it will ignore that line.
                String firstCh = "" + word[i].charAt(0);
                if(firstCh.matches("[AEIOUaeiou]")) {
                    try {
                        arrayOfWordLines.add(new WordLine(word[i], count));
                    }
                    catch (InvalidWordLineException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        inFile.close(); // We are done with the file, so close it.
        Collections.sort(arrayOfWordLines); // The built in sort method for ArrayLists.
        jframe.setVisible(true);
    }
    
    /**
     * Displays words starting with the specified vowel on the right column of the GUI.
     * 
     * @param letter The vowel that the words should start with
     */
    private void openVowels(String letter) {
        if(arrayOfWordLines == null)
            return;
        
        vowelWords.setText("Words that start with vowel: " + letter + "\n\n");
        for(WordLine wl : arrayOfWordLines) { // Range based for loop that will iterate through the ArrayList.
            String firstCh = "" + wl.word.charAt(0);
            if(firstCh.equalsIgnoreCase(letter))
                vowelWords.append("Line " + wl.lineNumber + ": " + wl.word + "\n");
        }
        jframe.setVisible(true);
    }
    
    /**
     * Refresh the GUI, clearing the columns and destroying the previous ArrayList.
     */
    private void resetDisplay() {
        myContentPane = jframe.getContentPane();
        originalText.setText("Original text:\n\n");
        vowelWords.setText("Words that start with vowel:");
        myContentPane.add(originalText);
        myContentPane.add(vowelWords);
        arrayOfWordLines = new ArrayList<WordLine>();
    }
}
