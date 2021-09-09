package model;

import java.util.HashMap;
import java.util.List;

public class ValueWrapper {
  List <Value>values;
  
  public ValueWrapper(List<Value> values) {
	this.values = values;
  }
  
  public ValueWrapper() {
  }
  
  public List<Value> getValues() {
	return values;
  }
  
  public void setValues(List<Value> values) {
	this.values = values;
  }
  
  @Override
  public String toString() {
	String res="";
	for (Value v :
			values) {
	  res+=values.toString();
	}
	return res;
  }
  
  public HashMap<Integer,String> toHashMap(){
	if(values==null)
	  return null;
	HashMap<Integer,String> result = new HashMap<>();
	for (Value v :
			this.getValues()) {
	  result.put(v.getId(), v.getValue());
	}
	return result;
  }
}
