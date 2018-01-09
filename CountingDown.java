import javax.swing.*;
	import java.awt.FlowLayout;
	 
	public class CountingDown
	{
	    public static void main(String[] args) throws java.lang.Exception
	    {
	        String str = "2009-10-28-19-00-00";//date-time with the pattern "yyyy-MM-dd-HH-mm-ss"
	  
	        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	        java.util.Date date = formatter.parse(str);
	        java.util.Timer timer = new java.util.Timer();
	        long target = date.getTime();//target date-time in Milliseconds
	        Task0 task = new Task0(target);
	        timer.schedule(task, 0L, 1000L);
	    }
	}
	 
	class Task0 extends java.util.TimerTask
	{
	    private long targ;
	     
	    Task0(long target)
	    {
	         this.targ = target;
	    }
	     
	    public void run()
	    {  
	        int n = (int)((this.targ - System.currentTimeMillis())/(1000L));
	        int daysLeft = n/(60*60*24);
	        int hoursLeft = (n/3600)-(daysLeft*24);
	        int minutesLeft = (n/60)-((hoursLeft*60)+(daysLeft*24*60));
	        int secondsLeft = (n)-((minutesLeft*60)+(hoursLeft*60*60)+(daysLeft*24*60*60));
	        JFrame test = new JFrame();
	        JLabel countdown = new JLabel (daysLeft + " days, " + hoursLeft + " hours, " + minutesLeft + " minutes, " + secondsLeft + " seconds left.");
	         
	        if(n<=0)
	        {
	            countdown = new JLabel ("I love you!");
	        }
	        test.setVisible(true);
	        test.setBounds (250,250,400,75);
	        test.setLayout (new FlowLayout());
	        test.add(countdown);
	    }
	} 