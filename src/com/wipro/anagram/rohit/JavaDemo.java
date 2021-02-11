package com.wipro.anagram.rohit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JavaDemo {

	
	String stringValue;
	
	public JavaDemo(String strValue) {
		   this.stringValue=strValue;
	}
	
	
	public void printAnag()
	{
		
		

		String splitVlasues[]=stringValue.split(",");
		
		
		
		Map<Integer, ArrayList<String>> mapValue= new HashMap<Integer, ArrayList<String>>();
		int mapcount=0;
		for (String value : splitVlasues) {
			
			
			String valuetoCompare=value.trim();
			

			 ArrayList<String> al= new ArrayList<String>();
			 al.add(valuetoCompare);
			for (String value1 : splitVlasues) {
				
				value1=value1.trim();
			    int firstLenght = valuetoCompare.length();
			    int secondLength = value1.length();
			 
			    if(valuetoCompare.equalsIgnoreCase(value1))
			    {
			    	continue;
			    }
			    
			    
			    // If length of both strings is not same, then they
			    // cannot be anagram
			    if (firstLenght != secondLength)
			        continue;
			    
			    char[] ch = new char[valuetoCompare.length()]; 
		        for (int i = 0; i < valuetoCompare.length(); i++) { 
		            ch[i] = valuetoCompare.charAt(i); 
		        } 
		        
		        char[] ch1 = new char[value1.length()]; 
		        for (int i = 0; i < value1.length(); i++) { 
		            ch1[i] = value1.charAt(i); 
		        } 
	
			    Arrays.sort(ch1);
		        Arrays.sort(ch);
		        
			    int count =0;
			    for (int i = 0; i < firstLenght; i++)
			    {
			        if (ch[i] != ch1[i])
			        {
			        	count=count+1;
			        }
			    }  
			    
			    if(count==0)
			    {
			    	
			    	al.add(value1);
			    	
			    }
			    
			    
				
			}
			
			
			 String tocheckduplicate = al.get(0);
			
			
			 
			 int tocheckCount=0;
			 for(ArrayList<String> alval :mapValue.values() )
			 {
				 
				 for(String val:alval)
				 {
					 if(tocheckduplicate.equalsIgnoreCase(val))
					 {
						 tocheckCount=tocheckCount+1;
					 }
				 }
				 
				 
			 }
			 
			 if(tocheckCount==0)
			 { mapcount=mapcount+1;
				 mapValue.put(mapcount, al);
			 }	
		}
		System.out.println(mapValue.toString());
	}

		
	
	
	
	
	
	
	public static void main(String ...s)
	{
		
		String strValue ="CAT, DOG, TAC, MAD, DAM, AMD, GOD, SET,test,smtpdg,tpgsmd,AAb,bAA";
		
		new JavaDemo(strValue).printAnag();
		
		
		
  }
}