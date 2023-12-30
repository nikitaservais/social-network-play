package controllers

import models.PostDao
import play.api.*
import play.api.mvc.*

import javax.inject.*

/** This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
@Singleton
class FeedController @Inject() (val controllerComponents: ControllerComponents)
    extends BaseController {

  def index(): Action[AnyContent] = Action {
    implicit request: Request[AnyContent] =>
      val posts = PostDao.getAll()
      Ok(views.html.feed(posts))
  }
}
