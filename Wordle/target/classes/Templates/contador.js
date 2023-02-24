var segundos = 60;

function tiempo(){
    document.querySelector('p').innerHTML = segundos + " segundos";
    if(segundos==0){
        alert("perdiste")
    }
    else{
        segundos--;
        setTimeout("tiempo()", 1000)
    }
}