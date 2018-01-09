
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;


class TextClock extends JFrame {


private JTextField _time;
public TextClock() {

_time = new JTextField(5);
_time.setEditable(false);
_time.setFont(new Font("sansserif", Font.PLAIN, 48));

JPanel content = new JPanel();
content.setLayout(new FlowLayout());
content.add(_time);

this.setContentPane(content);
this.setTitle("Timer");
this.pack();
this.setLocationRelativeTo(null);
this.setResizable(false);


javax.swing.Timer t = new javax.swing.Timer(1000, null);
t.start();
}


class ClockListener implements ActionListener {
public void actionPerformed(ActionEvent e) {

/*Calendar now = Calendar.getInstance();
int h = now.get(Calendar.HOUR_OF_DAY);
int m = now.get(Calendar.MINUTE);
int s = now.get(Calendar.SECOND);*/
if(_time.getText().equals("0:00"))
t.stop();
else
{
if(
_time.setText("" + h + ":" + m + ":" + s);

}
}


public static void main(String[] args) {
JFrame clock = new TextClock();
clock.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
clock.setVisible(true);
}
}