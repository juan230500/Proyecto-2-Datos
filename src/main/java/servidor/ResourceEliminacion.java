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
	Oleada OleadaPruebas=new Oleada(10,1);
	Oleada OleadaInterna;
	TraductorEliminarcion Trad=new TraductorEliminarcion();
	
    @GET
    @Produces(MediaType.TEXT_XML)
    public String getIt() throws JDOMException, IOException {
    	String fin=Trad.ToXML(OleadaPruebas,0,4);
    	/*OleadaInterna=Trad.GetOleada(fin);
    	Dragon[] ArrayInterno=Trad.getArrayPorID();
    	
    	OleadaInterna.display();
    	OleadaInterna.Realinear(4);
    	
    	String XML=Trad.AVLtoXML(OleadaInterna.getRootAVL());
    	
    	AVLTree tree=Trad.DesempaquetarAVL(ArrayInterno, XML);
    	tree.preOrder();
    	/*System.out.println(Arrays.toString(ArrayInterno));
    	
    	Trad.DesempaquetarIDArray(ArrayInterno, Trad.ArraytoXML(ArrayInterno));*/
    	
    	return fin;
    }
    
    /**
     * recibe peticiones de elimnar un dragon, convierte el arbol que recibe en uno temporal
     * para elimniar el nodo correctamente y tambien crea la alineacion deseada
     * @param request xml con la oleada a actulizar, el dragon a eliminar y el criterio
     * @return un xml con la oleada actualizada y la alineacion a dibujar
     * @throws JDOMException
     * @throws IOException
     */
    @POST
    @Produces(MediaType.TEXT_XML)
    public String RequestEliminar(String request) throws JDOMException, IOException {
    	Oleada Oleadatmp=Trad.GetOleada(request);
    	Oleadatmp.delete(Trad.getDragonEliminar());
    	Oleadatmp.Realinear(Trad.getCriterio());
        return Trad.IDToXMl(Oleadatmp);
    }
    
    
}
