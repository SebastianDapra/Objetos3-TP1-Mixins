package dominioTestCase

import org.scalatest._
import herramientas._
import elementosDelTerreno._
import elementosDelTerreno.BayaMorada

/**
 * @author sebastian
 */
class CasaDeChanchoTestCase extends FlatSpec with BeforeAndAfter {
  var terreno = new Terreno()
  var casaDeChanchoCopado = new CasaDeChancho(new Posicion(1, 1), new EstadoChanchoBuenHumor, terreno)

  before {
    casaDeChanchoCopado.agregrarElementoAStock(new BayaMorada(new Posicion(1, 1), 2, terreno))
  }

  after {}

  "una casa de chancho " should "agregar un elemento" in {

    assert(casaDeChanchoCopado.stockDelChancho.length == 1)
  }

  "una casa de chancho " should "calcular su energia de alimento" in {

    assert(casaDeChanchoCopado.calcularEnergiaDeAlimento() == 20)

  }
}