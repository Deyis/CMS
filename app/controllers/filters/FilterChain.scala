package controllers.filters

class FilterChain() {

  var filters: List[Filter] = List()

  def add(filter: Filter): FilterChain = {
    filters =  filters :+ filter
    this
  }

  def apply(path: String): Unit = {
    filters.head.apply(path, filters.tail)
  }
}
