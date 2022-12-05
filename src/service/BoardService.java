package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.BoardDao;
import dto.Board;
import util.Pager;

public class BoardService {
	private ServletContext application;
	private DataSource ds;
	private BoardDao boardDao; 
	
	public BoardService(ServletContext application) {
		this.application = application;
		boardDao = (BoardDao) application.getAttribute("boardDao");
		ds = (DataSource) application.getAttribute("dataSource");
	/*	try {
			InitialContext ic = new InitialContext();
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/java");
			Connection conn = ds.getConnection();
		} catch(Exception e) {
			e.printStackTrace();
		}*/
	}
	
	public void write(Board board) {
		System.out.println("게시글을 작성합니다.");
		BoardDao boardDao = (BoardDao) application.getAttribute("boardDao");
		boardDao.insert(board, null);
	}
	
	public void write2(Board board) {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			boardDao.insert2(board, conn);
		} catch(Exception e) {
			
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public int getTotalBoardNum() {
		int result=0;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = boardDao.countRows(conn); //전체테이블중 페이징이되는 대상(행수)만 카운팅할수도 있다.
		} catch(Exception e) {
			
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public List<Board> getPageList(Pager pager) {
		List<Board> result=null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = boardDao.selectPageList(pager,conn);
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public Board getBoard(int bno) {
		
		Board result=null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = boardDao.selectBoard(bno,conn);
			
		} catch(Exception e) {
			
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
