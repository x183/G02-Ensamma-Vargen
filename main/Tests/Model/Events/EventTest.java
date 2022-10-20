package Model.Events;
import Model.Interfaces.IAction;
import Model.Interfaces.util.IObserver;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EventTest {

    @Test
    public void selectActionTest(){
    Event testEvent = Event.getEvent("assets/AllEvents/TestEvent1.xml");
    TestObserver<IAction> hej = new TestObserver<>();
    testEvent.subscribe(hej);
    testEvent.selectAction(0);
    assertEquals(hej.getReceived().getActionName(), testEvent.getActions().get(0).getActionName());
    }


}
class TestObserver<T> implements IObserver<T> {
    private T receivedT;
    @Override
    public void update(T t) {
        receivedT = t;
    }
    public T getReceived(){
        return receivedT;
    }
}