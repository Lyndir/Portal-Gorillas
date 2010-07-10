package com.lyndir.lhunath.gorillas.webapp;

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

import com.lyndir.lhunath.apps.webapp.AppsSession;
import com.lyndir.lhunath.apps.webapp.AppsWebApplication;
import org.apache.wicket.Request;
import org.apache.wicket.Response;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;


/**
 * <h2>{@link GorillasWebApplication}<br>
 * <sub>Wicket {@link WebApplication} for the Gorillas iPhone game.</sub></h2>
 *
 * <p>
 * <i>May 31, 2009</i>
 * </p>
 *
 * @author lhunath
 */
public class GorillasWebApplication extends AppsWebApplication {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void init() {

        super.init();
    }

    @Override
    public Session newSession(final Request request, final Response response) {

        return ((AppsSession) super.newSession( request, response )).setStyleURL( "css/gorillas.css" );
    }
}
