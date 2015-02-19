package controllers.filters

import play.api.mvc.{AnyContent, Request}
import play.mvc.Http.Session


abstract class Filter {

  def apply(request: Request[AnyContent], filters: List[Filter])

  def doNext(request: Request[AnyContent], filters: List[Filter]): Unit = {
    filters match {
      case head::tail => filters.head(request, tail)
      case Nil =>
    }
  }

  def redirect(path: String): Unit = {

  }

  def error(message: String): Unit = {

  }

}
