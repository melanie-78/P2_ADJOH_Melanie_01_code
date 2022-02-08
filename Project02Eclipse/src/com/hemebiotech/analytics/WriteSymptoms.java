package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class WriteSymptoms {

    private Map<String, Integer> symptomsRecap;
    private String filename;

    /**
     *
     * @param symptomsRecap a Map of Symptoms, with for each symptom the number of occurences
     */

    public WriteSymptoms (Map<String, Integer> symptomsRecap, String filename){
        this.symptomsRecap= symptomsRecap;
        this.filename = filename;
    }

    /**
     * Don't return anything
     *
     * the Map provided is sorted and the result is written to a file called "result.out"
     */
    public void writeSymptoms() {

        Map<String, Integer> result = new TreeMap<String, Integer>(symptomsRecap);

        // next generate output
        try {
            FileWriter writer = new FileWriter(filename);

            for (Map.Entry<String, Integer> entry : result.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Could not load file");
        }
    }
}
