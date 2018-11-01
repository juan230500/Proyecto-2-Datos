package servidor;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.jdom2.JDOMException;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import juego.Oleada;

class TraductorInicioTest {
	TraductorInicio T=new TraductorInicio();

	

	@Test
	void testCantidadToXML() {
		String S=T.CantidadToXML(100, 2);
		//El formato deseado en el xml se verifica con un simple print
		System.out.println(S);
		assertTrue(true);
	}

	@Test
	void testGetDatosOleada() {
		String S=T.CantidadToXML(100, 2);
		T.getDatosOleada(S);
		assertTrue(true);
	}
	
	@Test
	void testGetCantidadDragones() {
		String S=T.CantidadToXML(100, 2);
		T.getDatosOleada(S);
		assertEquals(100,T.getCantidadDragones());
	}

	@Test
	void testGetRonda() {
		String S=T.CantidadToXML(100, 2);
		T.getDatosOleada(S);
		assertEquals(2,T.getRonda());
	}

	@Test
	void testToXMLFull() {
		String S=T.CantidadToXML(100, 2);
		T.getDatosOleada(S);
		Oleada OleadaTmp=new Oleada(T.getCantidadDragones(),T.getRonda());
		String XML=T.ToXMLFull(OleadaTmp);
		//El formato deseado en el xml se verifica con un simple print
		System.out.println(XML);
	}

	@Test
	void testGetOleadaFull() {
		String S=T.CantidadToXML(100, 2);
		T.getDatosOleada(S);
		Oleada OleadaTmp=new Oleada(T.getCantidadDragones(),T.getRonda());
		String XML=T.ToXMLFull(OleadaTmp);
		Oleada O=T.getOleadaFull(XML);
		assertEquals(O.getCantidadDragones(),OleadaTmp.getCantidadDragones());
		assertEquals(O.getRoot().getEdad(),OleadaTmp.getRoot().getEdad());
	}
}
