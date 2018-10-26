package servidor;

import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jdom2.JDOMException;

import juego.Oleada;

@Path("inicio")
public class ResourceInicio {
	
	private Oleada OleadaInterna;
	private TraductorInicio Trad1=new TraductorInicio();
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String getIt() throws JDOMException, IOException {
		String XML=Trad1.CantidadToXMl(100);
		int i=Trad1.GetCantidad(XML);
		System.out.println(i);
		Oleada OleadaTmp=new Oleada(i);
		System.out.println(XML);
		XML=Trad1.ToXMLFull(OleadaTmp);
		return XML;
	}
	
	@POST
	@Produces(MediaType.TEXT_XML)
	public String getout(String request) throws JDOMException, IOException {
		int i=Trad1.GetCantidad(request);
		Oleada OleadaTmp=new Oleada(i);
		OleadaTmp.display();
		String XML=Trad1.ToXMLFull(OleadaTmp);
		return Trad1.ToXMLFull(OleadaTmp);
	}

}
