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
package com.lyndir.lhunath.gorillas.webapp;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.string.StringValue;

import com.lyndir.lhunath.gorillas.model.GorilasVersion;


/**
 * <h2>{@link DemoPanel}<br>
 * <sub>[in short] (TODO).</sub></h2>
 * 
 * <p>
 * [description / usage].
 * </p>
 * 
 * <p>
 * <i>May 31, 2009</i>
 * </p>
 * 
 * @author lhunath
 */
public class DemoPanel extends Panel {

    protected GorilasVersion version = new GorilasVersion( "120", "1.2", "kOd6fI2Cm7c" );


    /**
     * @param id
     *            The Wicket ID of this panel.
     */
    public DemoPanel(String id) {

        super( id );

        WebMarkupContainer preview = new WebMarkupContainer( "preview" ) {

            @Override
            protected void onComponentTag(ComponentTag tag) {

                tag.put( "style", //
                         StringValue.valueOf( String.format( "background-image: url('%s/images/gorillas_phone.png')", //
                                                             version.getFullVersion() ) ) );
                super.onComponentTag( tag );
            }
        };

        preview.add( new WebMarkupContainer( "youtube" ) {

            @Override
            protected void onComponentTag(ComponentTag tag) {

                tag.put( "href", //
                         StringValue.valueOf( String.format( "http://www.youtube.com/watch?v=%s", //
                                                             version.getYouTubeID() ) ) );
                tag.put( "onclick", //
                         StringValue.valueOf( String.format( "pageTracker._trackPageview('/movie/youtube-%s');", //
                                                             version.getShortVersion() ) ) );
                super.onComponentTag( tag );
            }
        } );
        preview.add( new WebMarkupContainer( "iphone-youtube" ) {

            @Override
            protected void onComponentTag(ComponentTag tag) {

                tag.put( "href", //
                         StringValue.valueOf( String.format( "http://www.youtube.com/watch?v=%s", //
                                                             version.getYouTubeID() ) ) );
                tag.put( "onclick", //
                         StringValue.valueOf( String.format( "pageTracker._trackPageview('/movie/youtube-%s');", //
                                                             version.getShortVersion() ) ) );
                super.onComponentTag( tag );
            }
        } );
        preview.add( new WebMarkupContainer( "mpeg" ) {

            @Override
            protected void onComponentTag(ComponentTag tag) {

                tag.put( "href", //
                         StringValue.valueOf( String.format( "%s/movies/gorillas.mp4", //
                                                             version.getShortVersion() ) ) );
                tag.put( "onclick", //
                         StringValue.valueOf( String.format( "pageTracker._trackPageview('/movie/gorillas-%s.mp4');", //
                                                             version.getShortVersion() ) ) );
                super.onComponentTag( tag );
            }
        } );

        add( preview );
    }
}
