import com.whispir.CommandProcessor;
import com.whispir.Executor;
import com.whispir.ICommandProcessor;
import com.whispir.exception.InvalidCommandException;
import com.whispir.model.Position;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommandProcessorTest {

    @Test
    public void it_should_return_new_place()
    {
        String command="PLACE 1,0,NORTH";
        ICommandProcessor cProc= new CommandProcessor() ;
        Position pos=cProc.place(null,command);
        assertTrue(pos.getX()==1);
        assertTrue(pos.getY()==0);
        assertTrue(pos.getFacing().equals("NORTH"));


    }

    @Test
    public void it_should_execute_multiple_commands()
    {
        ICommandProcessor commandProcessor = new CommandProcessor();
        Executor executor = new Executor(commandProcessor);

        String commands[]= new  String[]{"PLACE 1,0,EAST","MOVE","LEFT","RIGHT","PLACE 2,3,WEST","REPORT"};
        Position currentPost=new Position(0,0,"SOUTH");



        currentPost=executor.executeCommands(commands);

        assertTrue(currentPost.getX()==2);
        assertTrue(currentPost.getY()==3);
        assertTrue(currentPost.getFacing().equals("WEST"));


    }

    @Test
    public void it_should_ignore_all_commands_until_first_place_command(){

        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ICommandProcessor commandProcessor = new CommandProcessor();
        Executor executor = new Executor(commandProcessor);

        String commands[]= new  String[]{"REPORT","PLACE 1,0,EAST","MOVE","LEFT","RIGHT","PLACE 2,3,WEST"};
        Position currentPost=new Position(0,0,"SOUTH");



        currentPost=executor.executeCommands(commands);


        assertEquals("",outContent.toString()); //REPORT command ignored hence nothing printed
        assertTrue(currentPost.getX()==2);
        assertTrue(currentPost.getY()==3);
        assertTrue(currentPost.getFacing().equals("WEST"));

    }

    @Test
    public void it_should_accept_valid_json_file()
    {
        ICommandProcessor commandProcessor = new CommandProcessor();
        String[] commandArg= new String[] {"command.json"};
        commandProcessor.readCommandFromFile(commandArg);

    }

    @Test(expected = InvalidCommandException.class)
    public void it_should_throw_exception_for_missing_file()
    {
        ICommandProcessor commandProcessor = new CommandProcessor();
        String[] commandArg= new String[] {"command1.json"};
        commandProcessor.readCommandFromFile(commandArg);

    }






}
