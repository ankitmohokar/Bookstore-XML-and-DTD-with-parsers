package xmlparse;

import java.io.*;
import org.xml.sax.*;
import javax.xml.parsers.*;

public class domParserDTD {
	public static void main(String args[]) {	
		try{
			System.out.println("This is XML parser against DTD!");
			DocumentBuilderFactory fac = DocumentBuilderFactory.newInstance();					
			fac.setValidating(true);															
			DocumentBuilder builder = fac.newDocumentBuilder();									
			builder.setErrorHandler(new org.xml.sax.ErrorHandler() {
				
				public void fatalError(SAXParseException exception)throws SAXException { }
																									
				public void error(SAXParseException e)throws SAXParseException {
					System.out.println("Please check the error at line: " +e.getLineNumber());					
					System.out.println(e.getMessage());
					System.exit(0);	
				}
				public void warning(SAXParseException err)throws SAXParseException{				
					System.out.println(err.getMessage());
					System.exit(0);
				}
			});			
				builder.parse(new FileInputStream("bookstore.xml"));									
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("The XML is validated successfully against the DTD!");
	}
}