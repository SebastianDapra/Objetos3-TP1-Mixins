package accesorios

import scala.util.Random

/**
 * @author sebastian
 */
class GeneradorRandom {
  def generarNumeroRandomEntre(cotaMenor: Int, cotaMayor: Int)={
    Math.floor(Math.random()*(cotaMayor-cotaMenor+1)+cotaMenor)
  }
  
  def generarBooleanoRandom()={
    Random.nextBoolean
  }
}