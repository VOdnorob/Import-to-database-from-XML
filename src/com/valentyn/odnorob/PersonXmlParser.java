package com.valentyn.odnorob;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class PersonXmlParser {

    public ArrayList parseXml(InputStream inputStream){

        ArrayList<Person> personList = new ArrayList<Person>();
        ArrayList<Contact> contactList = new ArrayList<Contact>();
        ArrayList<ArrayList> contactsAndPerson = new ArrayList<ArrayList>();
        try {
            PersonParserHandler handler = new PersonParserHandler();

            XMLReader parser = XMLReaderFactory.createXMLReader();

            parser.setContentHandler(handler);

            InputSource source = new InputSource(inputStream);

            parser.parse(source);

            contactsAndPerson.add(personList = handler.getPersonList());
            contactsAndPerson.add(contactList = handler.getContactsList());
        }catch (SAXException | IOException ex){
            ex.printStackTrace();
        }
        return contactsAndPerson;
    }
}
