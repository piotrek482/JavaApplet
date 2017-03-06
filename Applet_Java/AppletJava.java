package Applet_Java;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class AppletJava extends Applet implements Runnable
{
	private static final int N = 6;
	Java[] napis;
	
	//metoda init()
	public void init()
	{
		setBackground(Color.white);
		
		Dimension d = getSize();
		
		napis = new Java[N];
		
		for(int i=0; i<N; i++)
		{
			napis[i] = new Java(d);
		}
		
		Thread w = new Thread(this);
		w.start();
	}
	
	//metoda paint(Graphics g)
	public void paint(Graphics g)
	{
		for(Java j: napis)
		{
			j.rysuj(g);
		}
	}

	@Override
	public void run()
	{
		while(true)
		{
			try 
			{
				Thread.sleep(200);
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
			
			Dimension d = getSize();
			
			for(Java j: napis)
			{
				j.przesun(d);
				
			}
			repaint();
		}
	}
		
}
