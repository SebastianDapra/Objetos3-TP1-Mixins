package elementosDelTerreno

import accesorios.GeneradorRandom

/**
 * @author sebastian
 */
class BloqueDePiedra(posicionInicial: Posicion, terreno: Terreno, resistenciaInicial: Double) extends ElementoDelTerreno(posicionInicial, terreno) {
  var resistencia = resistenciaInicial
  
  def quitarResistencia(danio: Double){
    resistencia -= danio
    if(resistencia == 0){
      
      transformarEnPiedras()
    }
  }
  
  def transformarEnPiedras(){
    terreno.quitarElementoDelTerreno(this)
    var generador = new GeneradorRandom()
    var piedras = generador.generarNumeroRandomEntre(3, 5).intValue()
    for(piedras <- 1 to piedras){
      new Piedra(posicionInicial,terreno)
    }
    if(generador.generarBooleanoRandom()){
      new Oro(posicionInicial, terreno)
    }
    
    
  }
  
  
}