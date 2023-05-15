import java.util.HashMap;

public class RomanNumeral implements Comparable<RomanNumeral> {
  private String romanValue;
  private int arabicValue;
  private static final HashMap<Character, Integer> CONVERTER = new HashMap<>();
  static {
    CONVERTER.put('I', 1);
    CONVERTER.put('V', 5);
    CONVERTER.put('X', 10);
    CONVERTER.put('L', 50);
    CONVERTER.put('C', 100);
    CONVERTER.put('D', 500);
    CONVERTER.put('M', 1000);
  }
  
  public RomanNumeral(String value) {
    if(value == null || value.length() == 0)
      throw new IllegalRomanNumeralException("No input given");
    
    value = value.toUpperCase();
    romanValue = value;
    arabicValue = convert(value);
  }
  
  public void setRomanNumeral(String value) {
    if(value == null || value.length() == 0)
      throw new IllegalRomanNumeralException("No input given");
    
    value = value.toUpperCase();
    romanValue = value;
    arabicValue = convert(value);
  }
  
  public String getRomanNumeral() {
    return romanValue;
  }
  
  public int getArabicNumber() {
    return arabicValue;
  }
  
  private int convert(String value) {
    int lastPos = value.length()-1;
    Integer converted = CONVERTER.get(value.charAt(lastPos));
    if(converted == null)
      throw new IllegalRomanNumeralException("Invalid input");
    
    for(int i = 0; i < lastPos; i++) {
      Integer currentValue = CONVERTER.get(value.charAt(i)), nextValue = CONVERTER.get(value.charAt(i+1));
      if(currentValue == null || nextValue == null)
        throw new IllegalRomanNumeralException("Invalid input");
      
      converted = currentValue < nextValue ? converted-currentValue : converted+currentValue;
    }
    return converted;
  }
  
  public boolean equals(RomanNumeral other) {
    return arabicValue == other.arabicValue;
  }
  
  @Override
  public String toString() {
    return "Roman Numeral: " + romanValue + "\tArabic Number: " + arabicValue + "\n";
  }
  
  @Override
  public int compareTo(RomanNumeral other) {
    return Integer.valueOf(arabicValue).compareTo(other.getArabicNumber());
  }
}
