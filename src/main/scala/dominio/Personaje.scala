package dominio

import scala.collection.mutable.ArrayBuffer

/**
 * @author sebastian
 */
class Personaje(posicionInicial:Posicion, terrenoI:Terreno) extends ElementoDelTerreno(posicionInicial, terrenoI){
  
  var salud = 1000
  var inventario = new ArrayBuffer[ElementoDelTerreno]()
  
  def inspeccionarTerreno(distancia : Int)={
    terrenoI.obtenerElementosDistanciaMenorA(distancia, posicionInicial)
  }
  
  def contabilizarEnergiaTotalDeAlimento()={
    this.inspeccionarTerreno(100).collect { case baya:Baya => baya.energia }.sum
    //(bayas.map{b => b.energia}).sum
  }
  
  def contarArboles()={
    inspeccionarTerreno(200).count{ e => e.isInstanceOf[Arbol] }
  }
  
  def recogerComida(){
    var bayas = inspeccionarTerreno(100).collect{case baya:Baya => baya}
    inventario.appendAll(bayas)//agregarAlInventario()????
    terrenoI.quitarAlimento(bayas)
  }
  
  def reconocerCasaDeChanchoMejorProvisionada() = {
    var chanchos = terrenoI.obtenerTodasLasCasasDeChancho()
    chanchos.maxBy { c => c.calcularEnergiaDeAlimento() }
  }
  
  def agregarAlInventario(elemento:ElementoDelTerreno){
    inventario.append(elemento) 
  }
   
  def restarSalud(puntosDeSalud: Int){
    salud = salud -puntosDeSalud
  }
  
  def crearHoguera{
    val hierbas = inventario.filter { e => e.isInstanceOf[Hierba]}.take(3)
    val piedras = inventario.filter { e => e.isInstanceOf[Piedra]}.take(2)
    if (hierbas.length == 3 && piedras == 2){
        terrenoI.agregarElementoAlTerreno(new Hoguera(posicionInicial, terrenoI))
    }
  }
  
}