package controllers.filters

import play.api.mvc.{AnyContent, Request}


class PathTranslatorFilter extends Filter {

  override def apply(request: Request[AnyContent], filters: List[Filter]): Unit =  {

    doNext(request, filters)
  }
}
