package elementosDelTerreno

/**
 * @author sebastian
 */
class Posicion(xi:Int, yi:Int){
  var x = xi
  var y = yi
  
  def calcularDistanciaA(posicionD:Posicion)={
    Math.sqrt((Math.pow((posicionD.y - y),2)) + (Math.pow((posicionD.y - y),2))).intValue 
  }
}
