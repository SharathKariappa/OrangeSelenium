package Project.DataReaders;

import java.io.FileInputStream;
import java.util.Properties;



public class ConfigReader {
	
	private static Properties properties;
	private static final String propertyFilePath = "src/test/resources/DataProviders/ConfigurationData.properties";
	static
	{
		try(FileInputStream fis=new FileInputStream(propertyFilePath)) 
		{
			properties=new Properties();
			properties.load(fis);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String Key)
	{
		String value=properties.getProperty(Key);
		if(value!=null)
		return value;
		else
		throw new RuntimeException("Key '" + Key + "' not found in ConfigurationData.properties");
		
	}	
	
	
}
