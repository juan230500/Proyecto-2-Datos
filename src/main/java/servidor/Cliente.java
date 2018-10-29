package servidor;

import java.io.IOException;
import java.util.Arrays;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.jdom2.JDOMException;

import juego.Dragon;
import juego.Oleada;

public class Cliente {
	TraductorInicio Trad1;
	TraductorEliminarcion Trad2;
	Client client;
	WebTarget target;
	
	
	/**
	 * El cliente se instancia con enfoque a generar oleadas o actualizarlas
	 * por lo que recibe un true si es para iniciar una oleada y false de contrario
	 * @param inicio
	 */
	public Cliente(boolean inicio) {
		client= ClientBuilder.newBuilder().build();
		if (inicio) {
			Trad1=new TraductorInicio();
			target= client.target("http://localhost:8080/ProyectoServidor/webapi/inicio");
		}
		else {
			Trad2=new TraductorEliminarcion();
			target= client.target("http://localhost:8080/ProyectoServidor/webapi/eliminar");
		}
	}
	
	/**
	 * Metodo que agrupa las traducciones necesarias para enviar al servidor un tamano de oleada y ronda,
	 * recibir un xml y guardar la oleada completa resultante
	 * @param Cantidad tama;o de la oleada
	 * @param Ronda ronda actual para asignar nombres
	 * @return la oleada generada
	 * @throws JDOMException 
	 * @throws IOException
	 */
	public Oleada RequestGen(int Cantidad,int Ronda) throws JDOMException, IOException {
		 String xml=Trad1.CantidadToXML(Cantidad,Ronda);
		 String res = target.request().post(Entity.entity(xml, MediaType.TEXT_XML), String.class);
		 Oleada nueva=Trad1.getOleadaFull(res);
		 nueva.setDragonesDibujar(nueva.toArray());
		 return nueva;
	 }
	/**
	 * Metodo que agrupa las truducciones necesarias para enviar el arbol actual, el dragon muerto y el criterio de ordenamiento
	 * el request recupera un xml con el arbol actualizado y la alineacion a dibujar luego lo traduce en un nuevo arbol para
	 * sustutuir el viejo
	 * @param Inicial oleada a actualizar
	 * @param criterio alineacion esperada
	 * @param DragonEliminar dragon muerto
	 * @return la oleada con la alineacion y el arbol actualizado
	 * @throws JDOMException
	 * @throws IOException
	 */
	public Oleada RequestAlineacion(Oleada Inicial,int criterio,Dragon DragonEliminar) throws JDOMException, IOException {
		 if (Inicial.getCantidadDragones()==1) {
			 return new Oleada();
		 }
		 String xml2=Trad2.ToXML(Inicial,criterio,DragonEliminar.getEdad());
		 String res3 = target.request().post(Entity.entity(xml2, MediaType.TEXT_XML), String.class);
		 return Trad2.GetOleadaId(res3);
	}
}
