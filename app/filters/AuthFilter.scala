package filters

import akka.stream.Materializer
import controllers.routes
import models.{Global, UserDao}
import play.api.mvc.*

import javax.inject.*
import scala.concurrent.{ExecutionContext, Future}

class AuthFilter @Inject() (implicit
    val mat: Materializer,
    ec: ExecutionContext
) extends Filter {
  private val allowedUnAuthUrls: Seq[String] = Seq(
    routes.RegisterController.register().url
  )

  override def apply(
      nextFilter: RequestHeader => Future[Result]
  )(requestHeader: RequestHeader): Future[Result] = {
    if (allowedUnAuthUrls.contains(requestHeader.uri)) {
      return nextFilter(requestHeader)
    }
    nextFilter(requestHeader)
  }

  private def checkSession(
      requestHeader: RequestHeader,
      nextFilter: RequestHeader => Future[Result]
  ): Future[Result] = {
    isSessionValid(
      requestHeader.session
    ) match {
      case true => nextFilter(requestHeader)
      case false =>
        Future.successful(Results.Redirect(routes.LoginController.login()))
    }
  }

  private def isSessionValid(session: Session): Boolean = {
    session.get(models.Global.SESSION_USERNAME_KEY) match {
      case Some(username) => UserDao.exists(username)
      case None           => false
    }
  }
}
