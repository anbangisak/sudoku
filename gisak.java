
public class gisak
{
int k,r,i,j,p,a,c,tk;
int b[][]=new int[9][9];
public gisak(int z[][])
{
for( p=0;p<9;p++)
for( k=0;k<9;k++)
b[p][k]=z[p][k];
}
public int[][] read(int ka,int g1,int extra)
{
int g=g1;
int ak=ka;
int ex=extra;
tk=0;
for( i=0;i<9&&g<=1;i++)
c4:for( j=0;j<9;j++)
{
if(b[i][j]==0)
{
for(r=1;r<=9;r++)
{	
a=0;
for(k=0;k<9;k++)
{
if(r==b[i][k])
a++;
if(a>0)
break;
}
for(k=0;k<9;k++)
{
if(r==b[k][j])
a++;
if(a>0)
break;
}
anban ma=new anban(b);
if(i<3&&j<3)
g=ma.loop(0,3,0,3,r);
else if(i<3&&j<6)
g=ma.loop(0,3,3,6,r);
else if(i<3&&j<9)
g=ma.loop(0,3,6,9,r);
else if(i<6&&j<3)
g=ma.loop(3,6,0,3,r);
else if(i<6&&j<6)
g=ma.loop(3,6,3,6,r);
else if(i<6&&j<9)
g=ma.loop(3,6,6,9,r);
else if(i<9&&j<3)
g=ma.loop(6,9,0,3,r);
else if(i<9&&j<6)
g=ma.loop(6,9,3,6,r);
else 
g=ma.loop(6,9,6,9,r);
if(g>=1)
a++;
if(i<3&&j<3)
c=ma.check(i,j,0,3,0,3,r);
else if(i<3&&j<6)
c=ma.check(i,j,0,3,3,6,r);
else if(i<3&&j<9)
c=ma.check(i,j,0,3,6,9,r);
else if(i<6&&j<3)
c=ma.check(i,j,3,6,0,3,r);
else if(i<6&&j<6)
c=ma.check(i,j,3,6,3,6,r);
else if(i<6&&j<9)
c=ma.check(i,j,3,6,6,9,r);
else if(i<9&&j<3)
c=ma.check(i,j,6,9,0,3,r);
else if(i<9&&j<6)
c=ma.check(i,j,6,9,3,6,r);
else 
c=ma.check(i,j,6,9,6,9,r);
if(a==0&&c==4)//c>1
{
b[i][j]=r;
continue c4;
}
if(a==0&&c==5)
{
b[i][j]=r;
continue c4;
}
if(a==0&&c==ak&&ex==0)
{
tk++;
if(tk==1)
b[i][j]=r;
}
if(a==0&&c==ak&&ex==1)
{
tk++;
if(tk==2)
b[i][j]=r;
}
if(a==0&&c==ak&&ex==2)
{
tk++;
if(tk==3)
b[i][j]=r;
}
if(a==0&&c==ak&&ex==3)
{
tk++;
if(tk==4)
b[i][j]=r;
}
if(a==0&&c==ak&&ex==4)
{
tk++;
if(tk==5)
b[i][j]=r;
}
if(a==0&&c==ak&&ex==5)
{
tk++;
if(tk==6)
b[i][j]=r;
}
if(a==0&&c==ak&&ex==6)
{
tk++;
if(tk==7)
b[i][j]=r;
}
if(a==0&&c==ak&&ex==7)
{
tk++;
if(tk==8)
b[i][j]=r;
}
if(a==0&&c==ak&&ex==8)
{
tk++;
if(tk==9)
b[i][j]=r;
}
if(a==0&&c==ak&&ex==9)
{
tk++;
if(tk==10)
b[i][j]=r;
}
}}}
return(b);
}
}