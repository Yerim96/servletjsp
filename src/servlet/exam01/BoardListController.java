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


@WebServlet(name="exam01.BoardListcontroller", urlPatterns="/exam01/BoardListController")
public class BoardListController extends HttpServlet {
	
	
	

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service() 실행");
		//데이터 결과 생성
		//처리 결과 생성
		List<Board> boards = new ArrayList<>();
		
		for(int i=1; i<=5; i++){
			Board board = new Board();
			board.setBno(i);
			board.setBtitle("제목"+i);
			board.setBcontent("내용"+i);
			board.setBwriter("홍길동");
			board.setBdate(new Date());
			boards.add(board);
		}
	
		request.setAttribute("list", boards);
		//jsp로 이동 + 스프링을 배우면 빠지는 코드2
		request.getRequestDispatcher("/WEB-INF/views/exam01/boardList.jsp").forward(request, response);
	}


}
