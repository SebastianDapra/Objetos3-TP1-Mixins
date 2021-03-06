package dominio

import scala.util.Random
import scala.collection.mutable.ArrayBuffer

/**
 * @author sebastian
 */
class CasaDeChancho(posicionInicial:Posicion, estadoChancho:EstadoChancho, terrenoI:Terreno) extends ElementoDelTerreno(posicionInicial, terrenoI) {
  var estadoDelChancho = estadoChancho
  var stockDelChancho = new ArrayBuffer[ElementoDelTerreno]()

  def agregrarElementoAStock(element : ElementoDelTerreno){
	  stockDelChancho.append(element)
  }
  
  def calcularEnergiaDeAlimento()={
	  stockDelChancho.collect{ case baya:Baya => baya.energia }.sum
  }
  
  def recibirVisita(personaje : Personaje) {
    estadoDelChancho.recibirVisita(this, personaje)
  }
  
}



abstract class EstadoChancho(){
  def recibirVisita(casa :CasaDeChancho, personaje : Personaje)
}

class EstadoChanchoBuenHumor()extends EstadoChancho{
  def recibirVisita(casa :CasaDeChancho, personaje : Personaje){
    personaje.agregarAlInventario(casa.stockDelChancho.last)
  }
}

class EstadoChanchoNeutral()extends EstadoChancho{
  def recibirVisita(casa :CasaDeChancho, personaje : Personaje){   
  }
}

class EstadoChanchoMalHumor()extends EstadoChancho{
  
  def recibirVisita(casa :CasaDeChancho, personaje : Personaje){
    if(Random.nextBoolean){
      personaje.restarSalud(10)
      
    }
  }
}