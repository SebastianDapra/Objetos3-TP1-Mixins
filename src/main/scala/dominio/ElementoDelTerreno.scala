package dominio

/**
 * @author sebastian
 */
class ElementoDelTerreno(posicionInicial:Posicion, terr : Terreno) {
  var posicion = posicionInicial
  terr.agregarElementoAlTerreno(this)

  def distanciaA(posicionD:Posicion)={
    posicion.calcularDistanciaA(posicionD)
  }
}