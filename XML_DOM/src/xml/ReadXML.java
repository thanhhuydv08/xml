package xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadXML {

	public static void main(String[] args) throws  SAXException, IOException {
		// TODO Auto-generated method stub
      String maKH="",tenKH="";
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();//nha may
		DocumentBuilder db;
		try {
			db = dbf.newDocumentBuilder();
			Document doc = db.parse(new File("src/xml/khoa.xml"));
			Element e = doc.getDocumentElement();
			System.out.println(e.getNodeName());
			NodeList nodeList = e.getChildNodes();
			System.out.println("chieu dai root :"+nodeList.getLength());
			for(int i=0;i<nodeList.getLength();i++) {
				System.out.println("node con :"+nodeList.item(i).getNodeName());
		       Node node = nodeList.item(i);
		      // System.out.println("kieu node : "+node);
		       if(node.getNodeType()==1) {
		    	  if(node.getNodeName().equals("tenKH")) {
		    		  maKH= node.getTextContent();
		    	  }// check xem co node text enter xuong ding khong neu co phai loai bo ngay
		    	  else tenKH = node.getTextContent();
			}
			
			}
			
			System.out.println("Gia tri cua node : "+tenKH+"-"+maKH);
			
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}// nguoi tao
		
	
		
		
	}

}
