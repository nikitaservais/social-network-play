package utils

/** Retrieves the username from the session. If the username is not present in
  * the session, None is returned.
  * @param session
  *   The session to retrieve the username from.
  * @return
  *   The username from the session, or None if the username is not present in
  */
def getSessionUsername(
    session: play.api.mvc.Session
): Option[String] = {
  session.get(models.Global.SESSION_USERNAME_KEY)
}
