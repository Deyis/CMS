package controllers

import dao.MyMongoConnectionHelper
import models.{FooterModel, HeaderModel, MainPageModel}
import play.api.i18n.Messages
import play.api.libs.iteratee.Iteratee
import play.i18n.Lang
import play.api.mvc._
import reactivemongo.api._
import reactivemongo.bson._
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global

object Application extends Controller {

  def index(path: String) = Action {
    println(path)

    val query = BSONDocument("firstName" -> "Jack")
    val filter = BSONDocument(
      "lastName" -> 1,
      "_id" -> 1)

    MyMongoConnectionHelper.connect("localhost", "test").getCollection("test").find(query, filter).
      cursor[BSONDocument].
      enumerate().apply(Iteratee.foreach { doc =>
      println("found document: " + BSONDocument.pretty(doc))
    })


    Ok(views.html.index(
      MainPageModel(HeaderModel(Messages("header")(Lang.forCode("de"))),
        FooterModel(Messages("footer")(Lang.forCode("de"))))))

  }

  def showPage(s: String) = {
    Map("hello" -> Ok("Hello"), "good" -> Ok("Good") )

  }
}