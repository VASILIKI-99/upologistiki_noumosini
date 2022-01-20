package ask2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

public class randomPoints {
	private static HashMap<Float,Float> map1=new HashMap<Float,Float>();//Creating HashMap    
	private static HashMap<Float,Float> map2=new HashMap<Float,Float>();//Creating HashMap 
	private static  HashMap<Float,Float> map3=new HashMap<Float,Float>();//Creating HashMap 
	private static  HashMap<Float,Float> map4=new HashMap<Float,Float>();//Creating HashMap 
	private static  HashMap<Float,Float> map5=new HashMap<Float,Float>();//Creating HashMap 
	private static HashMap<Float,Float> map6=new HashMap<Float,Float>();//Creating HashMap 
	private static  HashMap<Float,Float> map7=new HashMap<Float,Float>();//Creating HashMap 
	private static  HashMap<Float,Float> map8=new HashMap<Float,Float>();//Creating HashMap 
	private static  HashMap<Float,Float> map9=new HashMap<Float,Float>();//Creating HashMap 
	private static  HashMap<Float,Float> map10=new HashMap<Float,Float>();//Creating HashMap 
	final static String outputFilePath= "write.txt";
	//private static final int M = 3;
	//edw dimourgountai ta tuxaia simeia
	public static Map<Float, Float> makeRandomPoints() {
		
		for (int i = 0; i < 150; i++) {
			//System.out.println(nextFloatBetween2(0.75f,1.15f));
			float x = nextFloatBetween2(0.75f,1.25f);
			float y = nextFloatBetween2(0.75f,1.25f);
			//System.out.println(x +"," + y);
			map1.put(x,y);  //Put elements in Map  
				
		}

		
		
		for (int i = 0; i < 150; i++) {
			//System.out.println(nextFloatBetween2(0.75f,1.15f));
			float x = nextFloatBetween2(0.0f,0.5f);
			float y = nextFloatBetween2(0.0f,0.5f);
			//System.out.println(x +"," + y);
			map2.put(x,y);  //Put elements in Map  
					
		}
		for (int i = 0; i < 150; i++) {
			//System.out.println(nextFloatBetween2(0.75f,1.15f));
			float x = nextFloatBetween2(0.0f,0.5f);
			float y = nextFloatBetween2(1.5f,2.0f);
			//System.out.println(x +"," + y);
			map3.put(x,y);  //Put elements in Map  
						
		}
		for (int i = 0; i < 150; i++) {
			//System.out.println(nextFloatBetween2(0.75f,1.15f));
			float x = nextFloatBetween2(1.5f,2.0f);
			float y = nextFloatBetween2(0.0f,0.5f);
			//System.out.println(x +"," + y);
			map4.put(x,y);  //Put elements in Map  
						
		}
		for (int i = 0; i < 150; i++) {
			//System.out.println(nextFloatBetween2(0.75f,1.15f));
			float x = nextFloatBetween2(1.5f,2.0f);
			float y = nextFloatBetween2(1.5f,2.0f);
			//System.out.println(x +"," + y);
			map5.put(x,y);  //Put elements in Map  
						
		}

		for (int i = 0; i < 75; i++) {
			//System.out.println(nextFloatBetween2(0.75f,1.15f));
			float x = nextFloatBetween2(0.6f,0.8f);
			float y = nextFloatBetween2(0.0f,0.4f);
			//System.out.println(x +"," + y);
			map6.put(x,y);  //Put elements in Map  
						
		}
		for (int i = 0; i < 75; i++) {
			//System.out.println(nextFloatBetween2(0.75f,1.15f));
			float x = nextFloatBetween2(0.6f,0.8f);
			float y = nextFloatBetween2(1.6f,2.0f);
			//System.out.println(x +"," + y);
			map7.put(x,y);  //Put elements in Map  
						
		}
		for (int i = 0; i < 75; i++) {
			//System.out.println(nextFloatBetween2(0.75f,1.15f));
			float x = nextFloatBetween2(1.2f,1.4f);
			float y = nextFloatBetween2(0.0f,0.4f);
			//System.out.println(x +"," + y);
			map8.put(x,y);  //Put elements in Map  
						
		}
		for (int i = 0; i < 75; i++) {
			//System.out.println(nextFloatBetween2(0.75f,1.15f));
			float x = nextFloatBetween2(1.2f,1.4f);
			float y = nextFloatBetween2(1.6f,2.0f);
			//System.out.println(x +"," + y);
			map9.put(x,y);  //Put elements in Map  
						
		}
		for (int i = 0; i < 150; i++) {
			//System.out.println(nextFloatBetween2(0.75f,1.15f));
			float x = nextFloatBetween2(0.0f,2.0f);
			float y = nextFloatBetween2(0.0f,2.0f);
			//System.out.println(x +"," + y);
			map10.put(x,y);  //Put elements in Map  
						
		}
		
	     // create new HashMap
	     HashMap<String, String> map = new HashMap<String, String>();



	     // new file object
	     File file = new File(outputFilePath);

	     BufferedWriter bf = null;
	   
	        
	     try {

	         // create new BufferedWriter for the output file
	         bf = new BufferedWriter(new FileWriter(file));

	         // iterate map entries
	         for (Entry<Float, Float> entry : map1.entrySet()) {

	             // put key and value separated by a colon
	             bf.write(entry.getKey() + "," + entry.getValue());

	             // new line
	             bf.newLine();
	         }
	         
			
	         for (Entry<Float, Float> entry : map2.entrySet()) {

	             // put key and value separated by a colon
	             bf.write(entry.getKey() + "," + entry.getValue());

	             // new line
	             bf.newLine();
	         }

	         for (Entry<Float, Float> entry : map3.entrySet()) {

	             // put key and value separated by a colon
	             bf.write(entry.getKey() + "," + entry.getValue());

	             // new line
	             bf.newLine();
	         }

	         for (Entry<Float, Float> entry : map4.entrySet()) {

	             // put key and value separated by a colon
	             bf.write(entry.getKey() + "," + entry.getValue());

	             // new line
	             bf.newLine();
	         }

	         for (Entry<Float, Float> entry : map5.entrySet()) {

	             // put key and value separated by a colon
	             bf.write(entry.getKey() + "," + entry.getValue());

	             // new line
	             bf.newLine();
	         }

	         for (Entry<Float, Float> entry : map6.entrySet()) {

	             // put key and value separated by a colon
	             bf.write(entry.getKey() + "," + entry.getValue());

	             // new line
	             bf.newLine();
	         }
	
	         for (Entry<Float, Float> entry : map7.entrySet()) {

	             // put key and value separated by a colon
	             bf.write(entry.getKey() + "," + entry.getValue());

	             // new line
	             bf.newLine();
	         }

	         for (Entry<Float, Float> entry : map8.entrySet()) {

	             // put key and value separated by a colon
	             bf.write(entry.getKey() + "," + entry.getValue());

	             // new line
	             bf.newLine();
	         }

	         for (Entry<Float, Float> entry : map9.entrySet()) {

	             // put key and value separated by a colon
	             bf.write(entry.getKey() + "," + entry.getValue());

	             // new line
	             bf.newLine();
	         }
	         

	         for (Entry<Float, Float> entry : map10.entrySet()) {

	             // put key and value separated by a colon
	             bf.write(entry.getKey() + "," + entry.getValue());

	             // new line
	             bf.newLine();
	         }

	         bf.flush();
	     }
	     catch (IOException e) {
	         e.printStackTrace();
	     }
	     finally {

	         try {

	             // always close the writer
	             bf.close();
	         }
	         catch (Exception e) {
	         }
	     }
	     int counter =0;
	     Map<Float, Float> mapFromFile1 = HashMapFromTextFile();
	     for (Map.Entry<Float, Float> entry : mapFromFile1.entrySet()) {
	         counter++;
	         //System.out.println("aaaaaaaaaaaa");
	         //System.out.println(entry.getKey() + " , " + entry.getValue());
	     }
	     System.out.println("Ta simeia :" + counter);
	     return mapFromFile1 ;

	}
	public static float nextFloatBetween2(float min, float max) {
	    return (new Random().nextFloat() * (max - min)) + min;
	}
	public static Map<Float, Float> HashMapFromTextFile()
    {
  
        Map<Float, Float> map = new HashMap<Float, Float>();
        BufferedReader br = null;
  
        try {
  
            // create file object
            File file = new File(outputFilePath);
  
            // create BufferedReader object from the File
            br = new BufferedReader(new FileReader(file));
  
            String line = null;
  
            // read file line by line
            while ((line = br.readLine()) != null) {
  
                // split the line by :
                String[] parts = line.split(",");
  
                // first part is name, second is number
                float name =Float.parseFloat( parts[0].trim());
                float number = Float.parseFloat(parts[1].trim());
  
                // put name, number in HashMap if they are
                // not empty
                
                    map.put(name, number);
                    //System.out.println(map);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
  
            // Always close the BufferedReader
            if (br != null) {
                try {
                    br.close();
                }
                catch (Exception e) {
                };
            }
        }
  
        return map;
    } 
}
