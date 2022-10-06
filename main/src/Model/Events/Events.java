package Model.Events;

import java.util.List;

//Paret class for all kinds of things that can happen in the game
//An event is always triggered when the player moves to another part of the story
public abstract class Events {
    String eventText;
    List<String> choices;
    List<Events> choiceEvents;

    public Events nextEvent(int choice)
    {
        return choiceEvents.get(choice);
    }

    public List<Events> getChoiceEvents()
    {
        return choiceEvents;
    }

    public List<String> getChoices()
    {
        return choices;
    }

    public String getEventText()
    {
        return eventText;
    }
}
