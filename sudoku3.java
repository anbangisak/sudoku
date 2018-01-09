/* create database in ms access with the name of highscore.
then table is displayed in right side.thn enter the values in the table.
then close the table (only table not the ms office).
it want the name of the table enter the name as student.
then start-->control panel-->administrative tools-->Data Source(odbc)
--> System DSN-->Add-->Microsoft Access Driver(*.mdb,*.accdb) -->
finish-->DataSource Name-->mydata-->click select-->(before browsing for db must close the ms
access window)browse for data-->close the application */


import java.sql.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.awt.Toolkit; 
import javax.swing.table.*;
class sudoku3 extends JFrame implements ActionListener,KeyListener
{
long  end,start,played,sec,min,points;
 String str,mode,pname;
 int r,c,n,p,k,a,i,j,e,g=0,forsec=0;
int darr=0,err=0,boxes=0,errinkey=1,fiveresult=0,stopclue=0;
 
 IntTextField ck[][]=new IntTextField[9][9];
 JButton d,d1,d2,d3,d4,d5,d6,d7,d8,d9;//d6,d7,d8,d9(jbase)
JButton ib1,ib2,clues;
 int m[][]=new int[9][9];
int s[][]=new int[9][9];
int b[][]=new int[9][9];
int sak[][]=new int[9][9];
Image imaBg;
    Thread th;
Container pc; 
JOptionPane jop;
JPanel jp,j1,jbase,ua,jinstructions,jhighscore;
JMenuBar menuBar;
 JMenuItem newAction;
        JMenuItem userAction;
        JMenuItem exitAction;
JMenuItem highscore;
JMenuItem instructions;
       JMenu fileMenu;
JMenu settings;
JLabel showtime,cdtimer,l1,l2,loadlabel,hp,emh,umbg1,emhbg1,hsbg;//cdtimer=countdowntimer
    DateFormat dateFormat2 = new SimpleDateFormat("h:mm:ss a"); 
Timer countdownTimer;
public sudoku3()
{
 menuBar = new JMenuBar();
       // Add the menubar to the frame
 setJMenuBar(menuBar);
       // Define and add two drop down menu to the menubar
        fileMenu = new JMenu("File");
fileMenu.setMnemonic('f');
settings = new JMenu("Settings");
settings.setMnemonic('s');
 menuBar.add(fileMenu);
menuBar.add(settings);
 newAction = new JMenuItem("New Game");
//newAction.setMnemonic('n');
newAction.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N,
java.awt.Event.CTRL_MASK));
userAction = new JMenuItem("User Mode");
userAction.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U,
java.awt.Event.CTRL_MASK));
exitAction = new JMenuItem("Exit");
exitAction.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X,
java.awt.Event.CTRL_MASK));
highscore = new JMenuItem("High Score");
highscore.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H,
java.awt.Event.CTRL_MASK));
instructions = new JMenuItem("Instructions");
instructions.setAccelerator(KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I,
java.awt.Event.CTRL_MASK));

//highscore.setMnemonic('h');
//instructions.setMnemonic('i');
 pc = getContentPane();
ua = new JPanel();
jbase = new JPanel();
jp = new JPanel();
j1 = new JPanel();
jinstructions = new JPanel();
jhighscore=new JPanel();
pc.add(jbase);
/* Adding Image Panel not to a panel

 ImagePanel panel = new ImagePanel(new ImageIcon("1.jpg").getImage());
pc.add(panel);
*/
JFrame.setDefaultLookAndFeelDecorated(true);
//jp.setLayout(null);	
//jp.setLayout(new FlowLayout());
jbase.setLayout(null);
//jbase.setBackground(Color.white);
for(int i=0;i<9;i++)
for(int j=0;j<9;j++)
{
ck[i][j]=new IntTextField(3);
ck[i][j].addKeyListener(this);
}

	//time
	showtime = new JLabel("");
 	
 	showtime.setBounds(0,400,100,30);
        	showtime.setFont(new Font("SansSerif",Font.PLAIN, 18));

