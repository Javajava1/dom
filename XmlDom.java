import java.io.File;

//import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
//import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Element;

public class XmlDom {

	public static void main(String[] args) throws ParserConfigurationException, TransformerException {
		// TODO Auto-generated method stub
		//创建DucumentBuilderFactory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//创建DucumentBuilder
		DocumentBuilder builder=factory.newDocumentBuilder();
		//创建Document
		//Document document =(Document) builder.newDocument();
		org.w3c.dom.Document document = builder.newDocument();
		// 设置XML声明中standalone为yes，即没有dtd和schema作为该XML的说明文档，且不显示该属性
        // document.setXmlStandalone(true);
		//创建根节点
		Element Team=document.createElement("Team");
		Element Teammember=document.createElement("Teammember");
		//添加子节点
	
		Element Empon=document.createElement("Empon");
		Empon.setAttribute("value", "30772");
		Element Name=document.createElement("Name");
		Name.setAttribute("value","Manjeet Singh" );
		Element Designation=document.createElement("Designation");
		Designation.setAttribute("value","Team Leader");
		Teammember.appendChild(Empon);
		Teammember.appendChild(Name);
		Teammember.appendChild(Designation);
		Team.appendChild(Teammember);
		document.appendChild(Team);
		//创建TransformerFactory对象
		TransformerFactory tff=TransformerFactory.newInstance();
		//创建transformer对象
		Transformer tf=tff.newTransformer();
		//使用Tranformer的tranform()方法将dom树转换成xml
		File dest=new File("demo.txt");
		tf.setOutputProperty(OutputKeys.INDENT, "yes");
		tf.transform(new DOMSource(document), new StreamResult(dest));
		
		System.out.println("已生成对应文件");
		
		
		
		
	}

}
