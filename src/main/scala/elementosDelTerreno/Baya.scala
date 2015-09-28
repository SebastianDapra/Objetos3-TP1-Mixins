package elementosDelTerreno


/**
 * @author sebastian
 */
abstract class Baya(posicionInicial:Posicion, tamanioI:Int, terrenoI:Terreno) extends ElementoDelTerreno(posicionInicial, terrenoI) {
  
  var tamanio = tamanioI
  
  def energia : Double
  
}

class BayaMorada (posicionInicial:Posicion, tamanioI: Int, terrenoI:Terreno) extends  Baya(posicionInicial, tamanioI, terrenoI){
  
   def  energia = {10}
  
}
 
class BayaNegra (posicionInicial:Posicion, tamanioI: Int, terrenoI:Terreno) extends  Baya(posicionInicial, tamanioI, terrenoI){
  def  energia = (tamanio*0.1)
}