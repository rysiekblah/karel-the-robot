package com.kozlowst.karel.message

import org.scalatest.{FlatSpec, GivenWhenThen, Matchers}

//@RunWith(classOf[JUnitRunner])
class CommandParserCmdTypeTest extends FlatSpec with Matchers with GivenWhenThen {

  "Parser getting a supported command" should "create a MessageDescriptor object with correct Type" in {
    Given("a parser")
    val parser = new CommandParser

    When("Parser gets a -W command")
    val cmdW = parser.processMessage("-W 3 5 1")

    Then("MessageDescriptor should be returned")
    cmdW shouldBe a [MessageDescriptor]
    cmdW.getType should equal (MessageType.Wall)

    When("Parser gets a -G command")
    val cmdG = parser.processMessage("-G 1 1")
    Then("MessageDescriptor should be returned")
    cmdG shouldBe a [MessageDescriptor]
    cmdG.getType should equal (MessageType.World)

    When("Parser gets a -B command")
    val cmdB = parser.processMessage("-B 1 1 3")
    Then("MessageDescriptor should be returned")
    cmdB shouldBe a [MessageDescriptor]
    cmdB.getType should equal (MessageType.Beeper)

    When("Parser gets a -T command")
    val cmdL = parser.processMessage("-T L")
    Then("MessageDescriptor should be returned")
    cmdL shouldBe a [MessageDescriptor]
    cmdL.getType should equal (MessageType.Turn)

  }

  it should "produce IllegalArgumentException if not supported command comes" in {
    intercept[IllegalArgumentException] {
      (new CommandParser).processMessage("a")
    }
  }

  it should "produce IllegalArgumentException if empty command string comes" in {
    intercept[IllegalArgumentException] {
      (new CommandParser).processMessage("")
    }
  }

}
