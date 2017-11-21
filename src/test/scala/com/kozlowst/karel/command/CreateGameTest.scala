package com.kozlowst.karel.command

import java.awt.Graphics2D

import com.kozlowst.karel.ApiTestSpec
import com.kozlowst.karel.world.World
import org.mockito.ArgumentMatchers._
import org.mockito.Mockito
import org.mockito.Mockito._

class CreateGameTest extends ApiTestSpec(classOf[CreateGameCmd]) {

  val world:World = Mockito.mock(classOf[World])
  val g2d:Graphics2D = Mockito.mock(classOf[Graphics2D])

  override def beforeEach(): Unit = {
    super.beforeEach()
    reset(g2d)
  }

  "With height=500 and width=500 and streets=5 and avenues=5" should "draw 10 lines" in {
    Mockito.when(world.getHeigh).thenReturn(500)
    Mockito.when(world.getWidth).thenReturn(500)
    val cmd = new CreateGameCmd(5,5)
    cmd.execute(g2d, world)
    Mockito.verify(g2d, times(10)).drawLine(anyInt(), anyInt(), anyInt(), anyInt())
  }

  "When streets=1 and avenue=1" should "draw 1 horizontal and one vertical line in a middle" in {
    Mockito.when(world.getHeigh).thenReturn(500)
    Mockito.when(world.getWidth).thenReturn(500)
    val cmd = new CreateGameCmd(1,1)
    cmd.execute(g2d, world)
    Mockito.verify(g2d, times(1)).drawLine(world.getWidth/2, 0, world.getWidth/2, world.getHeigh)
    Mockito.verify(g2d, times(1)).drawLine(0, world.getHeigh/2, world.getWidth, world.getHeigh/2)
  }

  "When streets=2 and avenue=2" should "draw 2 horizontal and 2 vertical lines" in {
    Mockito.when(world.getHeigh).thenReturn(500)
    Mockito.when(world.getWidth).thenReturn(500)
    Mockito.when(world.getGranulation).thenReturn(100)
    val cmd = new CreateGameCmd(2,2)
    cmd.execute(g2d, world)

    // >|<  |
    Mockito.verify(g2d).drawLine(50, 0, 50, 500)

    //  |  >|<
    Mockito.verify(g2d).drawLine(450, 0, 450, 500)

    //  --
    // >--<
    Mockito.verify(g2d).drawLine(0, 50, 500, 50)

    // >--<
    //  --
    Mockito.verify(g2d).drawLine(0, 450, 500, 450)
  }

}
