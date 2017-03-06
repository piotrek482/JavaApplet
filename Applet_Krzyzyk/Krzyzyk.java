package Applet_Krzyzyk;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

public class Krzyzyk 
{
	private int bok;
	private int x, y;
	private Color kolor;
	
	//konk=struktor
	public Krzyzyk(Dimension d)
	{
		Random r = new Random();
		x = r.nextInt(d.width - bok);
		y = r.nextInt(d.height - bok);
		kolor = new Color( (float)Math.random(), (float)Math.random(), (float)Math.random());
		
		bok = r.nextInt(50);
	}
	
	//metoda rysuj(Graphics g)
	public void rysuj(Graphics g)
	{
		g.setColor(kolor);
		g.fillRect(x, y, bok, 1);
		g.fillRect( x+(bok/2), y-(bok/2), 1, bok);
	}

	public void przesun(Dimension d) 
	{
		x += 1;
		
		if(bok+x > d.width)
		{
			x = 0;
		}
		
	}
	
	public boolean blisko(int xMouse, int yMouse)
	{
		int naj = 0;
		if(xMouse - x > naj && yMouse > naj)
		{
			return true;
		}
		return false;
	}
	
	public void zmienKolor()
	{
		kolor = Color.red;
	}
	
	public void resetKolor()
	{
		kolor = new Color( (float)Math.random(), (float)Math.random(), (float)Math.random());
	}
}
