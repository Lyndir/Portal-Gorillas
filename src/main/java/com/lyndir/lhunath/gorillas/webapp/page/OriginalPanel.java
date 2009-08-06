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

import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.util.template.PackagedTextTemplate;

import com.lyndir.lhunath.gorillas.webapp.JavaScriptProvider;


/**
 * <h2>{@link OriginalPanel}<br>
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
public class OriginalPanel extends Panel implements JavaScriptProvider {

    /**
     * @param id
     *            The Wicket ID of this panel.
     */
    public OriginalPanel(String id) {

        super( id );
    }

    /**
     * {@inheritDoc}
     */
    public String getProvidedJavaScript() {

        return new PackagedTextTemplate( getClass(), "showGame.js" ).asString();
    }
}
