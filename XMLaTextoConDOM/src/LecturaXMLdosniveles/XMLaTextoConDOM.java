package LecturaXMLdosniveles;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

public class  XMLaTextoConDOM {
    public static void main (String args[]) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("Personas.xml");
            document.getDocumentElement().normalize();
            //create an ArrayList to hold the traces
            ArrayList<String> stringList = new ArrayList<>();
// Create a ByteArrayOutputStream to capture the output
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            // Create a PrintStream that writes to the ByteArrayOutputStream
            PrintStream printStream = new PrintStream(outputStream);
            // Redirect System.out to the custom PrintStream
            System.setOut(printStream);

            stringList.add(String.format("Elemento raiz: %s %n", document.getDocumentElement().getNodeName()));

            NodeList empleados = document.getElementsByTagName("DatosPersona");

            stringList.add(String.format("Nodos persona a recorrer: %d %n", empleados.getLength()));

            for (int i = 0; i < empleados.getLength(); i++) {
                Node emple = empleados.item(i);
                if (emple.getNodeType() == Node.ELEMENT_NODE) {
                    Element elemento = (Element) emple;
                    stringList.add(String.format("nombre = [%12s] - edad = %s %n", elemento.getElementsByTagName("nombre").item(0).getTextContent(), elemento.getElementsByTagName("edad").item(0).getTextContent()));
                }
            }
        XMLaTextoConDOM XMLTCD = new XMLaTextoConDOM();
            EscribeEnFicheroDOM EEFCD = XMLTCD.new EscribeEnFicheroDOM();
            EEFCD.EscribeEnFicheroDOMMethod();
        } catch (Exception e)
        {e.printStackTrace();}
    }
    public class  EscribeEnFicheroDOM () {
        public void EscribeEnFicheroDOMMethod () {
        File fichero = new File ("PersonasDOM.txt");
        if (!fichero.exists()) {
            fichero.delete();
            System.out.println("Fichero PersonasDOM.txt ya existia. Fichero borrado");
        }
        else{
            try {

            }

            }

        }
        }
    }
}
