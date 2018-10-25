package servidor;

import java.io.IOException;
import java.io.StringReader;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import adt.Oleada;
import juego.Dragon;

public class Traductor {
	Dragon[] ArrayPorID;
	int i=0;
	
	/**
	 * Método principal para generar la oleada en el servidor a partir
	 * de un xml que manda el cliente
	 * @param XML string con el xml
	 * @return una oleada que se reordenará
	 * @throws JDOMException
	 * @throws IOException
	 */
	public Oleada GenOleada(String XML) throws JDOMException, IOException {
    	SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(new StringReader(XML));
        Element Root = document.getRootElement();
        
        Oleada OleadaNueva=new Oleada(1);
        
        DesempaquetarArbol(Root, OleadaNueva.getRoot());
        
        return OleadaNueva;
    }
    
    public void DesempaquetarAtributos(Element ElementoDragon, Dragon dragon) {
    	int Edad=Integer.parseInt(ElementoDragon.getAttribute("edad").getValue());
    	dragon.setEdad(Edad);
    	int Recarga=Integer.parseInt(ElementoDragon.getAttribute("recarga").getValue());
    	dragon.setRecarga(Recarga);
    	int Id=Integer.parseInt(ElementoDragon.getAttribute("id").getValue());
    	dragon.setId(Id);
    }
    
    public void DesempaquetarArbol(Element Root,Dragon node) {
    	DesempaquetarAtributos(Root, node);
    	
    	Element Iz=Root.getChild("hijoIz");
    	if (Iz!=null) {
    		Dragon hijoIz=new Dragon();
    		DesempaquetarArbol(Iz,hijoIz);
    		node.setHijoIz(hijoIz);
    	}
    	
    	Element Der=Root.getChild("hijoDer");
    	if (Der!=null) {
    		Dragon hijoDer=new Dragon();
    		DesempaquetarArbol(Der,hijoDer);
    		node.setHijoDer(hijoDer);
    	}
    }
    /**
     * Método que convierte la oleada del cliente en una string
     * que contiene el xml de los dragones y sus datos relevantes al ordenamiento
     * @param O oleada a convertir a xml
     * @return la string con el formato xml
     */
    public String ToXML(Oleada O) {
    	Element Padre = new Element("root");
    	this.ArrayPorID=new Dragon[O.getCantidadDragones()];
    	EmpaquetarAtributos(O.getRoot(), Padre);
        Document doc = new Document(Padre);

        return new XMLOutputter().outputString(doc);
    }
    
    public void EmpaquetarAtributos(Dragon dragon, Element destino) {
    	if (dragon!=null) {
	    	destino.setAttribute(new Attribute("edad",""+dragon.getEdad()));
	    	destino.setAttribute(new Attribute("recarga",""+dragon.getRecarga()));
	    	destino.setAttribute(new Attribute("id",""+""+this.i));
	    	
	    	this.ArrayPorID[i]=dragon;
	    	this.i++;
	    	
	    	if (dragon.getHijoIz()!=null) {
	    		Element hijoIz = new Element("hijoIz");
		    	EmpaquetarAtributos(dragon.getHijoIz(), hijoIz);
		    	destino.addContent(hijoIz);
	    	}
	    	if (dragon.getHijoDer()!=null) {
	    		Element hijoDer = new Element("hijoDer");
		    	EmpaquetarAtributos(dragon.getHijoDer(), hijoDer);
		    	destino.addContent(hijoDer);
	    	}
    	}
    }
}
