package controllers.filters


abstract class Filter {

  def apply(path:String, filters: List[Filter])

  def doNext(path: String, filters: List[Filter]): Unit = {
    filters.head.apply(path, filters.tail)
  }
}
