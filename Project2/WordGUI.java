import java.awt.*;
import javax.swing.JFrame;
@SuppressWarnings("serial")

public class WordGUI extends JFrame{
    public WordGUI() { // Any JFrame created using the WordGUI class will have these default parameters
        setTitle("Linked Lists"); 
        setLocation(100, 100);
        setSize(1400, 800);
        setLayout(new GridLayout(1, 3));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void printToGUI(String originalText, UnsortedWordList uwl, SortedWordList swl) {
        Container myContentPane = getContentPane(); // Create a container that will store the content inside the frame
        
        // Create 3 new TextAreas for the original text and both lists, then add them to the GUI
        TextArea inputText = new TextArea();
        TextArea unsorted = new TextArea();
        TextArea sorted = new TextArea();
        myContentPane.add(inputText);
        myContentPane.add(unsorted);
        myContentPane.add(sorted);
        
        // Give an explanation of what each column is
        inputText.append("Original text:\n\n" + originalText);
        unsorted.append("Unsorted List:\n\n");
        sorted.append("Sorted List:\n\n");
        
        int len = uwl.getLength(); // Tells us how many elemenents are in the list, which should be the same for both lists anyway.
        for(int i = 0; i < len; i++) {
            unsorted.append(uwl.next() + "\n");
            sorted.append(swl.next() + "\n");
        }
        
        setVisible(true); // Show the user the GUI
    }
}
