package models

import java.time.{LocalDateTime, ZonedDateTime}

object Dao {
  var users: Seq[User] = Seq(
    User("Paul", "emperor")
  )
  var posts: Seq[Post] = Seq(
    Post(
      "Paul",
      Seq(Like("Paul", ZonedDateTime.parse("2023-12-29T12:32:12Z"))),
      "path/to/image.png",
      ZonedDateTime.parse("2023-12-29T11:00:11Z"),
      "My beautiful image",
      Seq(
        Comment("user2", "Wow!"),
      )
    )
  )
}
