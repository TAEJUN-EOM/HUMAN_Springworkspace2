<%@ page   contentType="text/html; charset=utf-8" %>
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib  prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html >
<html>
<head>
<meta   charset="utf-8">
<TITLE>개인 정보 상세 조회</TITLE>
<link rel=stylesheet href="../css/user.css" type="text/css">
<script>
function userDelete(){	
	f.action="./delete.do";
	f.submit();	
}
function userModiy(){	
	f.action="./modify.do";
	f.submit();	
}

function userList(){
	f.action="./list.do";
	f.submit();	
}
</script>
</head>
<body>
<body bgcolor=#FFFFFF text=#000000 leftmargin=0 topmargin=0 marginwidth=0 marginheight=0>
<br>
<table width=780 border=0 cellpadding=0 cellspacing=0>
	<tr>
	  <td width="20"></td>
	  <td>
  <!--contents-->
	  <table width=590 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td bgcolor="f4f4f4" height="22">&nbsp;&nbsp;<b>사용자 관리 - 개인 정보 상세조회</b></td>
		  </tr>
	  </table>  
	  <br>

<!-- write Form  -->
	  <form name="f" method="post" action="">
	  
	  <table border="0" cellpadding="0" cellspacing="1" width="640" bgcolor="BBBBBB">
		  <tr>
			<td width=150 align=center bgcolor="E6ECDE" height="22">사용자 아이디</td>
			<td width=490 bgcolor="ffffff" style="padding-left:20">
				<input type="hidden" style="width:150" name="userid" value="${userInfo.userid}">
				 ${userInfo.userid}				 
			</td>
		  </tr>
		  <tr>
			<td width=150 align=center bgcolor="E6ECDE" height="22">비밀번호</td>
			<td width=490 bgcolor="ffffff" style="padding-left:20">				
				${userInfo.userpwd}
			</td>
		  </tr>
		   
		  <tr>
			<td width=200 align=center bgcolor="E6ECDE" height="22">이름</td>
			<td width=490 bgcolor="ffffff" style="padding-left:20">
				${userInfo.username}
			</td>
		  </tr>
		  
		  <tr>
			<td width=150 align=center bgcolor="E6ECDE" height="22">이메일 주소</td>
			<td width=490 bgcolor="ffffff" style="padding-left:20">				
				${userInfo.username}
			</td>
		  </tr>		
		  <tr>
			<td width=150 align=center bgcolor="E6ECDE" height="22">전화 번호</td>
			<td width=490 bgcolor="ffffff" style="padding-left:20">
				<input type="text" style="width:150px" name="phone" value="${userInfo.phone}">
				${userInfo.phone}
			</td>
		  </tr>		
		  <tr>
			<td width=150 align=center bgcolor="E6ECDE" height="22">주    소</td>
			<td width=490 bgcolor="ffffff" style="padding-left:20">
				<input type="text" style="width:150px" name="phone" value="${userInfo.address}">				
				${userInfo.address}
			</td>
			</tr>
			<tr>
				<td width=150 align=center bgcolor="E6ECDE" height="22"> 성 별 </td>
				<td width=490 bgcolor="ffffff" style="padding-left:20">
				${userInfo.gender}				
			</td>
		  </tr>		
	  </table>
	  <table width=640 border=0 cellpadding=0 cellspacing=0>
		  <tr>
			<td align=center>
			<input type="button" value="회원 삭제" onClick="userDelete()"> &nbsp;
			<input type="button" value="회원 수정" onClick="userModiy()">
			<input type="button" value="목록" onClick="userList()">
			</td>
		  </tr>
	  </table>

	  </td>
	</tr>
</table>  
	  				 
</body>
</html>