/*JButton okButton = new JButton("OK", new ImageIcon("ok.png"));
okButton.setMnemonic('O');
JButton cancelButton = new JButton("CANCEL", new ImageIcon("cancel.png"));	
cancelButton.setMnemonic('C');		*/
hp=new JLabel("");
emh=new JLabel("");
umbg1=new JLabel("");
emhbg1=new JLabel("");
hsbg=new JLabel("");
hp.setIcon(new ImageIcon("hp.png"));
emh.setIcon(new ImageIcon("emh.png"));
umbg1.setIcon(new ImageIcon("umbg1.png"));
emhbg1.setIcon(new ImageIcon("emhbg1.png"));
hsbg.setIcon(new ImageIcon("hsbg.png"));
//umbg1.setIcon(new ImageIcon("bg.png"));
hp.setBounds(0,-15,728,587);
jbase.add(hp);
l1=new JLabel("");
l1.setIcon(new ImageIcon("3.png"));
l2=new JLabel("");
l2.setIcon(new ImageIcon("uminst.png"));
loadlabel=new JLabel("Loading Please Wait.......");
ib1=new JButton("");
ib2=new JButton("");
clues=new JButton("");
clues.setMnemonic('l');
ib1.setMnemonic('n');
ib2.setMnemonic('p');

d=new JButton("");
d1=new JButton("");
d2=new JButton("");
d.setMnemonic('e');
d1.setMnemonic('m');
d2.setMnemonic('c');
d.setFont(new Font("Ariel", Font.BOLD,14));
d1.setFont(new Font("Ariel", Font.BOLD,14));
d2.setFont(new Font("Ariel", Font.BOLD,14));

d6=new JButton("");
	//d.setBounds(180,200,150,40);
d6.setFont(new Font("Ariel", Font.BOLD,14));
	//d.setPreferredSize(new Dimension(85,40));
	//d6.setMnemonic('n');
	//(not working)d.setColor(Color.RED);
	//d.setIcon(new ImageIcon("Sidebar.PNG"));
	// d=new JButton("easy",new ImageIcon("Sidebar.PNG"));

d7=new JButton("");
d8=new JButton("");
d9=new JButton("");

d7.setFont(new Font("Ariel", Font.BOLD,14));
d8.setFont(new Font("Ariel", Font.BOLD,14));
d9.setFont(new Font("Ariel", Font.BOLD,14));

d3=new JButton("");
d4=new JButton("");
d5=new JButton("");


d6.setBounds(512,219,160,37);//ng
d9.setBounds(512,275,160,37);//um
d7.setBounds(512,341,160,37);//hs
d8.setBounds(512,405,160,37);//in

d6.setIcon(new ImageIcon("ng.png"));
d9.setIcon(new ImageIcon("um.png"));
d7.setIcon(new ImageIcon("hs.png"));
d8.setIcon(new ImageIcon("in.png"));

jbase.add(d6);
jbase.add(d7);
jbase.add(d8);
jbase.add(d9);

/*jp.add(d3);
jp.add(d4);
jp.add(d5);*/

fileMenu.add(newAction);
fileMenu.add(userAction);
fileMenu.addSeparator();
fileMenu.add(exitAction);
settings.add(highscore);
settings.add(instructions);
highscore.addActionListener(this);
exitAction.addActionListener(this);
newAction.addActionListener(this);
userAction.addActionListener(this);
instructions.addActionListener(this);
ib1.addActionListener(this);
ib2.addActionListener(this);
clues.addActionListener(this);
//        j1.add(showtime);
d.addActionListener(this);
d1.addActionListener(this);
d2.addActionListener(this);
d3.addActionListener(this);
d4.addActionListener(this);
d5.addActionListener(this);
d6.addActionListener(this);
d7.addActionListener(this);
d8.addActionListener(this);
d9.addActionListener(this);
}
 public void updateDateTime()
    {
 th = new Thread(new Runnable()
        {
        public void run()
            {
            while(true)
                {
	java.util.Date date2 = new java.util.Date();
                String dateTime = dateFormat2.format(date2);
                showtime.setText(dateTime);
                showtime.updateUI();
                }
            }
        });
    th.start();
    }
