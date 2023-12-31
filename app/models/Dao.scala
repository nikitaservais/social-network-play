package models

import java.time.ZonedDateTime

object Dao {
  var users: Seq[User] = Seq(
    User("Paul", "emperor")
  )
  var posts: Seq[Post] = Seq(
    Post(
      1,
      "Paul",
      Seq(Like("Paul", ZonedDateTime.parse("2023-12-29T12:32:12Z"))),
      "images/test-image.jpeg",
      ZonedDateTime.parse("2023-12-29T11:00:11Z"),
      "My beautiful image",
      Seq(
        Comment("user2", "Wow!"),
        Comment("bother1", "Cool this is !"),
        Comment("bother2", "Cool this is !"),
        Comment("bother3", "Cool this is !")
      )
    ),
    Post(
      2,
      "Paul",
      Seq(Like("test", ZonedDateTime.parse("2023-12-29T12:32:12Z"))),
      "images/test-image.jpeg",
      ZonedDateTime.parse("2023-12-29T11:00:11Z"),
      "My beautiful image",
      Seq(
        Comment("user2", "Wow!")
      )
    ),
    Post(
      3,
      "Paul",
      Seq(Like("Paul", ZonedDateTime.parse("2023-12-29T12:32:12Z"))),
      "images/test-image.jpeg",
      ZonedDateTime.parse("2023-12-29T11:00:11Z"),
      "My beautiful image",
      Seq(
        Comment("user2", "Wow!")
      )
    ),
    Post(
      4,
      "Paul",
      Seq(Like("Paul", ZonedDateTime.parse("2023-12-29T12:32:12Z"))),
      "images/test-image.jpeg",
      ZonedDateTime.parse("2023-12-29T11:00:11Z"),
      "My beautiful image",
      Seq(
        Comment("user2", "Wow!")
      )
    ),
    Post(
      5,
      "Paul",
      Seq(Like("Paul", ZonedDateTime.parse("2023-12-29T12:32:12Z"))),
      "images/test-image.jpeg",
      ZonedDateTime.parse("2023-12-29T11:00:11Z"),
      "My beautiful image",
      Seq(
        Comment("user2", "Wow!")
      )
    )
  )
}
