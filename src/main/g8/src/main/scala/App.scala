import smoke._
import com.typesafe.config.ConfigFactory

object BasicExampleApp extends App {
    val smoke = new BasicExampleSmoke
}

class BasicExampleSmoke extends Smoke {
    val config = ConfigFactory.load().getConfig("smoke")
    val executionContext = scala.concurrent.ExecutionContext.global

    onRequest {
        case GET(Path("/example")) ⇒ reply {
            Thread.sleep(1000)
            Response(Ok, body = "It took me a second to build this response.\n")
        }
        case _ ⇒ reply(Response(NotFound))
    }
}
