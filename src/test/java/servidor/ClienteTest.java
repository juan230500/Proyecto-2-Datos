package servidor;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.jdom2.JDOMException;
import org.junit.jupiter.api.Test;

import juego.Oleada;

class ClienteTest {
	@Test
	void testRequestGen() throws JDOMException, IOException {
		//Se preuban con el servidor encendido
		Cliente C=new Cliente(true);
		Oleada N=C.RequestGen(13, 1);
		assertEquals(13,N.getCantidadDragones());
	}

	@Test
	void testRequestAlineacion() throws JDOMException, IOException {
		Cliente C=new Cliente(false);
		Oleada O=new Oleada(12,1);
		Oleada N=C.RequestAlineacion(O, 0, O.getRoot());
		//Su cantidad se reduce en uno y la raiz cambia
		assertEquals(11,N.getCantidadDragones());
		assertNotEquals(O.getRoot(), N.getRoot());
	}

}
