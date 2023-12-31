package controllers

import models.{Global, PostDao}
import play.api.mvc.{Action, AnyContent, MessagesAbstractController, MessagesControllerComponents}

import javax.inject.{Inject, Singleton}

@Singleton
class PostController @Inject() (
    cc: MessagesControllerComponents
) extends MessagesAbstractController(cc) {

  def index(id: Long): Action[AnyContent] = Action { implicit request =>
    val post = PostDao.getById(id)
    post match {
      case Some(p) => Ok(views.html.post(p))
      case None    => NotFound("Not Found")
    }
  }

  def addLike(id: Long): Action[AnyContent] = Action { implicit request =>
    PostDao.getById(id) match {
      case Some(post) => {
        post.addLike(Global.SESSION_USERNAME_KEY)
        Ok(views.html.post(post))
      }
      case None => NotFound("Not Found")
    }
  }

  def removeLike(id: Long): Action[AnyContent] = Action { implicit request =>
    PostDao.getById(id) match {
      case Some(post) => {
        post.removeLike(Global.SESSION_USERNAME_KEY)
        Ok(views.html.post(post))
      }
      case None => NotFound("Not Found")
    }
  }
}
