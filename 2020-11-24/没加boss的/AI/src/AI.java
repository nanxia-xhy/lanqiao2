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
	int Flag;//声明变量
	Image heroImg[][]=new Image[4][3];
	Image currentImg;

	public MainCanvas(){

		try
		{
			/*
			给变量赋值
			语法：变量名称=value
			*/
			for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
				heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
			}
			}

//left:0;right:1;up:3;down:2

			x=120;
			y=100;

			currentImg=heroImg[2][1];
			Flag=1;
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void paint(Graphics g){
		g.setColor(250,200,180);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);
	}
	public void keyPressed(int keyCode)
	{
		int action=getGameAction(keyCode);


		if(action==LEFT){
			changePicAndDirection(0);
		
		x-=1;
		repaint();
		}


		if(action==RIGHT){
		changePicAndDirection(1);
		x+=1;
		repaint();	
		}


		if(action==DOWN){
		changePicAndDirection(2);
		y+=1;
		repaint();
		
		}



		if(action==UP){
		changePicAndDirection(3);
		y-=1;
		repaint();
		}
	}
		public void changePicAndDirection(int direction){
			if(Flag==1){
			currentImg=heroImg[direction][0];
			Flag++;
		}
		else if(Flag==2){
			currentImg=heroImg[direction][2];
			Flag--;
		}

		
		}
	

}