import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{
	int x,y;
	int leftFlag;
	Image img,img1,img2,img3,img4,img5,img9,currentImg;
	public MainCanvas(){
		try
		{
			img=Image.createImage("/sayo10.png");
			img1=Image.createImage("/sayo12.png");
			img2=Image.createImage("/sayo06.png");
			img3=Image.createImage("/sayo10.png");
			img4=Image.createImage("/sayo24.png");

			img5=Image.createImage("/sayo02.png");
			img9=Image.createImage("/sayo22.png");



			currentImg=img;
			x=120;
			y=100;

			leftFlag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode)
	{
		int action=getGameAction(keyCode);
		if(action==LEFT){
		if(leftFlag==1){
			currentImg=img5;
			leftFlag++;
		}
		else if(leftFlag==2){
			currentImg=img9;
			leftFlag=1;
		}
		x-=1;
		repaint();

		}

		if(action==RIGHT){
		currentImg=img2;

		repaint();
		x+=1;
		}
		if(action==DOWN){
		currentImg=img3;
		repaint();
		y+=1;
		}
		if(action==UP){
		currentImg=img4;
		repaint();
		y-=2;
		}
	}

}