public void erredcleaning()
{
for(i=0;i<9;i++)
for(j=0;j<9;j++)
{
if(ck[i][j].getText().equals("0"))
ck[i][j].setText("");
if(darr==0)
ck[i][j].setForeground(Color.black);
else if(darr==1)
ck[i][j].setForeground(Color.blue);
}
}
public void timing()
{
if(boxes==81 && forsec==1 && g<=1)
{
int id=0;
end=System.currentTimeMillis();
played=end-start;
sec=played/1000;
min=sec/60;
sec=sec%60;
jop.showMessageDialog(null," Played time  " + min+ " : " +sec);
pname = jop.showInputDialog("Enter your name");
if(min>15)
points=5000;
else if(min>10)
points=10000;
else if(min>5)
points=20000;
else if(min>2)
points=50000;
else
points=100000;
jop.showMessageDialog(null,"you won "+points+" points");
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection c=DriverManager.getConnection("jdbc:odbc:highscore");
Statement s=c.createStatement();
ResultSet rs=s.executeQuery("select * from score;");
while(rs.next())
{
int idd=Integer.parseInt(rs.getString("id"));
if(idd>id)
id=idd;
//jop.showMessageDialog(null,"Successfully received id "+id);
}
id=id+1;
s.executeUpdate("insert into score values("+id+","+points+","+min+","+sec+",'"+mode+"','"+pname+"');");
s.close();
c.close();
}
catch(SQLException e)
{
System.out.println(e);
}
catch(ClassNotFoundException e)
{
System.out.println(e);
}

}
}
public void inresultcheck()
{
boxes=0;
if(errinkey==0)
for(i=0;i<9;i++)
for(j=0;j<9;j++)
{
if(ck[i][j].getText().equals("0"))
ck[i][j].setText("");
if(ck[i][j].getText().equals(""))
b[i][j]=0;
else
{
b[i][j]=Integer.parseInt(ck[i][j].getText());
boxes++;
}
}
else if(darr!=1)//0 = usermode 1=emc mode
{
for(i=0;i<9;i++)
for(j=0;j<9;j++)
{
if(ck[i][j].getText().equals("0"))
ck[i][j].setText("");
if(ck[i][j].getText().equals(""))
{
b[i][j]=0;
m[i][j]=0;
}
else
{
b[i][j]=Integer.parseInt(ck[i][j].getText());
m[i][j]=Integer.parseInt(ck[i][j].getText());
}
}
}
else
b=m;
anban gi=new anban(b);
g=0;
for(i=0;i<9&&g<=1;i++)
l:for(j=0;j<9&&g<=1;j++)
if(b[i][j]!=0)
{
a=b[i][j];
g=0;
for(k=0;k<9;k++)
{
if(a==b[i][k])
g++;
if(g==2)
{
if(errinkey==1)
err=1;
ck[i][j].setForeground(Color.red);
ck[i][k].setForeground(Color.red);
jop.showMessageDialog(null,"Sorry , the values are not possible");
continue l;
}
}
g=0;
for(k=0;k<9;k++)
{
if(a==b[k][j])
g++;
if(g==2)
{
if(errinkey==1)//1=result 0=usermode
err=1;//err=0 for result
ck[i][j].setForeground(Color.red);
ck[k][j].setForeground(Color.red);
jop.showMessageDialog(null,"Sorry , the values are not possible");
continue l;
}
}
if(i<3&&j<3)
g=loop(0,3,0,3,a,b);
else if(i<3&&j<6)
g=loop(0,3,3,6,a,b);
else if(i<3&&j<9)
g=loop(0,3,6,9,a,b);
else if(i<6&&j<3)
g=loop(3,6,0,3,a,b);
else if(i<6&&j<6)
g=loop(3,6,3,6,a,b);
else if(i<6&&j<9)
g=loop(3,6,6,9,a,b);
else if(i<9&&j<3)
g=loop(6,9,0,3,a,b);
else if(i<9&&j<6)
g=loop(6,9,3,6,a,b);
else 
g=loop(6,9,6,9,a,b);
if(g>=2)
{
if(errinkey==1)
err=1;
ck[i][j].setForeground(Color.red);
jop.showMessageDialog(null,"Sorry , the values are not possible");
continue l;
}}
}
 
