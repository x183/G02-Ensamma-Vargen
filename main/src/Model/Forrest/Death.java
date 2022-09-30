package Model.Forrest;

import java.util.ArrayList;
import java.util.List;

//An event where a choice you have made killed you, or you lost a battle
public class Death extends Event
{
    public Death()
    {
        eventText = "You died, sorry!\nWould you like to try again?";
        choices = new ArrayList<>();
        choiceEvents = new ArrayList<>();
    }
}
