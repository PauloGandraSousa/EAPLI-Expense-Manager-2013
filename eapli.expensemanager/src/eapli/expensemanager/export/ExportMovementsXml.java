/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eapli.expensemanager.export;

import eapli.expensemanager.model.Movement;
import eapli.expensemanager.persistence.CheckingAccountRepository;
import eapli.expensemanager.persistence.PersistenceFactory;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 *
 * @author Fernando
 */
public class ExportMovementsXml implements IExportMovementsStrategy {

    public String getOutput() {
        String xmlMovements = getMovementsInXml();
        String xml = prettyFormat(xmlMovements);
        save(xml, "ExportMovements.xml");
        return xml;
    }

    public String getMovementsInXml() {
        List<Movement> listMovements = getMovements();
        // An alternative would be using the builder and visitor pattern
        StringBuilder xml = new StringBuilder("<movements>");
        for (int i = 0; i < listMovements.size(); i++) {
            xml.append(listMovements.get(i).toXml()).append("\n");
        }
        xml.append("</movements>");
        return xml.toString();
    }

    public List<Movement> getMovements() {
        CheckingAccountRepository repo = PersistenceFactory
                .buildPersistenceFactory().checkingAccountRepository();
        return repo.theAccount().getMovements();
    }
 
    public String prettyFormat(String input) {
        return prettyFormat(input, 2);
    }
    
    /**
     *
     * based in code from
     * http://stackoverflow.com/questions/139076/how-to-pretty-print-xml-from-java
     *
     * @param input
     * @param indent
     * @return
     */
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

    public void save(String xml, String fileName) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(xml);
        }
        catch (IOException e) { }
        finally {
            try {
                writer.close( );
            }
            catch(IOException e) {}
	}
    }
}
