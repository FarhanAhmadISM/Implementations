package org.example;

import org.example.searchEngine.NormalSearchEngine;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NormalSearchEngineTest {
    NormalSearchEngine searchEngine;

    Document document1;
    Document document2;

    @BeforeEach
    void setUp() {
        searchEngine = new NormalSearchEngine();
        document1 = new Document("Company1", "InMobi");
        document2 = new Document("company2", "Pending");
    }

    @Test
    void createAndDeleteDataset() {
        searchEngine.createDataset("Farhan Ahmad");
        Assertions.assertEquals(1, searchEngine.getSearchEngine().size());

        searchEngine.deleteDataset("Farhan Ahmad");
        Assertions.assertFalse(searchEngine.getSearchEngine().containsKey("Farhan Ahmad"));
        Assertions.assertEquals(0, searchEngine.getSearchEngine().size());

    }

    @Test
    void insertAndSearchDocument() {
        searchEngine.createDataset("Farhan Ahmad");
        searchEngine.insertDocument("Farhan Ahmad", document1);
        searchEngine.insertDocument("Farhan Ahmad", document2);

        Document document = searchEngine.searchDocument("Farhan Ahmad", document1.getDocumentName());
        Assertions.assertNotNull(document);
        document = searchEngine.searchDocument("Farhan Ahmad", document2.getDocumentName());
        Assertions.assertNotNull(document);

        document = searchEngine.searchDocument("Farhan Ahmad", "dummy");
        Assertions.assertNull(document);
    }

}