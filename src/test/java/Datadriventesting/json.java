package Datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class json {public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	//parser json physical file into java object using json
	//parser class
	JSONParser parser=new JSONParser();//convert json file into java object json parser act as a translater
	Object obj = parser.parse(new FileReader("./configdata/commondata.json.txt"));
	
	//to retreat the data convert the java object into json object by typecasting
	JSONObject obj1=(JSONObject)obj;
	
	//read the data using get() by passing key
	System.out.println(obj1.get("browser"));
	System.out.println(obj1.get("url"));
	System.out.println(obj1.get("username"));
	System.out.println(obj1.get("password"));
	
	
}

}
