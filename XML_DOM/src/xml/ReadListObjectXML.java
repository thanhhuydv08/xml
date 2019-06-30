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

public class ReadListObjectXML {

	public static void main(String[] args) throws SAXException, IOException {
		// TODO Auto-generated method stub
String makh="",tenkh="";
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = documentBuilderFactory.newDocumentBuilder();
			Document doc = db.parse(new File("src/xml/dskhoa.xml"));
			Element e = doc.getDocumentElement();
			NodeList list1 = e.getElementsByTagName("khoa");//ok  mang cua dskhoa la 3 chua vao sau node cua khoa
			for(int i=0; i<list1.getLength();i++) {
				Node node1 = list1.item(i);
				NodeList list2 = node1.getChildNodes();
				for(int j=0;j<list2.getLength();j++) {
					//System.out.println(list2.getLength());//ok  vao duoc notde trong khoa co chiu dai 5 roi
					Node node2 = list2.item(i);
					if(node2.getNodeType()==1) {
						if(node2.getNodeName().equals("makh")) {
							makh=node2.getTextContent();
						}else {tenkh = node2.getTextContent();}
					}
					
				}
				
				
			}
			System.out.println(makh+"-"+tenkh);

			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
