package Applet_Krzyzyk;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ApletKrzyzyk extends Applet implements Runnable, MouseListener
{
	private static final int N = 10;
	private Krzyzyk[] krzyzyki;
	
	@Override
	public void init()
	{
		setBackground(Color.yellow);
		
		Dimension d = getSize();
		
		krzyzyki = new Krzyzyk[N];
		
		for(int i=0; i<N; i++)
		{
			krzyzyki[i] = new Krzyzyk(d);
		}
		
		addMouseListener(this);
		
		Thread w = new Thread(this);
		w.start();
		
	}
	
	@Override
	public void paint(Graphics g)
	{
		for(Krzyzyk k: krzyzyki)
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			Dimension d = getSize();
			
			for(Krzyzyk k : krzyzyki)
			{
				k.przesun(d);
			}
			repaint();
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) 
	{
		if(e.getButton() == MouseEvent.BUTTON1)
		{
			System.out.println("lewy");
			
			for(Krzyzyk k: krzyzyki)
			{
				if(k.blisko(e.getX(), e.getY()))
				{
					k.zmienKolor();
				}
			}
			repaint();
		}
		else if(e.getButton() == MouseEvent.BUTTON3)
		{
			for(Krzyzyk k : krzyzyki)
			{
				k.resetKolor();
			}
			repaint();
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
