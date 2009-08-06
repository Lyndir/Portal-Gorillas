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
package com.lyndir.lhunath.gorillas.webapp.page;

import java.util.HashMap;
import java.util.Map;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.template.PackagedTextTemplate;

import com.lyndir.lhunath.gorillas.model.GorillasVersion;
import com.lyndir.lhunath.gorillas.webapp.JavaScriptProvider;


/**
 * <h2>{@link DemoPanel}<br>
 * <sub>The interface panel that shows a video demonstration of the game.</sub></h2>
 * 
 * <p>
 * <i>May 31, 2009</i>
 * </p>
 * 
 * @author lhunath
 */
public class DemoPanel extends Panel implements JavaScriptProvider {

    private static final String JS_KEY_MOVIE_LINK     = "movieLink";
    private static final String JS_KEY_PAGETRACK_CODE = "pageTrackCode";


    /**
     * @param id
     *            The Wicket ID of this panel.
     */
    public DemoPanel(String id) {

        super( id );

        add( new Label( "version", GorillasVersion.getLatest().getShortVersion() ) );

        add( new WebMarkupContainer( "youtube" ) {

            @Override
            protected void onComponentTag(ComponentTag tag) {

                tag.put( "href", //
                         GorillasVersion.getLatest().getYouTubeLink() );
                tag.put( "onclick", //
                         GorillasVersion.getLatest().getYouTubePageTrackCode() );

                super.onComponentTag( tag );
            }
        } );
        add( new WebMarkupContainer( "mpeg" ) {

            @Override
            protected void onComponentTag(ComponentTag tag) {

                tag.put( "href", //
                         GorillasVersion.getLatest().getMP4Link() );
                tag.put( "onclick", //
                         GorillasVersion.getLatest().getMP4PageTrackCode() );

                super.onComponentTag( tag );
            }
        } );

        add( new WebMarkupContainer( "iphone-youtube" ) {

            @Override
            protected void onComponentTag(ComponentTag tag) {

                tag.put( "href", //
                         GorillasVersion.getLatest().getYouTubeLink() );
                tag.put( "onclick", //
                         GorillasVersion.getLatest().getYouTubePageTrackCode() );

                super.onComponentTag( tag );
            }
        } );
    }

    /**
     * {@inheritDoc}
     */
    public String getProvidedJavaScript() {

        Map<String, Object> variablesMap = new HashMap<String, Object>();
        variablesMap.put( JS_KEY_MOVIE_LINK, GorillasVersion.getLatest().getFLVLink() );
        variablesMap.put( JS_KEY_PAGETRACK_CODE, GorillasVersion.getLatest().getFLVPageTrackCode() );

        return new PackagedTextTemplate( getClass(), "showMovie.js" ).asString( variablesMap );
    }
}
