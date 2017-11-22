package feature.newgame;

import com.kozlowst.karel.command.CreateGameCmd;
import com.kozlowst.karel.command.DrawWallCmd;
import com.kozlowst.karel.executor.CommandExecutor;
import com.kozlowst.karel.handler.Handler;
import com.kozlowst.karel.message.Direction;
import com.kozlowst.karel.message.MessageType;
import com.kozlowst.karel.world.World;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.awt.*;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/context.xml")
public class NewGameSteps {

    @Mock
    private CommandExecutor commandExecutor;

    @Mock
    private Graphics2D graphics2D;

    @Autowired
    private World world;

    @Autowired
    @InjectMocks
    private Handler handler;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Given("^a message handler and window properties width='(\\d+)' heigh='(\\d+)' granulation='(\\d+)'")
    public void testGiven(int width, int heigh, int granulation) {

        ReflectionTestUtils.setField(world, "heigh", heigh);
        ReflectionTestUtils.setField(world, "width", width);
        ReflectionTestUtils.setField(world, "granulation", granulation);

        assertNotNull(handler);
    }

    @When("^a user provides '(\\d+)' streets and '(\\d+)' avenues")
    public void testCreateGameCommand(int streets, int avenues) {
        reset(graphics2D);
        doAnswer(invocation -> {
                    CreateGameCmd cmd = invocation.getArgument(0);
                    assertNotNull(cmd);
                    cmd.execute(graphics2D, world);
            return null;
        }
        ).when(commandExecutor).publishCommand(any(CreateGameCmd.class));

        ReflectionTestUtils.setField(world, "avenues", avenues);
        ReflectionTestUtils.setField(world, "streets", streets);

        handler.handleMessage(MessageType.World.getCode() + " " + streets + " " + avenues);
    }

    @When("^a user puts a wall at crossroad street: '(\\d+)' and avenue: '(\\d+)' on '(.+)'")
    public void testCreateWallCommand(int street, int avenue, Direction direction) {
        reset(graphics2D);
        doAnswer(invocation -> {
            DrawWallCmd cmd = invocation.getArgument(0);
            assertNotNull(cmd);
            cmd.execute(graphics2D, world);
            return null;
        }).when(commandExecutor).publishCommand(any(DrawWallCmd.class));
        handler.handleMessage(MessageType.Wall.getCode() + " " + street + " " + avenue + " " +  direction.getCode());
    }

    @Then("^drawing should be performed '(\\d+)' times with arguments x1='(\\d+)' y1='(\\d+)' x2='(\\d+)' y2='(\\d+)'")
    public void testRoadsDrawing(int count, int x1, int y1, int x2, int y2) {
        verify(graphics2D, times(count)).drawLine(x1, y1, x2, y2 );
    }

    @Then("^drawing lines should be performed '(\\d+)' times")
    public void testDrawingCalls(int count) {
        verify(graphics2D, times(count)).drawLine(anyInt(), anyInt(), anyInt(), anyInt());
    }


}
