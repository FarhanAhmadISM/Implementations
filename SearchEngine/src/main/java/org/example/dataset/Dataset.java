package org.example.dataset;

import org.example.Document;

public interface Dataset {

    void insertDocument(Document document);

    Document searchDocument(String documentName);

    void deleteAllDocument();
}
