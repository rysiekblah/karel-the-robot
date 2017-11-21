package com.kozlowst.karel.message

import com.kozlowst.karel.ApiTestSpec


class CmdArgumentsParsingTest extends ApiTestSpec(classOf[CommandParser]) {

  val parser = new CommandParser

  it should "throw exception when size is missing in -G command" in {
    intercept[IllegalArgumentException] {
      parser.processMessage("-G")
    }
  }

  it should "throw exception when one argument is missing in -G command" in {
    intercept[IllegalArgumentException] {
      parser.processMessage("-G 1")
    }
  }

  it should "throw exception when X is not a number in -G command" in {
    intercept[NumberFormatException] {
      parser.processMessage("-G X 2")
    }
  }

  it should "throw exception when Y is not a number in -G command" in {
    intercept[NumberFormatException] {
      parser.processMessage("-G 1 Y")
    }
  }

  it should "throw exception when direction missing in Robot command" in {
    intercept[IllegalArgumentException] {
      parser.processMessage("-R 1 2")
    }
  }

  it should "throw exception when direction and avenue is missing in Robot command" in {
    intercept[IllegalArgumentException] {
      parser.processMessage("-R 1")
    }
  }

  it should "throw exception when arguments missing in Robot command" in {
    intercept[IllegalArgumentException] {
      parser.processMessage("-R")
    }
  }

}
