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

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;


/**
 * <h2>{@link GorillasVersion}<br>
 * <sub>[in short] (TODO).</sub></h2>
 * 
 * <p>
 * [description / usage].
 * </p>
 * 
 * <p>
 * <i>Jun 2, 2009</i>
 * </p>
 * 
 * @author lhunath
 */
public class GorillasVersion implements Serializable, Comparable<GorillasVersion> {

    private static final SortedMap<String, GorillasVersion> versions = new TreeMap<String, GorillasVersion>();

    private String                                          fullVersion;
    private String                                          shortVersion;
    private Date                                            completionDate;
    private String                                          youTubeID;
    private List<String>                                    changes;


    public static List<GorillasVersion> getAll() {

        return Collections.unmodifiableList( new ArrayList<GorillasVersion>( versions.values() ) );
    }

    public static GorillasVersion getLatest() {

        return versions.get( versions.lastKey() );
    }

    public static void register(GorillasVersion gorillasVersion) {

        versions.put( gorillasVersion.getFullVersion(), gorillasVersion );
    }

    public GorillasVersion(String fullVersion, String shortVersion, Date completionDate, String youTubeID,
            String... changes) {

        this.fullVersion = fullVersion;
        this.shortVersion = shortVersion;
        this.completionDate = completionDate;
        this.youTubeID = youTubeID;
        this.changes = new LinkedList<String>( Arrays.asList( changes ) );
    }

    /**
     * @return The URI at which this version's screenshot can be found.
     */
    public String getScreenShotLink() {

        return String.format( "images/game/gorillas-%s.png", //
                              getFullVersion() );
    }

    /**
     * @return The URI at which this version's YouTube video can be found.
     */
    public String getYouTubeLink() {

        return String.format( "http://www.youtube.com/watch?v=%s", //
                              getYouTubeID() );
    }

    /**
     * @return The JS code to trigger a page tracker hit for the YouTube movie of this version.
     */
    public String getYouTubePageTrackCode() {

        return String.format( "pageTracker._trackPageview('/movie/gorillas-%s.yt');", //
                              getFullVersion() );
    }

    /**
     * @return The URI at which this version's FLV video can be found.
     */
    public String getFLVLink() {

        return String.format( "movies/gorillas-%s.flv", //
                              getFullVersion() );
    }

    /**
     * @return The JS code to trigger a page tracker hit for the FLV movie of this version.
     */
    public String getFLVPageTrackCode() {

        return String.format( "pageTracker._trackPageview('/movie/gorillas-%s.flv');", //
                              getFullVersion() );
    }

    /**
     * @return The URI at which this version's MP4 video can be found.
     */
    public String getMP4Link() {

        return String.format( "movies/gorillas-%s.mp4", //
                              getFullVersion() );
    }

    /**
     * @return The JS code to trigger a page tracker hit for the MP4 movie of this version.
     */
    public String getMP4PageTrackCode() {

        return String.format( "pageTracker._trackPageview('/movie/gorillas-%s.mp4');", //
                              getFullVersion() );
    }

    /**
     * @return The detailed version string.
     */
    public String getFullVersion() {

        return fullVersion;
    }

    /**
     * @return The user-friendly version string.
     */
    public String getShortVersion() {

        return shortVersion;
    }

    /**
     * @return The date when this version was completed and committed into the code repository.
     */
    public Date getCompletionDate() {

        return completionDate;
    }

    /**
     * @return The youTubeID that references a YouTube movie that demos this version
     */
    public String getYouTubeID() {

        return youTubeID;
    }

    /**
     * @return The list of changes introduced by this version since the last.
     */
    public List<String> getChanges() {

        return changes;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {

        return String.format( "{%s - %s, [yt: %s]}", shortVersion, fullVersion, youTubeID );
    }

    /**
     * Sorts by {@link #getFullVersion()}.
     * 
     * {@inheritDoc}
     */
    public int compareTo(GorillasVersion o) {

        return getFullVersion().compareTo( o.getFullVersion() );
    }
}
