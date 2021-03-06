package servidor;

import java.io.IOException;
import java.util.Arrays;

import org.jdom2.JDOMException;

import adt.Node;
import juego.Dragon;
import juego.Oleada;

public class MainCliente {

	public static void main(String[] args) throws JDOMException, IOException {
		long time_start, time_end;
		
		time_start = System.currentTimeMillis();
		
		/*Cliente C1=new Cliente(true);
		
		C1.RequestGen(100,2).display();*/
		
		
		
		Cliente C2=new Cliente(false);
		
		Oleada O=new Oleada(20,4);
		
		O.display();
		
		Dragon D[]=O.toArray();
		
		System.out.println(Arrays.toString(D));
		
		for (int i=0;i<D.length;i++) {
			System.out.println(O.getCantidadDragones());
			Oleada nueva=C2.RequestAlineacion(O, i%5, D[i]);
			
			Dragon[] ArrayD=nueva.getDragonesDibujar();
			Node RootAVL=nueva.getRootAVL();
			
			if (nueva.getCantidadDragones()==0) {
				O.setDragonesDibujar(ArrayD);
				O.setRootAVL(nueva.getRootAVL());
			}
			else {
				if (ArrayD!=null) {
					O.setDragonesDibujar(ArrayD);
				}
				if (RootAVL!=null) {
					O.setRootAVL(nueva.getRootAVL());
				}
			}
			O.setCantidadDragones(nueva.getCantidadDragones());
			O.setRoot(nueva.getRoot());
			
			System.out.println(Arrays.toString(O.getDragonesDibujar()));
			System.out.println(O.getRootAVL());
			System.out.println(O.getCantidadDragones());
			
			
		}
		
		
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
