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

public class TraductorEliminarcion {
	Dragon[] ArrayPorID;
	int i=0;
	int CantidadDragones;
	int criterio;
	int EdadEliminar;
	Dragon DragonEliminar;
	private static final Logger slf4jLogger = LoggerFactory.getLogger(TraductorEliminarcion.class);
	
	/**
     * Método que convierte la oleada del cliente en una string
     * que contiene el xml de los dragones y sus datos relevantes al ordenamiento
     * @param O oleada a convertir a xml
     * @return la string con el formato xml
     */
    public String ToXML(Oleada O,int criterio,int EdadEliminar) {
        
        slf4jLogger.info("Traduciendo...");
    	Element Request = new Element("info");
    	Request.setAttribute(new Attribute("criterio",""+criterio));
    	Request.setAttribute(new Attribute("edadEliminar",""+EdadEliminar));
    	
    	Element Padre = new Element("root");
    	this.ArrayPorID=new Dragon[O.getCantidadDragones()];
    	this.i=0;
    	this.criterio=criterio;
    	EmpaquetarAtributos(O.getRoot(), Padre);
    	
    	Request.addContent(Padre);
        Document doc = new Document(Request);

        return new XMLOutputter().outputString(doc);
    }
    
    private void EmpaquetarAtributos(Dragon dragon, Element destino) {
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
        System.out.println(XML);
        
        Element Principal = document.getRootElement();
        int criterio=Integer.parseInt(Principal.getAttribute("criterio").getValue());
    	this.criterio=criterio;
    	int edadEliminar=Integer.parseInt(Principal.getAttribute("edadEliminar").getValue());
    	this.EdadEliminar=edadEliminar;
        
        Element Root = Principal.getChild("root");
        
        Oleada OleadaNueva=new Oleada();
        OleadaNueva.setRoot(new Dragon());
        this.CantidadDragones=0;
        
        DesempaquetarArbol(Root, OleadaNueva.getRoot());
        
        this.CantidadDragones--;
        
        OleadaNueva.setCantidadDragones(this.CantidadDragones);
        
        return OleadaNueva;
    }
    
