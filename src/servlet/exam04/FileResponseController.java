package servlet.exam04;

import java.io.FileInputStream;
import java.io.IOException;

import java.io.PrintWriter;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

@WebServlet(name="exam04.FileResponseController",urlPatterns="/exam04/FileResponseController")
public class FileResponseController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fileName ="사진1.jpg";
		String filePath="C:/Temp/photo1.jpg";
		String contentType="image/jpeg";
		
		//http 응답에 content -type 헤더를 추가
		response.setContentType(contentType);
		
		
		//브라우저의 종류얻기
		String userAgent = request.getHeader("User-Agent");
		if(userAgent.contains("Trident")|| userAgent.contains("MSIE")) {
			//11에는 반드시 trident가 포함되어있다. msie는 11이하에 포함
			//IE일 경우 (인터넷익스플로어)
			fileName=URLEncoder.encode(fileName, "UTF-8");
		
		}else {
			//chrom, edge, firefox, safari일경우
			fileName= new String(fileName.getBytes("UTF-8"),"ISO-8859-1");
		}
		System.out.println(fileName);
		
		//Http 응답에 Content-Disposition 헤더를 추가
		response.setHeader("Content-Disposition", "attachment; filename=\""+ fileName + "\"");
		
		//Http 응답 본문에 파일 데이터 출력하기
		ServletOutputStream sos = response.getOutputStream();
		
		//방법1
		/*FileInputStream fis= new FileInputStream(filePath);
		byte[] data = new byte[1024];
		while(true) {
			int readByteNum = fis.read(data);
			if(readByteNum == -1) break;
			sos.write(data, 0, readByteNum);
		}
		sos.flush();
		fis.close();
		sos.close(); */
	
		//방법2
		Path path = Paths.get(filePath);
		Files.copy(path, sos);
		sos.flush();
		sos.close();
		
	}
	
	
}
