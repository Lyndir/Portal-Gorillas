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
package com.lyndir.lhunath.gorillas.web.apn;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;

import com.lyndir.lhunath.lib.system.logging.Logger;


/**
 * <h2>{@link GorillasAPNs}<br>
 * <sub>[in short] (TODO).</sub></h2>
 * 
 * <p>
 * [description / usage].
 * </p>
 * 
 * <p>
 * <i>Jun 19, 2009</i>
 * </p>
 * 
 * @author lhunath
 */
public class GorillasAPNs {

    private static final Logger logger        = Logger.get( GorillasAPNs.class );

    private static final String KEYSTORE_FILE = "ssl/Gorillas APNs Dev.jks";
    private static final String KEYSTORE_PASS = "467e4182520aac";
    private static final String PRIV_KEY_PASS = "2f2921c064bfd9";
    private static final String KEYSTORE_TYPE = "JKS";

    private static final byte[] TEST_TOKEN    = new byte[] { '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?',
            '?', '?', '?', '?', '?', '?', '?', '?', '?', '?', '?' /* TODO: Add Device Token (32 bytes) */};

    private APNClient           apnClient;


    public GorillasAPNs()
            throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException,
            KeyManagementException, UnrecoverableKeyException {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        KeyStore keyStore = KeyStore.getInstance( KEYSTORE_TYPE );
        keyStore.load( classLoader.getResourceAsStream( KEYSTORE_FILE ), KEYSTORE_PASS.toCharArray() );

        apnClient = new APNClient( keyStore, PRIV_KEY_PASS );
    }

    private void send()
            throws IOException {

        NotificationPayLoad payLoad = NotificationPayLoad.createSimpleAlert( "Hello World!" );
        apnClient.queueNotification( new NotificationDevice( TEST_TOKEN ), payLoad );

        apnClient.sendQueuedNotifications();
    }

    public static void main(String[] args)
            throws Exception {

        new GorillasAPNs().send();
    }
}
