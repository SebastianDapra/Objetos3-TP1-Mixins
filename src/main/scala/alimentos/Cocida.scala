package alimentos

import elementosDelTerreno._

/**
 * @author sebastian
 */
trait Cocida extends Baya{
 abstract override def energia ={
    super.energia * 1.1
  }
}

trait Podrida extends Baya{
 abstract override def energia ={
    super.energia * 0.33
  }
}
