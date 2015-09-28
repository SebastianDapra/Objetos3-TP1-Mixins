package elementosDelTerreno

import scala.collection.mutable.ArrayBuffer
import elementosDelTerreno.Baya
/**
 * @author sebastian
 */
class Terreno {
  var listaDeElementos = new ArrayBuffer[ElementoDelTerreno]() 
  
  def agregarElementoAlTerreno(elementoAAgregar : ElementoDelTerreno)={
    listaDeElementos.append(elementoAAgregar)
  }
  
  def quitarElementoDelTerreno(elemento : ElementoDelTerreno){
	  listaDeElementos.-=(elemento)
  }
  
  def obtenerElementosDistanciaMenorA(distancia:Int, posicion:Posicion) = {
    listaDeElementos.filter{ e => (e.distanciaA(posicion)) < distancia }
  }
  
  def obtenerTodasLasCasasDeChancho() = {
    listaDeElementos.filter{e => e.isInstanceOf[CasaDeChancho]}.map { x => x.asInstanceOf[CasaDeChancho] }
  } 
  
  def quitarAlimento(listaAQuitar:ArrayBuffer[Baya]){ 
    listaAQuitar.foreach { b => quitarElementoDelTerreno(b)}
  }
  
  def vaciarTerreno(){
    listaDeElementos = new ArrayBuffer[ElementoDelTerreno]() 
  }
  
}