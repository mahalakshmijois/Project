import java.io.*;
import javax.servlet.*;
import java.sql.*;
public class Artist_display extends GenericServlet
{
	Connection con;
	public void init() throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Art","root","root");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
		public void service (ServletRequest request,ServletResponse response) throws ServletException,IOException
	{
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		try{
			PreparedStatement st=con.prepareStatement("SELECT * FROM ARTIST");
		  
			ResultSet rs=st.executeQuery();
			pw.print("<table border='1'>");
			pw.print("<tr width=600px>");
			pw.print("<th width=600px>"+"Artist id"+"</th>");
			pw.print("<th width=600px>"+"Artist name"+"</th>");
			pw.print("<th width=600px>"+"Address"+"</th>");
			pw.print("<th width=600px>"+"Phone"+"</th>");
		
			pw.print("</tr>");
		     while(rs.next())  
			{
		    	 pw.print("<tr>");
			String Aid=rs.getString("Aid");	
			String Aname=rs.getString("Aname");
			String Address=rs.getString("Address");
			String Phone=rs.getString("Phone");	
				
			
			pw.print("<td>"+Aid+"</td>");
			pw.print("<td>"+Aname+"</td>");
			pw.print("<td>"+Address+"</td>");
			pw.print("<td>"+Phone+"</td>");
			
			pw.print("</tr>");
			   
			}
		     
				pw.print("</table>");
		}catch(Exception e)
		{
			
			pw.println(e);
		}
		pw.println("<body style='background-color:#f0b6b6;'>");
		pw.print("<center><a href='links.html'>BACK</a>");
		pw.close();
	}
}
	
	