/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package imagepackage;

import dividerpackage.DividerUtilities;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.imageio.ImageIO;

public class ImageUtilities
{
    //***************************************************************************
     public static void main(String[] args)
    {
       
       BufferedImage img=readBufferedImage(new File("e:\\View.png"));
       //BreakImageIntoParts(img, 8, 5, "e:\\parts");
      
       extractMessageToFile(img,"e:\\Certificate.pdf");
        
  //  BufferedImage img=combineImagesIntoOne(new String[]{"e:\\parts\\4.png","e:\\parts\\3.png","e:\\parts\\2.png","e:\\parts\\0.png","e:\\parts\\5.png"});
   //saveImage(img,new File("d:\\output.png"), "png");
             
    }
     //****************************************************************************

    public static BufferedImage combineImagesIntoOne(String[] files)
     {
         //***************Combine many Images given in the String array into one image********
         List<int[][]> matrices=new ArrayList<int[][]>();
         for(int i=0;i<=files.length-1;i++)
         {
             
             BufferedImage img=readBufferedImage(new File(files[i]));
             int[][] matrix=getMatrix(img);
             matrices.add(matrix);
         }
         BufferedImage temp=getStaticImageForMatrix( combineMatrices(matrices));
         return temp;
     }

     public static void BreakImageIntoParts(BufferedImage img,int totalparts,int partstocombine,String directory)
     {
         //breaking of image into several parts with name 0.png,1.png,2.png,3,4....and save it into a directory
         int[][] matrix=getMatrix(img);
         List<int[][]>matrices=DividerUtilities.breakIntoParts(matrix,totalparts,partstocombine);
         for(int i=0;i<=matrices.size()-1;i++)
         {
         BufferedImage newimg=getImageForMatrix(matrices.get(i));
         saveImage(newimg, new File(directory + "\\" + i + ".png"), "png");
         
         }
         
     }
     
     public static int[][] combineMatrices(List<int[][]>matrices)
     {
         //Combines matrices and returns a new matrix.....
         int[][] matrix=matrices.get(0);
         for(int i=1;i<=matrices.size()-1;i++)
         matrix=combine2Matrices(matrix,matrices.get(i));
         return matrix;
         
     }
    
     public static int[][] combine2Matrices(int[][] a,int[][] b)
     {
         //takes a new matrix and  ant makes it value to 1 ORing 
         int height=a.length;
         int width=a[0].length;
         int[][] matrix=new int[height][width];
         for(int y=0;y<=height-1;y++)
         {
             for(int x=0;x<=width-1;x++)
             {
                 if(a[y][x]==1 || b[y][x]==1)
                     matrix[y][x]=1;
             }
         }
         return matrix;
     }
     
     public static int[][] getMatrix(BufferedImage img)
     {
         //if no. of 1s in red component of a pixel is odd then stores 1 in matrix.
         int height=img.getHeight();
         int width=img.getWidth();
         int[][] matrix=new int[height][width];
          for(int y=0;y<=height-1;y++)
         {
             for(int x=0;x<=width-1;x++)
             {
                 int pixel=img.getRGB(x, y);
                 int red=red(pixel);
                 if(isOdd(red))
                     matrix[y][x]=1;
             }
         }
         return matrix;
     }
 
//***************************************************************************
     public static boolean isOdd(int n)
     {
         //if no. of pixels is odd number then return true.
         if(n % 2==0)
             return false;
         return true;
     }
     
