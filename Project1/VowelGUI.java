import java.awt.*;
import javax.swing.*;
@SuppressWarnings("serial")

public class VowelGUI extends JFrame {
    public VowelGUI(int height, int width) { // Any JFrame created using the VowelGUI class will have these default parameters
        setTitle("Vowel Counter");
        setSize(height, width); 
        setLocation(200, 200);
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void printToGUI(String[] list, int listSize, int vowelCount[]) {
        Container myContentPane = getContentPane(); // Create a container that will store the content inside the frame
        
        // Create two TextAreas for the Container, the sentences will be on the left and vowel count on the right as per GridLayout
        TextArea sentences = new TextArea();
        TextArea vowels = new TextArea();
        myContentPane.add(sentences);
        myContentPane.add(vowels);
        
        for (int i=0; i<listSize; i++) {
            sentences.append(list[i] + "\n"); // Add the lines from the file to the left TextArea
        }
        
        String letter[] = {"A", "E", "I", "O", "U"};
        for(int i = 0; i < 5; i++) {
            vowels.append("Number of " + letter[i] + "'s: " + Integer.toString(vowelCount[i]) + "\n");
            // Add the vowel count, separated by lines per vowel
        }
        setVisible(true); // Show the user the GUI
    }
}
