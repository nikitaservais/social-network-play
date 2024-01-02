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

  def index(
      sort: Option[String] = None,
      ord: Option[String] = None
  ): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    val posts = PostDao.getAll()
    sort match {
      case Some("date") => {
        var sortedPosts = posts.sortBy(_.getCreatedAt)
        ord match {
          case Some("desc") => sortedPosts = sortedPosts.reverse
          case _            => sortedPosts = sortedPosts
        }
        Ok(views.html.feed(sortedPosts))
      }
      case Some("like") => {
        var sortedPosts = posts.sortBy(_.likes.length)
        ord match {
          case Some("desc") => sortedPosts = sortedPosts.reverse
          case _            => sortedPosts = sortedPosts
        }
        Ok(views.html.feed(sortedPosts))
      }
      case _ => Ok(views.html.feed(posts))
    }
  }

  def likedPost(
      postId: Long,
      sort: Option[String] = None,
      ord: Option[String] = None
  ): Action[AnyContent] = Action { implicit request: Request[AnyContent] =>
    PostDao.getById(postId) match
      case Some(post) => {
        post.likedByUser(utils.getSessionUsername(request.session).get)
        Redirect(routes.FeedController.index(sort, ord))

      }
      case None => BadRequest("Post not found")
  }
}
