package Applet_Kulka;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class Kulka {
	int r = 50; // promień - atrybuty klasy
	Color c; // kolor kółka - atrybut klasy
	double x;	// współrzędna x - atrybut klasy
	double y;	// współrzędna y - atrybut klasy
	double dx = Math.random() * 10 - 5;
	double dy = Math.random() * 10 - 5; // przesunięcie kulek
	
	public Kulka(int r, Dimension d) {
		this.r = r;
		x = r + (Math.random() * (d.width - 2*r));
		y = r + (Math.random() * (d.height - 2*r));
		c = new Color(
				(float) Math.random(), 
				(float) Math.random(), 
				(float) Math.random());
	}

	/**
	 * @param r
	 * @param c
	 * @param x
	 * @param y
	 */
	public Kulka(int r, Color c, double x, double y) {
		this.r = r;
		this.c = c;
		this.x = x;
		this.y = y;
	}

	public void rysuj(Graphics g) {
		g.setColor(c);			
		g.fillOval((int)(x-r), (int)(y-r), 2*r, 2*r);		
	}

	public void przesun(Dimension d) {
		x += dx;
		y += dy;
		if( x > d.width) x = 0;
		else if(x < 0) x = d.width;
		if( y > d.height) y = 0;
		else if(y < 0) y = d.height;
	}
}
