package org.example;

public class Document {
    String documentName;
    String content;

    public Document(String documentName, String content) {
        this.documentName = documentName;
        this.content = content;
    }

    public String getDocumentName() {
        return documentName;
    }
}
