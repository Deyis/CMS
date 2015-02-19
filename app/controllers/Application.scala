package controllers

import controllers.filters.{LanguageFilter, FilterChain}
import dao.MyMongoConnectionHelper
import models.{FooterModel, HeaderModel, MainPageModel}
import play.api.i18n.Messages
import play.api.libs.iteratee.Iteratee
import play.core.j.JavaHelpers
import play.i18n.Lang
import play.api.mvc._
import play.mvc.Http
import reactivemongo.api._
import reactivemongo.bson._
import services.translations.TranslationService
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Application extends Controller {

  def index = Action { request => {
      Ok(views.html.index(
        MainPageModel(HeaderModel(TranslationService.get("header")),
          FooterModel(TranslationService.get("footer")))))
    }
  }

  def pathResolver(path: String) = Action {
    request => {
      Http.Context.current.set(JavaHelpers.createJavaContext(request))
      new FilterChain().add(new LanguageFilter()).apply(request)

//        val query = BSONDocument("firstName" -> "Jack")
//        val filter = BSONDocument(
//          "lastName" -> 1,
//          "_id" -> 1)
//
//        MyMongoConnectionHelper.connect("localhost", "test").getCollection("test").find(query, filter).
//          cursor[BSONDocument].
//          enumerate().apply(Iteratee.foreach { doc =>
//          println("found document: " + BSONDocument.pretty(doc))
//        })
//
      Ok(views.html.index(
        MainPageModel(HeaderModel(TranslationService.get("header")),
          FooterModel(TranslationService.get("footer")))))
    }
  }

  def showPage(s: String) = {
    Map("hello" -> Ok("Hello"), "good" -> Ok("Good") )
  }
}