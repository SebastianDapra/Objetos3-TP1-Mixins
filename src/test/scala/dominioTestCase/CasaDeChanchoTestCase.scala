package dominioTestCase

import dominio._
import org.scalatest._


/**
 * @author sebastian
 */
class CasaDeChanchoTestCase extends FlatSpec with BeforeAndAfter{
  
//  var terreno : Terreno
//  var casaDeChanchoCopado : CasaDeChancho
  var terreno = new Terreno()
  var casaDeChanchoCopado = new CasaDeChancho(new Posicion(1,1), new EstadoChanchoBuenHumor, terreno)
  
  before{
//    terreno = new Terreno()
//    casaDeChanchoCopado = new CasaDeChancho(new Posicion(1,1), new EstadoChanchoBuenHumor, terreno)
    casaDeChanchoCopado.agregrarElementoAStock(new BayaMorada(new Posicion(1,1),2, terreno))
  }
  
  after{}
  
  
  "una casa de chancho " should "agregar un elemento" in{
    
     assert(casaDeChanchoCopado.stockDelChancho.length == 1)
  }
  
  "una casa de chancho " should "calcular su energia de alimento" in {
    
    assert(casaDeChanchoCopado.calcularEnergiaDeAlimento() == 20)
    
  }
  
  //Testear estado
  
  
}