//Program to reverse a array of Strings 

public class StringReverse{
	
	
	static StringBuffer s = new StringBuffer("Hello World I am Wolf...");
	                                       //012345
	
	public static void main(String args[]){
		
		System.out.println(s);
		
		//create indices for storing starting and end character of each string
		int i=0,j=0,w=0;
		
		while(i<s.length()){
			
			if(i==0)
			  w=0;
			
			if(s.charAt(i) == ' ' || i==s.length()-1){
				
				j=i;
				
				if(i == s.length()-1)
					j=i;
				else
					j--;
				
				swap(w,j);
				
				w=i+1;
				
			}//if
			
			i++;
		}//while()..
		swap(0,s.length()-1);
		System.out.println(s);
		
	}//main
	
	
	public static void swap(int i, int j){
		
		while(i<j){
			char ch=s.charAt(i);
			s.setCharAt(i,s.charAt(j));
			s.setCharAt(j,ch);
			i++;
			j--;
		}//while
		System.out.println(s);
	}//swap
	
	
}//class 