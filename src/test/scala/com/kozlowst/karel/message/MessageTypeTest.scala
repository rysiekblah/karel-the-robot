package com.kozlowst.karel.message

import org.scalatest.FunSuite

class MessageTypeTest extends FunSuite {

  test("Get a World type by a code") {
    val world = MessageType.getByCode("-G")
    // TODO: read about it
    //assert(world.isInstanceOf[MessageType.World.type])
    assert(world.eq(MessageType.World))
    assert(world.getArgsNum === 2)
    assert(!world.getUsage.isEmpty)
  }

  test("Get a Wall type by a code") {
    val wall = MessageType.getByCode("-W")
    assert(wall.eq(MessageType.Wall))
    assert(wall.getArgsNum === 3)
    assert(!wall.getUsage.isEmpty)
  }

  test("Get a Beeper type by a code") {
    val beeper = MessageType.getByCode("-B")
    assert(beeper.eq(MessageType.Beeper))
    assert(beeper.getArgsNum === 3)
    assert(!beeper.getUsage.isEmpty)
  }

  test("Get a Robot type by type") {
    val robot = MessageType.getByCode("-R")
    assert(robot.eq(MessageType.Robot))
    assert(robot.getArgsNum === 3)
    assert(!robot.getUsage.isEmpty)
  }

  test("Get a Turn type by code") {
    val turn = MessageType.getByCode("-T")
    assert(turn.eq(MessageType.Turn))
    assert(turn.getArgsNum === 1)
    assert(!turn.getUsage.isEmpty)
  }

  test("Get a Move type by a code") {
    val move = MessageType.getByCode("-M")
    assert(move.eq(MessageType.Move))
    assert(move.getArgsNum === 0)
    assert(!move.getUsage.isEmpty)
  }

  test("Get a unknown code") {
    assert(MessageType.getByCode(".") === null)
  }

}
