package controllers

import models.PostDao
import play.api.mvc.*

import java.nio.file.Paths
import javax.inject.Inject

class UploadPostController @Inject() (
    cc: MessagesControllerComponents
) extends MessagesAbstractController(cc) {

  def index(): Action[AnyContent] = Action { implicit request =>
    Ok(views.html.uploadPost())
  }

  def upload(): Action[AnyContent] =
    Action { implicit request =>
      {
        val description = request.body.asMultipartFormData.get
          .asFormUrlEncoded("description")
          .head
        if (description.isEmpty) {
          Redirect(routes.UploadPostController.index())
            .flashing("error" -> "Description cannot be empty")
        } else {
          val imagePath = request.body.asMultipartFormData.get
            .file("picture")
            .map { picture =>
              {
                val filename = Paths.get(picture.filename).getFileName

                val fileSize = picture.fileSize
                val contentType = picture.contentType
                val path = s"public/images/$filename"
                picture.ref.copyTo(
                  Paths.get(path),
                  replace = true
                )
                filename.getFileName.toString
              }
            }
          if (imagePath.isEmpty) {
            Redirect(routes.UploadPostController.index())
              .flashing("error" -> "File not uploaded")
          } else {
            PostDao.create(
              utils.getSessionUsername(request.session).get,
              description,
              imagePath.get
            )
            Redirect(routes.UploadPostController.index())
              .flashing("success" -> "File uploaded")
          }
        }

      }
    }
}
