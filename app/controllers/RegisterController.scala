package controllers

import models.{User, UserDao}

import javax.inject.*
import play.api.*
import play.api.data.Form
import play.api.data.Forms.{mapping, nonEmptyText}
import play.api.mvc.*

/**
 * This controller creates an `Action` to handle HTTP requests to the
 * application's home page.
 */
@Singleton
class RegisterController @Inject()(
                                    cc: MessagesControllerComponents,
                                  ) extends MessagesAbstractController(cc) {
  val userForm: Form[User] = Form(
    mapping(
      "username" -> nonEmptyText,
      "password" -> nonEmptyText,
    )(User.apply)(User.unapply).verifying("Username already exists", user => {
      UserDao.validate(user)
    })
  )

  def register(): Action[AnyContent] = {
    Action { implicit request: MessagesRequest[AnyContent] =>
      Ok(views.html.register(userForm))
    }
  }

  def registerSubmit(): Action[AnyContent] = {
    Action { implicit request: MessagesRequest[AnyContent] =>
      userForm.bindFromRequest().fold(
        formWithErrors => {
          BadRequest(views.html.register(formWithErrors))
        },
        user => {
          UserDao.create(user)
          Redirect(routes.RegisterController.register()).flashing(s"INFO" -> s"User ${user.username} created successfully")

        }
      )
    }
  }
}
