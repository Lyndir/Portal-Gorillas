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
package com.lyndir.lhunath.gorillas.web.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.util.JSONBuilder;

import com.lyndir.lhunath.gorillas.model.GorillasLeague;
import com.lyndir.lhunath.gorillas.model.GorillasPlayer;
import com.lyndir.lhunath.lib.system.logging.Logger;


/**
 * <h2>{@link LeagueRegistration}<br>
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
public class LeagueRegistration extends HttpServlet {

    private static final String PAT_NAME     = "^\\p{Alpha}{2,}$";

    private static final String PAT_UDID     = "^\\p{XDigit}{40}$";

    private static final Logger logger       = Logger.get( LeagueRegistration.class );

    private static final String REQ_OP       = "op";

    private static final String OP_REG       = "register";
    private static final String REQ_REG_NAME = "name";
    private static final String REQ_REG_UDID = "udid";

    private GorillasLeague      league;


    /**
     * {@inheritDoc}
     */
    @Override
    public void init()
            throws ServletException {

        league = GorillasLeague.getLeague();

        super.init();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        handle( req, resp );
    }

    private void handle(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {

        // Response must be UTF-8
        resp.setContentType( "text/plain; UTF-8" );
        boolean success = false;

        try {
            String name = req.getParameter( REQ_REG_NAME );
            String udid = req.getParameter( REQ_REG_UDID );

            if (name == null || !name.matches( PAT_NAME )) {
                logger.wrn( "Received a registration request with invalid name ('%s') from '%s' at: %s", //
                            name, req.getRemoteHost(), req.getRequestURI() );
                return;
            }
            if (udid == null || !udid.matches( PAT_UDID )) {
                logger.wrn( "Received a registration request with invalid UDID ('%s') from '%s' at: %s", //
                            udid, req.getRemoteHost(), req.getRequestURI() );
                return;
            }

            GorillasPlayer player = new GorillasPlayer( udid, name );
            league.register( player );

            success = true;
        }

        finally {
            // Write response
            new JSONBuilder( resp.getWriter() ).key( "success" ).value( success );
            resp.flushBuffer();
        }
    }
}
