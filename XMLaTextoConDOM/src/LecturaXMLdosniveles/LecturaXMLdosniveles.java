package LecturaXMLdosniveles;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class LecturaXMLdosniveles {
    public static void main (String args[]) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("Personas.xml");
            document.getDocumentElement().normalize();

            System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());

            NodeList empleados = document.getElementsByTagName("DatosPersona");

            System.out.printf("Nodos persona a recorrer: %d %n", empleados.getLength());

            for (int i = 0; i < empleados.getLength(); i++) {
                Node emple = empleados.item(i);
                if (emple.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) emple;
                    System.out.printf("nombre = [%12s] - edad = %s %n", elemento.getElementsByTagName("nombre").item(0).getTextContent(), elemento.getElementsByTagName("edad").item(0).getTextContent());
                }
            }
        } catch (Exception e)
        {e.printStackTrace();}
    }
}
