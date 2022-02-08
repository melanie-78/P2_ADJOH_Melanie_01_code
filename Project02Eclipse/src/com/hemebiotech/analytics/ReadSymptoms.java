package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ReadSymptoms {

    private String filepath;

    /**
     * @param filepath a full or partial path to file with symptom strings in it, one per line
     */

    public ReadSymptoms(String filepath) {

        this.filepath = filepath;
    }

    /**
     * @return a Map of all Symptoms obtained from a data source, with for each symptom the number of occurences, duplicates are possible/probable
     */
    public Map<String, Integer> getSymptoms() {

        Map<String, Integer> symptomsRecap = new HashMap<String, Integer>();

        if (filepath != null) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(filepath));
                String line = reader.readLine();

                while (line != null) {
                    if (!symptomsRecap.containsKey(line)) {
                        symptomsRecap.put(line, 1);
                    } else {
                        Integer symptomValue = symptomsRecap.get(line);
                        symptomsRecap.put(line, symptomValue + 1);
                    }

                    line = reader.readLine();
                }
                reader.close();

            } catch (IOException e) {
                System.out.println("Could not load file");
            }

        }
        return symptomsRecap;
    }
}
