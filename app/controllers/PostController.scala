package controllers

import models.PostDao
import play.api.mvc.{Action, AnyContent, MessagesAbstractController, MessagesControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton
class PostController @Inject() (
    cc: MessagesControllerComponents
) extends MessagesAbstractController(cc) {

  def index(id: Long): Action[AnyContent] = Action { implicit request =>
    val post = PostDao.getById(id)
    post match {
      case Some(p) => {
        println(p)
        Ok(views.html.post(p))
      }
      case None => NotFound("Not Found")
    }
  }

  def pressedLike(id: Long): Action[AnyContent] = Action { implicit request =>
    PostDao.getById(id) match {
      case Some(post) => {
        post.hasUserLiked("test") match {
          case true  => post.removeLike("test")
          case false => post.addLike("test")
        }
        Redirect(routes.PostController.index(id))
      }
      case None => NotFound("Not Found")
    }
  }
}
