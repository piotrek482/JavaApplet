package Applet_Kwadrat;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TablicaKwadraty extends Applet implements Runnable, MouseListener
{
	//zmienna N
	private static final int N = 10;
	Kwadrat[] kwadraty;
	
	//metoda init()
	@Override
	public void init()
	{
		setBackground(Color.white);		//tlo
		
		Dimension d = getSize();		//rozmiar kwadratow
		
		kwadraty = new Kwadrat[N];
		for(int i=0; i<N; i++)
		{
			kwadraty[i] = new Kwadrat(d);		
		}
		
		addMouseListener(this);		//klik mysza
		
		//Thread - wyjatek
		Thread w = new Thread(this);
		w.start();
	}
	
	//metoda paint(Graphics g)
	@Override
	public void paint(Graphics g)
	{
		for(Kwadrat k: kwadraty)
		{
			k.rysuj(g);
		}
	}
	
	//metoda run()
	@Override
	public void run()
	{
		while(true)
		{
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			Dimension d = getSize();
			
			for(Kwadrat k : kwadraty)
			{
				k.zwieksz(d);
			}
			repaint();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
		{
			System.out.println("lewy");
			
			for(Kwadrat k: kwadraty)
			{
				if(k.zawiera(e.getX(), e.getY()))
				{
					k.zmienKolor();
					repaint();
				}
				
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
