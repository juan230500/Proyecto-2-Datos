package servidor;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.jdom2.JDOMException;

import juego.Oleada;

public class Cliente {
	
	public static void main(String[] args) throws InterruptedException, JDOMException, IOException {
		
		long time_start, time_end;
		time_start = System.currentTimeMillis();
		
		TraductorInicio Trad1=new TraductorInicio();
		
		Client client = ClientBuilder.newBuilder()
		          .build();
		
		 WebTarget target = client.target("http://localhost:8080/ProyectoServidor/webapi/inicio");
		 
		 String xml=Trad1.CantidadToXMl(10);
		 
		 String res3 = target.request().post(Entity.entity(xml, MediaType.TEXT_XML), String.class);
		 
		 Oleada O=Trad1.GetOleadaFull(res3);
		 
		 O.display();
		 
		time_end = System.currentTimeMillis();
		System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
		
		
	}
}
