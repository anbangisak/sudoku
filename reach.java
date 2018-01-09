

public class reach
{
int i,j,k,g,e,a;
int b[][]=new int[9][9];
int sak[][]=new int[9][9];
public reach(int z[][])
{
for( i=0;i<9;i++)
for( j=0;j<9;j++)
b[i][j]=z[i][j];
}
public int[][] make(int g1)
{
g=g1;
gisak ez=new gisak(b);
e=0;
for(i=0;i<9;i++)
for(j=0;j<9;j++)
if(b[i][j]!=0)
e++;
if(e>10)
for(a=0;a<=9;a++)
{
e=0;
for(i=0;i<9;i++)
for(j=0;j<9;j++)
if(b[i][j]!=0)
e++;
if(e!=81)
{
ez=new gisak(b);
for(k=0;k<6;k++)
for(i=0;i<1;i++)
{
for(j=0;j<5;j++)
sak=ez.read(4,g,0);
sak=ez.read(3,g,a);
}

e=0;
for(i=0;i<9;i++)
for(j=0;j<9;j++)
if(sak[i][j]!=0)
e++;
if(e==81)
b=sak;
}

if(e!=81)
{
 ez=new gisak(b);
for(k=0;k<6;k++)
for(i=0;i<1;i++)
{
for(j=0;j<5;j++)
sak=ez.read(4,g,0);
sak=ez.read(2,g,a);
}

e=0;
for(i=0;i<9;i++)
for(j=0;j<9;j++)
if(sak[i][j]!=0)
e++;
if(e==81)
b=sak;
}

if(e!=81)
{
 ez=new gisak(b);
for(k=0;k<6;k++)
for(i=0;i<1;i++)
{
for(j=0;j<5;j++)
sak=ez.read(4,g,0);
sak=ez.read(1,g,a);
}

e=0;
for(i=0;i<9;i++)
for(j=0;j<9;j++)
if(sak[i][j]!=0)
e++;
if(e==81)
b=sak;
}

if(e!=81)
{
ez=new gisak(b);
for(k=0;k<6;k++)
for(i=0;i<1;i++)
{
for(j=0;j<5;j++)
sak=ez.read(4,g,0);
sak=ez.read(0,g,a);
}
			//break br;
e=0;
for(i=0;i<9;i++)
for(j=0;j<9;j++)
if(sak[i][j]!=0)
e++;
if(e==81)
b=sak;
}}
return(b);
}//function

}//class
