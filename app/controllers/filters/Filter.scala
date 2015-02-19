package controllers.filters

import play.api.mvc.{AnyContent, Request}


abstract class Filter {

  def apply(request: Request[AnyContent], filters: List[Filter])

  def doNext(request: Request[AnyContent], filters: List[Filter]): Unit = {
    filters.head(request, filters.tail)
  }

  def redirect(path: String): Unit = {

  }

  def error(message: String): Unit = {

  }

}
