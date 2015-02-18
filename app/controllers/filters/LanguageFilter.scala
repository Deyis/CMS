package controllers.filters

import play.mvc.Http
import play.mvc.Http.Session

class LanguageFilter extends Filter {

  override def apply(path: String, filters: List[Filter]): Unit =  {
    println(path)

    val session: Session = Http.Context.current().session()
    session.put("lang", path.substring(0,2))

    doNext(path.substring(2), filters)
  }
}
