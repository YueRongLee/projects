package com.khh.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserValidController
 */
@WebServlet("/UserValidController")
public class UserValidController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserValidController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//�z�Lrequest���X�e�ݰe�i�Ӹ�T(������)
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//�i�JModel��Ƭd��
		String msg="���K�q���|������"; //���Astate
		//�ѦҪ��Amsg
		request.setAttribute("msg", msg);
		if(!username.equals("eric")){
			//�p�G�O
			RequestDispatcher disp=request.getRequestDispatcher("ok.jsp");
			//���L�h
			disp.forward(request, response);
			
		}else{
			//�p�G���O
			RequestDispatcher disp=request.getRequestDispatcher("failure.jsp");
			//���L�h
			disp.forward(request, response);
		}
	}

}
