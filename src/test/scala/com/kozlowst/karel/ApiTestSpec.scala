package com.kozlowst.karel

import org.junit.runner.RunWith
import org.mockito.MockitoAnnotations
import org.scalatest.junit.JUnitRunner
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{BeforeAndAfterEach, FlatSpec, Matchers}

@RunWith(classOf[JUnitRunner])
abstract class ApiTestSpec(clazz: Class[_]) extends FlatSpec with Matchers with MockitoSugar with BeforeAndAfterEach {

  behavior of clazz.getSimpleName

  override protected def beforeEach(): Unit = MockitoAnnotations.initMocks(this)

}
