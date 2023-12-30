package models

import java.time.ZonedDateTime

case class Post(
    user: String,
    likes: Seq[Like],
    imagePath: String,
    createdAt: ZonedDateTime,
    description: String,
    comments: Seq[Comment]
) {
  
  def userHasLiked(username: String): Boolean = likes.exists(_.user == user)
}
