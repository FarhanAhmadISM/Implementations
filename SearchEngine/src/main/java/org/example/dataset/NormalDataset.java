package org.example.dataset;

import org.example.Document;

import java.util.ArrayList;
import java.util.List;

public class NormalDataset implements Dataset{
    List<Document> documents;
    String datasetName;
    public NormalDataset(String datasetName) {
        this.documents = new ArrayList<>();
        this.datasetName = datasetName;
    }

    @Override
    public void insertDocument(Document document) {
        if (document != null) {
            Document existingDocument = documents
                    .stream()
                    .filter(document1 -> document1.getDocumentName().equals(document.getDocumentName()))
                    .findFirst()
                    .orElse(null);
            documents.remove(existingDocument);
            documents.add(document);
        }
    }

    @Override
    public Document searchDocument(String documentName) {
        return documents
                .stream()
                .filter(document -> document.getDocumentName().equals(documentName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteAllDocument() {
        documents = null;
        datasetName = null;
    }
}
