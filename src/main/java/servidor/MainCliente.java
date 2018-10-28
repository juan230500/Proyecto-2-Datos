package servidor;

import java.io.IOException;

import org.jdom2.JDOMException;

import juego.Oleada;

public class MainCliente {

	public static void main(String[] args) throws JDOMException, IOException {
		long time_start, time_end;
		
		time_start = System.currentTimeMillis();
		
		Cliente C1=new Cliente(true);
		
		C1.RequestGen(100,2).display();
		
		/*Cliente C2=new Cliente(false);
		
		Oleada O=new Oleada(20,4);
		
		O=C2.RequestAlineacion(O, 4, O.getRoot());*/
		
		 /*for (int i=11;i>10;i--) {
			 Oleada O=new Oleada(i);
			 String xml2=Trad2.ToXML(O,4,900);
			 O.display();
			 String res3 = target.request().post(Entity.entity(xml2, MediaType.TEXT_XML), String.class);
			 O=Trad2.GetOleadaId(res3);
			 O.display();
			 System.out.println(res3);
		 }*/
		 
		 //System.out.println(xml2);
		 
		 /*String xml=Trad1.CantidadToXMl(10);
		 
		 String res3 = target.request().post(Entity.entity(xml, MediaType.TEXT_XML), String.class);
		 
		 Oleada O=Trad1.GetOleadaFull(res3);
		 
		 O.display();*/
		 
		 time_end = System.currentTimeMillis();
		 System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
	}

}
