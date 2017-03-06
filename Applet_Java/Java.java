package Applet_Java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

public class Java 
{
	//zmienne
	private String napis;		
	private int x, y;					//odleg³oœci od brzegów lewego i górnego
	private Color kolor;
	//private int pomocnicza=1;
	
	
	//konstruktor
	public Java(Dimension d)
	{
		Random r = new Random();
		
		kolor = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());
		x=r.nextInt(d.width);
		y=r.nextInt(d.height);
		
		napis = "Java";
	}
	
	//metoda rysuj(Graphics g)
	public void rysuj(Graphics g)
	{
		g.setColor(Color.red);
		g.drawString(napis, x, y);
	}

	public void przesun(Dimension d) 
	{
		y += 1;
		
		if(y > d.height)
		{
			y = 0;
		}
		
	}
	
	
	
	
}