     public static BufferedImage getStaticImageForMatrix(int[][] a)
     {
         // change the  RGB value of pixel of an image
         int height=a.length;
         int width=a[0].length;
         BufferedImage img=ImageUtilities.getNewImage(width, height);
         for(int y=0;y<=height-1;y++)
         {
             for(int x=0;x<=width-1;x++)
             {
                 int pixel;
                 int random=(int)(Math.random()*256);
                 if(a[y][x]==0)
                 {
                     random=setEven(random);
                     pixel=rgb(255, 0, 0, 0);
                 }
                 else
                 {
                     random=setOdd(random);
                     pixel=rgb(255, 255, 255, 255);
                 }
                 img.setRGB(x, y, pixel);
             }
         }
         return img;
     }
     
   
     public static BufferedImage getImageForMatrix(int[][] a)
     {
         int height=a.length;
         int width=a[0].length;
         BufferedImage img=ImageUtilities.getNewImage(width, height);
         for(int y=0;y<=height-1;y++)
         {
             for(int x=0;x<=width-1;x++)
             {
                 int pixel;
                 int random=(int)(Math.random()*256);
                 if(a[y][x]==0)
                 {
                     random=setEven(random);
                     pixel=rgb(255, random, random, random);
                 }
                 else
                 {
                     random=setOdd(random);
                     pixel=rgb(255, random, random, random);
                 }
                 img.setRGB(x, y, pixel);
             }
         }
       return img;
     }
     //***************************************************************************
     public static int[] ExtractArrayFromImage(BufferedImage img)
    {
        List<Integer> lst=new ArrayList<Integer>();
        int currentchar=0;
        int n=0;
        int width=img.getWidth(),height=img.getHeight();
         for(int y=0;y<=height-1;y++)
         {
             for(int x=0;x<=width-1;x++)
             {
                 int pixel=img.getRGB(x, y);
                 int alpha=alpha(pixel);
                         int red=red(pixel);
                         int green=green(pixel);
                         int blue=blue(pixel);
                         currentchar=currentchar + red %2+green%2+blue%2;
                         
                n++;
                if(n>=43)
                {
                    if(currentchar>0)
                    {
                        lst.add(currentchar);
                        

                    }
                    n=0;
                    currentchar=0;
                }
                    
                }
         }
         int[] data=new int[lst.size()];
         for(int i=0;i<=lst.size()-1;i++)
             data[i]=Integer.parseInt("" + lst.get(i));
        return data;

    }
    //***************************************************************************
    public static BufferedImage insertMessageIntoImage(BufferedImage img,int[] characters)
    {
       int[] data=new int[characters.length + 1];
       for(int i=0;i<=characters.length-1;i++)
           data[i]=characters[i];
       characters=data;
        int currentcharacterno=0, n=0;
        int currentchar;
        int width=img.getWidth(),height=img.getHeight();
        BufferedImage temp=getNewImage(width,height);
        currentchar=characters[currentcharacterno];
         for(int y=0;y<=height-1;y++)
         {
             for(int x=0;x<=width-1;x++)
             {
                 int pixel=img.getRGB(x, y);
                 int alpha=alpha(pixel);
                         int red=red(pixel);
                         int green=green(pixel);
                         int blue=blue(pixel);
                         int newred,newgreen,newblue;
                         if(currentchar>0)
                         {
                             newred=setOdd(red);
                             currentchar--;
                         }
                             else
                             newred=setEven(red);
                          if(currentchar>0)
                         {
                             newgreen=setOdd(green);
                             currentchar--;
                         }
                             else
                             newgreen=setEven(green);
                          if(currentchar>0)
                         {
                             newblue=setOdd(blue);
                             currentchar--;
                         }
                             else
                             newblue=setEven(blue);
                          int newpixel=rgb(alpha,newred,newgreen,newblue);
                          temp.setRGB(x, y, newpixel);
                         
                         
                        // System.out.printf("X=%d,Y=%d,Red=%d,Green=%d,Blue=%d\n",x,y,red,green,blue);

                         n++;
                         if(n>=43)
                         {
                             currentcharacterno++;
                             if(currentcharacterno>=characters.length-1)
                                 currentchar=0;
                             else
                                 currentchar=characters[currentcharacterno];
                             n=0;
                             
                         }
                         
             }
         }
        return temp;

    }
    //***************************************************************************
   
