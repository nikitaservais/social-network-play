package controllers

import models.{Global, User}
import play.api.data.*
import play.api.data.Forms.*
import play.api.mvc.*

import javax.inject.*

@Singleton
class LoginController @Inject() (
    cc: MessagesControllerComponents
) extends MessagesAbstractController(cc) {

  val form: Form[User] = Form(
    mapping(
      "username" -> nonEmptyText,
      "password" -> nonEmptyText
    )(User.apply)(User.unapply)
      .verifying(
        "Invalid username/password",
        user => {
          User.loginAttempt(user)
        }
      )
  )

  private val formSubmitUrl = routes.LoginController.processLogin()

  def login(): Action[AnyContent] = {
    Action { implicit request: MessagesRequest[AnyContent] =>
      Ok(views.html.login(form, formSubmitUrl))
    }
  }

  def processLogin(): Action[AnyContent] = {
    Action { implicit request: MessagesRequest[AnyContent] =>
      {
        val errorFunction = { (formWithErrors: Form[User]) =>
          BadRequest(views.html.login(formWithErrors, formSubmitUrl))
        }
        val successFunction = { (user: User) =>
          {
            Redirect(routes.HomeController.index())
              .flashing("INFO" -> "You are logged in.")
              .withSession(Global.SESSION_USERNAME_KEY -> user.username)
          }
        }
        val formValidationResult: Form[User] = form.bindFromRequest()
        formValidationResult.fold(
          errorFunction,
          successFunction
        )
      }
    }
  }

  private def lengthIsGreaterThanNCharacters(s: String, n: Int): Boolean =
    if s.length > n then true else false

  private def lengthIsLessThanNCharacters(s: String, n: Int): Boolean =
    if s.length < n then true else false

}
