package Model.Forrest;

import java.util.List;

//Paret class for all kinds of things that can happen in the game
//An event is always triggered when the player moves to another part of the story
public abstract class Event {
    String eventText;
    List<String> choices;
    List<Event> choiceEvents;

    public Event nextEvent(int choice)
    {
        return choiceEvents.get(choice);
    }

    public List<Event> getChoiceEvents()
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
