package services.translations

import play.api.i18n.{Lang, Messages}
import request.info.LangData


class TranslationService {

  def get(key: String, langCode: String): String = {
    Messages(key)(Lang(LangData.getLanguageCode))
  }
}
