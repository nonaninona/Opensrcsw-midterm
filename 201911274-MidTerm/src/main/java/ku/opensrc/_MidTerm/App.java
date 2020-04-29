package ku.opensrc._MidTerm;
import java.io.*;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException, ParseException
    {
    	
    	System.out.print("Enter the keyword you are looking for : ");
    	Scanner console = new Scanner(System.in);
    	String input = console.next();
    	String[] words = input.split("\\|");
    	
        JSONParser jsonParser = new JSONParser();
        
        //파일 경로는 다를 수 있음
        try {
        	
	    	FileReader reader = new FileReader("C:\\Users\\이현희\\Desktop\\02보관함\\오픈소스SW\\github\\201911274-MidTerm\\MidTerm.json");
	  
	        JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
	        JSONArray infoArray = (JSONArray) jsonObject.get("poem");
	        
	        for(int i=0;i<infoArray.size();i++) {
	        	JSONObject itemObject = (JSONObject) infoArray.get(i);
	        	String data = (String)itemObject.get("item");
	        	
	          	boolean isprint = false;
	        	for(int j=0;j<words.length;j++) {
	        		if(data.indexOf(words[j]) != -1)
	        			isprint = true;
	        	}
	        	if(!isprint) {
	        		continue;
	        	}
	        	
	        	System.out.println("item " + i + " : " + data);
	        }
	        console.close();
	        reader.close();
	        
        }catch(FileNotFoundException e) {
        	System.out.println("get FileNotFoundException : " + e.getMessage() );
        }
    	
    }
}
