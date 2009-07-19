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
package com.lyndir.lhunath.gorillas.web.app.page;

import java.text.DateFormat;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.Panel;

import com.lyndir.lhunath.gorillas.model.GorillasVersion;


/**
 * <h2>{@link ArchivePanel}<br>
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
public class ArchivePanel extends Panel {

    /**
     * @param id
     *            The Wicket ID of this panel.
     */
    public ArchivePanel(String id) {

        super( id );

        List<GorillasVersion> versions = new LinkedList<GorillasVersion>( GorillasVersion.getAll() );
        Collections.reverse( versions );

        ListView<GorillasVersion> entries = new ListView<GorillasVersion>( "entries", versions ) {

            @Override
            protected void populateItem(ListItem<GorillasVersion> entryItem) {

                final GorillasVersion version = entryItem.getModelObject();

                entryItem.add( new Label( "version", version.getShortVersion() ) );
                entryItem.add( new Label( "date",
                        DateFormat.getDateInstance( DateFormat.LONG, getLocale() ).format( version.getCompletionDate() ) ) );

                entryItem.add( new WebMarkupContainer( "screenshot" ) {

                    @Override
                    protected void onComponentTag(ComponentTag tag) {

                        tag.put( "src", //
                                 version.getScreenShotLink() );

                        super.onComponentTag( tag );
                    }
                } );
                entryItem.add( new WebMarkupContainer( "youtube" ) {

                    @Override
                    protected void onComponentTag(ComponentTag tag) {

                        tag.put( "href", //
                                 version.getYouTubeLink() );
                        tag.put( "onclick", //
                                 version.getYouTubePageTrackCode() );

                        super.onComponentTag( tag );
                    }
                } );
                entryItem.add( new WebMarkupContainer( "flash" ) {

                    @Override
                    protected void onComponentTag(ComponentTag tag) {

                        tag.put( "href", //
                                 version.getFLVLink() );
                        tag.put( "onclick", //
                                 version.getFLVPageTrackCode() );

                        super.onComponentTag( tag );
                    }
                } );
                entryItem.add( new WebMarkupContainer( "mpeg" ) {

                    @Override
                    protected void onComponentTag(ComponentTag tag) {

                        tag.put( "href", //
                                 version.getMP4Link() );
                        tag.put( "onclick", //
                                 version.getMP4PageTrackCode() );

                        super.onComponentTag( tag );
                    }

                } );

                entryItem.add( new ListView<String>( "changes", version.getChanges() ) {

                    @Override
                    protected void populateItem(ListItem<String> changesItem) {

                        changesItem.add( new Label( "description", changesItem.getModelObject() ) );
                    }
                } );

                entryItem.add( new WebMarkupContainer( "source" ) {

                    @Override
                    protected void onComponentTag(ComponentTag tag) {

                        tag.put( "href", //
                                 String.format( "http://github.com/lhunath/Gorillas/tree/%s", //
                                                version.getFullVersion() ) );

                        super.onComponentTag( tag );
                    }
                } );

                entryItem.add( new ListView<String>( "dependencies", new LinkedList<String>(
                        version.getDependencies().keySet() ) ) {

                    @Override
                    protected void populateItem(ListItem<String> item) {

                        final String dependencyName = item.getModelObject();
                        final String dependencySnapshot = version.getDependencies().get( dependencyName );

                        WebMarkupContainer linkComponent = new WebMarkupContainer( "link" ) {

                            @Override
                            protected void onComponentTag(ComponentTag tag) {

                                tag.put( "href", //
                                         String.format( "snapshots/%s", //
                                                        dependencySnapshot ) );

                                super.onComponentTag( tag );
                            }
                        };

                        linkComponent.add( new Label( "name", dependencyName ) );
                        item.add( linkComponent );
                    }
                } );
            }
        };

        add( entries );
    }
}
