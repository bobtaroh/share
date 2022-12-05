// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:1
package controllers {

  // @LINE:1
  class ReverseTodoController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def todoDelete(todoId:Long): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "todo/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("todoId", todoId)) + "/delete")
    }
  
    // @LINE:4
    def todoEdit(todoId:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "todo/edit/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("todoId", todoId)))
    }
  
    // @LINE:5
    def todoUpdate(todoId:Long): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "todo/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("todoId", todoId)))
    }
  
    // @LINE:3
    def todoAdd(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "todo")
    }
  
    // @LINE:1
    def list(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "todo")
    }
  
    // @LINE:2
    def todoNew(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "todo/new")
    }
  
  }

  // @LINE:9
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def versioned(file:Asset): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[Asset]].unbind("file", file))
    }
  
  }


}
