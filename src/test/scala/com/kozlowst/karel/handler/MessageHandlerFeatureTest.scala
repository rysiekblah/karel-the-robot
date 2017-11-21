package com.kozlowst.karel.handler

import java.awt.Graphics2D

import com.kozlowst.karel.command.CreateGameCmd
import com.kozlowst.karel.handler.MessageHandlerTest.TestConfig
import com.kozlowst.karel.message.MessageType
import com.kozlowst.karel.world.World
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers._
import org.mockito.Mockito
import org.mockito.Mockito._
import org.mockito.invocation.InvocationOnMock
import org.scalatest.junit.JUnitRunner
import org.scalatest.mockito.MockitoSugar
import org.scalatest._
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.{ContextConfiguration, TestContextManager}
import org.springframework.test.util.ReflectionTestUtils

@RunWith(classOf[JUnitRunner])
@ContextConfiguration(
  classes = Array(classOf[TestConfig])
)
class MessageHandlerFeatureTest extends FeatureSpec with GivenWhenThen with Matchers with MockitoSugar  with BeforeAndAfter with BeforeAndAfterEach {

  @Autowired val handler: MessageHandler = null
  @Autowired val world: World = null

  val g2d:Graphics2D = Mockito.mock(classOf[Graphics2D])

  before {
    new TestContextManager(this.getClass()).prepareTestInstance(this)
  }

  info("Set of features related to new game creation")

  feature("User can create a new game with given number of streets and avenues") {
    scenario("If user gives 0 streets and 0 avenues no drawing should be performed") {
      Given("a message handler and window properties width='500' heigh='500' granulation='100'")
      ReflectionTestUtils.setField(world, "heigh", 500)
      ReflectionTestUtils.setField(world, "width", 500)
      ReflectionTestUtils.setField(world, "granulation", 100)

      When("a user provides '0' streets and '0' avenues")
      doAnswer((invocation: InvocationOnMock) => {
        val cmd:CreateGameCmd = invocation.getArgument(0)
        assert(cmd != null)
        cmd.execute(g2d, world)
      })
        .when(MessageHandlerTest.ex).publishCommand(any(classOf[CreateGameCmd]))
      ReflectionTestUtils.setField(world, "avenues", 0)
      ReflectionTestUtils.setField(world, "streets", 0)
      handler.handleMessage(MessageType.World.getCode + " " + 0 + " " + 0)

      Then("drawing lines should be performed '0' times")
      verify(g2d, times(0)).drawLine(anyInt(), anyInt(), anyInt(), anyInt())
    }
  }


}
