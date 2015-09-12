package dominio

/**
 * @author sebastian
 */
class Hierba (posicionInicial:Posicion, terrenoI:Terreno) extends ElementoDelTerreno(posicionInicial, terrenoI){
  var estadoHierba : EstadoHierba = new HierbaSinCortar
}

abstract class EstadoHierba{
  
}

class HierbaSinCortar extends EstadoHierba{}

class HierbaCortada extends EstadoHierba{}