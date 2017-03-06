package Applet_Kwadrat;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

public class Kwadrat 
{
	//zmienne
	private int bok_a, bok_b;		//dlugosci bokow
	private int x, y;				//odleg³oœci od krawêdzi lewej i górnej
	private Color kolor;			// zmiena kolor
	private int pomocnicza=1;		//pomocnicza zmienna
	
	
	//konstruktor
	public Kwadrat(Dimension d)
	{
		Random r = new Random();	//obiekt zmiennej do losowania
		
		bok_a = bok_b = r.nextInt(50);	//losowanie d³ugoœci boku kwadratu
		
		x = r.nextInt(d.width - bok_a);		//losowanie odleg³oœci kwadrato od krawêdzi lewej i górnej
		y = r.nextInt(d.height - bok_a);
		
		kolor = Color.blue;		//losowanie koloru
	}
	
	//metoda rysuj
	public void rysuj(Graphics g)
	{
		g.setColor(kolor);
		g.fillRect(x, y, bok_a, bok_a);
	}
	
	//metoda zwieksz(Dimension d)
	public void zwieksz(Dimension d)
	{
		bok_a += 2*pomocnicza;
		y += pomocnicza;
		x += pomocnicza;
		//bok_b += 1*pomocnicza;
		
		if(bok_a >= 2*bok_b) pomocnicza*=(-1);
		if(bok_a <= bok_b) pomocnicza *=(-1);
	}
	
	//metoda zmienKolor()
	public void zmienKolor()
	{
		Random r = new Random();
		kolor = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());	
//		if(kolor.equals(Color.blue)) kolor = Color.pink;
//		else if (kolor.equals(Color.pink)) kolor = Color.blue;
	}

	public boolean zawiera(int xMouse, int yMouse) {
		if ( (xMouse >= x && xMouse <= (x+bok_a) ) && ( (yMouse >= y && yMouse <= (y+bok_b) ) ))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
}
