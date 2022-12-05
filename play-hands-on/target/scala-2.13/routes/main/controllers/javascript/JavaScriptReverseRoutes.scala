// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers.javascript {

  // @LINE:1
  class ReverseTodoController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def todoDelete: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TodoController.todoDelete",
      """
        function(todoId0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "todo/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("todoId", todoId0)) + "/delete"})
        }
      """
    )
  
    // @LINE:4
    def todoEdit: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TodoController.todoEdit",
      """
        function(todoId0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "todo/edit/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("todoId", todoId0))})
        }
      """
    )
  
    // @LINE:5
    def todoUpdate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TodoController.todoUpdate",
      """
        function(todoId0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "todo/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("todoId", todoId0))})
        }
      """
    )
  
    // @LINE:3
    def todoAdd: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TodoController.todoAdd",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "todo"})
        }
      """
    )
  
    // @LINE:1
    def list: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TodoController.list",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "todo"})
        }
      """
    )
  
    // @LINE:2
    def todoNew: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.TodoController.todoNew",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "todo/new"})
        }
      """
    )
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[Asset]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }


}
