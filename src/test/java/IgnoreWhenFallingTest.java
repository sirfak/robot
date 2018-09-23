import com.whispir.CommandProcessor;
import com.whispir.ICommandProcessor;
import com.whispir.model.Position;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IgnoreWhenFallingTest {
    @Test
    public void it_should_ignore_Command_to_move_north_from_0_5()
    {
        String command="MOVE";
        Position currentPostion = new Position(0,5,"NORTH");
        ICommandProcessor cProc= new CommandProcessor() ;
        Position pos=cProc.move(currentPostion);
        assertTrue(pos.getX()==0);
        assertTrue(pos.getY()==5);
        assertTrue(pos.getFacing().equals("NORTH"));
    }

    @Test
    public void it_should_ignore_Command_to_move_west_from_0_5()
    {
        String command="MOVE";
        Position currentPostion = new Position(0,5,"WEST");
        ICommandProcessor cProc= new CommandProcessor() ;
        Position pos=cProc.move(currentPostion);
        assertTrue(pos.getX()==0);
        assertTrue(pos.getY()==5);
        assertTrue(pos.getFacing().equals("WEST"));
    }

    @Test
    public void it_should_ignore_command_to_move_south_from_0_0()
    {
        String command="MOVE";
        Position currentPostion = new Position(0,0,"SOUTH");
        ICommandProcessor cProc= new CommandProcessor() ;
        Position pos=cProc.move(currentPostion);
        assertTrue(pos.getX()==0);
        assertTrue(pos.getY()==0);
        assertTrue(pos.getFacing().equals("SOUTH"));
    }

    @Test
    public void it_should_ignore_command_to_move_west_from_0_0()
    {
        String command="MOVE";
        Position currentPostion = new Position(0,0,"WEST");
        ICommandProcessor cProc= new CommandProcessor() ;
        Position pos=cProc.move(currentPostion);
        assertTrue(pos.getX()==0);
        assertTrue(pos.getY()==0);
        assertTrue(pos.getFacing().equals("WEST"));
    }
    @Test
    public void it_should_ignore_command_to_move_east_from_5_0()
    {
        String command="MOVE";
        Position currentPostion = new Position(5,0,"EAST");
        ICommandProcessor cProc= new CommandProcessor() ;
        Position pos=cProc.move(currentPostion);
        assertTrue(pos.getX()==5);
        assertTrue(pos.getY()==0);
        assertTrue(pos.getFacing().equals("EAST"));
    }

    @Test
    public void it_should_ignore_command_to_move_south_from_5_0()
    {
        String command="MOVE";
        Position currentPostion = new Position(5,0,"SOUTH");
        ICommandProcessor cProc= new CommandProcessor() ;
        Position pos=cProc.move(currentPostion);
        assertTrue(pos.getX()==5);
        assertTrue(pos.getY()==0);
        assertTrue(pos.getFacing().equals("SOUTH"));
    }

    @Test
    public void it_should_ignore_command_to_move_north_from_5_5()
    {
        String command="MOVE";
        Position currentPostion = new Position(5,5,"NORTH");
        ICommandProcessor cProc= new CommandProcessor() ;
        Position pos=cProc.move(currentPostion);
        assertTrue(pos.getX()==5);
        assertTrue(pos.getY()==5);
        assertTrue(pos.getFacing().equals("NORTH"));
    }

    @Test
    public void it_should_ignore_command_to_move_east_from_5_5()
    {
        String command="MOVE";
        Position currentPostion = new Position(5,5,"EAST");
        ICommandProcessor cProc= new CommandProcessor() ;
        Position pos=cProc.move(currentPostion);
        assertTrue(pos.getX()==5);
        assertTrue(pos.getY()==5);
        assertTrue(pos.getFacing().equals("EAST"));
    }

}
