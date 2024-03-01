package org.example.searchEngine;

import org.example.Document;
import org.example.dataset.NormalDataset;

import java.util.HashMap;

public class NormalSearchEngine implements SearchEngine{
    HashMap<String, NormalDataset> searchEngine;

    public NormalSearchEngine() {
        searchEngine = new HashMap<>();
    }

    public HashMap<String, NormalDataset> getSearchEngine() {
        return searchEngine;
    }

    @Override
    public void createDataset(String datasetName) {
        if (searchEngine.containsKey(datasetName)) {
            System.out.println("Dataset already exists");
            return;
        }
        searchEngine.put(datasetName, new NormalDataset(datasetName));
    }

    @Override
    public void deleteDataset(String datasetName) {
        if (!searchEngine.containsKey(datasetName)) {
            System.out.println("Dataset doesn't exist");
            return;
        }
        NormalDataset normalDataset = searchEngine.get(datasetName);
        normalDataset.deleteAllDocument();
        searchEngine.remove(datasetName);
    }
    @Override
    public void insertDocument(String datasetName, Document document) {
        if (!searchEngine.containsKey(datasetName)) {
            System.out.println("Dataset doesn't exist");
            return;
        }
        NormalDataset normalDataset = searchEngine.get(datasetName);
        normalDataset.insertDocument(document);
    }

    @Override
    public Document searchDocument(String datasetName, String documentName) {
        if (!searchEngine.containsKey(datasetName)) {
            System.out.println("Dataset doesn't exist");
            return null;
        }
        NormalDataset normalDataset = searchEngine.get(datasetName);
        return normalDataset.searchDocument(documentName);
    }
}
