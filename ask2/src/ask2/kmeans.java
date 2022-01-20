package ask2;
import java.util.Arrays;

import java.util.Map;

import java.util.Random;


import java.io.File;  // Import the File class

import java.io.FileWriter;
import java.io.IOException;


public class kmeans {
	final static String outputFilePath= "write.txt";//path gia ta 1200 tuxaia noumera
	final static String out= "centers.txt";//path gia ta kentra
	final static String out1= "sfalmata.txt";//path gia ta sfalmata
	
	//main
	public static void main(String[] args) throws Exception {
		randomPoints rp =new randomPoints();
		Map<Float, Float> mapFromFile1 = rp.makeRandomPoints();
		
		makePlot2(mapFromFile1);
		int M = 3;// apo edw allazoume to M 
	    epanalispis(mapFromFile1,M);
	    System.out.println("To programma trexei epituxws");
	   
	}

	public static float  epanalispis(Map<Float, Float> mapFromFile1,int M) throws IOException {
		float[][] olika_sfalmata = new float[20][2];// tha periexei ta sfalmata apo oles tis epanalipseis 1200 epi 20
		float[][] nea_telika_kentra=new float[M*20][3];
		int mi=0;
		for(int i=0 ;i<20;i++) {
			float [][] arxika_kentra=random_centers(M,mapFromFile1);
			float[][] flagsArray = makeflags(M,arxika_kentra,mapFromFile1);
			float[][] nea_kentra = compareCentrers(arxika_kentra,M,flagsArray,mapFromFile1);
			float[][] flagsArray1 = makeflags(M,nea_kentra,mapFromFile1);
			
			
			for(int j=0;j<nea_kentra.length;j++) {
				nea_telika_kentra[mi][0]=nea_kentra[j][0];
				nea_telika_kentra[mi][1]=nea_kentra[j][1];
				nea_telika_kentra[mi][2]=i;
				mi++; 
			}
			
			float sfalma =sfalmaOmadopoisis(nea_kentra,flagsArray1,M);
			float m =sfalma;
			//System.out.println("-------------------");
			//System.out.println("epanalispsi "+i +" "+m);
			olika_sfalmata[i][0]= m ;// mikrotero 
			olika_sfalmata[i][1]= i ;// epanalipsi
			//System.out.println("sfalma kathe epanalijiw"+ sfalma);
		}
		float[] min = getMin2d(olika_sfalmata);
		//System.out.println("min oliko :"+ min[0]);
		float epa = min[1];
		
		
		float [][]centers=new float[M][2];
		int count=0;
		for(int i=0;i<nea_telika_kentra.length;i++) {
			if(nea_telika_kentra[i][2]==epa) {
			centers[count][0]=nea_telika_kentra[i][0];
			centers[count][1]=nea_telika_kentra[i][1];
			count++;
			}
		}
		//System.out.println("centers");
		//pritnArray2D(centers);
		//System.out.println("epa"+epa);
		//pritnArray2D(nea_telika_kentra);
		 File center_file = new File(out);
	     FileWriter center_writer = new FileWriter(center_file);
	     
	     for(int j=0; j < centers.length; j++) {
	    	 for(int k = 0;k<centers[j].length;k++) {
	            center_writer.write(centers[j][k]+" ");}center_writer.write("\n");
	     }
	     
	     center_writer.close();
	     
	     return min[0];
	}
	
	public static void makePlot2( Map<Float, Float> mapFromFile1) throws IOException {
		
	     float s1 = epanalispis(mapFromFile1,3);
	     float s2 = epanalispis(mapFromFile1,5);
	     float s6 = epanalispis(mapFromFile1,7);
	     float s4 = epanalispis(mapFromFile1,11);
	     float s5 = epanalispis(mapFromFile1,13);
	     float s3 = epanalispis(mapFromFile1,9);
	     
	     File cfile = new File(out1);
	     FileWriter cwriter = new FileWriter(cfile);
	     

	            cwriter.write(s1+" "+3 );cwriter.write("\n");
	            cwriter.write(s2+" "+5 );cwriter.write("\n");
	            cwriter.write(s6+" "+7 );cwriter.write("\n");
	            cwriter.write(s3+" "+9 );cwriter.write("\n");
	            cwriter.write(s4+" "+11 );cwriter.write("\n");
	            cwriter.write(s5+" "+13 );cwriter.write("\n");
	     
	     
	     cwriter.close();
		
	}
	public static void testarismata(float [][] t , float [][] nea , float [] sfalma,int M) {
		System.out.println("----------------------------------");
		System.out.println("testaroume");
		int count=0;
		int y=0;
		while(count<M) {
			for(int w=0;w<150;w++) {
				//System.out.println("to flag einai to :" +t[w][2]);
				if(t[w][2]==count  ) {//flags pinakas x y kai flag
					//System.out.println("to flag einai to :" +t[w][2]);
					y++;
					
					System.out.println("grammi : " + w +"  to flag einai to :" +t[w][2]+"  to kento:  "+ nea[count][0]+" "+ nea[count][1]+ "  simeio  " + t[w][0]+" "+t[w][1]+"  sfalma  "+sfalma[w] );
				
				}
			}
			count++;
		}
		System.out.println("mpikeee :" + y);//150
		
	}
	
