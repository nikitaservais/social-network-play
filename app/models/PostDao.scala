package models

object PostDao {
  var posts: Seq[Post] = Dao.posts

  def getAll(): Seq[Post] = posts

  def getById(id: Long): Option[Post] = {
    posts.find((post: Post) => post.getId == id)
  }
}
