function showMovie(container) {

    var flashvars = {
        config:         "{'clip':{'url': '${movieLink}'}}"
    };
    var params = {
    }

    var swfElement = document.getElementById("swf");
    if (swfElement) {
        swfobject.removeSWF("swf");

    } else {
        swfElement = document.createElement("div");
        swfElement.setAttribute("id", "swf");
        container.appendChild(swfElement);

        swfobject.embedSWF( "js/flowplayer/flowplayer-3.1.1.swf", "swf", "482", "322",
                            "9.0.0", "js/swfobject/expressInstall.swf", flashvars, params, {id: "swf"} );

        ${pageTrackCode}
    }

    return false;
}

$(document).ready(function() {
    if (navigator.appVersion.indexOf('iPhone') == -1) {
        var element = document.getElementById('preview');
        if (element) {
            element.onclick = function() { return showMovie(this); };
            if (element.captureEvents)
                element.captureEvents(Event.CLICK);
        }
    }
});
