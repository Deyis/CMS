package dao


import reactivemongo.api._
import reactivemongo.api.collections.default.BSONCollection
import scala.concurrent.ExecutionContext.Implicits.global

object MyMongoConnectionHelper {

  var db: DefaultDB = null
  
  def connect(dbHost: String, dbName: String) = {
    
    val driver = new MongoDriver
    val connection = driver.connection(List(dbHost))
    
    db = connection(dbName)
    this
  }

  def getCollection(collectionName: String): BSONCollection = {
    db(collectionName)
  }

}