    public static void extractMessageToFile(BufferedImage img,String filename)
    {
        PrintWriter out=null;
        try 
        {
            String output=ExtractMessageFromImage(img);
            out = new PrintWriter(filename);
            out.println(output);
            out.flush();
            out.close();
        } 
        catch (Exception ex) 
        {
           System.out.println(ex);
        } 
        
    }
    //**************************************************************************
    public static BufferedImage insertMessageFromFile(BufferedImage img,String filename)
    {
        
        String data=getStringFromFile(filename);
      return  insertMessageIntoImage(img, data);
    }
    //***************************************************************************
    public static String getStringFromFile(String filename)
    {
        try
        {
            Scanner s=new Scanner(new File(filename));
            String output="";
            while(s.hasNextLine())
                output=output + s.nextLine();
            s.close();
            return output;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            return "";
        }
    }
    //***************************************************************************
   
    //***************************************************************************
    
    public static void fileCopy(String src,String dest)
    {
       
        try
        {
            FileInputStream fin=new FileInputStream(src);
            FileOutputStream fout=new FileOutputStream(dest);
            DataInputStream in=new DataInputStream(fin);
            DataOutputStream out=new DataOutputStream(fout);
            int n;
            while((n=in.read())!=-1)
            {
             out.write(n);   
            }
            in.close();
            out.flush();
            out.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }
    
    
    //***************************************************************************
    public static BufferedImage copyImage(BufferedImage img)
{
    //this function is use for copy the previous image and store the height and width same as 
try
{
int width=img.getWidth();
int height=img.getHeight();
BufferedImage newimg=new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
for(int x=0;x<=width-1;x++)
for(int y=0;y<=height-1;y++)
{
int pixel=img.getRGB(x,y);
newimg.setRGB(x,y,pixel);
}
return newimg;
}
catch(Exception ex)
{
System.out.println(ex);
return null;
}

}
    //***************************************************************************
    public static BufferedImage getGrayScale(BufferedImage img)
        {
            //use to set the intensity of image by taking average of RGB value of each pixel.....
    int width=img.getWidth();
     int height=img.getHeight();
     BufferedImage temp=getNewImage(width,height);
     for(int x=0;x<=width-1;x++)
         for(int y=0;y<=height-1;y++)
             {
             int pixel=img.getRGB(x,y);
             int a=alpha(pixel);
             int r=red(pixel);
             int g=green(pixel);
             int b=blue(pixel);
             int avg=(r+g+b)/3;
             int newpixel=rgb(a,avg,avg,avg);
             temp.setRGB(x,y,newpixel);


         }
     return temp;

}
    //*****************************************
    //******************************************************************************
    public static String ExtractMessageFromImage(BufferedImage img)
    {
        //this function is used for extracting the message from image
        String output="";
        int currentchar=0;
        int n=0;
        int width=img.getWidth(),height=img.getHeight();
         for(int y=0;y<=height-1;y++)
         {
             for(int x=0;x<=width-1;x++)
             {
                 int pixel=img.getRGB(x, y);
                 int alpha=alpha(pixel);
                         int red=red(pixel);
                         int green=green(pixel);
                         int blue=blue(pixel);
                         currentchar=currentchar + red %2+green%2+blue%2;
                         
                n++;
                if(n>=43)
                {
                    if(currentchar>0)
                    {
                        char ch=(char)currentchar;
                        output=output+ch;

                    }
                    n=0;
                    currentchar=0;
                }
                    
                }
         }
        return output;

    }
    //******************************************************************************





     public static BufferedImage insertMessageIntoImage(BufferedImage img,String message)
    {
        message=message + " ";
        char[] characters=message.toCharArray();
        int currentcharacterno=0, n=0;
        int currentchar;
        int width=img.getWidth(),height=img.getHeight();
        BufferedImage temp=getNewImage(width,height);
        currentchar=characters[currentcharacterno];
         for(int y=0;y<=height-1;y++)
         {
             for(int x=0;x<=width-1;x++)
             {
                 int pixel=img.getRGB(x, y);
                 int alpha=alpha(pixel);
                         int red=red(pixel);
                         int green=green(pixel);
                         int blue=blue(pixel);
                         int newred,newgreen,newblue;
                         if(currentchar>0)
                         {
                             newred=setOdd(red);
                             currentchar--;
                         }
                             else
                             newred=setEven(red);
                          if(currentchar>0)
                         {
                             newgreen=setOdd(green);
                             currentchar--;
                         }
                             else
                             newgreen=setEven(green);
                          if(currentchar>0)
                         {
                             newblue=setOdd(blue);
                             currentchar--;
                         }
                             else
                             newblue=setEven(blue);
                          int newpixel=rgb(alpha,newred,newgreen,newblue);
                          temp.setRGB(x, y, newpixel);
                         
                         
                        // System.out.printf("X=%d,Y=%d,Red=%d,Green=%d,Blue=%d\n",x,y,red,green,blue);

                         n++;
                         if(n>=43)
                         {
                             currentcharacterno++;
                             if(currentcharacterno>=characters.length-1)
                                 currentchar=0;
                             else
                                 currentchar=characters[currentcharacterno];
                             n=0;
                             
                         }
                         
             }
         }
        return temp;

    }
public static int setEven(int n)
    {
    if(n % 2==0)
        return n;
    else
        return n-1;
}
public static int setOdd(int n)
    {
    if(n % 2==0)
        return n+1;
    else
        return n;
}

public static BufferedImage getNewImage(int width,int height)
    {
    BufferedImage temp=new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
    return temp;
}
public static BufferedImage getCombinedImage(BufferedImage img1,BufferedImage img2)
{
if(img1.getWidth()!=img2.getWidth())
return null;

if(img1.getHeight()!=img2.getHeight())
return null;
int width=img1.getWidth();
int height=img1.getHeight();
BufferedImage temp=new BufferedImage(width,height, BufferedImage.TYPE_INT_RGB);
for(int y=0;y<height;y++)
for(int x=0;x<width;x++)
{

int newrgb=img1.getRGB(x,y)^img2.getRGB(x,y);
temp.setRGB(x,y,newrgb);
}
return temp;
}
//************************
public static BufferedImage getXORImage(BufferedImage img1,BufferedImage img2)
    {
    int width=img1.getWidth();
    int height=img1.getHeight();
    BufferedImage xor=getNewImage(width, height);
    for(int x=0;x<=width-1;x++)
         for(int y=0;y<=height-1;y++)
         {
             int p1=img1.getRGB(x, y);
             int p2=img2.getRGB(x, y);
             int newpixel=p1^p2;
             xor.setRGB(x, y, newpixel); 
         }

    return xor;
}



public static BufferedImage getRandomImage(int width,int height)
{

BufferedImage temp=getNewImage(width,height);
     for(int x=0;x<=width-1;x++)
         for(int y=0;y<=height-1;y++)
             {

             int a=10;
             int r=(int)(Math.random()*256);
             int newpixel=rgb(a,r,r,r);
             temp.setRGB(x,y,newpixel);


         }
     return temp;
}

//***************************************
public static byte getRandomColor()
{
return (byte)(Math.random()*255);
}

//***************************************************
public static int rgb(int a,int r,int g,int b)
{
return (a << 24) | (r << 16) | (g << 8) | b;
}
public static int alpha(int rgb)
{
return ((rgb >> 24) & 0xff);
}
public static int red(int rgb)
{
return ((rgb >> 16) & 0xff);
}
public static int green(int rgb)
{
return ((rgb >> 8) & 0xff);
}
public static int blue(int rgb)
{
return ((rgb) & 0xff);
}
//***************************************************









public static boolean saveImage(BufferedImage img,File file,String format)
{
try
{
ImageIO.write(img,format,file);
return true;
}
catch(Exception ex)
{
System.out.println(ex);
return false;
}
}


public static BufferedImage readBufferedImage(File file)
{
try
{
BufferedImage img=ImageIO.read(file);
return img;
}
catch(Exception ex)
{
System.out.println(ex);
return null;
}
}
}


