package xmlparse;

import java.io.File;
import java.io.IOException;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import org.xml.sax.SAXException;
import javax.xml.validation.Schema;
import javax.xml.validation.Validator;

public class domParserSchema {

	public static void main(String[] args) {
		System.out.println("This program will validate XML against XSD file!");
		if(validateXMLSchema("bookstore.xsd","bookstore.xml") == true) {
			System.out.println("Validation is successful.");
		}
		else
			System.out.println("Validation is unsuccessful.");
	}

private static Boolean validateXMLSchema(String fileXsd, String fileXml) { 
            try {
            	SchemaFactory bookstore = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
                Schema schema = bookstore.newSchema(new File(fileXsd));
                Validator validator = schema.newValidator();
				validator.validate(new StreamSource(new File(fileXml)));
			} catch (SAXException e) {
				return false;// TODO Auto-generated catch block
				
			} catch (IOException e) {
				return false;// TODO Auto-generated catch block
				
			}

        return true;
    }

}