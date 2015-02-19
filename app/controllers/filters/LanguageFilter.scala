package controllers.filters

import play.api.mvc.{AnyContent, Request}
import play.mvc.Http
import play.mvc.Http.Session

class LanguageFilter extends Filter {

  override def apply(request: Request[AnyContent], filters: List[Filter]): Unit =  {

    val session: Session = Http.Context.current().session()
    session.put("lang", request.path.substring(1, 3))

    doNext(request, filters)
  }
}
