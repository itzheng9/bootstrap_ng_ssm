<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="java.lang.*,com.baidu.ueditor.ActionEnter"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%

    request.setCharacterEncoding( "utf-8");
	response.setHeader("Content-Type" , "text/html");
	
	String rootPath = application.getRealPath( "/" );
	System.out.println("rootPath"+rootPath);
	
	System.out.println("exec"+ new ActionEnter( request, rootPath ).exec());
	out.write( new ActionEnter( request, rootPath ).exec() );
	
%>