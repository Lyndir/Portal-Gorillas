function showGame(container) {

    var flashvars = false;
    var params = {
        menu:           "false"
    }

    var swfElement = document.getElementById("swf");
    if (!swfElement) {
        swfElement = document.createElement("div");
        swfElement.setAttribute("id", "swf");
        container.appendChild(swfElement);

        swfobject.embedSWF( "http://rickyroad.com/miscmedia/Gorilla.swf", "swf", "640", "350",
                            "9.0.0", "js/swfobject/expressInstall.swf", flashvars, params, {id: "swf"} );

        //pageTracker._trackPageview('/game/original');
    }

    return false;
}

$(document).ready(function() {
    if (navigator.appVersion.indexOf('iPhone') == -1) {
        var element = document.getElementById('game');
        if (element) {
            element.onclick = function() { return showGame(this); };
            if (element.captureEvents)
                element.captureEvents(Event.CLICK);
        }
    }
});
