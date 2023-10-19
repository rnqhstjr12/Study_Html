function loginCheck() {
	if (document.frm.id.value.length == 0) {
		alert("아이디를 입력해주세요.");
		frm.id.focus();
		return false;
	}
	if (document.frm.pw.value == "") {
		alert("암호는 반드시 입력해야 합니다.")
		frm.pw.focus();
		return false;
	}
	return true;
}
function insertCheck() {
	if (document.frm.id.value.length == 0) {
		alert("아이디를 입력해주세요.");
		frm.id.focus();
		return false;
	}
	if (document.frm.pw.value == "") {
		alert("암호는 반드시 입력해야 합니다.")
		frm.pw.focus();
		return false;
	}
	if (document.frm.name.value.length == 0) {
		alert("이름을 입력해 주세요.");
		frm.id.focus();
		return false;
	}
	if (document.frm.phone.value.length == 0) {
		alert("전화번호를 입력해 주세요.");
		frm.id.focus();
		return false;
	}
	return true;
}