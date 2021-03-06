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
	private TraductorInicio Trad1=new TraductorInicio();
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String getIt() throws JDOMException, IOException {
		Oleada OleadaTmp=new Oleada(1,Trad1.getRonda());
		String XML=Trad1.ToXMLFull(OleadaTmp);
		return XML;
	}
	/**
	 * Recibe un xml conn el tamano de la oleada y la ronda actual, genera una oleada temporal con 
	 * fabricadragones y la traduce a xml para que el cliente la desempaquete en su nueva oleada inicial
	 * @param request
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
	@POST
	@Produces(MediaType.TEXT_XML)
	public String RequestGenerarOleada(String request) throws JDOMException, IOException {
		Trad1.getDatosOleada(request);
		Oleada OleadaTmp=new Oleada(Trad1.getCantidadDragones(),Trad1.getRonda());
		OleadaTmp.display();
		String XML=Trad1.ToXMLFull(OleadaTmp);
		return XML;
	}

}
