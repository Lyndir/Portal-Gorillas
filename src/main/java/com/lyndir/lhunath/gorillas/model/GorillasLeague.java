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
package com.lyndir.lhunath.gorillas.model;

import java.util.SortedSet;
import java.util.TreeSet;

import com.lyndir.lhunath.lib.system.logging.Logger;


/**
 * <h2>{@link GorillasLeague}<br>
 * <sub>[in short] (TODO).</sub></h2>
 *
 * <p>
 * [description / usage].
 * </p>
 *
 * <p>
 * <i>Jun 17, 2009</i>
 * </p>
 *
 * @author lhunath
 */
public class GorillasLeague {

    private static final Logger logger = Logger.get( GorillasLeague.class );

    private static GorillasLeague instance;
    private SortedSet<GorillasPlayer> players;


    public static GorillasLeague getLeague() {

        if (instance == null)
            instance = new GorillasLeague();

        return instance;
    }

    private GorillasLeague() {

        players = new TreeSet<GorillasPlayer>();
    }

    public void register(GorillasPlayer newPlayer) {

        if (newPlayer == null) {
            logger.wrn( "Tried to register a null player in league: %s", this );
            return;
        }

        for (GorillasPlayer player : players)
            if (player.getName().equalsIgnoreCase( newPlayer.getName() ))
                logger.wrn( "Tried to register a new player with a name ('%s') that's already taken.",
                            newPlayer.getName() ).toError();

        players.add( newPlayer );
    }

    public GorillasPlayer leader() {

        return players.last();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        return String.format( "{lg: %s, lead:%s}", leader() );
    }
}
