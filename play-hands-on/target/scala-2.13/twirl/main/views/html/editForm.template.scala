
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object editForm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Long,Form[String],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(id: Long, todoForm: Form[String])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html>
<head>
    <title>Todo</title>
</head>
<body>

<h1>Todo更新</h1>

"""),_display_(/*11.2*/helper/*11.8*/.form(action = routes.TodoController.todoUpdate(id))/*11.60*/ {_display_(Seq[Any](format.raw/*11.62*/("""
"""),_display_(/*12.2*/helper/*12.8*/.CSRF.formField),format.raw/*12.23*/("""

"""),format.raw/*14.1*/("""<fieldset>

    """),_display_(/*16.6*/helper/*16.12*/.inputText(todoForm("name"), '_label -> "名前")),format.raw/*16.57*/("""

"""),format.raw/*18.1*/("""</fieldset>
""")))}),format.raw/*19.2*/("""

"""),format.raw/*21.1*/("""<input type="submit" value="更新">
<input type="submit" value="削除" class="btn danger">

</body>
</html>"""))
      }
    }
  }

  def render(id:Long,todoForm:Form[String],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(id,todoForm)(request)

  def f:((Long,Form[String]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (id,todoForm) => (request) => apply(id,todoForm)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/editForm.scala.html
                  HASH: 637130a9cf49c7f4485b4d374829b37dc25feabb
                  MATRIX: 765->1|934->77|961->78|1059->150|1073->156|1134->208|1174->210|1202->212|1216->218|1252->233|1281->235|1324->252|1339->258|1405->303|1434->305|1477->318|1506->320
                  LINES: 21->1|26->2|27->3|35->11|35->11|35->11|35->11|36->12|36->12|36->12|38->14|40->16|40->16|40->16|42->18|43->19|45->21
                  -- GENERATED --
              */
          