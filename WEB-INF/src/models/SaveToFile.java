package models ;
import java.io.* ;
import java.util.* ;

public class SaveToFile{
	public static void savePassword(String password){
		try{
			FileWriter fw = new FileWriter("C:\\Tomcat 9.0\\webapps\\password_manager\\WEB-INF\\security\\utility-list\\secure.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
		
			bw.write(password);
			bw.newLine();
		
			bw.close();
		}catch(IOException e){e.printStackTrace() ;}
	}

	public static ArrayList<String> collectPassword(){
		File file = new File("C:\\Tomcat 9.0\\webapps\\password_manager\\WEB-INF\\security\\utility-list\\secure.txt");
		ArrayList<String> list = new ArrayList<String>() ;
			
		try{ 
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String str = null;
			while((str=br.readLine())!=null){
				list.add(str) ;
			}
			
			br.close();
			fr.close();
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return list ;
	}
}