package servlet.exam02;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "exam02.ContentController", urlPatterns = "/exam02/ContentController")
public class ContentController extends HttpServlet {
	
	//역할: 서블릿 객체의 초기화 작업을 함.
	
	//클라이언트가 요청할 때 마다 콜백(요청 방식(get,post)와는 상관없이 실행됨)
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("/WEB-INF/views/exam02/content.jsp").forward(request, response);
	}
	

}
