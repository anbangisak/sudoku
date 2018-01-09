import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class AddingActionCommandActionListenerSample {
  public static void main(String args[]) {
    JFrame frame = new JFrame("Default Example");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JTextField textField = new JTextField();
    frame.add(textField, BorderLayout.NORTH);

    KeyListener keyListener = new KeyListener() {
      public void keyPressed(KeyEvent keyEvent) {
        printIt("Pressed", keyEvent);
      }
      public void keyReleased(KeyEvent keyEvent) {
        printIt("Released", keyEvent);
      }
      public void keyTyped(KeyEvent keyEvent) {
        printIt("Typed", keyEvent);
      }
      private void printIt(String title, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        String keyText = KeyEvent.getKeyText(keyCode);
        System.out.println(title + " : " + keyText+" key code"+keyCode);
      }
    };
    textField.addKeyListener(keyListener);
    textField.addKeyListener(keyListener);
    
    frame.setSize(250, 150);
    frame.setVisible(true);
  }
}