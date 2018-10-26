package servidor;

import java.io.IOException;
import java.io.StringReader;
import java.util.Arrays;
import java.util.List;

import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.XMLOutputter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import adt.AVLTree;
import adt.Node;
import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;
import juego.Dragon;
import juego.Oleada;

public class Traductor {
	Dragon[] ArrayPorID;
	
	public Dragon[] getArrayPorID() {
		return ArrayPorID;
	}

	int i=0;
	int CantidadDragones;
	private static final Logger slf4jLogger = LoggerFactory.getLogger(Traductor.class);
	
	public Dragon[] DesempaquetarIDArray(Dragon[] ArrayDragonesOriginal,String XML) throws JDOMException, IOException {
		SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(new StringReader(XML));
        Element Root = document.getRootElement();
        
        List<Element> IdList = Root.getChildren();
        Dragon[] ArrayDragonesFinal=new Dragon[IdList.size()];
        
        for (int temp = 0; temp < IdList.size(); temp++) {    
            Element student = IdList.get(temp);
            
            int id=Integer.parseInt(student.getText());
            
            ArrayDragonesFinal[temp]=ArrayDragonesOriginal[id];
        }
        System.out.println(Arrays.toString(ArrayDragonesFinal));
        return ArrayDragonesFinal;
	}
	
	public AVLTree DesempaquetarAVL(Dragon[] ArrayDragonesOriginal,String XML) throws JDOMException, IOException {
		SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(new StringReader(XML));
        Element Root = document.getRootElement();
        
        AVLTree tree=new AVLTree();
        int id=Integer.parseInt(Root.getText());
        tree.setRoot(new Node(ArrayDragonesOriginal[id]));
        
        DesempaquetarAVLREc(Root,tree.getRoot(),ArrayDragonesOriginal);
        
        return tree;
	}
	
	public void DesempaquetarAVLREc(Element Root,Node node,Dragon[] ArrayDragonesOriginal) {
		int id;
		
    	Element Iz=Root.getChild("hijoIz");
    	if (Iz!=null) {
    		id=Integer.parseInt(Iz.getText());
    		Node hijoIz=new Node(ArrayDragonesOriginal[id]);
    		DesempaquetarAVLREc(Iz,hijoIz,ArrayDragonesOriginal);
    		node.left=hijoIz;
    	}
    	
    	Element Der=Root.getChild("hijoDer");
    	if (Der!=null) {
    		id=Integer.parseInt(Der.getText());
    		Node hijoDer=new Node(ArrayDragonesOriginal[id]);
    		DesempaquetarAVLREc(Der,hijoDer,ArrayDragonesOriginal);
    		node.right=hijoDer;
    	}
    }
	
	public String ArraytoXML(Dragon[] ArrayDragones) {
		Element Padre = new Element("root");
		for (int i=0;i<ArrayDragones.length;i++) {
			Element Puntero=new Element("id");
			Puntero.setText(""+ArrayDragones[i].getId());
			Padre.addContent(Puntero);
		}
        Document doc = new Document(Padre);
        System.out.println(new XMLOutputter().outputString(doc));
        return new XMLOutputter().outputString(doc);
	}
	
	public String AVLtoXML(Node root) {
		Element Padre = new Element("root");
        Document doc = new Document(Padre);
        EmpaquetarAVL(root, Padre);
        System.out.println(new XMLOutputter().outputString(doc));
        return new XMLOutputter().outputString(doc);
	}
	
	private void EmpaquetarAVL(Node node,Element Padre)
    {
    	Padre.setText(""+node.key.getId());
    	if (node.left!=null) {
    		Element hijoIz = new Element("hijoIz");
    		EmpaquetarAVL(node.left, hijoIz);
	    	Padre.addContent(hijoIz);
    	}
    	if (node.right!=null) {
    		Element hijoDer = new Element("hijoDer");
    		EmpaquetarAVL(node.right, hijoDer);
    		Padre.addContent(hijoDer);
    	}
    }
	
	/**
	 * Método principal para generar la oleada en el servidor a partir
	 * de un xml que manda el cliente
	 * @param XML string con el xml
	 * @return una oleada que se reordenará
	 * @throws JDOMException
	 * @throws IOException
	 */
	public Oleada GetOleada(String XML) throws JDOMException, IOException {
    	SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(new StringReader(XML));
        Element Root = document.getRootElement();
        
        Oleada OleadaNueva=new Oleada(1);
        this.CantidadDragones=0;
        
        DesempaquetarArbol(Root, OleadaNueva.getRoot());
        
        OleadaNueva.setCantidadDragones(this.CantidadDragones);
        
        return OleadaNueva;
    }
    
    public void DesempaquetarAtributos(Element ElementoDragon, Dragon dragon) {
    	this.CantidadDragones++;
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
        
        slf4jLogger.info("Traduciendo...");
        LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
        // print logback's internal status
        StatusPrinter.print(lc);
        System.out.println("$$$");
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
