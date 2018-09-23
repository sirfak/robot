import com.whispir.CommandProcessor;
import com.whispir.ICommandProcessor;
import com.whispir.Position;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ReportCommandTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    @Before
    public void setSystout()
    {
        System.setOut(new PrintStream(outContent));
    }
    @Test
    public void it_should_report_current_position()
    {

        String command="REPORT";
        Position currentPostion=new Position(1,1,"SOUTH");
        ICommandProcessor cProc= new CommandProcessor() ;
        Position nextPostion=cProc.report(currentPostion);

        String expected="The robot is currently at 1,1 and facing SOUTH";
        assertEquals(expected,nextPostion.toString());
        assertEquals(expected,outContent.toString());



        assertTrue(nextPostion.getX()==1);
        assertTrue(nextPostion.getY()==1);
        assertTrue(nextPostion.getFacing().equals("SOUTH"));
    }
}
