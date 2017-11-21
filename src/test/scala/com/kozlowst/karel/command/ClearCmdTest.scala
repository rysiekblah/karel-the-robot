package com.kozlowst.karel.command

import java.awt.Graphics2D

import com.kozlowst.karel.ApiTestSpec
import com.kozlowst.karel.world.World
import org.mockito.Mockito
import org.mockito.Mockito.reset

class ClearCmdTest extends ApiTestSpec(classOf[ClearCmd]) {

  val world:World = Mockito.mock(classOf[World])
  val g2d:Graphics2D = Mockito.mock(classOf[Graphics2D])

  override def beforeEach(): Unit = {
    super.beforeEach()
    reset(g2d)
  }

  "Executing Clear command graphics" should "call clear method with width and heigh values" in {
    Mockito.when(world.getWidth).thenReturn(30)
    Mockito.when(world.getHeigh).thenReturn(10)
    (new ClearCmd).execute(g2d, world)
    Mockito.verify(g2d).clearRect(0, 0, 30, 10)
  }

}
