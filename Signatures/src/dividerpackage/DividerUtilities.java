package dividerpackage;

import java.util.List;
import java.util.ArrayList;
public class DividerUtilities
{
public static int countZeros(int[] a)
{
int count=0;
for(int i=0;i<=a.length-1;i++)
if(a[i]==0)
count++;
return count;
}
public static int[] getBinary(int n,int l)
{
String out="";
while(n>0)
{
int rem=n % 2;
n=n/2;
out=rem + out;
}
out=pad(out,l);
return toIntArray(out);
}
public static int[] toIntArray(String str)
{
char[] chars=str.toCharArray();
int[] a=new int[chars.length];
for(int i=0;i<=a.length-1;i++)
a[i]=chars[i]-'0';
return a;
}
public static String pad(String str,int l)
{
while(str.length()<l)
str="0" + str;
return str;
}
public static List<int[]> getBinaryArray(int digits)
{
List<int[]> lst=new ArrayList<int[]>();

int l=0;
int u=(int)Math.pow(2,digits);
for(int i=l;i<=u-1;i++)
{
int[] a=getBinary(i,digits);
lst.add(a);
}
return lst;
}

public static void print(int[] a)
{
System.out.println();
for(int i=0;i<=a.length-1;i++)
System.out.print(a[i] + ",");
System.out.println();
}
public static void print(int[][] a)
{
int m=a.length;
int n=a[0].length;
System.out.println();
for(int i=0;i<=m-1;i++)
{
for(int j=0;j<=n-1;j++)
System.out.printf("%6d",a[i][j]);
System.out.println();
}
System.out.println();
}
public static List<int[]> getDividingArray(int digits,int parts)
{
List<int[]> l=getBinaryArray(digits);
List<int[]> lst=new ArrayList<int[]>();
for(int[] a:l)
if(countZeros(a)<parts)
lst.add(a);
return lst;
}
public static List<int[][]> breakIntoParts(int[][] a,int totalparts,int partstocombine)
{
List<int[][]> output=new ArrayList<int[][]>();
int height=a.length;
int digits=a[0].length;
System.out.println(digits);
List<int[]> binaries=getDividingArray(totalparts,partstocombine);
int size=binaries.size();
for(int i=1;i<=totalparts;i++)
output.add(new int[height][digits]);
for(int i=0;i<=height-1;i++)
{
for(int j=0;j<=digits-1;j++)
{
int random=(int)(Math.random()*size);
int[] randomarray=binaries.get(random);
for(int k=0;k<=output.size()-1;k++)
{
int[][] temp=output.get(k);
if(a[i][j]==0)
temp[i][j]=0;
else
temp[i][j]=randomarray[k];
}
}
}
return output;
}
public static void main(String[]arg)
{
int[][] a={{1,1,0},{0,1,1},{1,1,1}};
List<int[][]> matrices=breakIntoParts(a,8,5);
for(int[][] matrix:matrices)
print(matrix); 
}
}