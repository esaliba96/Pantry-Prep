package logic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestSuite1 {

    @Test
    public void createAnAchievement() {
        Achievement tester = new Achievement("Name", "A description."); 

        // assert statements
        assertEquals("Name", tester.getName(), "Name must be set to \"Name\".");
        assertEquals("A description.", tester.getDescription(), "Description must be set to \"A description.\".");
        assertEquals("Name", tester.getName(), "Name must be set to \"Name\".");
    }
    
    @Test
    public void achieveAnAchievement() {
        Achievement tester = new Achievement("Name", "A description."); 
        tester.addToProgress(0.5);
        // assert statements
        assertEquals(0.5, tester.getProgress(), "The acheivement progress must be 0.5.");
        assertEquals(false, tester.isAchieved(), "The acheivement must not be completed yet.");
        
        tester.addToProgress(0.5);
        assertEquals(true, tester.isAchieved(), "The acheivement must be completed.");

    }
}