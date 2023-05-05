
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import com.cm6123.monopoly.game.Board;
import com.cm6123.monopoly.game.Property;

import org.junit.jupiter.api.Test;
public class BoardTest {

    @Test
    public void testProperties() {
        //given that the board is created
        ArrayList<Property> properties = new ArrayList<>();
        Board.createProperties(properties);
        //then the board should have 16 properties
        assertEquals(16, properties.size());
        //and the first property should be "Home"
        assertEquals("Home", properties.get(0).getName());
       //and the las property colour group should be "Grey"
        assertEquals("Grey", properties.get(15).getColourGroup());
    }

}
