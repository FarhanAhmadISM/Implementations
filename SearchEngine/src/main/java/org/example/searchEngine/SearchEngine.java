package org.example.searchEngine;

import org.example.Document;

public interface SearchEngine {
    void createDataset(String datasetName);
    void deleteDataset(String datasetName);
    void insertDocument(String datasetName, Document document);
    Document searchDocument(String datasetName, String documentName);
}
