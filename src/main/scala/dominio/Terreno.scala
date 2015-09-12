package dominio

import scala.collection.mutable.ArrayBuffer
/**
 * @author sebastian
 */
class Terreno {
  var listaDeElementos = new ArrayBuffer[ElementoDelTerreno]() 
  
  def agregarElementoAlTerreno(elementoAAgregar : ElementoDelTerreno)={
    listaDeElementos.append(elementoAAgregar)
  }
  
  def obtenerElementosDistanciaMenorA(distancia:Int, posicion:Posicion) = {
    listaDeElementos.filter{ e => (e.distanciaA(posicion)) < distancia }
  }
  
  def obtenerTodasLasCasasDeChancho() = {
    listaDeElementos.filter{e => e.isInstanceOf[CasaDeChancho]}.map { x => x.asInstanceOf[CasaDeChancho] }
  } 
  
  def quitarAlimento(listaAQuitar:ArrayBuffer[Baya]){ 
    listaAQuitar.foreach { b => listaDeElementos.-=(b)}
    //filter { e => e.isInstanceOf[Baya]}.take(listaAQuitar.length)  
  }
}