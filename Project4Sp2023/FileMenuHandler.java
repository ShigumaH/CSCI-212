import java.awt.Container;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.TreeSet;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class FileMenuHandler implements ActionListener {
  JFrame jframe;
  TextArea roman = new TextArea();
  TextArea arabic = new TextArea();

  public FileMenuHandler(JFrame jf) {
    jframe = jf;
  }

  public void actionPerformed(ActionEvent event) {
    String menuName = event.getActionCommand();

    if(menuName.equals("Open"))
      openFile();
    else if(menuName.equals("Quit"))
      System.exit(0);
    else if(menuName.equals("Roman to Arabic"))
      convertRoman();
  }
  
  private void convertRoman() {
    String userInput = JOptionPane.showInputDialog(null, "Enter a Roman Numeral to convert:");
    
    try {
      RomanNumeral convertedRoman = new RomanNumeral(userInput);
      JOptionPane.showMessageDialog(null, userInput + " equals: " + convertedRoman.getArabicNumber());
    }
    catch(IllegalRomanNumeralException e) {
      System.out.println(e.getMessage() + ": " + userInput);
      JOptionPane.showMessageDialog(null, "Illegal input!");
    }
  }
  
  private void openFile() {
    var fileChooser = new JFileChooser();
    int status = fileChooser.showOpenDialog(null);

    if(status == JFileChooser.APPROVE_OPTION)
      readSource(fileChooser.getSelectedFile());
    else
      JOptionPane.showMessageDialog(null, "Open File dialog canceled");
  }

  private void readSource(File chosenFile) {
    Scanner inputFile = null;
    
    try {
      inputFile = new Scanner(chosenFile);
    }
    catch(FileNotFoundException e) {
      e.printStackTrace();
    }
    
    Container myContentPane = jframe.getContentPane();
    myContentPane.add(roman);
    myContentPane.add(arabic);
    
    var sortedNums = new TreeSet<RomanNumeral>();
    
    while(inputFile.hasNextLine()) {
      for(String splitRoman : inputFile.nextLine().split(",")) {
        try {
          var romanNumeral = new RomanNumeral(splitRoman);
          sortedNums.add(romanNumeral);
        }
        catch(IllegalRomanNumeralException e) {
          System.out.println(e.getMessage() + ": " + splitRoman);
        }
      }
    }
    inputFile.close();
    
    roman.setText("Roman Numerals:\n\n");
    arabic.setText("Arabic Numbers:\n\n");
    
    sortedNums.forEach(key -> {
      roman.append(key.getRomanNumeral() + "\n");
      arabic.append(Integer.toString(key.getArabicNumber()) + "\n");
    });
    jframe.revalidate();
    jframe.repaint();
  }
}