<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
label {
	width:160px;
	display: inline-block;
	float: left;
}
#button{
	text-align: center;
}
</style>
<script type="text/javascript">
	function checkOn() {
		if (document.frm.name.value == null) {
			alert("이름을 입력해 주세요.");
			return false;
		} else if (document.frm.rNum1.value == null ||
				   document.frm.rNum1.value == null) {
			alert("주민번호를 입력해 주세요.");
			return false;

		} else if (document.frm.id.value == null) {
			alert("아이디를 입력해 주세요.");
			return false;

		} else if (document.frm.pwd.value == null) {
			alert("비밀번호를 입력해 주세요.");
			return false;
			
		} else if (document.frm.pwd_re.value == null) {
			alert("비밀번호를 입력해 주세요.");
			return false;
		} else if (document.frm.pwd.value != document.frm.pwd_re.value) {
			alert("비밀번호를 정확히 입력해 주세요.");
			return false;
		}
	}
</script>
<title>prob02</title>
</head>
<body>
<form id="frm" action="LoginSet">
	<label for="name">이름</label>
	<input type="text" name="name" id="name"><br>
	
	<label>주민등록번호</label>
	<input type="text" name="rNum1"> - 
	<input type="password" name="rNum2"><br>
	
	<label for="id">아이디</label>
	<input type="text" name="id" id="id"><br>
	
	<label for="pwd">비밀번호</label>
	<input type="password" name="pwd" id="pwd"><br>
	<label for="pwd_re">비밀번호 확인</label>
	<input type="password" name="pwd_re" id="pwd_re"><br>
	
    <label for="email">이메일 </label>
    <input type="text" name="email"> @ 
    <input type="text" name="email_dns">
    <select name="emailaddr">
			<option value="">직접입력</option>
			<option value="naver">naver.com</option>
			<option value="gmail">gmail.com</option>
			<option value="daum">daum.net</option>
			<option value="nate">nate.com</option>
	</select><br>
	
	<label for="zipCode">우편번호</label>
	<input type="text" name="zipCode" id="zipCode"><br>
	
	<label for="addr">주소</label>
	<input type="text" name="addr1" id="addr1">
	<input type="text" name="addr2"><br>
	
	<label for="phone">핸드폰번호</label>
	<input type="tel" name="phone" id="phone"><br>
	
	<label for="job" style="float: left">직업</label>
	<select id="job" name="job" size="4">
		<option value="무직" selected="selected">무직</option>
		<option value="학생">학생</option>
		<option value="컴퓨터/인터넷">컴퓨터/인터넷</option>
		<option value="언론">언론</option>
		<option value="공무원">공무원</option>
		<option value="군인">군인</option>
		<option value="서비스업">서비스업</option>
		<option value="교육">교육</option>
	</select><br>
	
	<label for="check">메일/SMS 정보 수신</label>
	<input type="radio" id="check" name="check" checked>수신
	<input type="radio" id="check" name="check">수신거부<br>
	
	<label for="coff">관심분야</label>
	<input type="checkbox" name="coff" id="coff" value="생두">생두
	<input type="checkbox" name="coff" id="coff" value="원두">원두
	<input type="checkbox" name="coff" id="coff" value="로스팅">로스팅
	<input type="checkbox" name="coff" id="coff" value="핸드드립">핸드드립
	<input type="checkbox" name="coff" id="coff" value="에스프레소">에스프레소
	<input type="checkbox" name="coff" id="coff" value="창업">창업<br>
	
<div id="button">
	<input type="submit" value="회원가입" onclick="return checkOn()">
	<input type="submit" value="취소">
</div>
</form>

</body>
</html>