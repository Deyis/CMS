package controllers.filters

import play.api.mvc.{AnyContent, Request}
import play.mvc.Http
import play.mvc.Http.Session

class LanguageFilter extends Filter {

  override def apply(request: Request[AnyContent], filters: List[Filter]): Unit =  {
    println(request.path)

    val session: Session = Http.Context.current().session()
    session.put("lang", request.path.substring(0,2))

    doNext(request, filters)
  }
}
