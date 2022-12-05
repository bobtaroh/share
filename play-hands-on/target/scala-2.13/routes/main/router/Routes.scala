// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:1
  TodoController_0: controllers.TodoController,
  // @LINE:9
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:1
    TodoController_0: controllers.TodoController,
    // @LINE:9
    Assets_1: controllers.Assets
  ) = this(errorHandler, TodoController_0, Assets_1, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, TodoController_0, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """todo""", """controllers.TodoController.list()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """todo/new""", """controllers.TodoController.todoNew()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """todo""", """controllers.TodoController.todoAdd()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """todo/edit/""" + "$" + """todoId<[^/]+>""", """controllers.TodoController.todoEdit(todoId:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """todo/""" + "$" + """todoId<[^/]+>""", """controllers.TodoController.todoUpdate(todoId:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """todo/""" + "$" + """todoId<[^/]+>/delete""", """controllers.TodoController.todoDelete(todoId:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:1
  private[this] lazy val controllers_TodoController_list0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("todo")))
  )
  private[this] lazy val controllers_TodoController_list0_invoker = createInvoker(
    TodoController_0.list(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TodoController",
      "list",
      Nil,
      "GET",
      this.prefix + """todo""",
      """""",
      Seq()
    )
  )

  // @LINE:2
  private[this] lazy val controllers_TodoController_todoNew1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("todo/new")))
  )
  private[this] lazy val controllers_TodoController_todoNew1_invoker = createInvoker(
    TodoController_0.todoNew(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TodoController",
      "todoNew",
      Nil,
      "GET",
      this.prefix + """todo/new""",
      """""",
      Seq()
    )
  )

  // @LINE:3
  private[this] lazy val controllers_TodoController_todoAdd2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("todo")))
  )
  private[this] lazy val controllers_TodoController_todoAdd2_invoker = createInvoker(
    TodoController_0.todoAdd(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TodoController",
      "todoAdd",
      Nil,
      "POST",
      this.prefix + """todo""",
      """""",
      Seq()
    )
  )

  // @LINE:4
  private[this] lazy val controllers_TodoController_todoEdit3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("todo/edit/"), DynamicPart("todoId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TodoController_todoEdit3_invoker = createInvoker(
    TodoController_0.todoEdit(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TodoController",
      "todoEdit",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """todo/edit/""" + "$" + """todoId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:5
  private[this] lazy val controllers_TodoController_todoUpdate4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("todo/"), DynamicPart("todoId", """[^/]+""",true)))
  )
  private[this] lazy val controllers_TodoController_todoUpdate4_invoker = createInvoker(
    TodoController_0.todoUpdate(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TodoController",
      "todoUpdate",
      Seq(classOf[Long]),
      "POST",
      this.prefix + """todo/""" + "$" + """todoId<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:6
  private[this] lazy val controllers_TodoController_todoDelete5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("todo/"), DynamicPart("todoId", """[^/]+""",true), StaticPart("/delete")))
  )
  private[this] lazy val controllers_TodoController_todoDelete5_invoker = createInvoker(
    TodoController_0.todoDelete(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TodoController",
      "todoDelete",
      Seq(classOf[Long]),
      "POST",
      this.prefix + """todo/""" + "$" + """todoId<[^/]+>/delete""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:1
    case controllers_TodoController_list0_route(params@_) =>
      call { 
        controllers_TodoController_list0_invoker.call(TodoController_0.list())
      }
  
    // @LINE:2
    case controllers_TodoController_todoNew1_route(params@_) =>
      call { 
        controllers_TodoController_todoNew1_invoker.call(TodoController_0.todoNew())
      }
  
    // @LINE:3
    case controllers_TodoController_todoAdd2_route(params@_) =>
      call { 
        controllers_TodoController_todoAdd2_invoker.call(TodoController_0.todoAdd())
      }
  
    // @LINE:4
    case controllers_TodoController_todoEdit3_route(params@_) =>
      call(params.fromPath[Long]("todoId", None)) { (todoId) =>
        controllers_TodoController_todoEdit3_invoker.call(TodoController_0.todoEdit(todoId))
      }
  
    // @LINE:5
    case controllers_TodoController_todoUpdate4_route(params@_) =>
      call(params.fromPath[Long]("todoId", None)) { (todoId) =>
        controllers_TodoController_todoUpdate4_invoker.call(TodoController_0.todoUpdate(todoId))
      }
  
    // @LINE:6
    case controllers_TodoController_todoDelete5_route(params@_) =>
      call(params.fromPath[Long]("todoId", None)) { (todoId) =>
        controllers_TodoController_todoDelete5_invoker.call(TodoController_0.todoDelete(todoId))
      }
  
    // @LINE:9
    case controllers_Assets_versioned6_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned6_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
