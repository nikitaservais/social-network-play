package models

object UserDao {
  private var users: Seq[User] = Dao.users
  def validate(user: User): Boolean = {
    !users.exists(u => u.username == user.username)
  }

  def create(user: User): Unit = {
    users = users :+ user
  }

  def find(username: String): Option[User] = {
    users.find(u => u.username == username)
  }
}
