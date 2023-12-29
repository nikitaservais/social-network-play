package models

case class User(username: String, password: String) // TODO: hash password

object User {
  def unapply(user: User): Option[(String, String)] = {
    Some((user.username, user.password))
  }
}
