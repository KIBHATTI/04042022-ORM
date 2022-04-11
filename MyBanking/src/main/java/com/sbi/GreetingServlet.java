package com.sbi;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GreetingServlet
 */
public class GreetingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreetingServlet() {
        super();
        System.out.println("Greeting servlet cons called");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("Init() is called");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("Destroy() is called");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet() is called");
		String greetMsg="";
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		int hod=currentDateTime.getHour();
		if(hod>=4 && hod <=12)
		{
			greetMsg="Good Morning";
		} 
		else if(hod>12 && hod <=17)
		{
			greetMsg="Good noon";
		}
		else if(hod>17 && hod <=20)
		{
			greetMsg="Good Evening";
		}
		else if(hod>20 && hod <=00)
		{
			greetMsg="Good Night";
		}
		else if(hod>00 && hod <=3)
		{
			greetMsg="Good Mid Night";
		}
		PrintWriter pw = response.getWriter();
		String clientname=request.getRemoteAddr();
		pw.println("<h1> Welcome User!! How are you? </h1>");
		pw.println("GreetMsg :::" +greetMsg);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost() is called");
		
		doGet(request, response);
	}

}
