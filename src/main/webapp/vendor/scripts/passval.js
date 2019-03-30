var password = document.getElementById("inputpassword")
  , confirm_password = document.getElementById("inputpassword2");

function validatePassword(){
  if(inputpassword.value != inputpassword2.value) {
    inputpassword2.setCustomValidity("Passwords don't match");
  } else {
    inputpassword2.setCustomValidity('');
  }
}

inputpassword.onchange = validatePassword;
inputpassword2.onkeyup = validatePassword;