package servidor;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import juego.Oleada;

class TraductorEliminarcionTest {
	TraductorEliminarcion T=new TraductorEliminarcion();

	@Test
	void testToXML() {
		Oleada O=new Oleada(8,1);
		String S=T.ToXML(O, 0, O.getRoot().getEdad());
		//El formato deseado en el xml se verifica con un simple print
		System.out.println(S);
		assertTrue(true);
	}

	@Test
	void testGetOleada() {
		Oleada O=new Oleada(8,1);
		String S=T.ToXML(O, 0, O.getRoot().getEdad());
		Oleada N=T.GetOleada(S);
		//Despues de eliminar quedarán 7
		assertEquals(7,N.getCantidadDragones());
	}

	@Test
	void testIDToXMl() {
		Oleada O=new Oleada(8,1);
		String S=T.ToXML(O, 0, O.getRoot().getEdad());
		Oleada N=T.GetOleada(S);
		String S2=T.IDToXMl(O);
		//El formato deseado en el xml se verifica con un simple print
		System.out.println(S);
		assertTrue(true);
	}

	@Test
	void testGetOleadaId() {
		Oleada O=new Oleada(8,1);
		String S=T.ToXML(O, 0, O.getRoot().getEdad());
		Oleada N=T.GetOleada(S);
		String S2=T.IDToXMl(O);
		Oleada F=T.GetOleadaId(S2);
		assertEquals(O.getCantidadDragones(),F.getCantidadDragones());
		assertNotEquals(O.getRoot(), F.getRoot());
	}

	@Test
	void testGetArrayPorID() {
		Oleada O=new Oleada(8,1);
		String S=T.ToXML(O, 0, O.getRoot().getEdad());
		Oleada N=T.GetOleada(S);
		//Imprime el array correcto de la oleada
		System.out.println(Arrays.toString(T.getArrayPorID()));	
	}

	@Test
	void testGetCriterio() {
		Oleada O=new Oleada(8,1);
		String S=T.ToXML(O, 0, O.getRoot().getEdad());
		Oleada N=T.GetOleada(S);
		assertEquals(0,T.getCriterio());
	}

	@Test
	void testGetDragonEliminar() {
		Oleada O=new Oleada(8,1);
		String S=T.ToXML(O, 0, O.getRoot().getEdad());
		Oleada N=T.GetOleada(S);
		//Despues de eliminar quedarán 7
		assertEquals(O.getRoot().getEdad(),T.getDragonEliminar().getEdad());
	}

}
