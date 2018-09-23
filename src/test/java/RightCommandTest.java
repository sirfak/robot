import com.whispir.CommandProcessor;
import com.whispir.ICommandProcessor;
import com.whispir.Position;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class RightCommandTest {
    @Test
    public void it_should_turn_SOUTH_from_EAST_on_right_command()
    {
        String command="RIGHT";
        Position currentPostion=new Position(1,1,"EAST");
        ICommandProcessor cProc= new CommandProcessor() ;
        Position nextPostion=cProc.right(currentPostion);
        assertTrue(nextPostion.getX()==1);
        assertTrue(nextPostion.getY()==1);
        assertTrue(nextPostion.getFacing().equals("SOUTH"));


    }

    @Test
    public void it_should_turn_WEST_from_SOUTH_on_right_command()
    {
        String command="RIGHT";
        Position currentPostion=new Position(1,1,"SOUTH");
        ICommandProcessor cProc= new CommandProcessor() ;
        Position nextPostion=cProc.right(currentPostion);
        assertTrue(nextPostion.getX()==1);
        assertTrue(nextPostion.getY()==1);
        assertTrue(nextPostion.getFacing().equals("WEST"));


    }

    @Test
    public void it_should_turn_NORTH_from_WEST_on_right_command()
    {
        String command="RIGHT";
        Position currentPostion=new Position(1,1,"WEST");
        ICommandProcessor cProc= new CommandProcessor() ;
        Position nextPostion=cProc.right(currentPostion);
        assertTrue(nextPostion.getX()==1);
        assertTrue(nextPostion.getY()==1);
        assertTrue(nextPostion.getFacing().equals("NORTH"));


    }

    @Test
    public void it_should_turn_EAST_from_NORTH_on_right_command()
    {
        String command="RIGHT";
        Position currentPostion=new Position(1,1,"NORTH");
        ICommandProcessor cProc= new CommandProcessor() ;
        Position nextPostion=cProc.right(currentPostion);
        assertTrue(nextPostion.getX()==1);
        assertTrue(nextPostion.getY()==1);
        assertTrue(nextPostion.getFacing().equals("EAST"));


    }
}
