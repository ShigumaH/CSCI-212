import java.awt.GridLayout;
import javax.swing.*;
@SuppressWarnings("serial")

public class RomanNumeralGUI extends JFrame {
  public RomanNumeralGUI() {
    setTitle("Sorted Roman Numerals & Converted Values");
    setSize(500, 350);
    setLocation(250, 250);
    setLayout(new GridLayout(1, 2));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    createMenu();
    setVisible(true);
  }

  private void createMenu() {
    JMenuItem item;
    var menuBar = new JMenuBar();
    var fileMenu = new JMenu("File");
    var convertMenu = new JMenu("Convert");
    var menuHandler = new FileMenuHandler(this);

    String menuOptions[] = { "Open", "Quit", "Roman to Arabic" };
    for(int i = 0; i < 3; i++) {
      item = new JMenuItem(menuOptions[i]);
      item.addActionListener(menuHandler);

      if(i < 2)
        fileMenu.add(item);
      else
        convertMenu.add(item);

      if(i == 0)
        fileMenu.addSeparator();
    }
    setJMenuBar(menuBar);
    menuBar.add(fileMenu);
    menuBar.add(convertMenu);
  }
}