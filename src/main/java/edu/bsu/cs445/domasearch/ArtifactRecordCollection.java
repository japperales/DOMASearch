package edu.bsu.cs445.domasearch;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name="metadata")
@XmlAccessorType(XmlAccessType.FIELD)
public
class ArtifactRecordCollection {

    static ArtifactRecordCollection of(ArtifactRecord... records) {
        Preconditions.checkNotNull(records, "Parameter may not be null");
        ArtifactRecordCollection collection = new ArtifactRecordCollection();
        collection.items.addAll(Arrays.asList(records));
        return collection;
    }

    public int size() {
        return items.size();
    }

    static ArtifactRecordCollection createEmpty() {
        return new ArtifactRecordCollection();
    }

    int countRecordsByTitleQuery(String query) {
        List<ArtifactRecord> result = searchTitles(query);
        return result.size();
    }

    // This item is used by the JAXB parsing but not used in custom code.
    @SuppressWarnings({"unused","MismatchedQueryAndUpdateOfCollection"})
    @XmlElement(name="record")
    private List<ArtifactRecord> items = Lists.newArrayList();

    List<ArtifactRecord> searchTitles(String query) {
        List<ArtifactRecord> result = items.stream()
                .filter(artifactRecord -> artifactRecord.getTitle().contains(query))
                .map(artifactRecord -> new ArtifactRecord(artifactRecord.getTitle(),artifactRecord.getArtist(),artifactRecord.getDateMade(),artifactRecord.getItemURL()))
                .collect(Collectors.toList());
        return ImmutableList.copyOf(result);
    }

    List<ArtifactRecord> searchArtist(String query) {
        List<ArtifactRecord> result = items.stream()
                .filter(artifactRecord -> artifactRecord.getArtist().contains(query))
                .map(artifactRecord -> new ArtifactRecord(artifactRecord.getTitle(),artifactRecord.getArtist(),artifactRecord.getDateMade(),artifactRecord.getItemURL()))
                .collect(Collectors.toList());
        return ImmutableList.copyOf(result);
    }

    List<ArtifactRecord> searchDate(String query) {
        List<ArtifactRecord> result = items.stream()
                .filter(artifactRecord -> artifactRecord.getDateMade().contains(query))
                .map(artifactRecord -> new ArtifactRecord(artifactRecord.getTitle(),artifactRecord.getArtist(),artifactRecord.getDateMade(),artifactRecord.getItemURL()))
                .collect(Collectors.toList());
        return ImmutableList.copyOf(result);
    }




}
