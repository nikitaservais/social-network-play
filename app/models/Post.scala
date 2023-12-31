package models

import java.time.ZonedDateTime

class Post(
    id: Long,
    user: String,
    imagePath: String,
    createdAt: ZonedDateTime,
    description: String,
    var likes: Seq[Like],
    var comments: Seq[Comment]
) {
  def getId: Long = id
  def getUser: String = user
  def getLikes: Seq[Like] = likes
  def getImagePath: String = imagePath
  def getCreatedAt: ZonedDateTime = createdAt
  def getDescription: String = description
  def getComments: Seq[Comment] = comments

  def addLike(username: String): Unit = {
    likes = likes :+ Like(username)
  }

  def removeLike(username: String): Unit = {
    likes = likes.filterNot(_.user == username)
  }

  def hasUserLiked(username: String): Boolean = {
    likes.exists(_.user == username)
  }

  def addComment(comment: Comment): Unit = {
    comments = comments :+ comment
  }

  def removeComment(index: Int): Unit = {
    comments = comments.take(index) ++ comments.drop(index + 1)
  }
}
