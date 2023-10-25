function emploCheck(){
   if(document.frm.name.value.length==0){
      alert("이름을 입력해주세요.");
      frm.name.focus();
      return false;
   }
   if(document.frm.pass.value.length==0){
      alert("비밀번호를 입력하세요.");
      frm.pass.focus();
      return false;
   }
   if(document.frm.id.value.length==0){
      alert("아이디를 입력해주세요.");
      frm.title.focus();
      return false;
   }
   return true;
}