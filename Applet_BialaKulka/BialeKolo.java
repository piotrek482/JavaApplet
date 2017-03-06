package Applet_BialaKulka;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

public class BialeKolo 
{
	//zmienne
	private int x, y, promien, kopia_promien, pomocnicza = 1;
	private Color kolor;
	
	//konstruktor
	public BialeKolo(Dimension d)
	{
		Random r = new Random();
		//kolor = new Color( 1.f, 1.f, 1.f );
		//kolor = new Color( r.nextFloat(), r.nextFloat(), r.nextFloat() );
		kolor = new Color ( (float)Math.random(), (float)Math.random(), (float)Math.random() );
		
		promien = kopia_promien = r.nextInt(50);
		x = r.nextInt(d.width - promien);
		y = r.nextInt(d.height - promien);
	}
	
	//metody rysuj(Graphics g)
	public void rysuj(Graphics g)
	{
		g.setColor(Color.white);
		g.fillOval(x, y, promien, promien);
		
		g.setColor(kolor);
		g.drawString("0", x+(promien/2), y+(promien/2));
		
		g.setColor(Color.BLACK);
		g.fillOval(x+(promien/2), y+(promien/2), 2, 2);
	}
	
	//metoda odbijsie
	public void odbij(Dimension d)
	{
		if (y<d.height-promien)
		{
			y += 5;
		}
		
	}
	
	//metoda zmienrozmiar
}
