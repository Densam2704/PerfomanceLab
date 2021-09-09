package serializer;

import com.google.gson.*;
import model.NestedTest;
import model.NestedTestWrapper;

import java.lang.reflect.Type;

public class NestedTestWrapperSerializer implements JsonSerializer<NestedTestWrapper> {
  @Override
  public JsonElement serialize(NestedTestWrapper src, Type type, JsonSerializationContext context) {
	JsonObject result = new JsonObject();
	JsonArray tests = new JsonArray();
	result.add("tests",tests);
	for (NestedTest test :
			src.getTests()) {
	  tests.add(
			  test instanceof NestedTest ?
					  context.serialize(test) :
					  new JsonObject()
	  );
	}
	return result;
  }
}
