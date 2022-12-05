
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
/*1.2*/import controllers.Post
/*2.2*/import java.time.format.DateTimeFormatter

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Seq[Post],Form[PostRequest],Messages,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*4.2*/(posts: Seq[Post], form: Form[PostRequest])(implicit messages: Messages):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*5.1*/("""<!--<!DOCTYPE html>-->
<html lang="ja">
<head>
    <title>Scala Text Textboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <link rel="stylesheet" href="/assets/textboard.css">
</head>
<body>
<div class="container">
    <h1>"""),_display_(/*14.10*/Messages("textboard.title")),format.raw/*14.37*/("""</h1>
    """),_display_(/*15.6*/for(error <- form.errors) yield /*15.31*/{_display_(Seq[Any](format.raw/*15.32*/("""
    """),format.raw/*16.5*/("""<p class="text-danger" id="error">"""),_display_(/*16.40*/Messages(error.message)),format.raw/*16.63*/("""</p>
    """)))}),format.raw/*17.6*/("""
    """),format.raw/*18.5*/("""<form method="POST" action="/" class="form-inline">
        <input type="text" class="form-control" id="post" name="post">
        <button type="submit" class="btn btn-default">"""),_display_(/*20.56*/Messages("textboard.send")),format.raw/*20.82*/("""</button>
    </form>
    <table class="table">
        <thead>
        <tr><th>"""),_display_(/*24.18*/Messages("textboard.dateTime")),format.raw/*24.48*/("""</th><th>"""),_display_(/*24.58*/Messages("textboard.message")),format.raw/*24.87*/("""</th></tr>
        </thead>
        <tbody>
        """),_display_(/*27.10*/for(post <- posts.reverse) yield /*27.36*/{_display_(Seq[Any](format.raw/*27.37*/("""
        """),format.raw/*28.9*/("""<tr>
            <td class="post-date">"""),_display_(/*29.36*/{
                val formatter = DateTimeFormatter.ofPattern(Messages("textboard.dateFormat"), messages.lang.toLocale)
                post.date.format(formatter)
                }),format.raw/*32.18*/("""</td>
            <td class="post-body">"""),_display_(/*33.36*/post/*33.40*/.body),format.raw/*33.45*/("""</td>
        </tr>
        """)))}),format.raw/*35.10*/("""
        """),format.raw/*36.9*/("""</tbody>
    </table>
</div>
</body>
</html>"""))
      }
    }
  }

  def render(posts:Seq[Post],form:Form[PostRequest],messages:Messages): play.twirl.api.HtmlFormat.Appendable = apply(posts,form)(messages)

  def f:((Seq[Post],Form[PostRequest]) => (Messages) => play.twirl.api.HtmlFormat.Appendable) = (posts,form) => (messages) => apply(posts,form)(messages)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 3bd859a037005b2ea23c5f2a36dd9c34fb82b0b3
                  MATRIX: 432->1|463->26|839->70|1005->143|1437->548|1485->575|1522->586|1563->611|1602->612|1634->617|1696->652|1740->675|1780->685|1812->690|2017->868|2064->894|2172->975|2223->1005|2260->1015|2310->1044|2390->1097|2432->1123|2471->1124|2507->1133|2574->1173|2776->1354|2844->1395|2857->1399|2883->1404|2943->1433|2979->1442
                  LINES: 17->1|18->2|23->4|28->5|37->14|37->14|38->15|38->15|38->15|39->16|39->16|39->16|40->17|41->18|43->20|43->20|47->24|47->24|47->24|47->24|50->27|50->27|50->27|51->28|52->29|55->32|56->33|56->33|56->33|58->35|59->36
                  -- GENERATED --
              */
          