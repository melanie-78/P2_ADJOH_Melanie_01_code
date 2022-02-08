package com.hemebiotech.analytics;

import java.util.Map;

public class AnalyticsCounter {

	public static final String SYMPTOM_INPUT_FILENAME = "symptoms.txt";
	public static final String SYMPTOM_OUTPUT_FILENAME = "result.out";

	public static void main(String args[]){
	    ReadSymptoms readerSymtomps = new ReadSymptoms(SYMPTOM_INPUT_FILENAME);
		Map<String, Integer> symptoms = readerSymtomps.getSymptoms();

		WriteSymptoms writerSymptoms = new WriteSymptoms(symptoms, SYMPTOM_OUTPUT_FILENAME);
		writerSymptoms.writeSymptoms();
	}
}
