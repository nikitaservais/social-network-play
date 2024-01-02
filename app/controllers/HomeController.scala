package controllers

import play.api.*
import play.api.mvc.*

import javax.inject.*

/** This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class HomeController @Inject() (val controllerComponents: ControllerComponents)
    extends BaseController {

  def index(): Action[AnyContent] = Action {
    implicit request: Request[AnyContent] =>
      request.session.get(models.Global.SESSION_USERNAME_KEY) match
        case Some(username) =>
          Redirect(routes.FeedController.index()).withSession(request.session)
        case None =>
          Redirect(routes.RegisterController.register())
  }
}
