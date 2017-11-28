package com.kozlowst.karel.handler

import com.kozlowst.karel.ApiTestSpec
import com.kozlowst.karel.command._
import com.kozlowst.karel.executor.CommandExecutor
import com.kozlowst.karel.handler.MessageHandlerTest.TestConfig
import org.mockito.ArgumentMatchers._
import org.mockito.Mockito
import org.mockito.Mockito._
import org.scalatest.{BeforeAndAfter, BeforeAndAfterEach}
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation._
import org.springframework.test.context.{ContextConfiguration, TestContextManager}

@ContextConfiguration(
  classes = Array(classOf[TestConfig])
)
class MessageHandlerTest extends ApiTestSpec(classOf[MessageHandler]) with BeforeAndAfter with BeforeAndAfterEach {

  @Autowired
  val handler: MessageHandler = null

  before {
    new TestContextManager(this.getClass()).prepareTestInstance(this)
  }

  override def beforeEach() = {
    super.beforeEach()
    reset(MessageHandlerTest.ex)
  }

  it should "publish CreateWorldMatrix command to executor" in {
    handler.handleMessage("-G 4 4")
    verify(MessageHandlerTest.ex, times(1)).publishCommand(isA(classOf[CreateGameCmd]))
  }

  it should "publish DrawWall command when gets -W x1y1x2y2" in {
    handler.handleMessage("-W 1 2 3 4")
    verify(MessageHandlerTest.ex, times(1)).publishCommand(isA(classOf[DrawWallCmd]))
  }

  it should "publish CreateRobot command when gets -R x y d" in {
    handler.handleMessage("-R 1 2 1")
    verify(MessageHandlerTest.ex, times(1)).publishCommand(isA(classOf[PutRobotCmd]))
  }

  it should "publish PutBeeper command when gets -B x y n" in {
    handler.handleMessage("-B 1 2 3")
    verify(MessageHandlerTest.ex, times(1)).publishCommand(isA(classOf[PutBeepersCmd]))
  }

  it should "publish Move command when gets a -M" in {
    handler.handleMessage("-M")
    verify(MessageHandlerTest.ex, times(1)).publishCommand(isA(classOf[MoveCmd]))
  }

  it should "publish Turn command when gets -T side" in {
    handler.handleMessage("-T L")
    verify(MessageHandlerTest.ex, times(1)).publishCommand(isA(classOf[TurnCmd]))
  }

}

object MessageHandlerTest {

  val ex: CommandExecutor = Mockito.mock(classOf[CommandExecutor])

  @Configuration
  @ComponentScan(
    basePackages=Array("com.kozlowst.karel"),
    excludeFilters = Array(new ComponentScan.Filter(`type` = FilterType.REGEX, pattern=Array("com.kozlowst.karel.ui.*")))
  )
  @PropertySource(Array("classpath:properties/ui.properties"))
  class TestConfig {
    @Bean def commandExec:CommandExecutor = ex
  }

}
