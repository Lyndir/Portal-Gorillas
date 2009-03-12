<?php

    $target = 'about';
    if(isset($_GET['about']))
        $target = 'about';
    elseif(isset($_GET['original']))
        $target = 'original';
    elseif(isset($_GET['next']))
        $target = 'next';

?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Gorillas - The iPhone Game</title>
        <meta name="verify-v1" content="IluFmv0cMN6OlW/zGTTUB9T7yXMyqW2PiEA5scdp274=" />
        <link rel="icon" href="favicon.png" type="image/x-png" />
        <link rel="shortcut icon" href="favicon.png" type="image/x-png" />
        <link rel="stylesheet" type="text/css" href="style.css" />
        <!--[if !IE]>-->
            <style type="text/css">
                @media only screen and (max-device-width: 480px) {
                    #preview object, #preview .tip .small {
                        display:            none;
                        visibility:         hidden;
                    }
                    .iphone, #preview .tip {
                        display:            block;
                    }
                }
            </style>
        <!--<![endif]-->
        <!--[if lt IE 8]>
            <script type="text/javascript">
                IE7_PNG_SUFFIX = ".png";
            </script>
            <script type="text/javascript" src="http://ie7-js.googlecode.com/svn/version/2.0(beta3)/IE8.js"></script>
        <![endif]-->
        <script type="text/javascript">

            // Flash demonstrational movie.
            function showMovie() {
                var movieElement = document.getElementById('preview').getElementsByTagName('object')[0];

                if(movieElement.style.display == 'block') {
                    movieElement.style.display = 'none';
                } else {
                    movieElement.style.display = 'block';
                    pageTracker._trackPageview('/movie/gorillas.flv');
                }

                return true;
            }

            // Flash game: Original Gorilla.Bas
            function showGame() {
                var gameElement = document.getElementById('game').getElementsByTagName('object')[0];

                if(!(gameElement.style.display == 'block')) {
                    gameElement.style.display = 'block';
                    pageTracker._trackPageview('/game/original');
                } else
                    return false;

                return true;
            }

            // Google Analytics
            var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
            document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
        </script>
    </head>

    <body>
        <div>
            <ul id="menu">
                <li class="a<?=($target == 'about')? " active": ""?>">
                    <a href="/?about"></a></li>
                <li class="b">
                    <a href="/trac"></a></li>
                <li class="c<?=($target == 'original')? " active": ""?>">
                    <a href="/?original"></a></li>
                <li class="d">
                    <a href="http://lhunath.lyndir.com"
                        onclick="pageTracker._trackPageview(this.href.replace(/^[a-z]+:\/\//i, '/external/'));"></a></li>
            </ul>
        </div>

        <div id="back">
            <a class="track" href="/trac"></a>
            <a class="title" href="/"></a>
            <div class="bottom"></div>
        </div> 
                
        <? include("$target.php"); ?>

        <p>
            <!-- W3C, Valid XHTML 1.0 -->
            <a href="http://validator.w3.org/check?uri=referer">
                <img src="images/valid-xhtml10.png" alt="Valid XHTML 1.0 Strict" />
            </a>

            <!-- Image Preloading -->
            <img src="images/back_trac_hover.png" class="preload" alt="Preload image of Trac logo." />

            <!-- Track this page hit on GA -->
            <script type="text/javascript">
                try {
                    var pageTracker = _gat._getTracker("UA-90535-5");
                    pageTracker._trackPageview();
                } catch(err) {}
            </script>
        </p>

        <p id="footer">
            <!-- Credits -->
            <b  xmlns:dc="http://purl.org/dc/elements/1.1/">Gorillas</b>
            by
            <a  class="b"
                href="http://gorillas.lyndir.com"
                rel="cc:attributionURL"
                xmlns:cc="http://creativecommons.org/ns#">Maarten Billemont</a>
            is licensed under the
            <a  class="b"
                href="http://creativecommons.org/licenses/GPL/2.0/">CC-GNU GPL</a>
            version 2.0.
        </p>
    </body>
</html>
