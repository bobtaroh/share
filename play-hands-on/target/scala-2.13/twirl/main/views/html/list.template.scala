
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
/*1.2*/import services._

object list extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template1[Seq[Todo],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*2.2*/(items: Seq[Todo]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<html>
<head>
    <title>Todo</title>
</head>
<body>

<section>
    <table>
        <thead>
        <tr>
            <h1>さくっと掲示板</h1>
        </tr>
        </thead>
        <tbody>
        <ol>
        """),_display_(/*19.10*/items/*19.15*/.map/*19.19*/ { todo =>_display_(Seq[Any](format.raw/*19.29*/("""
            """),format.raw/*20.13*/("""<li><a href=""""),_display_(/*20.27*/controllers/*20.38*/.routes.TodoController.todoEdit(todo.id.get)),format.raw/*20.82*/("""">"""),_display_(/*20.85*/todo/*20.89*/.name),format.raw/*20.94*/("""</a></li>
        """)))}),format.raw/*21.10*/("""
        """),format.raw/*22.9*/("""</ol>
        </tbody>
    </table>
    <a href=""""),_display_(/*25.15*/controllers/*25.26*/.routes.TodoController.todoNew()),format.raw/*25.58*/("""">登録画面</a>
</section>

</body>
</html>"""))
      }
    }
  }

  def render(items:Seq[Todo]): play.twirl.api.HtmlFormat.Appendable = apply(items)

  def f:((Seq[Todo]) => play.twirl.api.HtmlFormat.Appendable) = (items) => apply(items)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/list.scala.html
                  HASH: 24afbf658e3b7ffd5c07de25fe296ef57beca0d4
                  MATRIX: 432->1|756->20|868->39|895->40|1125->243|1139->248|1152->252|1200->262|1241->275|1282->289|1302->300|1367->344|1397->347|1410->351|1436->356|1486->375|1522->384|1599->434|1619->445|1672->477
                  LINES: 17->1|22->2|27->3|28->4|43->19|43->19|43->19|43->19|44->20|44->20|44->20|44->20|44->20|44->20|44->20|45->21|46->22|49->25|49->25|49->25
                  -- GENERATED --
              */
          