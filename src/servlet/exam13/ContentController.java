package servlet.exam13;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.Board;
import service.BoardService;
import util.Pager;


@WebServlet(name="exam13.ContentController", urlPatterns="/exam13/ContentController")
public class ContentController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strpageNo = request.getParameter("pageNo");
		//pageNo 얻기
		if(strpageNo == null) { //만약 페이지넘버가 넘어오지 않는다면
			strpageNo="1";
		}
		int pageNo = Integer.parseInt(strpageNo); //디폴트 값 1로 설정
		
		//보드서비스는 어플리케이션 범위에 저장했다.
		//BoardService 객체 얻기
		ServletContext application = request.getServletContext();
		BoardService boardService = (BoardService) application.getAttribute("boardService");
		
		
		//페이징 대상이 되는 전체 행수 얻기
		int totalBoardNum = boardService.getTotalBoardNum(); 
		
		//pager 생성
		Pager pager = new Pager(10, 5, totalBoardNum, pageNo);
		
		
		//해당 pageNo에 해당하는 게시물 가져오기 
		List<Board> pageList = boardService.getPageList(pager);
		
		request.setAttribute("pager", pager);
		request.setAttribute("pageList", pageList);
		
		
		request.getRequestDispatcher("/WEB-INF/views/exam13/content.jsp").forward(request, response);
		
	}
}
