package Model.Events;

import java.util.List;

//Paret class for all kinds of things that can happen in the game
//An event is always triggered when the player moves to another part of the story
public abstract class EventSuper {
    String eventText;
    List<String> choices;
    List<EventSuper> choiceEvents;

    public EventSuper nextEvent(int choice)
    {
        return choiceEvents.get(choice);
    }

    public List<EventSuper> getChoiceEvents()
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
