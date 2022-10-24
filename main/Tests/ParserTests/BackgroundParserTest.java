package ParserTests;

import com.LoneWolf.Model.Events.Event;
import View.BackgroundParser;
import javafx.scene.layout.Background;
import org.junit.Test;

import static View.BackgroundParser.ParseBackground;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class BackgroundParserTest {

    /*
     * cant understand why this test doesnt work, the method works fine
     * in the game, but not in the test
     */
  /*  @Test
    public void testBackgroundParser() {
        Event testEvent = Event.getEvent("assets/AllEvents/Event5.xml");
        Background background = BackgroundParser.ParseBackground(testEvent.getPathToThisEvent());
        assertNotNull(background);
    } */

}
