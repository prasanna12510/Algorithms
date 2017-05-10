package arrays;

import java.util.Enumeration;
import java.util.Vector;

public class RotateArray {
	
	static int arr[] = {1,2,3,4,5,6,7};
	Vector<Integer> v = new Vector<Integer>();
	
	public void executeRotateArray(int arr[],int steps){
		int j=0;
		
		for(int i=0;i<arr.length;i++){
			
			if(i==steps){
				j=i+1;
				while(j<arr.length){
					
					v.add(arr[j]);
					j++;
				}
				
			}
			
		}
		
		for(int i = 0;i<=steps;i++){
			
			
			v.add(arr[i]);
		}
		
		
		
	Enumeration<Integer> e= v.elements();
	
	while(e.hasMoreElements()){
		
		System.out.println(" "+e.nextElement());
	}
		
	}//method
	
		
	
	public static void main(String args[]){
		
		
		
		RotateArray ra = new RotateArray();
		ra.executeRotateArray(arr, 1);
		
	}
	
	

}//class
