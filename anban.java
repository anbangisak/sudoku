

public class anban
{
int r,c,n,p,k,a,i,j,g=0;
int s[][]=new int[9][9];
public anban(int z[][])
{
for( p=0;p<9;p++)
for( k=0;k<9;k++)
s[p][k]=z[p][k];
}
public int loop(int x,int y,int xx,int w,int t)
{
r=y;c=w;a=t;
n=0;
for(p=x;p<r;p++)
for(k=xx;k<c;k++)
if(a==s[p][k])
n++;
return(n);
}
public int check(int i1,int j1,int r1,int r2,int c1,int c2,int w)
{
int aa=22,bb=22,cc=22,dd=22;
i=i1;j=j1;r=r2;n=c2;p=c1;a=r1;g=w;
c=0;
for(k=0;k<9;k++)
{
if(i+1!=r && g==s[i+1][k] )
{
c++;
aa=i+1;
}
if(j+1!=n && g==s[k][j+1] )
{
bb=j+1;
c++;
}
if( i+2!=r && i+2!=r+1 && g==s[i+2][k] )
{
cc=i+2;
c++;
}
if( j+2!=n && j+2!=n+1 && g==s[k][j+2] )
{
dd=j+2;
c++;
}
if( i-1!=a-1 && g==s[i-1][k] )
{
cc=i-1;
c++;
}
if( j-1!=p-1 && g==s[k][j-1] )
{
dd=j-1;
c++;
}
if( i-2!=a-1 && i-2!=a-2 && g==s[i-2][k] )
{
aa=i-2;
c++;
}
if( j-2!=p-1 && j-2!=p-2 && g==s[k][j-2] )
{
bb=j-2;
c++;
}
}
if(c<4 && c!=4)
{
a=0;    n=0;
for(p=r1;p<r2;p++)
for(k=c1;k<c2;k++)
if(aa!=p && bb!=k && cc!=p && dd!=k )
{
if(s[p][k]>=0 && ( p!=i || k!=j ) )
a++;
if(s[p][k]>0 && s[p][k]!=0 && ( p!=i || k!=j ))
n++;
}
if(a==n && n!=0 && a!=0)
c=5;
}
if(c<4)
{
int ak=0,nn=0; 
key:for(k=0;k<9;k++)
if(s[i][k]==0 && k!=j )//&& bb!=k && dd!=k )
{
ak++;
for(p=0;p<9;p++)
if(s[p][k]==g)
{
nn++;
if(ak==nn)
continue key;
}
}
if(ak==nn)
c=5;
}
if(c<4)
{
int ak=0,nn=0;
key:for(k=0;k<9;k++)
if(s[k][j]==0 && k!=i )//&& aa!=k && cc!=k )
{
ak++;
for(p=0;p<9;p++)
if(s[k][p]==g)
{
nn++;
if(ak==nn)
continue key;
}
}
if(ak==nn )
c=5;
}
return(c);
}
}