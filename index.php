<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Gorillas - The iPhone Game</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <script type="text/javascript" src=".jquery/jquery.js"></script>
        <script type="text/javascript">
            $(document).ready(function() {
 
                $("#preview").toggle(
                    function () {
                        $("object").css({"display":"block"});
                    },
                    function () {
                        $("object").css({"display":"none"});
                    }
                );
            });
        </script>
    </head>

    <body>
        <div id="back">
            <a class="track" href="/trac"></a>
            <a class="title" href="/">In the App Store, soon!</a>
            <div class="bottom"></div>
        </div> 
            
        <div id="preview">
            <!--img src="images/gorillas_phone.png" alt="Screenshot of the Gorillas game on the iPhone." /-->
            <div class="tip">Click for a short gameplay video.</div>
            <object type="application/x-shockwave-flash" data=".jquery/shadowbox-2.0/flvplayer.swf">
                <param name="movie" value=".jquery/shadowbox-2.0/flvplayer.swf" />
                <param name="allowfullscreen" value="true" />
                <param name="flashvars" value="file=http://gorillas.lyndir.com/gorillas.flv&amp;width=482&amp;height=322&amp;autostart=true&amp;displayheight=322&amp;showicons=false&amp;backcolor=0x000000&amp;frontcolor=0xCCCCCC&amp;lightcolor=0x557722" />
            </object>
            <!--a rel="shadowbox;width=482;height=302" title="Gorillas" href="gorillas.flv">
                <img src="images/gorillas_phone.png" />
            </a-->
        </div>

        <script type="text/javascript">
            var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
            document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
        </script><script type="text/javascript">
            try {
                var pageTracker = _gat._getTracker("UA-90535-5");
                pageTracker._trackPageview();
            } catch(err) {}
        </script>

        <div>
            <!-- W3C, Valid XHTML 1.0 -->
            <a href="http://validator.w3.org/check?uri=referer">
                <img src="http://www.w3.org/Icons/valid-xhtml10" alt="Valid XHTML 1.0 Strict" height="31" width="88" />
            </a><br />

            <!-- AddThis -->
            <script type="text/javascript">
                addthis_pub             = 'lhunath'; 
                addthis_logo            = 'http://gorillas.lyndir.com/images/icon.png';
                addthis_logo_background = 'EFEFFF';
                addthis_logo_color      = '666699';
                addthis_brand           = 'Gorillas';
                addthis_options         = 'favorites, email, digg, delicious, myspace, facebook, google, live, more';
            </script>
            <a href="http://www.addthis.com/bookmark.php"
                onmouseover="return addthis_open(this, '', '[URL]', '[TITLE]')"
                onclick="return addthis_sendto()"
                onmouseout="addthis_close()">
                <img src="http://s7.addthis.com/static/btn/lg-share-en.gif" width="125" height="16" border="0" alt="Share" />
            </a><br />
            <script type="text/javascript" src="http://s7.addthis.com/js/152/addthis_widget.js"></script>

            <!-- Creative Commons License -->
            <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/3.0/" class="float right">
                <img alt="Creative Commons License" src="http://i.creativecommons.org/l/by-nc-sa/3.0/88x31.png" />
            </a><br />
            <img src="images/back_hover trac_hover.png" class="preload" alt="Preload image of Trac logo." />
        </div>

        <p id="footer">
            <b xmlns:dc="http://purl.org/dc/elements/1.1/" href="http://purl.org/dc/dcmitype/InteractiveResource" property="dc:title" rel="dc:type">Gorillas</b> by <a xmlns:cc="http://creativecommons.org/ns#" href="http://gorillas.lyndir.com" property="cc:attributionName" rel="cc:attributionURL">Maarten Billemont</a> is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-sa/3.0/">Creative Commons Attribution-Noncommercial-Share Alike 3.0 Unported License</a>.
        </p>
    </body>
</html>
