var wartezeitMin = 0;
var wartezeitSek = 10;
var loginOk = false;

document.getElementById("countdown-timer").innerHTML = "15:00";
function  countdown(){
	
	wartezeitSek--;
	if (wartezeitSek < 0) {
		wartezeitSek = 59;
		wartezeitMin--;
	}

	var wMin=""+wartezeitMin, wSek=""+wartezeitSek;

	if (wartezeitMin < 10)
		wMin = "0" + wartezeitMin;
	if (wartezeitSek < 10)
		wSek = "0" + wartezeitSek;

	document.getElementById("countdown-timer").innerHTML = wMin+":"+wSek;
	
	if (wartezeitMin === 0 && wartezeitSek === 0 && loginOk) {
		// new GuiDrive(GuiUser.this); // Eventuallität (loginKorrekt &&
		// warteZeitAbgelaufen ) -> Dann Login????
		console.log("asd");
	} else if (wartezeitMin === 0 && wartezeitSek === 0) {
		wartezeitMin = 15;
		wartezeitSek = 00;
	}
};

var timerID = setInterval("countdown()", 1000);