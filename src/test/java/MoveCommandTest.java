import com.whispir.CommandProcessor;
import com.whispir.ICommandProcessor;
import com.whispir.Position;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MoveCommandTest {
    @Test
    public void it_should_move_one_unit_north_without_changing_direction()
    {
        String command="MOVE";
        ICommandProcessor cProc= new CommandProcessor() ;
        Position currentPostion=new Position(1,1,"NORTH");
        Position pos=cProc.move(currentPostion);
        assertTrue(pos.getX()==1);
        assertTrue(pos.getY()==2); // moves north ie y axis
        assertTrue(pos.getFacing().equals("NORTH"));


    }

    @Test
    public void it_should_move_one_unit_south_without_changing_direction()
    {
        String command="MOVE";
        ICommandProcessor cProc= new CommandProcessor() ;
        Position currentPostion=new Position(1,1,"SOUTH");
        Position pos=cProc.move(currentPostion);
        assertTrue(pos.getX()==1);
        assertTrue(pos.getY()==0); // moves south ie y axis
        assertTrue(pos.getFacing().equals("SOUTH"));


    }

    @Test
    public void it_should_move_one_unit_east_without_changing_direction()
    {
        String command="MOVE";
        ICommandProcessor cProc= new CommandProcessor() ;
        Position currentPostion=new Position(1,1,"EAST");
        Position pos=cProc.move(currentPostion);
        assertTrue(pos.getX()==2);
        assertTrue(pos.getY()==1); // moves east ie x axis
        assertTrue(pos.getFacing().equals("EAST"));


    }

    @Test
    public void it_should_move_one_unit_west_without_changing_direction()
    {
        String command="MOVE";
        ICommandProcessor cProc= new CommandProcessor() ;
        Position currentPostion=new Position(1,1,"WEST");
        Position pos=cProc.move(currentPostion);
        assertTrue(pos.getX()==0);
        assertTrue(pos.getY()==1); // moves west ie x axis
        assertTrue(pos.getFacing().equals("WEST"));
    }
}
