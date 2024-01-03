package models

import java.time.ZonedDateTime

/** @param id
  *   Post id
  * @param user
  *   User who posted
  * @param imagePath
  *   Path to image file
  * @param createdAt
  *   Time of creation
  * @param description
  *   Description of post
  * @param likes
  *   Likes on post
  * @param comments
  *   Comments on post
  */
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

  private def addLike(username: String): Unit = {
    likes = likes :+ Like(username)
  }

  private def removeLike(username: String): Unit = {
    likes = likes.filterNot(_.user == username)
  }

  /** Checks if a user has liked a post
    * @param username
    *   User to check
    * @return
    *   True if user has liked post, false otherwise
    */
  def hasUserLiked(username: String): Boolean = {
    likes.exists(_.user == username)
  }

  /** Toggles a like on a post by a user
    * @param username
    *   User to toggle like for
    */
  def likedByUser(username: String): Unit = {
    this.hasUserLiked(username) match {
      case true  => this.removeLike(username)
      case false => this.addLike(username)
    }
  }

  def addComment(comment: Comment): Unit = {
    comments = comments :+ comment
  }

  def removeComment(index: Int): Unit = {
    comments = comments.take(index) ++ comments.drop(index + 1)
  }

}
