package Model.Events;

import java.util.ArrayList;

//An event where a choice you have made killed you, or you lost a battle
public class Death extends Events
{
    public Death()
    {
        eventText = "You died, sorry!\nWould you like to try again?";
        choices = new ArrayList<>();
        choiceEvents = new ArrayList<>();
    }
}
