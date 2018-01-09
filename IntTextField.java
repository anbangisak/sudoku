import java.lang.*;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.PlainDocument;
class IntTextField extends JTextField 
{
  public IntTextField(int defval, int size) {
    super("" + defval, size);
  }
  public IntTextField(int size) {
    super(size);
  }
  protected Document createDefaultModel() {
    return new IntTextDocument();
  }
  public boolean isValid() {
    try {
/*	if( Integer.parseInt(getText()) == 0)
      return false;	*/
      Integer.parseInt(getText());
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public int getValue() {
    try {
/*	if( Integer.parseInt(getText()) == 0)
	      return 0;	*/
 return Integer.parseInt(getText());    
}
  catch (NumberFormatException e) {
      return 0;
    }
  }
  class IntTextDocument extends PlainDocument {
    public void insertString(int offs, String str, AttributeSet a)
        throws BadLocationException {
      if (str == null )//&& str != "0"
        return;
  String oldString = getText(0, getLength());
      String newString = oldString.substring(0, offs) + str + oldString.substring(offs);
      try {
//if(Integer.parseInt(newString + "0") != 0)
   Integer.parseInt(newString + "0");

if ((getLength() + str.length()) <= 1 )//&& str != "0"
        super.insertString(offs, str, a);
      } catch (NumberFormatException e) {
      }
    }
  }

}