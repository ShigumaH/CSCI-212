import javax.swing.*;
import java.awt.GridLayout;
@SuppressWarnings("serial")

/**
 * Creates a GUI with two columns, and a menu bar
 * 
 */
public class WordGUI extends JFrame{
    /**
     * Creates the GUI with the specified default values.
     */
    public WordGUI() {
        setTitle("Vowel List"); 
        setLocation(150, 150);
        setSize(1200, 500);
        setLayout(new GridLayout(1, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        createMenu();
        setVisible(true);
    }
    
    /**
     * Creates the menu bar with File and List menus.
     * The File menu contains Open and Quit buttons,
     * while the List menu contains buttons for each vowel.
     */
    private void createMenu() {
        JMenuItem item;
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu listMenu = new JMenu("List");
        FileMenuHandler fmh = new FileMenuHandler(this);
        
        String menuOptions[] = {"Open", "Quit", "A", "E", "I", "O", "U"}; // An array containing all the menu options.
        for(int i = 0; i < 7; i++) {
            item = new JMenuItem(menuOptions[i]);
            item.addActionListener(fmh);
            
            // The first two should be added to fileMenu, otherwise add the vowels to listMenu.
            if(i < 2)
                fileMenu.add(item);
            else
                listMenu.add(item);
            
            // Add horizontal separator lines in the appropriate locations.
            if(i < 1)
                fileMenu.addSeparator();
            else if(i > 1 && i < 6)
                listMenu.addSeparator();
        }
        setJMenuBar(menuBar);
        menuBar.add(fileMenu);
        menuBar.add(listMenu);
     }
}
