/**
 *
 */
package eapli.util;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * @author Paulo Gandra Sousa
 * 
 */
public final class Strings {

	private Strings() {

	}

	public static String prettyFormat(String input) {
		return prettyFormat(input, 2);
	}

	/**
	 * returns an XML formated output.
	 * <p>
	 * based in code from
	 * http://stackoverflow.com/questions/139076/how-to-pretty
	 * -print-xml-from-java
	 * 
	 * @param input
	 * @param indent
	 * @return
	 */
	public static String prettyFormat(String input, int indent) {
		try {
			Source xmlInput = new StreamSource(new StringReader(input));
			StringWriter stringWriter = new StringWriter();
			StreamResult xmlOutput = new StreamResult(stringWriter);
			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			transformerFactory.setAttribute("indent-number", indent);
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(xmlInput, xmlOutput);
			return xmlOutput.getWriter().toString();
		} catch (Exception e) {
			throw new RuntimeException(e); // simple exception handling, please
			// review it
		}
	}
}
