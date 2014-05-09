var wartezeitMin = 15;
var wartezeitSek = 00;
var getTimeSek = 0;
var loginOk = true;

document.getElementById("countdown-timer").innerHTML = "15:00";

function getTime() {
	var request = new XMLHttpRequest();
	request.open("POST", "getData");
    request.send();
    request.onreadystatechange = function(){
        if(request.readyState === 4){
            getTimeSek = request.responseText;
            
        }
    }
    wartezeitMin = getTimeSek/60;
    wartezeitSek = getTimeSek%60;
}


function countdown() {

	if(wartezeitSek%5==0)
		getTime();
	
	wartezeitSek--;
	if (wartezeitSek < 0) {
		wartezeitSek = 59;
		wartezeitMin--;
	}

	var wMin = "" + wartezeitMin, wSek = "" + wartezeitSek;

	if (wartezeitMin < 10)
		wMin = "0" + wartezeitMin;
	if (wartezeitSek < 10)
		wSek = "0" + wartezeitSek;

	document.getElementById("countdown-timer").innerHTML = wMin + ":" + wSek;

	if (wartezeitMin === 0 && wartezeitSek === 0 && loginOk) {
		window.location = "steuerung.jsp";
	} else if (wartezeitMin === 0 && wartezeitSek === 0) {
		wartezeitMin = 15;
		wartezeitSek = 00;
	}
};

var timerID = setInterval("countdown()", 1000);