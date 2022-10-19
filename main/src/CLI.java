import Model.Entities.Player;
import Model.Interfaces.IAction;
import Model.Model;
import Model.Events.*;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

/**
 * Main class for the version of the game that runs in the console.
 * Should be simple to understand, and easy to modify.
 */
public class CLI {
    /**
     * Main method for the version of the game that runs in the console.
     */
    public static void main (String[] args ) throws IOException
    {
        System.out.println("Welcome to the Lone Wolf!\nEnter any symbol into the console to start your adventure!");

        //Console cons = System.console();
        Scanner scanner = new Scanner(System.in);

        Event startEvent = EventParser.parse("assets/AllEvents/startEvent.xml");
        Model model = new Model(new Player(2, 8, 1, "Vargis"), startEvent);
        scanner.nextLine();
        int keyPressed;
        boolean restart = false;

        while (true)
        {
            if(restart){
                startEvent = EventParser.parse("assets/AllEvents/startEvent.xml");
                model = new Model(new Player(2, 8, 1, "Vargis"), startEvent);
                restart = false;
            }
            Event currentEvent = model.getCurrentEvent();
            System.out.println(currentEvent.getEventText());
            List<IAction> choices = currentEvent.getActions();
            for (int i = 0; i < choices.size(); i++)
            {
                System.out.println(i + choices.get(i).getActionName());
            }
            keyPressed = scanner.nextInt();
            if(model.getActionName(keyPressed).equals(" Restart")){
                restart = true;
            } else if(model.getActionName(keyPressed).equals(" Quit Game")) {
                System.out.println("Thank you for playing the Lone Wolf!");
                break;
            } else
                model.selectAction(keyPressed);
        }

    }



}
