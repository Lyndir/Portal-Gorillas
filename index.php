<?php
    session_start();

    $target = 'about';
    if(isset($_GET['about']))
        $target = 'about';
    elseif(isset($_GET['original']))
        $target = 'original';
    elseif(isset($_GET['next']))
        $target = 'next';
    elseif(isset($_GET['test']))
        $target = 'test';

    $version = readlink("current");
    if(isset($_GET['v']))
        if($_GET['v'] == '1.0' || $_GET['v'] == '100')
            $version = '100';
        elseif($_GET['v'] == '1.1' || $_GET['v'] == '110')
            $version = '110';

    if($_POST['message']) {
        $name = $_POST['name'];
        $message = $_POST['message'];
        if(!$name)
            $name = "Anonymous";

        $_SESSION['comments'][$target] = array( $name, $message );

        $append = sprintf("%s: %s\n", $name, $_POST['message']);
        $current = file_get_contents("$target.moderate.txt");
        if(!strpos($current, $append)) {
          $handle = fopen("$target.moderate.txt", "a");
          fwrite($handle, $append);
          fclose($handle);
        }
    } elseif ($_SESSION['comments'][$target])
        list($name, $message) = $_SESSION['comments'][$target];
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
    <head>
        <title>Gorillas - The iPhone Game</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
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
        <script type="text/javascript" src="swfobject/swfobject.js"></script>
        <script type="text/javascript" src=".jquery/jquery.js"></script>
        <script type="text/javascript" src=".jquery/shadowbox-2.0/build/adapter/shadowbox-jquery.js"></script>
        <script type="text/javascript" src=".jquery/shadowbox-2.0/build/shadowbox.js"></script>
        <script type="text/javascript">
            Shadowbox.loadSkin('classic', '.jquery/shadowbox-2.0/src/skin');
            Shadowbox.loadLanguage('en', '.jquery/shadowbox-2.0/build/lang');
            Shadowbox.loadPlayer(['img', 'flv', 'qt', 'wmp', 'iframe'], '.jquery/shadowbox-2.0/build/player');

            $(document).ready(function() {

                var options = {
                    handleOversize:     'drag',
                    flvPlayer:          '.jquery/shadowbox-2.0/build/flvplayer.swf',
                    ext:                { img: ['png', 'jpg', 'jpeg', 'gif', 'bmp', 'php'] }
                };

                Shadowbox.init(options);
            });

            // Flash demonstrational movie.
            function showMovie(version) {
                var flashvars = {
                    file:           "http://gorillas.lyndir.com/" + version + "/movies/gorillas.flv",
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

                var swfElement = document.getElementById("swf");
                if(swfElement) {
                    swfobject.removeSWF("swf");

                } else {
                    swfElement = document.createElement("div");
                    swfElement.setAttribute("id", "swf");
                    document.getElementById("preview").appendChild(swfElement);

                    swfobject.embedSWF(".jquery/shadowbox-2.0/flvplayer.swf", "swf", "482", "322", "9.0.0", "swfobject/expressInstall.swf", flashvars, params, {id: "swf"});

                    pageTracker._trackPageview("/movie/gorillas-" + version + ".flv");
                }

                return false;
            }

            // Flash game: Original Gorilla.Bas
            function showGame() {
                var flashvars = false;
                var params = {
                    menu:           "false"
                }

                var swfElement = document.getElementById("swf");
                if(!swfElement) {
                    swfElement = document.createElement("div");
                    swfElement.setAttribute("id", "swf");
                    document.getElementById("game").appendChild(swfElement);

                    swfobject.embedSWF("http://rickyroad.com/miscmedia/Gorilla.swf", "swf", "640", "350", "9.0.0", "swfobject/expressInstall.swf", flashvars, params, {id: "swf"});

                    pageTracker._trackPageview('/game/original');
                }

                return false;
            }

            // Google Analytics
            var gaJsHost = (("https:" == document.location.protocol) ? "https://ssl." : "http://www.");
            document.write(unescape("%3Cscript src='" + gaJsHost + "google-analytics.com/ga.js' type='text/javascript'%3E%3C/script%3E"));
        </script>
    </head>

    <body class="<?="t_$target"?>">
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
            <!--ul id="submenu">
                <li class="a<?=($target == 'about' && $version == '100')? " active": ""?>">
                    <a href="/?about&amp;v=1.0"></a></li>
                <li class="b<?=($target == 'about' && $version == '110')? " active": ""?>">
                    <a href="/?about&amp;v=1.1"></a></li>
            </ul-->
        </div>

        <div id="back">
            <a class="track" href="/trac"></a>
            <a class="title" href="/"></a>
            <div class="bottom"></div>
        </div> 
                
        <div id="comments">
            <?php
                $lines = explode("\n", file_get_contents("$target.txt"));
                foreach($lines as $line) {
                    list($_name, $_message) = explode(':', $line, 2);
                    $_message = trim($_message);
                    $_name = trim($_name);

                    if($_name == $name || !$_message)
                        continue; ?>

                    <br /><?=sprintf('"%s"', htmlspecialchars(ucfirst($_message)))?>
                    <?php if($_name) { ?>
                        <?=sprintf('~%s', htmlspecialchars(preg_replace('/(@|\Wat\W).*/', '', $_name)))?>
                    <? }
                }
            ?>
            <?php if($message) { ?>
                <br /><?=sprintf('"%s"', htmlspecialchars(ucfirst($message)))?>
                <?php if($name) { ?>
                    <?=sprintf('~%s', htmlspecialchars(preg_replace('/(@|\Wat\W).*/', '', $name)))?>
                <? } ?>
            <? } ?>
            
            <form action="<?="?$target&amp;v=$version"?>" method="POST">
                <p>Post <b>your</b> impression.</p>
                <p>Got a comment, opinion, impression or question?<br />
                    Don't forget to leave your email address if you'd like me to get back to you.</p>

                <label for="user">Name or email:</label>
                <input type="text" name="name" id="name" value="<?=htmlspecialchars($name)?>" />

                <label for="message">Your impression:</label>
                <input type="text" name="message" id="message" value="<?=htmlspecialchars($message)?>" />

                <label for="post"></label>
                <input type="submit" name="post" id="post" value="Post" />
            </form>
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
            <a  class="border"
                href="http://gorillas.lyndir.com"
                rel="cc:attributionURL"
                xmlns:cc="http://creativecommons.org/ns#">Maarten Billemont</a>
            is licensed under the
            <a  class="border"
                href="http://creativecommons.org/licenses/GPL/2.0/">CC-GNU GPL</a>
            version 2.0.
        </p>
    </body>
</html>
