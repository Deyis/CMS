package request.info

import play.mvc.Http
import play.mvc.Http.Session


object LangData {
  def getLanguageCode: String = {
    val session: Session = Http.Context.current().session()
    session.get("lang")
  }
}
