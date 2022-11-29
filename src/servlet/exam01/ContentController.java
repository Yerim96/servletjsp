package servlet.exam01;

import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;


@WebServlet(name="exam01.ContentController", urlPatterns= {"/exam01/ContentController"})
public class ContentController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 실행");
		//데이터 결과 생성
		//처리 결과 생성
	
		
		//jsp로 이동 + 스프링을 배우면 빠지는 코드2
		request.getRequestDispatcher("/WEB-INF/views/exam01/content.jsp").forward(request, response);
	}

}
