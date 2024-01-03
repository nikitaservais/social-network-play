package models

case class User(username: String, password: String)

object User {
  def unapply(user: User): Option[(String, String)] = {
    Some((user.username, user.password))
  }

  /** Verify if the user exists in the database and if the password is correct
    * @param user
    *   the user to verify
    * @return
    *   true if the user exists and the password is correct, false otherwise
    */
  def verifyUser(user: User): Boolean = {
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
