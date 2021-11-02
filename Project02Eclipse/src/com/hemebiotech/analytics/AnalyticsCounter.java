package com.hemebiotech.analytics;

import java.io.*;
import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.TreeMap;

import static java.util.Map.Entry.comparingByKey;


public class AnalyticsCounter {
	// private static int headacheCount = 0;
	private static int rashCount = 0;		// initialize to 0
	private static int pupilCount = 0;		// initialize to 0
	
	public static void main(String args[]) throws Exception{
		// first get input
		BufferedReader reader = new BufferedReader (new FileReader("symptoms.txt"));
		String line = reader.readLine();

		Map<String,Integer> symptomsRecap = new HashMap<String, Integer>();

		while (line != null) {
			if (!symptomsRecap.containsKey(line)){
				symptomsRecap.put(line, 1);
			} else {
				Integer symptomValue = symptomsRecap.get(line);
				symptomsRecap.put(line, symptomValue +1);
			}

			line = reader.readLine();	// get another symptom
		}

		Map<String, Integer> result = new TreeMap<String, Integer>(symptomsRecap);

		// next generate output
		FileWriter writer = new FileWriter ("result.out");

		for (Map.Entry<String, Integer> entry : result.entrySet()) {
			writer.write(entry.getKey() +": " + entry.getValue() + "\n");
		}
		writer.close();
	}
}
