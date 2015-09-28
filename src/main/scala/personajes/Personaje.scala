package personajes

import scala.collection.mutable.ArrayBuffer
import elementosDelTerreno.Arbol
import elementosDelTerreno.Baya
import elementosDelTerreno.ElementoDelTerreno
import elementosDelTerreno.Hierba
import elementosDelTerreno.Hoguera
import elementosDelTerreno.Piedra
import elementosDelTerreno.Posicion
import elementosDelTerreno.Terreno

/**
 * @author sebastian
 */
class Personaje(posicionInicial: Posicion, terr: Terreno, puntosDeSalud: Int) extends PersonajeDelTerreno(posicionInicial, terr, puntosDeSalud) {

  //var herramientaActual = new Herramienta(this)
  var inventario = new ArrayBuffer[ElementoDelTerreno]()
  var terreno = terr

  def inspeccionarTerreno(distancia: Int) = {
    terreno.obtenerElementosDistanciaMenorA(distancia, posicionInicial)
  }

  def contabilizarEnergiaTotalDeAlimento() = {
    this.inspeccionarTerreno(100).collect { case baya: Baya => baya.energia }.sum
  }

  def contarArboles() = {
    inspeccionarTerreno(200).count { e => e.isInstanceOf[Arbol] }
  }

  def recogerComida() {
    var bayas = inspeccionarTerreno(100).collect { case baya: Baya => baya }
    inventario.appendAll(bayas) //agregarAlInventario()????
    terreno.quitarAlimento(bayas)
  }

  def reconocerCasaDeChanchoMejorProvisionada() = {
    var chanchos = terreno.obtenerTodasLasCasasDeChancho()
    chanchos.maxBy { c => c.calcularEnergiaDeAlimento() }
  }

  def agregarAlInventario(elemento: ElementoDelTerreno) {
    inventario.append(elemento)
  }

  def vaciarInventario {
    inventario = new ArrayBuffer[ElementoDelTerreno]
  }

  def crearHoguera {
    val hierbas = inventario.filter { e => e.isInstanceOf[Hierba] }.take(3)
    val piedras = inventario.filter { e => e.isInstanceOf[Piedra] }.take(2)
    if (hierbas.length == 3 && piedras == 2) {
      terreno.agregarElementoAlTerreno(new Hoguera(posicionInicial, terreno))
    }
  }

  def cantidadDeElementosEnElInventario() = {
    this.inventario.size
  }

  def quitarElementoDelInventario(elemento: ElementoDelTerreno) {
    inventario.-=(elemento)
  }

//  def equiparHerramienta(herramienta: Herramienta) {
//    herramientaActual = herramienta
//  }
//
//  def talar(arbol: Arbol) {
//    herramientaActual.talar(arbol)
//  }
//
//  def cavar(hierba: Hierba) {
//    herramientaActual.cavar(hierba)
//    agregarAlInventario(hierba)
//    terreno.quitarElementoDelTerreno(hierba)
//
//  }
//
//  def cavarArbol(arbol: Arbol) {
//    if (arbol.resistencia == 0) {
//      agregarAlInventario(herramientaActual.cavarArbol(arbol))
//    } else {
//      throw new Exception("Este arbol aun puede ser talado")
//    }
//  }
//
//  def picar(bloque: BloqueDePiedra) {
//    herramientaActual.picar(bloque)
//  }
//  
//  def atacar(personaje: PersonajeDelTerreno){
//    herramientaActual.atacar(personaje)
//  }

}