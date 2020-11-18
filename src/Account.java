
public class Account {
	
	  String username;
	  String realName;
	  String password;
	  
	 
	  public Account(String u, String rN, String p)
	    {
	    username = u;
	    realName = rN;
	    password = p;
	    }

	  public String getusername()
		{
			return username;
		}

	public void setusername(String username)
		{
			this.username = username;
		}

	public String getrealName()
		{
			return realName;
		}

	public void setrealName(String realName)
		{
			this.realName = realName;
		}

	public String getpassword()
		{
			return password;
		}

	public void setpassword(String password)
		{
			this.password = password;
		}
	  
	
	
}
