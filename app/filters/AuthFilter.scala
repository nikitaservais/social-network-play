package filters

import akka.stream.Materializer
import controllers.routes
import models.{Global, UserDao}
import play.api.mvc.*

import javax.inject.*
import scala.concurrent.{ExecutionContext, Future}

/** This is a filter for the application to check if the user is logged in or not. If the user is not logged in, then
 * the user will be redirected to the login page.
  */
class AuthFilter @Inject() (implicit
    val mat: Materializer,
    ec: ExecutionContext
) extends Filter {
  private val allowedUnAuthUrls: Seq[String] = Seq(
    routes.RegisterController.index().url,
    routes.LoginController.index().url
  )

  override def apply(
      nextFilter: RequestHeader => Future[Result]
  )(requestHeader: RequestHeader): Future[Result] = {
    if (allowedUnAuthUrls.contains(requestHeader.uri)) {
      return nextFilter(requestHeader)
    }
    isSessionValid(
      requestHeader.session
    ) match {
      case true => nextFilter(requestHeader)
      case false =>
        Future.successful(Results.Redirect(routes.LoginController.index()))
    }

  }

  private def isSessionValid(session: Session): Boolean = {
    utils.getSessionUsername(session) match {
      case Some(username) => UserDao.exists(username)
      case None           => false
    }
  }
}