public void textalign(int ou)//ou=ordinary /user mode
{
int c=143,r=136,u=ou;
for(i=0;i<9;i++)
{
c=143;
for(j=0;j<9;j++)
{
ck[i][j].enable();
ck[i][j].setText("");
ck[i][j].setBackground(Color.white);
ck[i][j].setHorizontalAlignment(JTextField.CENTER);//RIGHT ,LEFT
ck[i][j].setFont(new Font("Ariel",Font.BOLD, 12));
if(u==0)
ck[i][j].setForeground(Color.black);
else
ck[i][j].setForeground(Color.BLUE);
ck[i][j].setBounds(c,r,30,30);
c=c+37;
if((j+1)%3==0)
c=c+10; //System.out.println(" ");
}
if((i+1)%3==0)
r=r+10;//System.out.println();
r=r+37;//System.out.println();
}
//jop.showMessageDialog(null,"horizontal c " +c+ "vertical r" +r);
}
public int loop(int x,int y,int xx,int w,int t,int[][] ss)
{
s=ss;
r=y;c=w;a=t;
n=0;
for(p=x;p<r;p++)
for(k=xx;k<c;k++)
if(a==s[p][k])
{
n++;
if(n==2)
ck[p][k].setForeground(Color.red);
}
return(n);
}
public static void main(String[] args) 
{
sudoku3 obj= new sudoku3();
obj.setVisible(true);
obj.setIconImage(new ImageIcon("2.png").getImage());
/* when you like to add full screen comment the obj.setSize(390,500); option
Toolkit tk= Toolkit.getDefaultToolkit();
int xSize = ((int) tk.getScreenSize().getWidth());  
int ySize = ((int) tk.getScreenSize().getHeight());  
obj.setSize(xSize,ySize);  */
obj.setSize(728,615);
obj.setTitle("sudoku");
obj.setResizable(false);
obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public void keyReleased(KeyEvent e) {
if(e.getKeyChar()!=KeyEvent.VK_ENTER)
{
fiveresult=0;
erredcleaning();
errinkey=0;
inresultcheck();
timing();	//the person given the all inputs correctly to say his finished time
}
/* int keyCode = e.getKeyCode();
String key = e.getKeyText(keyCode); 
for(i=0;i<9;i++)
for(j=0;j<9;j++)
if(key==KeyEvent.VK_RIGHT&&true==ck[i][j].isFocus())  
{
if(i+1%9==0&&j+1%9==0)
{
i=0;
j=0;
}
else if(i+1%9!=0&&j+1%9==0)
{
j=0;
i++;
}
else if(i+1%9!=0&&j+1%9!=0)
j++;
ck[i][j].requestFocus();
}*/
      }

      public void keyTyped(KeyEvent e) {

      }

      public void keyPressed(KeyEvent e) {

      }

	
public void actionPerformed(ActionEvent st)
{
 jop = new JOptionPane();
if(st.getSource()==clues)
{
g=0;
//stopclue=0;
inresultcheck();
int fr[][]=new int[9][9];
fr=m;
int inputall[][]=new int[9][9];
if(g<=1)
{
for(i=0;i<9;i++)
for(j=0;j<9;j++)
if(ck[i][j].getText().equals(""))
inputall[i][j]=0;
else
inputall[i][j]=Integer.parseInt(ck[i][j].getText());
reach ch=new reach(fr);
fr=ch.make(g);
//fiveresult
if(fiveresult<12)
{
if(fiveresult==0&&stopclue<12)
{
for(i=0;i<9;i++)
for(j=0;j<9;j++)
if(inputall[i][j]!=0 && inputall[i][j]!=m[i][j] )
{
ck[i][j].setForeground(Color.blue);
ck[i][j].setText(Integer.toString(fr[i][j]));
}
stopclue++;
fiveresult++;
}//==0
if(fiveresult>=0&&fiveresult<11&&stopclue<12)
{
int cc=0;
for(i=0;i<9;i++)
for(j=0;j<9;j++)
if(ck[i][j].getText().equals("")&&cc==0)
{
cc++;
ck[i][j].setForeground(Color.blue);
ck[i][j].setText(Integer.toString(fr[i][j]));
}
stopclue++;
fiveresult++;
}
else
{
for(i=0;i<9;i++)
for(j=0;j<9;j++)
{
ck[i][j].setForeground(new Color(50,50,50));
ck[i][j].setText(Integer.toString(fr[i][j]));
ck[i][j].disable();
}
}
}
}
//jop.showMessageDialog(null,"Clue");
}
if(st.getSource()==highscore||st.getSource()==d7)
{

jinstructions.setVisible(false);
jbase.setVisible(false);
jp.setVisible(false);
ua.setVisible(false);
j1.setVisible(false);
pc.add(jhighscore);
int score[]=new int[5];
int id[]=new int[5];
int minute[]=new int[5];
int second[]=new int[5];
String pname[]=new String[5];
String mode[]=new String[5];

try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection c=DriverManager.getConnection("jdbc:odbc:highscore");
//String database="jdbc:odbc:{Microsoft Access Driver (*.mdb)};DBQ=highscore.mdb";
//String database="jdbc:odbc://localhost/highscore";
//Connection c=DriverManager.getConnection(database,"","");
Statement s=c.createStatement();
ResultSet rs[]=new ResultSet[30];
int id1=0;
for(i=0;i<5;i++)
{
rs[i]=s.executeQuery("select * from score;");
while(rs[i].next())
{
pname[i]="";
int idd=Integer.parseInt(rs[i].getString("score"));
 id1=Integer.parseInt(rs[i].getString("id"));
if(idd>score[i]&&i==0)
{
score[i]=idd;
id[i]=id1;
}
else if(id[0]!=id1&&i==1)
{
if(idd>score[i])
{
id[i]=id1;
score[i]=idd;
}}
else if(id[0]!=id1&&id[1]!=id1&&i==2)
{
if(idd>score[i])
{
id[i]=id1;
score[i]=idd;
}}
else if(id[0]!=id1&&id[1]!=id1&&i==3&&id[2]!=id1)
{
if(idd>score[i])
{
id[i]=id1;
score[i]=idd;
}}
else if(id[0]!=id1&&id[1]!=id1&&i==4&&id[2]!=id1&&id[3]!=id1)
{
if(idd>score[i])
{
id[i]=id1;
score[i]=idd;
}
}
}
rs[i+6]=s.executeQuery("select * from score where id="+id[i]+";");
while(rs[i+6].next())
{
id[i]=Integer.parseInt(rs[i+6].getString("id"));
minute[i]=Integer.parseInt(rs[i+6].getString("min"));
second[i]=Integer.parseInt(rs[i+6].getString("sec"));
score[i]=Integer.parseInt(rs[i+6].getString("score"));
pname[i]=rs[i+6].getString("pname");
mode[i]=rs[i+6].getString("mode");
/*jop.showMessageDialog(null,"id "+id[i]+" min " + minute[i] + " sec" +second[i]+ "score " +score[i]+
 "pname "+pname[i]+ " mode "+mode[i]);*/
}
}

/* For Table actions */
Object data[][] = {
    {1, pname[0],
     mode[0],minute[0]+ " : " + second[0], score[0]},
{2, pname[1],
     mode[1],minute[1]+ " : " + second[1], score[1]},
{3, pname[2],
     mode[2],minute[2]+ " : " + second[2], score[2]},
{4, pname[3],
     mode[3],minute[3]+ " : " + second[3], score[3]},
{5, pname[4],
     mode[4],minute[4]+ " : " + second[4], score[4]},
};

String[] columnNames = {"S.No",
                        "Name",
                        "Mode",
                        "Time Taken",
                        "Score"};

JTable table= new JTable(data, columnNames);
/*
TableColumn column = null;
for (int i = 0; i < 5; i++) {
    column = table.getColumnModel().getColumn(i);
    if (i == 2) {
        column.setPreferredWidth(80); //third column is bigger
    } else {
        column.setPreferredWidth(50);
    }
}*/


jhighscore.add(table);
jhighscore.add(hsbg);
table.setBounds(100,250,550,90);
table.disable();
hsbg.setBounds(0,-15,728,587);
s.close();
c.close();
}
catch(SQLException e)
{
System.out.println(e);
}
catch(ClassNotFoundException e)
{
System.out.println(e);
}


//jhighscore.setBounds(35,15,250,350);
jhighscore.setBackground(new Color(126,130,100));
jhighscore.setLayout(null);
jhighscore.setVisible(true);
}
if(st.getSource()==instructions||st.getSource()==ib2||st.getSource()==d8)
{
jhighscore.setVisible(false);
jinstructions.setVisible(false);
jbase.setVisible(false);
jp.setVisible(false);
ua.setVisible(false);
j1.setVisible(false);
l2.setVisible(false);
ib2.setVisible(false);
l1.setVisible(true);
ib1.setVisible(true);
l1.setBounds(0,-15,728,587);
ib1.setIcon(new ImageIcon("ra.png"));
ib1.setBounds(620,492,89,61);
//l2.setBounds(0,0,390,500);
jinstructions.add(l1);
jinstructions.add(ib1);
pc.add(jinstructions);
jinstructions.setBackground(Color.black);
jinstructions.setLayout(null);
jinstructions.setVisible(true);
}
if(st.getSource()==ib1)
{
l1.setVisible(false);
ib1.setVisible(false);
l2.setBounds(0,-15,728,589);
ib2.setIcon(new ImageIcon("la.png"));
ib2.setBounds(42,465,89,61);
l2.setVisible(true);
ib2.setVisible(true);
jinstructions.add(l2);
jinstructions.add(ib2);
pc.add(jinstructions);
jinstructions.setBackground(Color.black);
jinstructions.setLayout(null);
jinstructions.setVisible(true);
}
if(st.getSource()==exitAction)
{
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
System.exit(0);
}
if(st.getSource()==newAction || st.getSource() == d6)
{
jhighscore.setVisible(false);
jinstructions.setVisible(false);
jbase.setVisible(false);
jp.setVisible(false);
ua.setVisible(false);

d.setBounds(56,234,160,37);
d1.setBounds(57,319,160,37);
d2.setBounds(57,402,160,37);

d.setIcon(new ImageIcon("easy.png"));
d1.setIcon(new ImageIcon("medium.png"));
d2.setIcon(new ImageIcon("hard.png"));

emh.setBounds(0,-15,728,587);

j1.add(d);
j1.add(d1);
j1.add(d2);
j1.add(emh);
updateDateTime();
  j1.add(showtime);
pc.add(j1);
j1.setBackground(new Color(125,135,150));
j1.setLayout(null);
j1.setVisible(true);
}
if(st.getSource()==userAction || st.getSource() == d9)
{
jhighscore.setVisible(false);
jinstructions.setVisible(false);
jbase.setVisible(false);
j1.setVisible(false);
jp.setVisible(false);
ua.setVisible(false);
ua.setLayout(null);
textalign(0);
for(i=0;i<9;i++)
for(j=0;j<9;j++)
ua.add(ck[i][j]);
d3.setIcon(new ImageIcon("reset.png"));
d4.setIcon(new ImageIcon("result.png"));
d5.setIcon(new ImageIcon("free.png"));

d4.setBounds(551,250,160,37);
d3.setBounds(549,319,160,37);
d5.setBounds(549,384,160,37);

umbg1.setBounds(0,-15,728,587);
ua.add(d3);
ua.add(d4);
ua.add(d5);
ua.add(umbg1);
pc.add(ua);
ua.setVisible(true);
jop.showMessageDialog(null," User Mode ");
darr=0;
forsec=0;
}

if(st.getSource()==d)
{
mode="easy";
fiveresult=0;
stopclue=0;
th.stop();
clues.setVisible(false);

loadlabel.setVisible(true);
j1.setVisible(false);


//loadlabel.setIcon(new ImageIcon(this.getClass().getResource("5.gif")));

textalign(1);
for(i=0;i<9;i++)
for(j=0;j<9;j++)
jp.add(ck[i][j]);
/* we set setbounds so it displayed in center ok when using this change the setbounds
d.setBounds(50,475,20,20);
d1.setBounds(100,475,20,20);
d2.setBounds(150,475,20,20);
jp.add(d);
jp.add(d1);
jp.add(d2);*/

//getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
//jp.setLayout(new FlowLayout());
loadlabel.setBounds(540,340,140,30);
jp.add(loadlabel);
pc.add(jp);
jp.add(emhbg1);
emhbg1.setBounds(0,-15,728,587);
jp.setLayout(null);
jp.setVisible(true);
a=0;

jop.showMessageDialog(null,"Loading the question generation process Please Wait");
for33 f=new for33();
m=f.three(48);
loadlabel.setVisible(false);
jop.showMessageDialog(null,"Game Begins!");
clues.setVisible(true);
clues.setIcon(new ImageIcon("clue.png"));
clues.setBounds(549,384,160,37);
jp.add(clues);

for(int i=0;i<9;i++)
for(int j=0;j<9;j++)
if(m[i][j]==0)
ck[i][j].setText("");
else
{
a++;
ck[i][j].setBackground(Color.black);
ck[i][j].setForeground(Color.white);
ck[i][j].setText(Integer.toString(m[i][j]));
ck[i][j].disable();
darr=1;
forsec=1;
}
start=System.currentTimeMillis();
}
if(st.getSource()==d1)
{
mode="medium";
fiveresult=0;
stopclue=0;
clues.setVisible(false);
loadlabel.setVisible(true);
th.stop();
j1.setVisible(false);

textalign(1);
for(i=0;i<9;i++)
for(j=0;j<9;j++)
jp.add(ck[i][j]);
loadlabel.setBounds(540,340,140,30);
jp.add(loadlabel);
pc.add(jp);
jp.add(emhbg1);
emhbg1.setBounds(0,-15,728,587);
jp.setLayout(null);
jp.setVisible(true);
a=0;
jop.showMessageDialog(null,"Loading the question generation process Please Wait");
for33 f=new for33();
m=f.three(36);
jop.showMessageDialog(null,"Game Begins!");
loadlabel.setVisible(false);
clues.setVisible(true);
clues.setIcon(new ImageIcon("clue.png"));
clues.setBounds(549,384,160,37);
jp.add(clues);

for(int i=0;i<9;i++)
for(int j=0;j<9;j++)
if(m[i][j]==0)
ck[i][j].setText("");
else
{
a++;
ck[i][j].setBackground(Color.black);
ck[i][j].setForeground(Color.white);
ck[i][j].setText(Integer.toString(m[i][j]));
ck[i][j].disable();
darr=1;
forsec=1;
}
start=System.currentTimeMillis();
}

if(st.getSource()==d2)
{
mode="complex";
fiveresult=0;
stopclue=0;
clues.setVisible(false);
loadlabel.setVisible(true);
th.stop();
j1.setVisible(false);
textalign(1);
for(i=0;i<9;i++)
for(j=0;j<9;j++)
jp.add(ck[i][j]);
loadlabel.setBounds(540,340,140,30);
jp.add(loadlabel);
pc.add(jp);
jp.add(emhbg1);
emhbg1.setBounds(0,-15,728,587);
jp.setLayout(null);
jp.setVisible(true);
a=0;
jop.showMessageDialog(null,"Loading the question generation process Please Wait");
for33 f=new for33();
m=f.three(23);
jop.showMessageDialog(null,"Game Begins!");
loadlabel.setVisible(false);
clues.setVisible(true);
clues.setIcon(new ImageIcon("clue.png"));
clues.setBounds(549,384,160,37);
jp.add(clues);

for(int i=0;i<9;i++)
for(int j=0;j<9;j++)
if(m[i][j]==0)
ck[i][j].setText("");
else
{
a++;
ck[i][j].setBackground(Color.black);
ck[i][j].setForeground(Color.white);
ck[i][j].setText(Integer.toString(m[i][j]));
ck[i][j].disable();
darr=1;
forsec=1;
}
start=System.currentTimeMillis();
}


if(st.getSource()==d3)
{
for(int i=0;i<9;i++)
for(int j=0;j<9;j++)
ck[i][j].setText("");
jop.showMessageDialog(null,"Reset Process Done");
}

if(st.getSource()==d5)
{
for(int i=0;i<9;i++)
for(int j=0;j<9;j++)
if(m[i][j]==0)
ck[i][j].setText("");
else
{
ck[i][j].setForeground(Color.black);
ck[i][j].setText(Integer.toString(m[i][j]));
}
jop.showMessageDialog(null,"Contents Cleaned");
}

if(st.getSource()==d4)
{
errinkey=1;
g=0;
err=0;
inresultcheck();
reach ch=new reach(b);
b=ch.make(g);
gisak ez=new gisak(b);
e=0;
for(i=0;i<9;i++)
for(j=0;j<9;j++)
if(b[i][j]!=0)
e++;
if(e!=81)
jop.showMessageDialog(null,"Given sudoku question is not worth");
/*{
for(k=0;k<20;k++)
b=ez.read(4,g,0);*/

/*}
next for now only da
b=sak;
}*/

/*for(int i=0;i<9;i++)
for(int j=0;j<9;j++)
ck[i][j].setForeground(Color.black);
ck[i][j].setText(Integer.toString(m[i][j]));*/



if(e==81)
for(i=0;i<9&&g<=1;i++)
for(j=0;j<9;j++)
if(b[i][j]==0)
ck[i][j].setText("");
else
{
ck[i][j].setForeground(Color.blue);
ck[i][j].setText(Integer.toString(b[i][j]));
}

for(int i=0;i<9;i++)
for(int j=0;j<9;j++)
if(m[i][j]!=0&&err!=1)
{
ck[i][j].setForeground(Color.black);
ck[i][j].setText(Integer.toString(m[i][j]));
}
if(e==81)
jop.showMessageDialog(null,"Needed Result");
}
}
}