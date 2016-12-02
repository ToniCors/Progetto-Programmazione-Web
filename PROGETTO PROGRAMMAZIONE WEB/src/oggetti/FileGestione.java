package oggetti;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

import javax.servlet.ServletContext;



public class FileGestione {
	
	public static void Aggiorna(String path ,String u, String p,String e){
	
		System.out.println("\n\n");
		System.out.println("SCRITTURA : scrivo");
		
		FileOutputStream fos = null;
		PrintStream scrivi= null;
		try {
		   fos = new FileOutputStream(path, true);   // Apro in append
		   scrivi = new PrintStream(fos);
		   scrivi.println(u);
		   scrivi.println(p);
		   scrivi.println(e);
		  
		} catch (Exception ex) {
		   
		} finally {
		   if (fos != null) {
		      try { fos.close(); scrivi.close();} catch (Exception ex) { }
		   }
		}

}
	
	public static int LeggiReg(String path ,String u, String p,String e) throws IOException{
		int flag=0;
		
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		
		String user =null;
		String word=null;
		String emeil = null;
		
		while((user = br.readLine())!=null && flag !=1){
			System.out.println("user = "+user);
			word =br.readLine();
			System.out.println("word = "+word);
			emeil = br.readLine();
			System.out.println("emeil = "+emeil);
			
			if(user.equals(u)){
				flag=1;	
				System.out.println("LETTURA crdenziale esistente");
				
			}
			
			if(emeil.equals(e)){
				flag=2;	
				System.out.println("LETTURA crdenziale esistente");
				
			}
			
			if(emeil.equals(e)&& user.equals(u)){
				flag=3;	
				System.out.println("LETTURA crdenziale esistente");
				
			}			
		}
		
		System.out.println("FINE LETTURA flag = "+flag);
		br.close();	
		
		
				return flag ;
		
	}
	
	public static int LeggiLog(String path ,String u, String p) throws IOException{
		int flag=0;
		
      BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path)));
		
		String user =null;
		String pw=null;
		String emeil = null;
		
		while((user = br.readLine())!=null && flag !=1){
			System.out.println("user = "+user);
			pw =br.readLine();
			System.out.println("word = "+pw);
			emeil = br.readLine();
			System.out.println("emeil = "+emeil);
			
			if(user.equals(u)){
				flag=1;	
				System.out.println("LETTURA crdenziale esistente");
				
			}
			
			if(pw.equals(p)){
				flag=2;	
				System.out.println("LETTURA crdenziale esistente");
				
			}
			
			if(pw.equals(p)&& user.equals(u)){
				flag=3;	
				System.out.println("LETTURA crdenziale esistente");
				
			}			
		}
		
		System.out.println("FINE LETTURA flag = "+flag);
		br.close();	
		
		
				return flag ;
		
	}
}
