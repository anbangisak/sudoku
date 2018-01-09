import java.util.*;
public class for33
{
public int[][] three(int x)
{
int mk[];
int m[][]=new int[9][9];
int b[][]=new int[9][9];
int i,j,k,l,g,p,d,a,kk,gg,e=0;
Random r=new Random();

int tb;//tb=total boxes
for(int z=1;z<2;z++)
{
for(kk=0;kk<23;kk++)
{
tb=r.nextInt(81)+1;
l=r.nextInt(9)+1;
gg=0;
ll:for(i=0;i<9;i++)
for(j=0;j<9;j++)
if(gg==tb)
{
if(m[i][j]==0)
{
anban gi=new anban(m);
a=l;
g=0;
for(k=0;k<9;k++)
if(a==m[i][k])
{
kk--;
break ll;
}
for(k=0;k<9;k++)
if(a==m[k][j])
{
kk--;
break ll;
}
if(i<3&&j<3)
g=gi.loop(0,3,0,3,a);
else if(i<3&&j<6)
g=gi.loop(0,3,3,6,a);
else if(i<3&&j<9)
g=gi.loop(0,3,6,9,a);
else if(i<6&&j<3)
g=gi.loop(3,6,0,3,a);
else if(i<6&&j<6)
g=gi.loop(3,6,3,6,a);
else if(i<6&&j<9)
g=gi.loop(3,6,6,9,a);
else if(i<9&&j<3)
g=gi.loop(6,9,0,3,a);
else if(i<9&&j<6)
g=gi.loop(6,9,3,6,a);
else 
g=gi.loop(6,9,6,9,a);
if(g!=0)
{
kk--;
break ll;
}
if(g==0)
m[i][j]=l;
}
else
kk--;
gg++;
}
else
gg++;
}
for(i=0;i<9;i++)
for(j=0;j<9;j++)
b[i][j]=m[i][j];
g=0;
reach ch=new reach(m);
m=ch.make(g);
gisak ez=new gisak(m);
e=0;
for(i=0;i<9;i++)
for(j=0;j<9;j++)
if(m[i][j]!=0)
e++;
if(e!=81)
{
for(i=0;i<9;i++)
for(j=0;j<9;j++)
m[i][j]=0;
z--;
}
}
//tb=0;
//i=0;
if(x!=23)
for(i=0;i<9;i++)
for(j=0;j<9;j++)
b[i][j]=0;

if(e==81)
for(kk=0;kk<x && x!=23;kk++)
{
//if(i==0)


tb=r.nextInt(81)+1;


/*for(a=0;a<1&&i!=0;a++)
{
tb=r.nextInt(81)+1;
for(k=0;k<mk.length;k++)
if(mk[k]==tb)
{
a--;
break;
}
}*/


gg=0;
for(p=0;p<9;p++)
for(d=0;d<9;d++)
{
gg++;
if(gg==tb)
b[p][d]=m[p][d];
}

//i++;

}
return(b);
}//function
}//class