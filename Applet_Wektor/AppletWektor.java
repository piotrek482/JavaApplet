package Applet_Wektor;

import java.applet.Applet;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by piotrek13 on 03.12.2016.
 */
public class AppletWektor extends Applet implements MouseListener
{
    //zmienna N - ilosc kol i wektorow
    private static final int N = 10;
    Wektor[] wektory;

    //metoda init()
    public void init()
    {
        setBackground( Color.white );       //ustawienie tła na biłe

        Dimension d = getSize();            //pobranie wymiarów

        wektory = new Wektor[N];            //utworzenie tablicy obiektow

        for(int i=0; i<N; i++)
        {
            wektory[i] = new Wektor(d);
        }

        addMouseListener(this);             //obsługa myszy

        Thread w = new Thread();        //wyaatek
        w.start();
    }

    @Override
    public void paint(Graphics g)
    {
        for(Wektor w: wektory)
        {
            w.rysuj( g );
        }
    }



    @Override
    public void mouseClicked(MouseEvent e)
    {
        if(e.getButton() == MouseEvent.BUTTON1)
        {
            System.out.print( "Lewy przycisk myszy" );

            for(Wektor w: wektory)
            {
                    w.przesun( e, e.getX(), e.getY() );
            }
                repaint();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}
