package eapli.expensemanager.presentation;

import eapli.expensemanager.controllers.BaseController;
import eapli.expensemanager.controllers.ExportMovementsController;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class ExportMovementsToXmlUI extends BaseForm {

    private ExportMovementsController controller = new ExportMovementsController();

    @Override
    protected BaseController controller() {
        return controller;
    }

    public void run() {
        System.out.println("-- EXPORT MOVEMENTS TO XML --");
        String xmlMovements = controller.getMovementsInXml();
//        System.out.println(xmlMovements);
        System.out.println(prettyFormat(xmlMovements));
    }
    
    @Override
    public boolean doShow() {
        String xmlMovements = controller.getMovementsInXml();
        System.out.println(prettyFormat(xmlMovements));
        System.out.println("= = = = = = = = = = =");
        System.out.println(xmlMovements);
        
        return true;
    }

    // http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java
    
    public String prettyFormat(String input, int indent) {
        try {
            Source xmlInput = new StreamSource(new StringReader(input));
            StringWriter stringWriter = new StringWriter();
            StreamResult xmlOutput = new StreamResult(stringWriter);
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            transformerFactory.setAttribute("indent-number", indent);
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(xmlInput, xmlOutput);
            return xmlOutput.getWriter().toString();
        } catch (Exception e) {
            throw new RuntimeException(e); // simple exception handling, please review it
        }
    }

    public String prettyFormat(String input) {
        return prettyFormat(input, 2);
    }

    @Override
    public String headline() {
        return "EXPORT MOVEMENTS TO XML";    
    }
}
