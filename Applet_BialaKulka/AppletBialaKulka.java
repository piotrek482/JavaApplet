package Applet_BialaKulka;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class AppletBialaKulka extends Applet implements Runnable
{
	//zmienne
	private static final int N = 10;
	private BialeKolo[] bialekolka;
	
	//metoda init()
	@Override
	public void init()
	{
		setBackground(Color.black);
		
		Dimension d = getSize();
		
		bialekolka = new BialeKolo[N];
		
		for(int i = 0; i<N; i++)
		{
			bialekolka[i] = new BialeKolo(d);
		}
			
		Thread w = new Thread(this);
		w.start();
	}
	
	//paint(Graphics g)
	@Override
	public void paint(Graphics g)
	{
		for(BialeKolo bk: bialekolka)
		{
			bk.rysuj(g);
		}
	}


	@Override
	public void run() 
	{
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Dimension d = getSize();
		
		for(BialeKolo bk: bialekolka)
		{
			bk.odbij(d);
		}
		
		repaint();
	}
	
}
