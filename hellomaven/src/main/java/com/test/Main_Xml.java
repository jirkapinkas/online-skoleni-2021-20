package com.test;

import com.test.mapper.TableCat;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.ByteArrayInputStream;

public class Main_Xml {

    public static void main(String[] args) throws JAXBException {
        TableCat tableCat = TableCat.builder()
                .id(1)
                .alive(true)
                .lives(9)
                .name("Cica")
                .color("blue")
                .build();
        JAXBContext context = JAXBContext.newInstance(TableCat.class);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(tableCat, System.out);

        String inputXml = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><tableCat><alive>true</alive><color>blue</color><id>1</id><lives>9</lives><name>Cica</name></tableCat>";
        Unmarshaller unmarshaller = context.createUnmarshaller();
        TableCat tableCat2 = (TableCat) unmarshaller.unmarshal(new ByteArrayInputStream(inputXml.getBytes()));
        System.out.println(tableCat2);
    }

}
