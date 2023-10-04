function check() {
	if (doucument.frm.id.value == "") {
		alert("아이디를 입력해주세요.");
		document.frm.id.focus();
		return false;
	} else if (doucument.frm.age.value == "") {
		alert("나이를 입력해주세요.");
		document.frm.age.focus();
		return false;
	} else if (doucument.frm.name.value == "") {
		alert("이름을 입력해주세요.");
		document.frm.age.focus();
		return false;
	} else if (doucument.frm.from.value == "") {
		alert("주소를 입력해주세요.");
		document.frm.age.focus();
		return false;
	} else if (isNaN(doucument.frm.age.value)) {
		alert("숫자로 입력해주세요.");
		document.frm.age.focus();
		return false;
	} else {
		return true;
	}
}