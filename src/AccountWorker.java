import java.io.*;
import java.util.*;

public class AccountWorker {
	  public static void readAccount() 
	  	{

	    
	  	}
		  
		  public static void writeAccount() throws IOException
	  	{
			  Scanner file = new Scanner( new File( "IDLog" ) );
	      // The name of the file to open.
	      String fileName = "IDLog";
	      
	      new PrintWriter("IDLog").close();

	      try {
	          // Assume default encoding.
	          FileWriter fileWriter = new FileWriter(fileName, true);

	          // Always wrap FileWriter in BufferedWriter.
	          BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

	          // Note that write() does not automatically
	          // append a newline character.
	  		for(int i = 0; i < RunConsole.AccountList.size(); i++)
	  		{
	  			
	  			 String prework = RunConsole.AccountList.get(i).getusername()+"/"+RunConsole.AccountList.get(i).getrealName()+"/"+RunConsole.AccountList.get(i).getpassword();
	  			 String [] work = prework.split("");
	  			 for(int w = 0; w < work.length; w++)
	  			 {
	  				 work [w] = Encryption.encrypt(work[w]);
	  				bufferedWriter.write(work[w]);
	  			 }
	  			
	  			 bufferedWriter.newLine();

	  		}
	         
	          // Always close files.
	          bufferedWriter.close();
	      	}
	      
	      catch(IOException ex) 
	      	{
	          System.out.println("Error writing to file '" + fileName + "'");
	          // Or we could just do this:
	          // ex.printStackTrace();
	      	}
	  	}

		
		public static void fill() throws IOException  {

			 Scanner file = new Scanner( new File( "IDLog" ) );
			
			  // The name of the file to open.
		      String fileName = "IDLog";

		      // This will reference one line at a time
		      String line = null;

		      try 
		      	{
		          // FileReader reads text files in the default encoding.
		          FileReader fileReader = new FileReader(fileName);

		          // Always wrap FileReader in BufferedReader.
		          BufferedReader bufferedReader =  new BufferedReader(fileReader);
		       
		          while((line = bufferedReader.readLine()) != null) 
		       		{
		        	//  	line = bufferedReader.readLine();
		        	  
		        	  String prework = line;
		        	  String postwork = "";
			  			 String [] work = prework.split("");
			  			 for(int w = 0; w < work.length; w++)
			  			 {
			  				 work [w] = Encryption.decrypt(work[w]);
			  				 postwork = postwork.concat(work[w]);
			  				
			  			 }
			  			 
			  			
		        	 // System.out.println(postwork);
		          		String [] unfixed = postwork.split("/");
		          		
		          		RunConsole.AccountList.add(new Account(unfixed[0], unfixed[1], unfixed[2]));
		        
		       		}
		          bufferedReader.close();
		      	}
		      catch(FileNotFoundException ex) 
		      	{
		          System.out.println(
		              "Unable to open file '" + fileName + "'");
		        
		      	}
		      catch(IOException ex) 
		      	{
		          System.out.println(
		              "Error reading file '" + fileName + "'");	
		         
		          // Or we could just do this: ex.printStackTrace();
		      	}
			
		}
}
