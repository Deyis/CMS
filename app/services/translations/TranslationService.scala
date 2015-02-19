package services.translations

import play.api.i18n.{Lang, Messages}
import request.info.LangData


object TranslationService {

  def get(key: String): String = {
    Messages(key)(Lang(LangData.getLanguageCode))
  }
}
