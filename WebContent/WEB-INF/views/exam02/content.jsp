<%@ page contentType="text/html; charset=UTF-8" %>

<%@ include file="/WEB-INF/views/common/header.jsp" %>

<div class="card m-2">
	<div class="card-header">
		content.jsp
	</div>
	<div class="card-body">
	<h4>GET 방식</h4>
	<a href ="/servletjsp/exam02/GetController?param1=value&param2=value2" class="btn btn-info btn-sm"> 링크로 이동</a>
	<hr/>
	
		<form method="get" action="/servletjsp/exam02/GetController">
			<input type="text" name="parm3" value="value3"/><br/>
			<input type="text" name="parm4" value="value4"/><br/>
			<input type="submit" value="Form으로 제출" class="btn btn-info btn-sm"/>
		</form>
		
		<h4 class="mt-3">POST 방식</h4>
			<form method="post" action="/servletjsp/exam02/PostController">
			<input type="text" name="parm5" value="value3"/><br/>
			<input type="text" name="parm6" value="value4"/><br/>
			<input type="submit" value="Form으로 제출" class="btn btn-info btn-sm"/>
		</form>
	</div>
</div>

<%@ include file="/WEB-INF/views/common/footer.jsp" %>