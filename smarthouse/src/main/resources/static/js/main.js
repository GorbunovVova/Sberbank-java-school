function showTemperature()
{
	$.ajax({
		url: "lastTemperature/",
		cache: false,
		success: function(html){
			$("#temperature").html(html);
		}
	});
}

$(document).ready(function(){
	showTemperature();
	setInterval('showTemperature()',1000);
});

function showWetness()
{
	$.ajax({
		url: "lastWetness/",
		cache: false,
		success: function(html){
			$("#wetness").html(html);
		}
	});
}

$(document).ready(function(){
	showWetness();
	setInterval('showWetness()',1000);
});

function showGas()
{
    $.ajax({
    	url: "lastGas/",
    	cache: false,
    	success: function(html){
    		$("#gas").html(html);
    		if (html.startsWith("1.0")) {
    		    alert("Опасная концентрация газа!");
    		}
    	}
    });
}

$(document).ready(function(){
    showGas();
    setInterval('showGas()',1000);
});

function showLight()
{
    $.ajax({
    	url: "lastLight/",
    	cache: false,
    	success: function(html){
    		$("#light").html(html);
    	}
    });
}

$(document).ready(function(){
    showLight();
    setInterval('showLight()',1000);
});

function showTv()
{
    $.ajax({
    	url: "lastTv/",
    	cache: false,
    	success: function(html){
    		$("#tv").html(html);
    	}
    });
}

$(document).ready(function(){
    showTv();
    setInterval('showTv()',1000);
});

function showKettle()
{
    $.ajax({
    	url: "lastKettle/",
    	cache: false,
    	success: function(html){
    		$("#kettle").html(html);
    	}
    });
}

$(document).ready(function(){
    showKettle();
    setInterval('showKettle()',1000);
});

function showGameConsole()
{
    $.ajax({
    	url: "lastGameConsole/",
    	cache: false,
    	success: function(html){
    		$("#gameConsole").html(html);
    	}
    });
}

$(document).ready(function(){
    showGameConsole();
    setInterval('showGameConsole()',1000);
});
function showAlarm()
{
    $.ajax({
    	url: "lastAlarm/",
    	cache: false,
    	success: function(html){
    		$("#alarm").html(html);
    		var date = new Date();
    		var hours = date.getHours();
    		var minutes = date.getMinutes();
    		var seconds = date.getSeconds();
    		var strDate = hours + ":" + minutes + ":" + seconds;
    		console.log("текущее время" + strDate);
    	    console.log("будильник" + html);
    	    if (strDate == html) {
    	        alert("Будильник!");
    	    }
    	}
    });
}

$(document).ready(function(){
    showAlarm();
    setInterval('showAlarm()',1000);
});

$(document).ready(function(){

    $('#temperatureForm').submit(function(){
        $.ajax({
            type: "POST",
            url: "temperature/",
            data: {value : $("#temperatureInput").val()}
        });
        return false;
    });

});

$(document).ready(function(){

    $('#wetnessForm').submit(function(){
        $.ajax({
            type: "POST",
            url: "wetness/",
            data: {value : $("#wetnessInput").val()}
        });
        return false;
    });
});

$(document).ready(function(){

    $('#wetnessForm').submit(function(){
        $.ajax({
            type: "POST",
            url: "wetness/",
            data: {value : $("#wetnessInput").val()}
        });
        return false;
    });
});

$(document).ready(function(){

       $('#alarmForm').submit(function(){
           $.ajax({
               type: "POST",
               url: "alarm/",
               data: {time : $("#alarmInput").val()}
       });
       return false;
    });
});

$(document).ready(function(){

       $('#lightForm').submit(function(){
           $.ajax({
               type: "POST",
               url: "light/",
               data: {toggle : (($("#light").text() == "Свет включен") ? false : true)}
       });
       return false;
    });
});

$(document).ready(function(){

        $('#tvForm').submit(function(){
           $.ajax({
               type: "POST",
               url: "tv/",
               data: {toggle : (($("#tv").text() == "Телевизор включен") ? false : true)}
        });
        return false;
    });
});

$(document).ready(function(){

       $('#gameConsoleForm').submit(function(){
           $.ajax({
               type: "POST",
               url: "gameConsole/",
               data: {toggle : (($("#gameConsole").text() == "Приставка включена") ? false : true)}
       });
       return false;
    });
});

$(document).ready(function(){

       $('#kettleForm').submit(function(){
           $.ajax({
               type: "POST",
               url: "kettle/",
               data: {toggle : (($("#kettle").text() == "Чайник включен") ? false : true)}
       });
       return false;
    });
});

