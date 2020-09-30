package models ;
import java.sql.* ;
import org.jasypt.util.text.BasicTextEncryptor;
import java.util.* ;


public class Platform{
	private Integer platformId ;
	private String platformName ;
	private String userName ;
	private String password ;
	

	/* METHODS TO INTERRACT WITH DATABASE */
	
	public static ArrayList<Platform> decryptRecords(){
		ArrayList<Platform> platforms = new ArrayList<Platform>() ;
		try{
			Class.forName("com.mysql.jdbc.Driver") ;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro?user=root&password=1234") ;
			
			String query = "select platform_id,platform_name,username from platform" ;
			PreparedStatement pst = con.prepareStatement(query) ;

			ResultSet rs = pst.executeQuery() ;
			
			while(rs.next()){
				Platform platform = new Platform(rs.getInt("platform_id"),rs.getString("platform_name"),rs.getString("username")) ;
				platforms.add(platform) ;
			}

		}
		catch (SQLException | ClassNotFoundException e){
			e.printStackTrace() ;
		}
		return platforms ;
	}



	
	public static ArrayList<Platform> collectRecords(){
		ArrayList<Platform> platforms = new ArrayList<Platform>() ;
		try{
			Class.forName("com.mysql.jdbc.Driver") ;
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro?user=root&password=1234") ;
			
			String query = "select * from platform" ;
			PreparedStatement pst = con.prepareStatement(query) ;

			ResultSet rs = pst.executeQuery() ;
			
			while(rs.next()){
				Platform platform = new Platform(rs.getInt("platform_id"),rs.getString("platform_name"),rs.getString("username"),rs.getString("password")) ;
				platforms.add(platform) ;
			}

		}
		catch (SQLException | ClassNotFoundException e){
			e.printStackTrace() ;
		}
		return platforms ;
	}
	
	public boolean saveData(){
		boolean flag = false ;

		try{
			Class.forName("com.mysql.jdbc.Driver") ;
		
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pro?user=root&password=1234") ;
			String query = "insert into platform (platform_name,username,password) value (?,?,?)" ;
			
			PreparedStatement pst = con.prepareStatement(query) ;

			pst.setString(1,platformName) ;
			pst.setString(2,userName) ;
			
			/* PASSWORD ENCRYPTION	*/
			
			BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
			textEncryptor.setPassword(password);
			String encPass = textEncryptor.encrypt(password);
			
			/* PASSWORD ENCRYPTION	*/

			pst.setString(3,encPass) ;

			int res = pst.executeUpdate() ;

			if(res==1){
				flag = true ;
			}
			con.close() ;
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace() ;
		}
		return flag ;
	}
	
	/* CONSTRUCTORS & GETTER-SETTERS */

	public Platform(String platformName,String userName,String password){
		this.platformName = platformName ;
		this.userName = userName ;
		this.password = password ;
	}

	public Platform(Integer platformId,String platformName,String userName,String password){
		this.platformId = platformId ;
		this.platformName = platformName ;
		this.userName = userName ;
		this.password = password ;
	}

	public Platform(Integer platformId,String platformName,String userName){
		this.platformId = platformId ;
		this.platformName = platformName ;
		this.userName = userName ;
	}

	
	public Platform(){
	
	}
	
	public void setPassword(String password){
		this.password = password ;
	}

	public String getPassword(){
		return password ;
	}
	
	public void setUserName(String userName){
		this.userName = userName ;
	}

	public String getUserName(){
		return userName ;
	}
	
	public void setPlatformName(String platformName){
		this.platformName = platformName ;
	}

	public String getPlatformName(){
		return platformName ;
	}
	
	public void setPlatformId(Integer platformId){
		this.platformId = platformId ;
	}

	public Integer getPlatformId(){
		return platformId ;
	}
}