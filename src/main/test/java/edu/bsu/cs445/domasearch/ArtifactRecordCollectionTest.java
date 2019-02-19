package edu.bsu.cs445.domasearch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static edu.bsu.cs445.domasearch.SearchPane.searchByTitle;

class ArtifactRecordCollectionTest {

    @Test
    void testCountRecordsByTitleQuery_emptyString_zero() {
        ArtifactRecordCollection collection = ArtifactRecordCollection.createEmpty();
        int count = collection.countRecordsByTitleQuery("");
        searchByTitle = true;
        Assertions.assertEquals(0, count);
    }

    @Test
    void testCountRecordsByTitleQuery_oneItemMatch_one() {
        ArtifactRecord record = ArtifactRecord.withTitle("Foo");
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(record);
        int count = collection.countRecordsByTitleQuery("Foo");
        Assertions.assertEquals(1, count);
    }

    @Test
    void testCountRecordsByTitleQuery_noItemsMatchInNonemptyCollection_zero() {
        ArtifactRecord record = ArtifactRecord.withTitle("Foo");
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(record);
        int count = collection.countRecordsByTitleQuery("Bar");
        Assertions.assertEquals(0, count);
    }

    @Test
    void testCountRecordsByTitleQuery_twoItemsMatch_two() {
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(
                ArtifactRecord.withTitle("Foo"),
                ArtifactRecord.withTitle("Fool"));
        int count = collection.countRecordsByTitleQuery("Foo");
        Assertions.assertEquals(2, count);
    }

    @Test
    void testSearchTitles() {
        final String testTitle = "Foo";
        ArtifactRecordCollection collection = ArtifactRecordCollection.of(
                ArtifactRecord.withTitle(testTitle)
        );
        List<ArtifactRecord> result = collection.searchTitles(testTitle);
        Assertions.assertEquals(testTitle, result.get(0).getTitle());
    }
}
