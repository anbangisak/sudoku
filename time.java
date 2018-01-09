import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class time extends JFrame implements ActionListener {
JPanel jp;
 JLabel label,l;
JButton b,b1;//b2
JOptionPane jop;
Thread th;  
      Timer countdownTimer;
      int sec = 59,min=2;
    public time() {
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

      countdownTimer = new Timer(1000,null);
  countdownTimer.start();
 
      
  
      }
 public void updateDateTime()
    {
 th = new Thread(new Runnable()
        {
        public void run()
            {
            while(true)
                {
      countdownTimer = new Timer(1000);
  countdownTimer.start();

      if (--sec > 0) {
  
      label.setText(String.valueOf(min)+"  :  "+String.valueOf(sec));
  
      }
else if(--min>-1)
{
sec=59;
label.setText(String.valueOf(min)+"  :  "+String.valueOf(sec));
}
 else {
  
      label.setText("Time's up!");
  
      countdownTimer.stop();
  
      }

                }

            }
        });
    th.start();
    }
      public static void main(String[] args) {
time t = new time();
t.updateDateTime();
}
      public void actionPerformed(ActionEvent e) {
jop = new JOptionPane();
  if(e.getSource() == b)
{
th.stop();
}
}
}