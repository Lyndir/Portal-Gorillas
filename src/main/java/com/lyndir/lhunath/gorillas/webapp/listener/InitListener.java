/*
 *   Copyright 2009, Maarten Billemont
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package com.lyndir.lhunath.gorillas.webapp.listener;

import com.google.common.collect.ImmutableList;
import com.lyndir.lhunath.apps.listener.AppsListener;
import com.lyndir.lhunath.apps.model.App;
import com.lyndir.lhunath.apps.model.AppVersion;
import com.lyndir.lhunath.apps.model.Dependency;
import com.lyndir.lhunath.apps.model.GitHubSourceProvider;
import java.util.Date;
import javax.servlet.ServletContextEvent;


/**
 * <h2>{@link InitListener}<br> <sub>[in short] (TODO).</sub></h2>
 *
 * <p> [description / usage]. </p>
 *
 * <p> <i>Jun 12, 2009</i> </p>
 *
 * @author lhunath
 */
public class InitListener extends AppsListener {

    /**
     * {@inheritDoc}
     */
    @Override
    public void contextInitialized(final ServletContextEvent sce) {

        super.contextInitialized( sce );

        // Register our application and its versions.
        App gorillas = new App( "lhunath", "Gorillas", "gorillas", new GitHubSourceProvider( "Lamentum" ), "UA-90535-5" );
        String description = "<p class='short'>Gorillas is a resurrection of the classic QBasic game shipped with MS-DOS 5.</p>" //
                             + "<p>Gorillas are at large on the metropolis rooftops.<br />" //
                             + "They're fighting for control over the city by bombarding each other with explosive bananas.  " //
                             + "One touch on the screen determines the throw's aim and velocity and sends your projectile on "  //
                             + "its way to take out your enemy or the buildings that stand in your way.<br />" //
                             + "<p>This release combines gorgeous iPhone/iPad/iPod touch features with pure melancholic gameplay.</p>";
        AppVersion.register( new AppVersion( gorillas, "100", "1.0", //
                                             null, //
                                             description, //
                                             ImmutableList.of( //
                                                               new Dependency( "Cocos2d-iPhone",
                                                                               "http://github.com/lhunath/Cocos2D-iPhone/tree/Gorillas-100",
                                                                               "http://github.com/lhunath/Cocos2D-iPhone/tarball/Gorillas-100" ),
                                                               //
                                                               new Dependency( "iLibs", "http://github.com/lhunath/iLibs",
                                                                               "http://github.com/lhunath/iLibs/downloads" ) ), //
                                             new Date( 1231931604L * 1000 ), "Hu4Y8eJLqkI", //
                                             "Eye candy worthy of your iPhone / iPod touch", //
                                             "Wind and weather effects, such as rain and snow", //
                                             "A range of excellent retro remixes", //
                                             "Challenge the AI or a friend", //
                                             "Dynamically adjusted or configurable difficulty", //
                                             "Pick from several different cities / worlds", //
                                             "Fully Open Source" //
        ) );

        AppVersion.register( new AppVersion( gorillas, "110", "1.1", //
                                             null, //
                                             description, //
                                             ImmutableList.of( //
                                                               new Dependency( "Cocos2d-iPhone",
                                                                               "http://github.com/lhunath/Cocos2D-iPhone/tree/Gorillas-110",
                                                                               "http://github.com/lhunath/Cocos2D-iPhone/tarball/Gorillas-110" ),
                                                               //
                                                               new Dependency( "iLibs", "http://github.com/lhunath/iLibs",
                                                                               "http://github.com/lhunath/iLibs/downloads" ) ), //
                                             new Date( 1236986395L * 1000 ), "kOd6fI2Cm7c", //
                                             "Sound effects, vibration and shaking", //
                                             "Game modes: Dynamic, Team Game & Last Man Standing", //
                                             "Camera action and game field zooming", //
                                             "Many gorillas together in the game", //
                                             "Throwing, cheering and dancing animations", //
                                             "Kill shot replays" //
        ) );

        AppVersion.register( new AppVersion( gorillas, "122", "1.2", //
                                             null, //
                                             description, //
                                             ImmutableList.of( //
                                                               new Dependency( "Cocos2d-iPhone",
                                                                               "http://github.com/lhunath/Cocos2D-iPhone/tree/Gorillas-122",
                                                                               "http://github.com/lhunath/Cocos2D-iPhone/tarball/Gorillas-122" ),
                                                               //
                                                               new Dependency( "iLibs", "http://github.com/lhunath/iLibs",
                                                                               "http://github.com/lhunath/iLibs/downloads" ) ), //
                                             new Date( 1240302082L * 1000 ), "kOd6fI2Cm7c", //
                                             "Holiday themed player models" //
        ) );

        AppVersion.register( new AppVersion( gorillas, "131", "1.3", //
                                             null, //
                                             description, //
                                             ImmutableList.of( //
                                                               new Dependency( "Cocos2d-iPhone",
                                                                               "http://github.com/lhunath/Cocos2D-iPhone/tree/Gorillas-131",
                                                                               "http://github.com/lhunath/Cocos2D-iPhone/tarball/Gorillas-131" ),
                                                               //
                                                               new Dependency( "iLibs", "http://github.com/lhunath/iLibs",
                                                                               "http://github.com/lhunath/iLibs/downloads" ) ), //
                                             new Date( 1247060791L * 1000 ), "Q-s8bimr1GY", //
                                             "Show metrics while aiming", //
                                             "Added another player model", //
                                             "Voice effects and new (higher quality) audio tracks", //
                                             "Localized (currently English, Dutch and Arabic)", //
                                             "Auto-zoom when aiming at the very top of the screen" //
        ) );
    }
}
