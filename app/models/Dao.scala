package models

import java.time.ZonedDateTime

object Dao {
  var users: Seq[User] = Seq(
    User("Paul", "emperor")
  )
  var posts: Seq[Post] = Seq(
    Post(
      id = 1,
      user = "Paul",
      likes = Seq(Like("Paul", ZonedDateTime.parse("2023-12-29T12:32:12Z"))),
      imagePath = "images/test-image.jpeg",
      createdAt = ZonedDateTime.parse("2023-12-29T11:00:11Z"),
      description = "My beautiful image",
      comments = Seq(
        Comment("test", "Wow!"),
        Comment("bother1", "Cool this is !"),
        Comment("bother2", "Cool this is !"),
        Comment("bother3", "Cool this is !")
      )
    ),
    Post(
      id = 2,
      user = "Paul",
      likes = Seq(Like("test", ZonedDateTime.parse("2023-12-29T12:32:12Z"))),
      imagePath = "images/test-image.jpeg",
      createdAt = ZonedDateTime.parse("2023-12-29T11:00:11Z"),
      description = "My beautiful image",
      comments = Seq(
        Comment("user2", "Wow!")
      )
    ),
    Post(
      id = 3,
      user = "Paul",
      likes = Seq(Like("Paul", ZonedDateTime.parse("2023-12-29T12:32:12Z"))),
      imagePath = "images/test-image.jpeg",
      createdAt = ZonedDateTime.parse("2023-12-29T11:00:11Z"),
      description = "My beautiful image",
      comments = Seq(
        Comment("user2", "Wow!")
      )
    ),
    Post(
      id = 4,
      user = "Paul",
      likes = Seq(Like("Paul", ZonedDateTime.parse("2023-12-29T12:32:12Z"))),
      imagePath = "images/test-image.jpeg",
      createdAt = ZonedDateTime.parse("2023-12-29T11:00:11Z"),
      description = "My beautiful image",
      comments = Seq(
        Comment("user2", "Wow!")
      )
    ),
    Post(
      id = 5,
      user = "Paul",
      likes = Seq(Like("Paul", ZonedDateTime.parse("2023-12-29T12:32:12Z"))),
      imagePath = "images/test-image.jpeg",
      createdAt = ZonedDateTime.parse("2023-12-29T11:00:11Z"),
      description = "My beautiful image",
      comments = Seq(
        Comment("user2", "Wow!")
      )
    )
  )
}
