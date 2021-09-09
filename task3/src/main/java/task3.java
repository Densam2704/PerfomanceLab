import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.*;
import serializer.NestedTestSerializer;
import serializer.NestedTestWrapperSerializer;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class task3 {
  private static HashMap<Integer, String> values;
  private static NestedTestWrapper tests;
  private static NestedTestWrapper report;
  public static final String reportFilename = "report.json";
  
  public static void main(String[] args) throws IOException {
	if (args.length < 2) {
	  System.out.println("Not enough args!");
	  return;
	}
	readValuesJSON(args[1]);
	readTestsJSON(args[0]);
	writeReportJSON(reportFilename, formReportJSON());
  }
  
  private static void readValuesJSON(String filename) throws IOException {
	String json = getJSONStringFromFile(filename);
	ValueWrapper wrapper = new Gson().fromJson(json, ValueWrapper.class);
	values = wrapper.toHashMap();
  }
  
  private static String getJSONStringFromFile(String filename) throws IOException {
	FileReader fileReader = new FileReader(filename);
	Scanner scanner = new Scanner(fileReader);
	String json = "";
	while (scanner.hasNext()) {
	  json += scanner.nextLine();
	}
	scanner.close();
	fileReader.close();
	return json;
  }
  
  private static void readTestsJSON(String filename) throws IOException {
	String json = getJSONStringFromFile(filename);
	tests = new Gson().fromJson(json, NestedTestWrapper.class);
	
  }
  
  private static String formReportJSON() {
	report = tests;
	for (NestedTest nt :
			report.getTests()) {
	  if (values.containsKey(nt.getId())) {
		nt.setValue(values.get(nt.getId()));
		System.out.println(nt);
	  }
	  readRecursively(nt);
	}
	
	//Регистрация сериализатора
	Gson gson = new GsonBuilder()
			.setPrettyPrinting()
			.registerTypeAdapter(NestedTestWrapper.class, new NestedTestWrapperSerializer())
			.registerTypeAdapter(NestedTest.class, new NestedTestSerializer())
			.create();
	
	return gson.toJson(report);
  }
  
  private static void readRecursively(NestedTest nt) {
	if (nt.getValues() != null)
	  for (NestedTest deeperLayer :
			  nt.getValues()) {
		if (values.containsKey(deeperLayer.getId())) {
		  deeperLayer.setValue(values.get(deeperLayer.getId()));
		  System.out.println(deeperLayer);
		}
		readRecursively(deeperLayer);
	  }
  }
  
  
  private static void writeReportJSON(String reportFilename, String json) throws IOException {
	FileWriter fileWriter = new FileWriter(reportFilename);
	fileWriter.write(json);
	fileWriter.flush();
	fileWriter.close();
  }
}
