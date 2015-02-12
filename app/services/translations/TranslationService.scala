package services.translations

import play.api.i18n.{Lang, Messages}

/**
 * Created by Denis_Ivanchenko on 2/11/2015.
 */
class TranslationService {
  def get(key: String, langCode: String): String = {
    Messages(key)(Lang(langCode))
  }
}
