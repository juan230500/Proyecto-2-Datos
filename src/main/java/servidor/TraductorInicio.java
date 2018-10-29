package servidor;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;

import adt.LinkedList;
import adt.Node_Linked;
import juego.Dragon;
import juego.Oleada;

public class TraductorInicio {
	
	private int CantidadDragones;
	private int Ronda;
	
	public int getCantidadDragones() {
		return CantidadDragones;
	}

	public int getRonda() {
		return Ronda;
	}

	public String CantidadToXML(int cantidad,int ronda) {
		Element Padre = new Element("Cantidad");
		Padre.setText(""+cantidad);
		Padre.setAttribute(new Attribute("ronda",""+ronda));
        Document doc = new Document(Padre);
        return new XMLOutputter().outputString(doc);
	}
	
	public void getDatosOleada(String XML) throws JDOMException, IOException {
		SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(new StringReader(XML));
        Element Root = document.getRootElement();
        this.CantidadDragones=Integer.parseInt(Root.getText());
        this.Ronda=Integer.parseInt(Root.getAttributeValue("ronda"));
	}
	
	public String ToXMLFull(Oleada O) {
		Element Padre = new Element("root");
        Document doc = new Document(Padre);
        EmpaquetarAtributosFull(O.getRoot(), Padre);
        return new XMLOutputter().outputString(doc);
	}
	
	private void EmpaquetarAtributosFull(Dragon dragon, Element destino) {
    	destino.setAttribute(new Attribute("edad",""+dragon.getEdad()));
    	destino.setAttribute(new Attribute("recarga",""+dragon.getRecarga()));
    	destino.setAttribute(new Attribute("resistencia",""+dragon.getResistencia()));
    	destino.setAttribute(new Attribute("nombre",""+dragon.getNombre()));
    	destino.setAttribute(new Attribute("clase",""+dragon.getClase()));
    	
    	if (dragon.getClase()=="Capitán") {
    		Element i = new Element("Mando");
    		EmpaquetarInfanteria(i, dragon);
    		destino.addContent(i);
    	}
    	
    	if (dragon.getHijoIz()!=null) {
    		Element hijoIz = new Element("hijoIz");
	    	EmpaquetarAtributosFull(dragon.getHijoIz(), hijoIz);
	    	destino.addContent(hijoIz);
    	}
    	if (dragon.getHijoDer()!=null) {
    		Element hijoDer = new Element("hijoDer");
	    	EmpaquetarAtributosFull(dragon.getHijoDer(), hijoDer);
	    	destino.addContent(hijoDer);
    	}
    	
    }
	
	private void EmpaquetarInfanteria(Element Root,Dragon dragon) {
		LinkedList Infanterias=dragon.getDragones_asignados();
		Node_Linked  tmp=Infanterias.getHead();
		while (tmp!=null) {
			Element i = new Element("Infanteria");
			i.setText(""+((Dragon) tmp.getData()).getNombre());
			Root.addContent(i);
			tmp=tmp.getNext();
		}
	}
	
	public Oleada getOleadaFull(String XML) throws JDOMException, IOException {
		SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(new StringReader(XML));
        Element Root = document.getRootElement();
        
        Oleada OleadaNueva=new Oleada(1,1);
        this.CantidadDragones=0;
        
        DesempaquetarArbol(Root, OleadaNueva.getRoot());
        
        OleadaNueva.setCantidadDragones(this.CantidadDragones);
        
        return OleadaNueva;
	}
	
    private void DesempaquetarArbol(Element Root,Dragon node) {
    	DesempaquetarAtributos(Root, node);
    	
    	Element mando=Root.getChild("Mando");
    	if (mando!=null) {
    		List<Element> studentList = mando.getChildren();
    		LinkedList L=new LinkedList();
            for (int temp = 0; temp < studentList.size(); temp++) {    
               Element tmp = studentList.get(temp);
               L.insertFirst(tmp.getText());
            }
            node.setDragones_asignados(L);
    	}
    	
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
    
     void DesempaquetarAtributos(Element ElementoDragon, final Dragon dragon) {
    	this.CantidadDragones++;
    	int edad=Integer.parseInt(ElementoDragon.getAttribute("edad").getValue());
    	dragon.setEdad(edad);
    	int recarga=Integer.parseInt(ElementoDragon.getAttribute("recarga").getValue());
    	dragon.setRecarga(recarga);
    	int resistencia=Integer.parseInt(ElementoDragon.getAttribute("resistencia").getValue());
    	dragon.setResistencia(resistencia);
    	String nombre=ElementoDragon.getAttribute("nombre").getValue();
    	dragon.setNombre(nombre);
    	String clase=ElementoDragon.getAttribute("clase").getValue();
    	dragon.setClase(clase);
    	
    	dragon.getLabel().setText(dragon.getNombre());
        dragon.getLabel().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                dragon.setClick(true);
            }
        });
    }

}

