
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

object createForm extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[Form[String],MessagesRequestHeader,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(todoForm: Form[String])(implicit request: MessagesRequestHeader):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html>
<head>
    <title>Todo</title>
</head>
<body>

<h1>Todo登録</h1>

"""),_display_(/*11.2*/helper/*11.8*/.form(action = routes.TodoController.todoAdd())/*11.55*/ {_display_(Seq[Any](format.raw/*11.57*/("""
"""),_display_(/*12.2*/helper/*12.8*/.CSRF.formField),format.raw/*12.23*/("""

"""),format.raw/*14.1*/("""<fieldset>

    """),_display_(/*16.6*/helper/*16.12*/.inputText(todoForm("name"), '_label -> "名前")),format.raw/*16.57*/("""

"""),format.raw/*18.1*/("""</fieldset>

<input type="submit" value="登録">

""")))}),format.raw/*22.2*/("""

"""),format.raw/*24.1*/("""</body>
</html>"""))
      }
    }
  }

  def render(todoForm:Form[String],request:MessagesRequestHeader): play.twirl.api.HtmlFormat.Appendable = apply(todoForm)(request)

  def f:((Form[String]) => (MessagesRequestHeader) => play.twirl.api.HtmlFormat.Appendable) = (todoForm) => (request) => apply(todoForm)(request)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/createForm.scala.html
                  HASH: 5c6ede2c40ee8cd0831a82d6e389c8399f76f049
                  MATRIX: 762->1|921->67|948->68|1046->140|1060->146|1116->193|1156->195|1184->197|1198->203|1234->218|1263->220|1306->237|1321->243|1387->288|1416->290|1494->338|1523->340
                  LINES: 21->1|26->2|27->3|35->11|35->11|35->11|35->11|36->12|36->12|36->12|38->14|40->16|40->16|40->16|42->18|46->22|48->24
                  -- GENERATED --
              */
          