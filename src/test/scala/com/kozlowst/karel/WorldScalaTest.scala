
import com.kozlowst.karel.world.World
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FlatSpec, GivenWhenThen, Matchers}

@RunWith(classOf[JUnitRunner])
class WorldScalaTest extends FlatSpec with Matchers with GivenWhenThen {
  "A world" should "be created" in {
    Given("The something")
    val w = new World
    assert(w != null)
    assume(true)
    println("yep")

    assertDoesNotCompile("val a:String = 1")


  }
}