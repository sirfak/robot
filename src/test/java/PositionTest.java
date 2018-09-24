import com.whispir.model.Position;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PositionTest {
    @Test
    public void it_should_return_direction_from_index() {
        Position pos = new Position(0, 0, "NORTH");
        String direction = pos.toFacing(0);
        assertEquals(direction, "EAST");
    }

    @Test
    public void it_should_return_current_direction_if_invalid_index() {
        Position pos = new Position(0, 0, "NORTH");
        String direction = pos.toFacing(20);
        assertEquals(direction, "NORTH");
    }
}

