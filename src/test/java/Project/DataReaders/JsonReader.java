package Project.DataReaders;

import java.util.List;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonReader {
	
	public static <T> List<T> getSpecificdata(String Key,Class<T> classType) throws Exception 
	{
		ObjectMapper mapper=new ObjectMapper();
		JsonNode rootNode=mapper.readTree(new File("src/test/resources/DataProviders/TestData.json"));
		JsonNode specificNode=rootNode.get(Key);
		return mapper.readerForListOf(classType).readValue(specificNode);
	
	}
}
