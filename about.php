        <h2>For a preview of Gorillas 1.1, <a href="?next" class="b">click here</a>.</h2>

        <div id="preview">
            <div class="tip">Click for a short gameplay video.<br />
                <span class="small">(or <a href="http://www.youtube.com/watch?v=Hu4Y8eJLqkI"
                                            onclick="pageTracker._trackPageview('/movie/youtube');">YouTube</a>
                                      / <a href="gorillas.mp4"
                                            onclick="pageTracker._trackPageview('/movie/gorillas.mp4');">MPEG-4</a>)</span></div>
            <object type="application/x-shockwave-flash" data=".jquery/shadowbox-2.0/flvplayer.swf">
                <param name="movie" value=".jquery/shadowbox-2.0/flvplayer.swf" />
                <param name="allowfullscreen" value="true" />
                <param name="flashvars" value="file=http://gorillas.lyndir.com/gorillas.flv&amp;width=482&amp;height=322&amp;autostart=true&amp;displayheight=322&amp;showicons=false&amp;backcolor=0x000000&amp;frontcolor=0xCCCCCC&amp;lightcolor=0x557722" />
            </object>

            <a class="iphone" href="http://www.youtube.com/watch?v=Hu4Y8eJLqkI"
                onclick="pageTracker._trackPageview('/movie/youtube');"></a>
        </div>

        <script type="text/javascript">
            if(navigator.appVersion.indexOf('iPhone') == -1)
                document.getElementById('preview').onclick = showMovie;
        </script>

        <div id="content">
            <p>
                <!-- App Store -->
                <a href="http://itunes.apple.com/WebObjects/MZStore.woa/wa/viewSoftware?id=302275459&amp;mt=8"
                    onclick="pageTracker._trackPageview(this.href.replace(/^[a-z]+:\/\//i, '/external/'));">
                    <img src="images/appstore.png" alt="The Apple App Store" />
                </a>
                <br />

                <!-- AddThis -->
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

            <!-- Description -->
            <div class="text">
                <p><b>Gorillas</b><br />
                    by <a class="b" href="http://lhunath.lyndir.com"
                    onclick="pageTracker._trackPageview(this.href.replace(/^[a-z]+:\/\//i, '/external/'));">Lhunath</a></p>
                <p>Gorillas is a port of the <a class="b" href="?original">original GORILLA.BAS</a> to the iPhone platform.</p>

                <p>It's a turn based single player and multi player game where the objective is to blast your opponent away using carefully aimed bananas.</p>

                <p>With a single touch of the display you determine the direction and speed of your banana's throw.  Don't forget to take the wind into account!</p>

                <p><b>FEATURES:</b></p>
                <ul>
                   <li>Eye candy worthy of your iPhone / iPod touch</li>
                   <li>Wind and weather effects, such as rain and snow</li>
                   <li>A range of excellent retro remixes</li>
                   <li>Challenge the AI or a friend</li>
                   <li>Dynamically adjusted or configurable difficulty</li>
                   <li>Pick from several different cities / worlds</li>
                   <li>Fully <a class="b" href="/trac">Open Source (GPLv2)</a></li>
                </ul>

                <p><b>UPCOMING UPDATE:</b><br />
                    Version 1.1 is near completion and will introduce the following togglable additions:</p>
                <ul>
                   <li>Camera action</li>
                   <li>Zoomable game field for those long shots</li>
                   <li>Sound effects, vibration and shaking</li>
                   <li>Kill shot replay during multiplayer</li>
                   <li>Bonusses for skilled shots</li>
                   <li>Training features</li>
                </ul>
            </div>

            <!-- Screenshots -->
            <p id="screenshots">
                <img src="images/2.png" alt="Throwing bananas is an easy, one-touch motion." />
                <img src="images/3.png" alt="Two gorillas trying to dig through buildings before getting hit." />
                <img src="images/4.png" alt="Gorillas features several different worlds to play in." />
                <img src="images/5.png" alt="Each world has different gravity and wind strength." />
            </p>

            <!-- Creative Commons License -->
            <a href="http://creativecommons.org/licenses/GPL/2.0/" class="float right">
                <img alt="CC-GNU GPL" src="http://creativecommons.org/images/public/cc-GPL-a.png" />
            </a>
        </div>
