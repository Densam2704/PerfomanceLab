package serializer;

import com.google.gson.*;
import model.NestedTest;

import java.lang.reflect.Type;

public class NestedTestSerializer implements JsonSerializer<NestedTest> {
  @Override
  public JsonElement serialize(NestedTest src, Type type, JsonSerializationContext context) {
	JsonObject result = new JsonObject();
 
	result.addProperty("id", src.getId());
	result.addProperty("title", src.getTitle());
	result.addProperty("value", src.getValue());
	JsonArray values = new JsonArray();
	
	if (src.getValues()!=null){
	  result.add("values",values);
	  for (NestedTest test :
			  src.getValues()) {
		values.add(
				test instanceof NestedTest ?
						context.serialize(test) :
						new JsonObject()
		);
	  }
	}
	
	
 
	return result;
  }
}
