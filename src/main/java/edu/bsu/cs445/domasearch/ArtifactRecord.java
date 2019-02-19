package edu.bsu.cs445.domasearch;

import com.google.common.base.Preconditions;
import javafx.beans.property.SimpleStringProperty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="record")
@XmlAccessorType(XmlAccessType.FIELD)
class ArtifactRecord {

    static ArtifactRecord withTitle(String title) {
        ArtifactRecord record = new ArtifactRecord(title,null,null,null);
        record.title = Preconditions.checkNotNull(title);
        return record;
    }

    ArtifactRecord(String title, String artist, String dateMade, String itemURL){
        this.title = title;
        this.artist = artist;
        this.dateMade = dateMade;
        this.itemURL= itemURL;
    }

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Title")
    private String title;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="CONTENTdm_File_Name")
    private String fileName;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Artist")
    private String artist;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Date_Made")
    private String dateMade;

    @SuppressWarnings("unused") // Not set in source code, but set through JAXB.
    @XmlElement(name="Item_URL")
    private String itemURL;

    String getTitle() {
        return title;
    }

    String getFileName() { return fileName; }

    String getArtist() {
        return artist;
    }

    String getDateMade() {
        return dateMade;
    }

    String getItemURL(){
        return itemURL;
    }

}
