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

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.settings.IExceptionSettings;

import com.lyndir.lhunath.gorillas.webapp.error.AccessDeniedErrorPage;
import com.lyndir.lhunath.gorillas.webapp.error.InternalErrorPage;
import com.lyndir.lhunath.gorillas.webapp.error.PageExpiredErrorPage;
import com.lyndir.lhunath.gorillas.webapp.page.LayoutPage;


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
public class GorillasWebApplication extends WebApplication {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void init() {

        getApplicationSettings().setPageExpiredErrorPage( PageExpiredErrorPage.class );
        getApplicationSettings().setAccessDeniedPage( AccessDeniedErrorPage.class );
        getApplicationSettings().setInternalErrorPage( InternalErrorPage.class );

        getExceptionSettings().setUnexpectedExceptionDisplay( IExceptionSettings.SHOW_INTERNAL_ERROR_PAGE );
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Class<? extends Page> getHomePage() {

        return LayoutPage.class;
    }
}
