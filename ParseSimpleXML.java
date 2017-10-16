import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParseSimpleXML {

	Element root=null;
	ParseSimpleXML(){
	
	
	try {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc=builder.parse("5.4.xml");
		doc.normalize();
		root=doc.getDocumentElement();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	public void Parse(){
		System.out.println("<?xml version = \"1.0\"?>");
		System.out.println("<"+root.getNodeName()+">");
		NodeList children=root.getChildNodes();
		for(int i=0;i<children.getLength();i++){
			Node child=children.item(i);
			if(child.getNodeType()==Node.ELEMENT_NODE){
				System.out.println("<"+child.getNodeName()+">");
				System.out.println(child.getFirstChild().getNodeValue());
				System.out.println("</"+child.getNodeName()+">");
				
			}
		}
		System.out.println("</"+root.getNodeName()+">");
	}
}
