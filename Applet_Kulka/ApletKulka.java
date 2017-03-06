package Applet_Kulka;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

/**
 * Aplet z kolorową kulką
 * @author jurczyk
 */
public class ApletKulka extends Applet implements Runnable, MouseListener {

	//ten aplet dodaje czerwone kulki lewym, a niebieskie prawym przyciskiem
	
	//Kulka[] tablica; // atrybut - tablica kulek
	ArrayList<Kulka> lista;

	/**
	 * Wywoływana raz, przy starcie apletu
	 * @see java.applet.Applet#init()
	 */
	@Override
	public void init() {
		int N = 10;		
		String ile = getParameter("ILE_KULEK");
		if(ile != null){
			try{
				N = Integer.parseInt(ile);
			}catch(NumberFormatException ex){				
				System.err.println("Błędna wartość parametru");
			}
		}
		
		Dimension d = getSize();
		
		//tablica = new Kulka[N];
		lista = new ArrayList<Kulka>(N);
		
		for(int i = 0; i < N; i++)
			lista.add(new Kulka(30, d));
			//tablica[i] = new Kulka(30, d);
		
		addMouseListener(this);
		
		new Thread(this).start();
	}

	/** 
	 * Wywoływana, gdy aplet potrzebuje być odrysowany
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	@Override
	public void paint(Graphics g) {
		for(Kulka k : lista)
			k.rysuj(g);
	}

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			Dimension d = getSize();
			for(Kulka k : lista)
				k.przesun(d);
			repaint();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == e.BUTTON1)
			lista.add(new Kulka(10, Color.RED, e.getX(), e.getY()));
		else if(e.getButton() == e.BUTTON3)
			lista.add(new Kulka(10, Color.BLUE, e.getX(), e.getY()));
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println(e);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		System.out.println(e);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println(e);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println(e);
	}
}