    private void DesempaquetarArbol(Element Root,Dragon node) {
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
    
    private void DesempaquetarAtributos(Element ElementoDragon, Dragon dragon) {
    	this.CantidadDragones++;
    	int Edad=Integer.parseInt(ElementoDragon.getAttribute("edad").getValue());
    	dragon.setEdad(Edad);
    	int Recarga=Integer.parseInt(ElementoDragon.getAttribute("recarga").getValue());
    	dragon.setRecarga(Recarga);
    	int Id=Integer.parseInt(ElementoDragon.getAttribute("id").getValue());
    	dragon.setId(Id);
    	
    	if (Edad==this.EdadEliminar)
    		this.DragonEliminar=dragon;
    }

    /**
     * Emtodo principal que toma los ID de los dragones ordenados en el arbol temporal
     * y los escribe en un arbol por familias para que se actualice en el cliente
     * ademas escribe tanto array o avl para dibujarlos, el ABB no porque con actualizarlo en el cliente es suficiente
     * @param O
     * @return
     */
	public String IDToXMl(Oleada O) {
    	Element Principal = new Element("principal");

    	Element Padre = this.IDArboltoXML(O);
    	Principal.addContent(Padre);
    	if (this.criterio<3) {
    		Element Array = this.ArraytoXML(O.getDragonesDibujar());
        	Principal.addContent(Array);
    	}
    	else if (this.criterio==4) {
    		Element AVL = this.AVLtoXML(O.getRootAVL());
        	Principal.addContent(AVL);
    	}
        Document doc = new Document(Principal);
        return new XMLOutputter().outputString(doc);
    }
    
    private Element IDArboltoXML(Oleada O) {
    	Element Padre = new Element("root");
    	EmpaquetarID(O.getRoot(), Padre);
        return Padre;
    }
    
    private void EmpaquetarID(Dragon dragon, Element destino) {
    	destino.setAttribute(new Attribute("id",""+""+dragon.getId()));
    	
    	if (dragon.getHijoIz()!=null) {
    		Element hijoIz = new Element("hijoIz");
    		EmpaquetarID(dragon.getHijoIz(), hijoIz);
	    	destino.addContent(hijoIz);
    	}
    	if (dragon.getHijoDer()!=null) {
    		Element hijoDer = new Element("hijoDer");
    		EmpaquetarID(dragon.getHijoDer(), hijoDer);
	    	destino.addContent(hijoDer);
    	}
    }
    
    private Element ArraytoXML(Dragon[] ArrayDragones) {
		Element Padre = new Element("Array");
		for (int i=0;i<ArrayDragones.length;i++) {
			Element Puntero=new Element("id");
			Puntero.setText(""+ArrayDragones[i].getId());
			Padre.addContent(Puntero);
		}
        return Padre;
	}
	
	private Element AVLtoXML(Node root) {
		Element Padre = new Element("AVL");
        EmpaquetarAVL(root, Padre);
        return Padre;
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
	 * Metodo Que toma el xml que da el servidor con los ID que asigno al inicio a los dragones
	 * y actuliza los hijos y padres del arbol del cliente y guarda el avl o array ordenado dentro de mismo
	 * @param XML
	 * @return
	 * @throws JDOMException
	 * @throws IOException
	 */
    public Oleada GetOleadaId(String XML) throws JDOMException, IOException {
    	SAXBuilder saxBuilder = new SAXBuilder();
        Document document = saxBuilder.build(new StringReader(XML));
        
        Element Principal = document.getRootElement();
        
        Element Root = Principal.getChild("root");
        
        Oleada OleadaNueva=new Oleada();
        int id=Integer.parseInt(Root.getAttribute("id").getValue());
        Dragon root=this.ArrayPorID[id].copy();
        CicloArrayCopias();
        this.ArrayPorID[id].setPadre(null);
        OleadaNueva.setRoot(this.ArrayPorID[id]);
        this.CantidadDragones=0;
        
        if (this.criterio<3) {
        	Element Array = Principal.getChild("Array");
        	OleadaNueva.setDragonesDibujar(DesempaquetarIDArray(Array));
        }
        else if (this.criterio==4) {
        	Element AVL = Principal.getChild("AVL");
        	OleadaNueva.setRootAVL(DesempaquetarAVL(AVL));
        }
        
        DesempaquetarArbolID(Root, OleadaNueva.getRoot());
        
        OleadaNueva.setCantidadDragones(this.CantidadDragones);
        
        return OleadaNueva;
    }
    
    private void CicloArrayCopias() {
    	int largo=this.ArrayPorID.length;
    	for (int temp = 0; temp < largo; temp++) {
    		this.ArrayPorID[temp].getLabel().setVisible(false);
    		this.ArrayPorID[temp]=this.ArrayPorID[temp].copy();
        }
    }
    
    private void DesempaquetarArbolID(Element Root,Dragon node) {
    	this.CantidadDragones++;
    	
    	
    	Element Iz=Root.getChild("hijoIz");
    	if (Iz!=null) {
    		int id=Integer.parseInt(Iz.getAttribute("id").getValue());
    		Dragon hijoIz=this.ArrayPorID[id];
        	node.setHijoIz(hijoIz);
    		DesempaquetarArbolID(Iz,hijoIz);
    		
    	}
    	else {
    		node.setHijoIz(null);
    	}
    	
    	Element Der=Root.getChild("hijoDer");
    	if (Der!=null) {
    		int id=Integer.parseInt(Der.getAttribute("id").getValue());
    		Dragon hijoDer=this.ArrayPorID[id];
        	node.setHijoDer(hijoDer);
    		DesempaquetarArbolID(Der,hijoDer);
    	}
    	else {
    		node.setHijoDer(null);
    	}
    }
    
    private Dragon[] DesempaquetarIDArray(Element Root) throws JDOMException, IOException {
        List<Element> IdList = Root.getChildren();
        Dragon[] ArrayDragonesFinal=new Dragon[IdList.size()];
        
        for (int temp = 0; temp < IdList.size(); temp++) {    
            Element student = IdList.get(temp);
            
            int id=Integer.parseInt(student.getText());
            
            ArrayDragonesFinal[temp]=this.ArrayPorID[id];
        }
        return ArrayDragonesFinal;
	}

    private Node DesempaquetarAVL(Element Root) throws JDOMException, IOException {
        AVLTree tree=new AVLTree();
        int id=Integer.parseInt(Root.getText());
        tree.setRoot(new Node(this.ArrayPorID[id]));
        DesempaquetarAVLREc(Root,tree.getRoot());
        tree.preOrder();
        return tree.getRoot();
	}
	
	private void DesempaquetarAVLREc(Element Root,Node node) {
		int id;
		
    	Element Iz=Root.getChild("hijoIz");
    	if (Iz!=null) {
    		id=Integer.parseInt(Iz.getText());
    		Node hijoIz=new Node(this.ArrayPorID[id]);
    		DesempaquetarAVLREc(Iz,hijoIz);
    		node.left=hijoIz;
    	}
    	
    	Element Der=Root.getChild("hijoDer");
    	if (Der!=null) {
    		id=Integer.parseInt(Der.getText());
    		Node hijoDer=new Node(this.ArrayPorID[id]);
    		DesempaquetarAVLREc(Der,hijoDer);
    		node.right=hijoDer;
    	}
    }
	
	
	
	public Dragon[] getArrayPorID() {
		return ArrayPorID;
	}
	
	public int getCriterio() {
		return criterio;
	}

	public Dragon getDragonEliminar() {
		return DragonEliminar;
	}
    
	
}
