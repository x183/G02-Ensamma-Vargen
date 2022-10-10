package View;

import Model.Entities.Player;
import Model.Model;
import Model.Events.*;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

//Dumb class for making the project run in the terminal :)
public class CLI {
    public static void main (String[] args ) throws IOException
    {
        System.out.println("Welcome to the Lone Wolf!\nPress any key to begin your adventure");

        //Console cons = System.console();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();

        Event startEvent = EventParser.parse("assets/AllEvents/startEvent.xml");

        Model model = new Model(new Player(2, 8, 1, "Vargis"), startEvent);

        String keyPressed;
      /*  while (false)
        {
            pressedKey = cons.readLine();
            System.out.println("");

        }
       */
    }



}
