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
	TraductorInicio Trad1=new TraductorInicio();
	TraductorEliminarcion Trad2=new TraductorEliminarcion();
	Client client;
	WebTarget target;
	
	public Cliente(boolean inicio) {
		
		client= ClientBuilder.newBuilder().build();
		
		if (inicio) {
			target= client.target("http://localhost:8080/ProyectoServidor/webapi/inicio");
		}
		else {
			target= client.target("http://localhost:8080/ProyectoServidor/webapi/eliminar");
		}
		
	}

	public Oleada RequestGen(int Cantidad,int Ronda) throws JDOMException, IOException {
		 String xml=Trad1.CantidadToXML(Cantidad,Ronda);
		 String res = target.request().post(Entity.entity(xml, MediaType.TEXT_XML), String.class);
		 Oleada nueva=Trad1.getOleadaFull(res);
		 nueva.setDragonesDibujar(nueva.toArray());
		 return nueva;
	 }
	
	public Oleada RequestAlineacion(Oleada Inicial,int criterio,Dragon DragonEliminar) throws JDOMException, IOException {
		 if (Inicial.getCantidadDragones()==1) {
			 return new Oleada();
		 }
		 String xml2=Trad2.ToXML(Inicial,criterio,DragonEliminar.getEdad());
		 String res3 = target.request().post(Entity.entity(xml2, MediaType.TEXT_XML), String.class);
		 return Trad2.GetOleadaId(res3);
	}
}
