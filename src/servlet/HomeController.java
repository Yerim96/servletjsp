package servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(name="HomeController", urlPatterns="/HomeController");
public class HomeController extends HttpServlet{
	
	//클라이언트가 요청할때마다 콜백(요청방식과는 상관없다)
	//역할: 요청처리
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 실행");
		
		//jsp로 이동 + 스프링을 배우면 빠지는 코드2
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}
	

	
}
