import com.typesafe.config.ConfigFactory
import smoke._

object BasicExampleApp extends SmokeApp with StaticAssets {

  override val smokeConfig = ConfigFactory.load().getConfig("smoke")
  override val executionContext = scala.concurrent.ExecutionContext.global

  override val publicFolder: String = smokeConfig.getString("static-assets.public-dir")
  override val cacheAssets: Boolean = smokeConfig.getBoolean("static-assets.cache-assets")
  override val cacheAssetsPreload: Boolean = smokeConfig.getBoolean("static-assets.cache-assets-preload")

  onRequest {
    case GET(Path(path)) ⇒ reply(responseFromAsset(path))
    case _               ⇒ reply(Response(NotFound))
  }

  after { response ⇒
    val headers = response.headers ++ Seq(
      "Server" -> "MockFeatures",
      "Connection" -> "Close")
    Response(response.status, headers, response.body)
  }
}

