
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import com.cm6123.monopoly.game.Board;
import com.cm6123.monopoly.game.Property;

import org.junit.jupiter.api.Test;
public class BoardTest {

    @Test
    public void testProperties() {
        // Create an ArrayList of Property objects
        ArrayList<Property> properties = new ArrayList<>();
        // Add a Property object to the ArrayList
        Board.createProperties(properties);
        // given that the board is created the test Check that the ArrayList has 16 elements
        assertEquals(16, properties.size());
        // Check that the first element in the ArrayList has the name "Home"
        assertEquals("Home", properties.get(0).getName());
        // Check that the colour group of the last element in the ArrayList is "Grey"
        assertEquals("Grey", properties.get(15).getColourGroup());
    }



}
