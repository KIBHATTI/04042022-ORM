package com.sbi;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ApplicantServlet
 */
public class ApplicantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ApplicantServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		request.getParameter("actype" );
		request.getParameter( "app_name");
		request.getParameter("app_mobno");
		request.getParameter("app_dob");
		request.getParameter("app_fathername");
		request.getParameter("app_maritalstatus");
		request.getParameter("app_occupation");
		request.getParameter( "app_annualincome");
		request.getParameter("app_adhaarno");
		request.getParameter("app_panno");
		request.getParameter("app_p_area");
		request.getParameter("app_p_street");
		request.getParameter("app_p_city");
		request.getParameter("app_p_state");
		request.getParameter("app_p_country");
		request.getParameter("app_p_pin");

			  
		request.getParameter("app_c_area");
		request.getParameter("app_c_street");
		request.getParameter("app_c_city");
		request.getParameter("app_c_state");
		request.getParameter("app_c_country");
		request.getParameter("app_c_pin");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
