package blog.self_documenting_apis

import org.http4k.contract.div
import org.http4k.core.HttpHandler
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.lens.Path
import org.http4k.lens.int

data class Age(val value: Int) {
    init {
        require(value >= 0)
    }

    val isAdult = value >= 18
}

fun basicHandler(name: String, age: Age): HttpHandler = { req: Request ->
    val beverage = if (age.isAdult) "beer" else "lemonade"
    Response(OK).body("Hello $name, would you like some $beverage?")
}

val basicRoute = "/greet" / Path.of("name") / Path.int().map(::Age).of("age") bindContract GET to ::basicHandler

