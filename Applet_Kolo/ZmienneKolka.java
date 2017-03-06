package Applet_Kolo;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ZmienneKolka extends Applet implements Runnable, MouseListener
{
	//zmienne
	private static final int N = 10;
	private Kolko[] kolka;
	
	//metoda init()
	@Override 
	public void init()
	{
		setBackground(Color.yellow);		//zmiana koloru t³a na ¿ó³ty
		
		Dimension d = getSize();			//pobranie rozmiaru
		
		kolka = new Kolko[N];				//inicjalizacja obiektów
		
		for(int i=0; i<N; i++)
		{
			kolka[i] = new Kolko(d);		//przypisanie obiektom rozmiarów
		}
		
		addMouseListener(this);
		
		Thread w = new Thread(this);		//utworzenie wyj¹tku
		w.start();
	}
	
	//metoda paint(Graphich g)
	public void paint(Graphics g)
	{
		for(Kolko k: kolka)
		{
			k.rysuj(g);
		}
	}

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
			
			for(Kolko k: kolka)
			{
				k.zmienRozmiar(d);
			}
			
			repaint();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3)
		{
			System.out.println("prawy");		//wyswietla info ze prawy
			
			for(Kolko k: kolka)					//sprawdzamy dla kazdego elementu/kolka
			{
				if( k.zawiera(e.getX(), e.getY()) )		//pobieramy X i Y po³o¿enia myszki/kursora
				{
					k.zmienKolor();
				}
				repaint();
			}
			
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
