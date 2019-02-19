package edu.bsu.cs445.domasearch;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

public class JaxbParser {

    public static JaxbParser create() {
        return new JaxbParser();
    }

    public ArtifactRecordCollection parse(InputStream input) {
        try {
            JAXBContext context = JAXBContext.newInstance(ArtifactRecordCollection.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (ArtifactRecordCollection)unmarshaller.unmarshal(input);
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }
    }
}
