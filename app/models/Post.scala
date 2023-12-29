package models

import java.time.ZonedDateTime

case class Post(
    user: String,
    likes: Seq[Like],
    imagePath: String,
    createdAt: ZonedDateTime,
    description: String,
    comments: Seq[Comment]
) {}
