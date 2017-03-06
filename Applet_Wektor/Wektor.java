package Applet_Wektor;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * Created by piotrek13 on 03.12.2016.
 */
public class Wektor
{
    //zmienne
    private int promien_kola = 10;
    private int poczatek_x, poczatek_y;
    private Color kolor;

    //zmienne dla wektora
    private int dlugosc;

    //konstruktor
    public Wektor(Dimension d)
    {
        Random r = new Random();        //zmienna r - losowanie

        kolor = new Color(r.nextFloat(), r.nextFloat(), r.nextFloat());     //losowanie koloru

        poczatek_x = r.nextInt(d.width - promien_kola);       //losowanie poczatku wektora i srodka koła
        poczatek_y = r.nextInt(d.height - promien_kola);

        dlugosc = r.nextInt(50);
    }

    //metoda rysuj(Graphics g)
    public void rysuj(Graphics g)
    {
        g.setColor(kolor);
        g.fillOval( poczatek_x, poczatek_y, promien_kola, promien_kola );

        g.setColor(Color.red);
        g.fillRect( poczatek_x+(promien_kola/2), poczatek_y+(promien_kola/2), dlugosc, 2 );
    }

//    public boolean zawiera(int xMouse, int yMouse)
//    {
////        if(xMouse <= poczatek_x || yMouse <= poczatek_y)
////        {
////           return true;
////        }
////        else
////        {
////            return false;
////        }
//        return true;
//    }

    public void przesun(MouseEvent e, int xMouse, int yMouse)
    {
        poczatek_x = xMouse;
        poczatek_y = yMouse;
    }
}
