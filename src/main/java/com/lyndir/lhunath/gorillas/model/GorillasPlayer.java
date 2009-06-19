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

import java.util.Date;
import java.util.HashMap;

import com.lyndir.lhunath.lib.system.logging.Logger;


/**
 * <h2>{@link GorillasPlayer}<br>
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
public class GorillasPlayer implements Comparable<GorillasPlayer> {

    private static final Logger    logger = Logger.get( GorillasPlayer.class );

    private String                 udid;
    private String                 name;

    private int                    topScore;
    private HashMap<Date, Integer> scoreHistory;


    public GorillasPlayer(String udid, String name) {

        this.udid = udid;
        this.name = name;
    }

    public void addScore(Date scoreDate, int score) {

        if (scoreDate == null) {
            logger.wrn( "Tried to add score (%s) with a null date to: %s", score, this );
            return;
        }

        if (!scoreHistory.containsKey( scoreDate ))
            scoreHistory.put( scoreDate, score );

        if (score > topScore)
            topScore = score;
    }

    /**
     * @return The name of this {@link GorillasPlayer}.
     */
    public String getName() {

        return name;
    }

    /**
     * @return The device UDID of this {@link GorillasPlayer}.
     */
    public String getUdid() {

        return udid;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        return String.format( "{pl: %s, %s, score: %d}", name, udid, topScore );
    }

    /**
     * {@inheritDoc}
     */
    public int compareTo(GorillasPlayer o) {

        return topScore - o.topScore;
    }
}
