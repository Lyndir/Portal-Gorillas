// Flash demonstrational movie.
function showMovie(container, version) {
    var flashvars = {
        file:           "/" + version + "/movies/gorillas.flv",
        width:          "482",
        height:         "322",
        autostart:      "true",
        displayheight:  "322",
        showicons:      "false",
        backcolor:      "0x000000",
        frontcolor:     "0xCCCCCC",
        lightcolor:     "0x557722"
    };
    var params = {
        menu:           "false"
    }

    var swfElement = container.getElementById("swf");
    if(swfElement) {
        swfobject.removeSWF("swf");

    } else {
        swfElement = document.createElement("div");
        swfElement.setAttribute("id", "swf");
        container.appendChild(swfElement);

        swfobject.embedSWF( ".jquery/shadowbox-2.0/flvplayer.swf", "swf", "482", "322",
                            "9.0.0", "swfobject/expressInstall.swf", flashvars, params, {id: "swf"} );

        pageTracker._trackPageview("/movie/gorillas-" + version + ".flv");
    }

    return false;
}

$(document).ready(function() {
    if(navigator.appVersion.indexOf('iPhone') == -1) {
        var element = document.getElementById('preview');

        element.onclick = function() { return showMovie(preview, '1.2'); };
        if (element.captureEvents)
            element.captureEvents(Event.CLICK);
    }
}
