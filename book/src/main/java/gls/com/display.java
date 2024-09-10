package gls.com;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/display")
public class display extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public display() {
        super();
        // TODO Auto-generated constructor stub
           }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			try
			{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con= DriverManager.getConnection("jdbc:mysql://localhost/dkdb","root","root@123");
		PreparedStatement pst=  con.prepareStatement("Select * from book");
		ResultSet rs = pst.executeQuery();
		while(rs.next())
		{			
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id");
		String bname = request.getParameter("bname");
        String bprice = request.getParameter("bprice");
        String author = request.getParameter("author");
        
        // Display the received variables
        out.println("<html>");
        out.println("<body> <center>");
        out.println("<h1>Book Name: " + bname + "</h1>");
        out.println("<h1>Book Price: " + bprice + "</h1>");
        out.println("<h1>Author:" + author + "</h1>");
        
        
        String delUrl="Delete?id="+id;
        out.println("<a href='" + delUrl + "'>" + "Delete" + "</a>");
        
        String editUrl="EditBook?id="+id+"&bname="+bname+"&bprice="+bprice+"&author="+author;
        out.println("<a href='" + editUrl + "'>" + "Edit" + "</a>");
        
        String linkUrl="login.jsp";                
        out.println("<a href='" + linkUrl + "'>" + "Home" + "</a>");
        
        out.println("</center></body>");
        out.println("</html>");
	
		}
		
		}catch(Exception e)
			{
				System.out.println(e);
			}
			}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
