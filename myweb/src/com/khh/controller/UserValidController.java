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
		//透過request取出前端送進來資訊(表單欄位)
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		//進入Model資料查詢
		String msg="巨匠電腦會員驗證"; //狀態state
		//參考狀態msg
		request.setAttribute("msg", msg);
		if(!username.equals("eric")){
			//如果是
			RequestDispatcher disp=request.getRequestDispatcher("ok.jsp");
			//派過去
			disp.forward(request, response);
			
		}else{
			//如果不是
			RequestDispatcher disp=request.getRequestDispatcher("failure.jsp");
			//派過去
			disp.forward(request, response);
		}
	}

}
