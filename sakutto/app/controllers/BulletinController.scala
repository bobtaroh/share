package controllers

//コピペ
import javax.inject._
import play.api.mvc._
import services._
import play.api.data._
import play.api.data.Forms._
//コピペ

//入力
class BulletinController @Inject()(bulletinService: BulletinService, mcc: MessagesControllerComponents)
  extends MessagesAbstractController(mcc) {

  def helloworld() = Action { implicit request: MessagesRequest[AnyContent] =>
    Ok("Hello World")
  }

  def list() = Action { implicit request: MessagesRequest[AnyContent] =>
    val items: Seq[Bulletin] = bulletinService.list()
    Ok(views.html.list(items))
  }

  val bulletinForm: Form[(String, String, String)] = Form(
    tuple(
      "title" -> text,
      "name" -> text,
      "content" -> text
    )
  )

  //val bulletinForm_title: Form[String] = Form("title" -> nonEmptyText)

  //val bulletinForm_name: Form[String] = Form("name" -> nonEmptyText)

  def bulletinNew = Action { implicit request: MessagesRequest[AnyContent] =>
    Ok(views.html.createForm(bulletinForm))
  }

  def bulletinAdd() = Action { implicit request: MessagesRequest[AnyContent] =>
    val name: (String, String, String) = bulletinForm.bindFromRequest().get
    bulletinService.insert(Bulletin(id = None, name._1, name._2, name._3))
    Redirect(routes.BulletinController.list())
  }

  def bulletinEdit(bulletinId: Long) = Action { implicit request: MessagesRequest[AnyContent] =>
    bulletinService.findById(bulletinId).map { bulletin =>
      Ok(views.html.editForm(bulletinId, bulletinForm.fill(bulletin.title, bulletin.name, bulletin.content)))
    }.getOrElse(NotFound)
  }

  def bulletinUpdate(bulletinId: Long) = Action { implicit request: MessagesRequest[AnyContent] =>
    val name: (String, String, String) = bulletinForm.bindFromRequest().get
    //val title: String = bulletinForm_title.bindFromRequest().get
    //val name: String = bulletinForm_name.bindFromRequest().get
    bulletinService.update(bulletinId, Bulletin(Some(bulletinId), name._1, name._2, name._3))
    Redirect(routes.BulletinController.list())
  }

  def bulletinDelete(bulletinId: Long) = Action { implicit request: MessagesRequest[AnyContent] =>
    bulletinService.delete(bulletinId)
    Redirect(routes.BulletinController.list())
  }
}
//入力