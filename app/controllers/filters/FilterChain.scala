package controllers.filters

import play.api.mvc.{AnyContent, Request}
import play.mvc.Http.Session

class FilterChain() {

  var filters: List[Filter] = List()

  def add(filter: Filter): FilterChain = {
    filters =  filters :+ filter
    this
  }

  def apply(request: Request[AnyContent]): Unit = {
    filters.head(request, filters.tail)
  }
}
