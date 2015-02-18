package controllers.filters


class PathTranslatorFilter extends Filter {

  override def apply(path: String, filters: List[Filter]): Unit =  {


    doNext(path, filters)
  }
}