	//dimiourgoume ta tuxaia kentra 
	public static float [][] random_centers( int M, Map<Float, Float> mapFromFile1 ){
		//System.out.println(i);
		Random rand = new Random();
		int size1=mapFromFile1.size();
		//float centers[][];
		float[][] centers= new float[M][2];
		int p=0;

		for(int i=0;i<M;i++) {
			int random = rand.nextInt(size1);
		//tyxaia shmeia mesa se olo to synolo
			int j=0;
			for (Float r : mapFromFile1.keySet()) {
				j++;
				if(random==j) {
					//System.out.println("key: " + r + " value: " + mapFromFile1.get(r));
					centers[p][0]=r;
					centers[p][1]= mapFromFile1.get(r);
				}
			}
			p++;
		}

		return centers;
	}
	public static float calculateDistanceBetweenPoints(float x1, float y1, float x2, float y2) {       
			    return (float) Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}
	
	  // Method for getting the minimum value
	  public static float getMin(float[] inputArray){ 
	    float minValue = inputArray[0]; 
	    for(int i=1;i<inputArray.length;i++){ 
	      if(inputArray[i] < minValue){ 
	        minValue = inputArray[i]; 
	      } 
	    } 
	    return minValue; 
	  } 
	  // Method for getting the minimum value
	  public static float [] getMin2d(float[][] inputArray){ 
		    float minValue = inputArray[0][0]; 
		    float epanaliji = 0;
		    for(int i=1;i<inputArray.length;i++){ 
		      if(inputArray[i][0] < minValue){ 
		        minValue = inputArray[i][0]; 
		        epanaliji = inputArray[i][1];
		      } 
		    } 
		    
			float []mik= {minValue,epanaliji};
		    return  mik  ; 
		  } 
		  
	 // vriskoume ta flags
	public static float[][] makeflags( int M,float [][] kentra,Map<Float, Float> mapFromFile1 ){
		int z = mapFromFile1.size();
		float [][] numflags=new float [z][z];
		float [] d= new float [M];
		float [] allmind= new float [z];
		int w=0;
		for (Float r : mapFromFile1.keySet()) {
			
			//System.out.println("key: " + r + " value: " + mapFromFile1.get(r));
			
			for(int i =0;i<M;i++) {
				d[i]=calculatePower(kentra[i][0],kentra[i][1],r,mapFromFile1.get(r));//edw to allaksame na to doume gia sigoura


			}
			float min = getMin(d);
			//System.out.println("min distance");
			//System.out.println(min);
			allmind[w]=min;
			numflags[w][0]=r;
			numflags[w][1]=mapFromFile1.get(r);
			
			for(int i=0;i<M;i++) {
				if(min==d[i]) {
					numflags[w][2]=i;
				}

			}
			w++;
		}
		return numflags;
	
	}
	
	//dimiourgoume ta nea kentra
	public static float[][] newkentra( int M,float [][] pointWflags){
		float mo[][] = new float [M][2];
		int sum[]=new int[M];
		int len=pointWflags.length;
		float sumx = 0;
		float sumy = 0;
		for(int m=0;m<M;m++) {
			mo[m][0]=0;
			mo[m][1]=0;
			sum[m]=0;
		}
		int count=0;
		while(count<M) {
			for(int i=0;i<len;i++) {
				if(pointWflags[i][2]==count) {
					sum[count]++;
					sumy+=pointWflags[i][1];
					sumx+=pointWflags[i][0];
				}
			}
			mo[count][0]= (sumx/sum[count]);
			mo[count][1]=sumy/sum[count];
			sumx=0;
			sumy=0;
			
		count++;
		}
		
		return mo;
	}
	public static float[][] compareCentrers(float [][]palia, int M,float [][] pointWflags,Map<Float, Float> mapFromFile1 ){
		float nea[][] = newkentra(M,pointWflags);
		if (Arrays.deepEquals(palia, nea)){
			return palia;
		}else {
			//System.out.println("neos pinakaas"); 
			//pritnArray2D(nea);

			float[][] t = makeflags(M,nea,mapFromFile1);
			return compareCentrers(nea,M,t,mapFromFile1);
		}
	}
	
	public static void pritnArray2D(float[][] array) {
		System.out.println("array");
		for(int i=0;i<array.length;i++) {
			for(int j=0;j<array[i].length;j++) {
			System.out.println(array[i][j]);
			}
		}
	}
	
	public static float calculatePower(float x1, float y1, float x2, float y2) {   
		float y=(y2 - y1)*(y2 - y1);//y^2
		float x=(x2 - x1)*(x2 - x1);//x^2
		
		float s = y+x;
		
	    return s;
	}
	
	//briskoume sfamla omadopoisis
	public static float sfalmaOmadopoisis (float [][]kentra,float [][]flags,int M) {
		int len =flags.length;
		float sfalma=0;
		float [] sfalmaArray=new float[len];
		int count=0;//metritis 
		while(count<M) {
			for(int i=0;i<flags.length;i++) {
				if(flags[i][2]==count) {
					sfalmaArray[i]=calculatePower(kentra[count][0],kentra[count][1],flags[i][0],flags[i][1]);
					
				}
			}
			
		count++;
		}
		
		//System.out.println("array gia sfamlta");
		for(int i=0 ; i<sfalmaArray.length;i++) {
			sfalma+=sfalmaArray[i];
		}
		return sfalma;
		
	}
	public static void printArray(float[] array) {
		System.out.println("array ");
		for(int i=0;i<array.length;i++) {
			System.out.println(array[i]);

		}
	}
}
