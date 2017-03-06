package Applet_Kolo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

public class Kolko 
{
	//zmienne
//	private int srodek;		//srodek kola
	private int x, y;		//odleglosc brzegow kolka od krawedzi
	private int promien, kopia_promien, pomocnicza=1;
	private Color kolor;
	
	
	
	//konstruktor
	public Kolko(Dimension d)
	{
		Random r = new Random();
		
		//kolor = new Color(.0f, .0f, .0f);  //nie trzeba losowaæ bo kolor ko³ek ma byæ bia³y
		
		promien = kopia_promien = r.nextInt(50);
		x = r.nextInt(d.width - promien);
		y = r.nextInt(d.height - promien);
	}
	
	
	//metoda rysuj(Graphics g)
	public void rysuj(Graphics g)
	{
		g.setColor(kolor = Color.white);
		g.fillOval(x, y, promien, promien);
	}
	
	//metoda zmienRozmiar
	public void zmienRozmiar(Dimension d)
	{
		promien -= 1*pomocnicza;
		
		if(promien < 0 ) pomocnicza*=(-1); 
		if(promien > kopia_promien ) pomocnicza*=(-1); 
	}
	
	//metoda zmienKolor()
	public void zmienKolor()
	{
		kolor = Color.black;
	}


	public boolean zawiera(int xMouse, int yMouse) 
	{
		if( (xMouse >= x && xMouse <= (x+promien+promien))  && (yMouse >= y && yMouse <= (y+promien+promien)) )
		{
			return true;
		}
		else
		{
			return false;
		}
		 

	}
}
