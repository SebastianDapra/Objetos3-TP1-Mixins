package dominioTestCase

import dominio._
import org.scalatest._

/**
 * @author sebastian
 */
class PersonajeTestCase extends FlatSpec {

    var terreno = new Terreno()
    var beto = new Personaje(new Posicion(0,0), terreno)
    var bayaNegra = new BayaNegra(new Posicion(10,10), 50, terreno)
    var bayaMorada = new BayaMorada(new Posicion(101,101), 20, terreno)
    var arbolito = new Arbol(new Posicion(100,100), terreno)
    var arbol = new Arbol(new Posicion(201,201), terreno)
    var casaDeChanchoCopado = new CasaDeChancho(new Posicion(1,1), new EstadoChanchoBuenHumor, terreno)
    var casaDeChanchoEnojado = new CasaDeChancho(new Posicion(20,20), new EstadoChanchoMalHumor, terreno)
  
  "un personaje  " should "inspeccionar el terreno" in{
     assert(beto.inspeccionarTerreno(14).length == 2)
  }
  
  "un personaje  " should "contabilizar energia total del alimento que se encuentra a lo sumo a 100 de distancia" in{
     assert(beto.contabilizarEnergiaTotalDeAlimento() == 5)
  }
  
  "un personaje  " should "contabilizar cantidad de arboles a lo sumo a 200 de distancaia" in{
     assert(beto.contarArboles() == 1)
  }
  
   "un personaje  " should "recoger la comida que se encuentre a los sumo a 100 de distancia" in{
     beto.recogerComida()
     assert(beto.inventario.length == 1)
     assert(terreno.listaDeElementos.length == 6)
  }
   
   "un personaje  " should "reconocer la casa de chancho mejor provisionado" in{
     casaDeChanchoCopado.agregrarElementoAStock(bayaMorada)
     casaDeChanchoEnojado.agregrarElementoAStock(bayaNegra)
     beto.reconocerCasaDeChanchoMejorProvisionada()
     assert(true)//comparar casas???
  }
   
   "un personaje  " should "agregar un elemento a su inventario" in{
     beto.agregarAlInventario(bayaNegra)
     assert(beto.inventario.length == 1)
  }
   
   "un personaje  " should "perder salud" in{
     beto.restarSalud(100)
     assert(beto.salud == 900)
  }
   
   "un personaje  " should "crear una hoguera" in{
     beto.agregarAlInventario(new Piedra(new Posicion(0,0), terreno))
     beto.agregarAlInventario(new Piedra(new Posicion(0,0), terreno))
     beto.agregarAlInventario(new Hierba(new Posicion(0,0), terreno))
     beto.agregarAlInventario(new Hierba(new Posicion(0,0), terreno))
     beto.agregarAlInventario(new Hierba(new Posicion(0,0), terreno))
     beto.crearHoguera
     assert(beto.inspeccionarTerreno(14).length == 3)
  }
   
  
}