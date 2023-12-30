package models

case class User(username: String, password: String) // TODO: hash password

object User {
  def unapply(user: User): Option[(String, String)] = {
    Some((user.username, user.password))
  }

  def loginAttempt(user: User): Boolean = {
    UserDao.find(user.username) match {
      case Some(foundUser) => {
        if (foundUser.password == user.password) {
          true
        } else {
          false

        }
      }
      case None => false
    }
  }
}
