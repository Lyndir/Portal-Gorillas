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

/**
 * <h2>{@link GorilasVersion}<br>
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
public class GorilasVersion {

    private String fullVersion;
    private String shortVersion;
    private String youTubeID;


    /**
     * Create a new {@link GorilasVersion} instance.
     */
    public GorilasVersion(String fullVersion, String shortVersion, String youTubeID) {

        this.fullVersion = fullVersion;
        this.shortVersion = shortVersion;
    }

    /**
     * @return The fullVersion of this {@link GorilasVersion}.
     */
    public String getFullVersion() {

        return fullVersion;
    }

    /**
     * @return The shortVersion of this {@link GorilasVersion}.
     */
    public String getShortVersion() {

        return shortVersion;
    }

    /**
     * @return The youTubeID of this {@link GorilasVersion}.
     */
    public String getYouTubeID() {

        return youTubeID;
    }
}
