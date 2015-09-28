package elementosDelTerreno

import scala.util.Random
import accesorios.GeneradorRandom

/**
 * @author sebastian
 */
abstract class Arbol(posicionInicial: Posicion, terreno: Terreno) extends ElementoDelTerreno(posicionInicial, terreno) {
  var resistencia = 0
  var estadoDelArbol: EstadoArbol = new EstadoSinTalar

  def quitarResistencia(danio: Int) {
    estadoDelArbol.descontarDanio(this, danio)
    
  }
  def talado() {
    resistencia = 0
    estadoDelArbol = new EstadoTalado
  }

  def definirResistencia = {
    0
  }
  
  def transformarEnPiezasDeMadera(){
    for(obtenerCantidadDeMadera <- 1 to obtenerCantidadDeMadera){
      new PiezaDeMadera(posicionInicial,terreno)
    }
   }
    
    def obtenerCantidadDeMadera(): Int = this match{
      case x: ArbolGrande => new GeneradorRandom().generarNumeroRandomEntre(5,8).intValue()
      case x: ArbolChico => 3
    }

}

class ArbolGrande(posicionInicial: Posicion, terreno: Terreno) extends Arbol(posicionInicial, terreno) {
  resistencia = this.definirResistencia
  override def definirResistencia = {
    new GeneradorRandom().generarNumeroRandomEntre(5,10).intValue()
  }
}

class ArbolChico(posicionInicial: Posicion, terreno: Terreno) extends Arbol(posicionInicial, terreno) {
  resistencia = this.definirResistencia

  override def definirResistencia = {
    new GeneradorRandom().generarNumeroRandomEntre(3,5).intValue()
  }

}

abstract class EstadoArbol() {
  def descontarDanio(arbol: Arbol, danio: Int)
}

class EstadoSinTalar() extends EstadoArbol {
  def descontarDanio(arbol: Arbol, danio: Int) {
    arbol.resistencia -= danio
    if (arbol.resistencia <= 0) {
      arbol.talado
      arbol.transformarEnPiezasDeMadera()
    }
  }
}

class EstadoTalado() extends EstadoArbol {
  def descontarDanio(arbol: Arbol, danio: Int) {

  }
}

class PiezaDeMadera(posicionInicial: Posicion, terreno: Terreno) extends ElementoDelTerreno(posicionInicial, terreno){
  
}
