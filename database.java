/* create database in ms access with the name of mydata.
then table is displayed in right side.thn enter the values in the table.
then close the table (only table not the ms office).
it want the name of the table enter the name as student.
then start-->control panel-->administrative tools-->Data Source(odbc)
--> System DSN-->Add-->Microsoft Access Driver(*.mdb,*.accdb) -->
finish-->DataSource Name-->mydata-->click select-->(before browsing for db must close the ms
access window)browse for data-->close the application */

import java.sql.*;
import java.io.*;
class database
{
public static void main(String pr[])
{
int i,n;
String str;
DataInputStream st=new DataInputStream(System.in);
System.out.println("1)select,\n2)insert,\n3)delete,\n4)exit\n");
try{
Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection c=DriverManager.getConnection("jdbc:odbc:highscore");
Statement s=c.createStatement();
do
{
System.out.println("Choose any one of them:");
i=Integer.parseInt(st.readLine());
switch(i)
{
case 1:
{
ResultSet rs=s.executeQuery("select * from score;");
while(rs.next())
System.out.println(rs.getString("id"));
continue;
}
case 2:
{
System.out.println("enter the id: ");
n=Integer.parseInt(st.readLine());
System.out.println("enter the score: ");
int j=Integer.parseInt(st.readLine());
System.out.println("enter the min: ");
int min=Integer.parseInt(st.readLine());
System.out.println("enter the sec: ");
int sec=Integer.parseInt(st.readLine());
s.executeUpdate("insert into score values("+n+","+j+","+min+","+sec+");");
continue;
}
case 3:
{
System.out.println("Enter the id: ");
 n=Integer.parseInt(st.readLine());
s.executeUpdate("delete from score where id="+n+";");
continue;
}
case 4:
break;
default:
System.out.println("please enter the correct one: ");
}
}while(i!=4);
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
catch(IOException e)
{
System.out.println(e);
}
}
}