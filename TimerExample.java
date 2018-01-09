        import java.awt.EventQueue;
        import java.awt.event.ActionEvent;
        import java.awt.event.ActionListener;
import java.awt.*;
        import javax.swing.JFrame;
        import javax.swing.*;
        import javax.swing.Timer;
         
        public class TimerExample extends JFrame implements ActionListener {
  
       
  JPanel jp;
 JLabel label,l;
JButton b,b1;//b2
JOptionPane jop;
  
      Timer countdownTimer;
  
      // Initial game time
  
      int sec = 59,min=2;//timeRemaining 
  
       
  
      public TimerExample() {
jp=new JPanel();  
      setDefaultCloseOperation(EXIT_ON_CLOSE);
  
      setSize(400, 400);
      label = new JLabel(String.valueOf(min)+"  :  "+String.valueOf(sec), JLabel.CENTER);
  label.setBounds(0,100,75,25);
l=new JLabel("");
  l.setBounds(300,100,75,25);
  b=new JButton("stop");

b1=new JButton("play");
  b.setBounds(100,100,75,25);
b1.setBounds(150,100,75,25);
//b2=new JButton("click to pause");
jp.add(label);
jp.add(l);
jp.add(b);
jp.add(b1);

     getContentPane().add(jp);
 //     getContentPane().add(b);
    //getContentPane().add(b1);
  //  getContentPane().add(b2);
       
 
      setVisible(true);

      countdownTimer = new Timer(1000, new CountdownTimerListener());
  countdownTimer.start();
 
      
  
      }
  
       
  
      class CountdownTimerListener implements ActionListener {
  
      public void actionPerformed(ActionEvent e) {
jop = new JOptionPane();
  if(e.getSource() == b)
{
int ssec=sec,mmin=min;
sec=0;
min=0;
      l.setText(String.valueOf(mmin)+"  :  "+String.valueOf(ssec));
      countdownTimer.stop();
jop.showMessageDialog(null," stopped ");
}

  if(e.getSource() == b1)
    countdownTimer.start();
/*if(e.getSource() == b2)
    countdownTimer.pause();*/
  
      if (--sec > 0) {
  
      label.setText(String.valueOf(min)+"  :  "+String.valueOf(sec));
  
      }
else if(--min>-1)
{
sec=59;
label.setText(String.valueOf(min)+"  :  "+String.valueOf(sec));
    countdownTimer.stop();  
}
 else {
  
      label.setText("Time's up!");
  
      countdownTimer.stop();
  
      }

  
      }
  
      }
  
        public void actionPerformed(ActionEvent e) {
jop = new JOptionPane();
  if(e.getSource() == b)
{
int ssec=sec,mmin=min;
sec=0;
min=0;
      l.setText(String.valueOf(mmin)+"  :  "+String.valueOf(ssec));
      countdownTimer.stop();
jop.showMessageDialog(null," stopped ");
}
}
  
      public static void main(String[] args) {
  
      EventQueue.invokeLater(new Runnable() {
  
      public void run() {

      new TimerExample();
 
      }
  
      });
  
      }
  
      }