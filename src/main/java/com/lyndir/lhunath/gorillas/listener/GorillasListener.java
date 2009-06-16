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
package com.lyndir.lhunath.gorillas.listener;

import java.util.Date;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.lyndir.lhunath.gorillas.model.GorillasVersion;


/**
 * <h2>{@link GorillasListener}<br>
 * <sub>[in short] (TODO).</sub></h2>
 * 
 * <p>
 * [description / usage].
 * </p>
 * 
 * <p>
 * <i>Jun 12, 2009</i>
 * </p>
 * 
 * @author lhunath
 */
public class GorillasListener implements ServletContextListener {

    /**
     * {@inheritDoc}
     */
    public void contextInitialized(ServletContextEvent sce) {

        GorillasVersion.register( new GorillasVersion( "100", "1.0", new Date( 1231931604L * 1000 ), "Hu4Y8eJLqkI",
                "Eye candy worthy of your iPhone / iPod touch", "Wind and weather effects, such as rain and snow",
                "A range of excellent retro remixes", "Challenge the AI or a friend",
                "Dynamically adjusted or configurable difficulty", "Pick from several different cities / worlds",
                "Fully Open Source (GPLv2)" ) );
        GorillasVersion.register( new GorillasVersion( "110", "1.1", new Date( 1236986395L * 1000 ), "kOd6fI2Cm7c",
                "Sound effects, vibration and shaking", "Game modes: Dynamic, Team Game & Last Man Standing",
                "Camera action and game field zooming", "Many gorillas together in the game",
                "Throwing, cheering and dancing animations", "Kill shot replays" ) );
        GorillasVersion.register( new GorillasVersion( "122", "1.2", new Date( 1240302082L * 1000 ), "kOd6fI2Cm7c",
                "Holiday themed player models" ) );
    }

    /**
     * {@inheritDoc}
     */
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
