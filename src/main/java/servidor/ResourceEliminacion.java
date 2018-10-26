package servidor;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import adt.AVLTree;
import juego.Dragon;
import juego.Oleada;

import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

/**
 * Root resource (exposed at "myresource" path)
 */
@Path("eliminar")
public class ResourceEliminacion {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
	Oleada OleadaPruebas=new Oleada(10);
	Oleada OleadaInterna;
	TraductorEliminarcion Trad=new TraductorEliminarcion();
	
    @GET
    @Produces(MediaType.TEXT_XML)
    public String getIt() throws JDOMException, IOException {
    	String fin=Trad.ToXML(OleadaPruebas);
    	OleadaInterna=Trad.GetOleada(fin);
    	Dragon[] ArrayInterno=Trad.getArrayPorID();
    	
    	OleadaInterna.display();
    	OleadaInterna.Realinear(4);
    	
    	String XML=Trad.AVLtoXML(OleadaInterna.getRootAVL());
    	
    	AVLTree tree=Trad.DesempaquetarAVL(ArrayInterno, XML);
    	tree.preOrder();
    	/*System.out.println(Arrays.toString(ArrayInterno));
    	
    	Trad.DesempaquetarIDArray(ArrayInterno, Trad.ArraytoXML(ArrayInterno));
    	*/
    	return fin;
    }
    
    @POST
    @Produces(MediaType.TEXT_XML)
    public String Respuesta() {
        return Trad.ToXML(OleadaPruebas);
    }
    
    
}
