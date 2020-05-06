package com.heathCareDoctor.Class;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DoctorRegistrationAPI
 */
@WebServlet("/DoctorRegistrationAPI")
public class DoctorRegistrationAPI extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	DoctorRegistration doctorObj = new DoctorRegistration();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorRegistrationAPI() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String output = doctorObj.insertDoctorDeatails(request.getParameter("f_name"),
				request.getParameter("l_name"),
				request.getParameter("age"),
				request.getParameter("email"),
				request.getParameter("phoneNo"),
				request.getParameter("nic"),
				request.getParameter("hospital_name"),
				request.getParameter("specialization"));
		
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request);
		String output = doctorObj.updateDoctorDetails(paras.get("hidDocIDSave").toString(),
											   paras.get("f_name").toString().replace('+', ' '),
											   paras.get("l_name").toString().replace('+', ' '),
											   paras.get("age").toString(),
											   paras.get("email").toString().replace("%40", "@"),
											   paras.get("phoneNo").toString(),
											   paras.get("nic").toString().replace('+', ' '),
											   paras.get("hospital_name").toString().replace('+', ' '),
											   paras.get("specialization").toString().replace('+', ' '));		
		response.getWriter().write(output);
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		Map paras = getParasMap(request);
		String output = doctorObj.deleteDoctorDetails(paras.get("id").toString());
		
		response.getWriter().write(output);
		
	}

		// Convert request parameters to a Map
	private static Map getParasMap(HttpServletRequest request){
			
	Map<String, String> map = new HashMap<String, String>();
	try
		{
				Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
				String queryString = scanner.hasNext() ?
									 scanner.useDelimiter("\\A").next() : "";
		        scanner.close();
		        
		        String[] params = queryString.split("&");
		        for (String param : params)
		        {
		        	String[] p = param.split("=");
		        	map.put(p[0], p[1]);
		        }
		}
		catch (Exception e)
		{
		}
		return map;
		}
}
