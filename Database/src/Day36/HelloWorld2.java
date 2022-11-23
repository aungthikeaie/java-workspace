package Day36;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class HelloWorld2 extends Applet 
{
	private static final int NUM_WORDS = 100;
	private static final Color[] color = {Color.black,Color.red,Color.blue,Color.green,Color.yellow};
	private static Random randy;
	private int randomInRange(int low, int high)
	{
		return(Math.abs(randy.nextInt())%(high-low+1))+low;
	}
	public void init()
	{
		randy = new Random();
	}
	public void paint(Graphics g)
	{
		for(int i = 0; i < NUM_WORDS; i++)
		{
			int x = randomInRange(1, 200);
			int y = randomInRange(1, 200);
			g.setColor(color[randomInRange(0, color.length-1)]);
			g.drawString("Hello world!", x, y);
		}
	}
}
