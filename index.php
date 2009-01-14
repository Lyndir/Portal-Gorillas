<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Gorillas - The iPhone Game</title>
        <meta name="verify-v1" content="IluFmv0cMN6OlW/zGTTUB9T7yXMyqW2PiEA5scdp274=" />
        <link rel="icon" href="favicon.png" type="image/png" />
        <link rel="shortcut icon" href="favicon.png" type="image/png" />
        <link rel="stylesheet" type="text/css" href="style.css" />
        <!--[if !IE]>-->
            <link type="text/css" media="only screen and (max-device-width: 480px)" href="style-iphone.css" rel="stylesheet" />
        <!--<![endif]-->
        <!--[if lt IE 8]>
            <script type="text/javascript">
                IE7_PNG_SUFFIX = ".png";
            </script>
            <script type="text/javascript" src="http://ie7-js.googlecode.com/svn/version/2.0(beta3)/IE8.js"></script>
        <![endif]-->
        <script type="text/javascript">
            function showMovie() {
                var movieElement = document.getElementById('preview').getElementsByTagName('object')[0];

                if(movieElement.style.display == 'block') {
                    movieElement.style.display = 'none';
                    pageTracker._trackEvent("Movies", "Start", "gorillas.flv", 1);
                } else {
                    movieElement.style.display = 'block';
                    pageTracker._trackEvent("Movies", "Stop", "gorillas.flv", 1);
                }

                return true;
            }
        </script>
    </head>

    <body>
        <div id="back">
            <a class="track" href="/trac"></a>
            <a class="title" href="/">In the App Store, soon!</a>
            <div class="bottom"></div>
        </div> 
            
        <div id="preview">
            <div class="tip">Click for a short gameplay video.<br />
                (or <a href="gorillas.mp4">download</a> / <a href="http://www.youtube.com/watch?v=Hu4Y8eJLqkI">YouTube</a>)</div>
            <object type="application/x-shockwave-flash" data=".jquery/shadowbox-2.0/flvplayer.swf">
                <param name="movie" value=".jquery/shadowbox-2.0/flvplayer.swf" />
                <param name="allowfullscreen" value="true" />
                <param name="flashvars" value="file=http://gorillas.lyndir.com/gorillas.flv&amp;width=482&amp;height=322&amp;autostart=true&amp;displayheight=322&amp;showicons=false&amp;backcolor=0x000000&amp;frontcolor=0xCCCCCC&amp;lightcolor=0x557722" />
            </object>
            <a class="iphone" href="http://www.youtube.com/watch?v=Hu4Y8eJLqkI" onclick="return pageTracker._trackEvent('Movies', 'Start', 'gorillas.youtube', 1);"></a>
        </div>

        <script type="text/javascript">
            var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
            document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
        </script><script type="text/javascript">
            if(navigator.appVersion.indexOf('iPhone') == -1)
                document.getElementById('preview').onclick = showMovie;

            try {
                var pageTracker = _gat._getTracker("UA-90535-5");
                pageTracker._trackPageview();
            } catch(err) {}
        </script>

        <div id="content">
            <!-- AddThis -->
            <p>
                <script type="text/javascript">
                    addthis_pub             = 'lhunath'; 
                    addthis_logo            = 'http://gorillas.lyndir.com/images/icon.png';
                    addthis_logo_background = 'EFEFFF';
                    addthis_logo_color      = '666699';
                    addthis_brand           = 'Gorillas';
                    addthis_options         = 'email, twitter, stumbleupon, digg, delicious, facebook, slashdot, more';
                </script>
                <a href="http://www.addthis.com/bookmark.php"
                    onmouseover="return addthis_open(this, '', '[URL]', '[TITLE]')"
                    onclick="return addthis_sendto()"
                    onmouseout="addthis_close()">
                    <img src="images/sm-share-en.gif" alt="Share" />
                </a>
                <script type="text/javascript" src="http://s7.addthis.com/js/152/addthis_widget.js"></script>
            </p>

            <div class="text">
                <p><b>Gorillas</b><br />
                    by <a href="http://lhunath.lyndir.com">Lhunath</a></p>
                <p><i>Gorillas</i> is a turn based single player and multiplayer game where the objective is to blast your opponent away using carefully aimed bananas.</p>

                <p>With a single touch of the display you determine the direction and speed of your banana's throw.  Don't forget to take the wind into account!</p>


                <p><b>FEATURES:</b>
                <ul>
                    <li>Classic retro look</li>
                    <li>Eye candy worthy of your iPhone / iPod touch</li>
                    <li> Wind and weather effects, such as rain and snow</li>
                    <li> Challenge the AI or a friend</li>
                    <li> Dynamically adjusted difficulty</li>
                    <li> Several different cities / worlds</li>
                    <li> Fully Open Source (GPLv2)</li>
                </ul></p>
            </div>

            <p>
                <img class="screenshot" src="images/Screenshot 2009.01.13 21.43.25.png" />
                <img class="screenshot" src="images/Screenshot 2009.01.13 21.25.33.png" />
                <img class="screenshot" src="images/Screenshot 2009.01.13 21.10.41.png" />
                <img class="screenshot" src="images/Screenshot 2009.01.13 21.12.30.png" />
            </p>

            <!-- W3C, Valid XHTML 1.0 -->
            <p>
                <a href="http://validator.w3.org/check?uri=referer">
                    <img src="images/valid-xhtml10.png" alt="Valid XHTML 1.0 Strict" />
                </a>
            </p>

            <!-- Creative Commons License -->
            <a href="http://creativecommons.org/licenses/GPL/2.0/" class="float right">
                <img alt="CC-GNU GPL" src="http://creativecommons.org/images/public/cc-GPL-a.png" />
            </a>

            <!-- Image Preloading -->
            <img src="images/back_trac_hover.png" class="preload" alt="Preload image of Trac logo." />
        </div>

        <p id="footer">
            <b xmlns:dc="http://purl.org/dc/elements/1.1/" href="http://purl.org/dc/dcmitype/InteractiveResource" property="dc:title" rel="dc:type">Gorillas</b> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://gorillas.lyndir.com" property="cc:attributionName" rel="cc:attributionURL">Maarten Billemont</a> is licensed under the <a href="http://creativecommons.org/licenses/GPL/2.0/">CC-GNU GPL</a> version 2.0.
        </p>
    </body>
</html>
