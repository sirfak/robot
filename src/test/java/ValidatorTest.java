import com.whispir.model.Validator;
import com.whispir.exception.InvalidCommandException;
import org.junit.Assert;
import org.junit.Test;

public class ValidatorTest {

    Validator validator = new Validator();
    @Test
    public void it_should_return_true_for_move_command()
    {

        boolean isValid=validator.validateCommand("MOVE");
        Assert.assertTrue(isValid);
    }

    @Test
    public void it_should_return_true_for_right_command()
    {
        boolean isValid=validator.validateCommand("RIGHT");
        Assert.assertTrue(isValid);
    }

    @Test
    public void it_should_return_true_for_left_command()
    {
        boolean isValid=validator.validateCommand("LEFT");
        Assert.assertTrue(isValid);
    }

    @Test
    public void it_should_return_true_for_report_command()
    {
        boolean isValid=validator.validateCommand("REPORT");
        Assert.assertTrue(isValid);
    }

    @Test
    public void it_should_return_true_for_place_command()
    {
        boolean isValid=validator.validateCommand("PLACE 0,0,NORTH");
        Assert.assertTrue(isValid);
    }

    @Test
    public void it_should_fail_for_invalid_direction_in_place_command()
    {
        boolean isValid=validator.validateCommand("PLACE 0,0,blabla");
        Assert.assertFalse(isValid);
    }

    @Test(expected = InvalidCommandException.class)
    public void it_should_fail_for_invalid_position_in_place_command()
    {
        boolean isValid=validator.validateCommand("PLACE a,b,NORTH");
        Assert.assertFalse(isValid);
    }

}
