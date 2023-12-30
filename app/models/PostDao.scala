package models

object PostDao {
  var posts: Seq[Post] = Dao.posts

  def getAll(): Seq[Post] = posts
}
