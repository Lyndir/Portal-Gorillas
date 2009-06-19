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

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.KeyStore.Builder;
import java.security.cert.PKIXParameters;

import javax.net.ssl.CertPathTrustManagerParameters;
import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.KeyStoreBuilderParameters;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;


/**
 * <h2>{@link APNClient}<br>
 * <sub>[in short] (TODO).</sub></h2>
 * 
 * <p>
 * [description / usage].
 * </p>
 * 
 * <p>
 * <i>Jun 18, 2009</i>
 * </p>
 * 
 * @author lhunath
 */
public class APNClient implements Runnable {

    private static final String KEYSTORE_FILE = "ssl/keystore.js";
    private static final String KEYSTORE_PASS = "467e4182520aac";
    private static final String PRIV_KEY_PASS = "2f2921c064bfd9";
    private static final String KEYSTORE_TYPE = "JKS";

    private static final String APNS_PROTOCOL = "TLS";
    private static final String APNS_HOSTNAME = "gateway.sandbox.push.apple.com";
    private static final int    APNS_TCP_PORT = 2195;


    public static void main(String[] args)
            throws Exception {

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        KeyStore keyStore = KeyStore.getInstance( KEYSTORE_TYPE );
        keyStore.load( classLoader.getResourceAsStream( KEYSTORE_FILE ), KEYSTORE_PASS.toCharArray() );

        new APNClient( keyStore, PRIV_KEY_PASS, APNS_HOSTNAME, APNS_TCP_PORT ).run();
    }


    private SSLEngine engine;


    /**
     * Create a new {@link APNClient} instance by setting up the PKIX identity and trust to reasonable defaults from the
     * given parameters.
     * 
     * @param keyStore
     *            The keystore which provides all required SSL keys and certificates.
     * @param privateKeyPassword
     *            The password which protects the required <code>keyStore</code>'s private key.
     * @param host
     *            The hostname of the Apple Push Notification server (APNs).
     * @param port
     *            The port on which the Apple Push Notification server (APNs) listens.
     * 
     * @throws NoSuchAlgorithmException
     *             The <code>keyStore</code> provider does not support the necessary algorithms.
     * @throws InvalidAlgorithmParameterException
     *             The private key algorithm could not be understood.
     * @throws KeyManagementException
     *             The SSL context could not be initialized from the provided private keys.
     * @throws KeyStoreException
     *             The <code>keyStore</code> has not been properly initialized.
     */
    public APNClient(KeyStore keyStore, String privateKeyPassword, String host, int port)
            throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, KeyManagementException,
            KeyStoreException {

        this( keyStore.getProvider(), host, port, createKeyManagerFactory( keyStore, privateKeyPassword ),
              createTrustManagerFactory( keyStore ) );
    }

    /**
     * Create a new {@link APNClient} instance using a custom configured {@link KeyManagerFactory} and
     * {@link TrustManagerFactory} to provide PKIX identity and trust.
     * 
     * @param sslProvider
     *            The {@link Provider} which provides the Java Security services.
     * @param host
     *            The hostname of the Apple Push Notification server (APNs).
     * @param port
     *            The port on which the Apple Push Notification server (APNs) listens.
     * @param trustManagerFactory
     *            The factory that will create the SSL context's {@link TrustManager}s.
     * @param keyManagerFactory
     *            The factory that will create the SSL context's {@link KeyManager}s.
     * 
     * @throws NoSuchAlgorithmException
     *             The <code>keyStore</code> provider does not support the necessary algorithms.
     * @throws InvalidAlgorithmParameterException
     *             The private key algorithm could not be understood.
     * @throws KeyManagementException
     *             The SSL context could not be initialized from the provided private keys.
     * @throws KeyStoreException
     *             The <code>keyStore</code> has not been properly initialized.
     */
    public APNClient(Provider sslProvider, String host, int port, KeyManagerFactory keyManagerFactory,
            TrustManagerFactory trustManagerFactory)
            throws NoSuchAlgorithmException, KeyManagementException {

        // Set up an SSL context from identity and trust configurations.
        SSLContext sslContext = SSLContext.getInstance( APNS_PROTOCOL, sslProvider );
        sslContext.init( keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null );

        engine = sslContext.createSSLEngine( host, port );
        engine.setUseClientMode( true );
    }

    /**
     * Create a new {@link APNClient} instance using a custom configured {@link SSLEngine}.
     * 
     * @param engine
     *            The fully configured SSL engine set up to provide the whole SSL negotiation logic.
     */
    public APNClient(SSLEngine engine) {

        this.engine = engine;
    }

    /**
     * Creates the factory for {@link KeyManager}s which provide the client identity.
     * 
     * <p>
     * Uses private key entries in the given <code>keyStore</code> and unlocks them with the given
     * <code>privateKeyPassword</code>.
     * </p>
     * 
     * @param keyStore
     *            The {@link KeyStore} that provides the private key(s).
     * @param privateKeyPassword
     *            The password that protects the private key data.
     * 
     * @return A {@link KeyManagerFactory}.
     * 
     * @throws NoSuchAlgorithmException
     * @throws InvalidAlgorithmParameterException
     */
    protected static KeyManagerFactory createKeyManagerFactory(KeyStore keyStore, String privateKeyPassword)
            throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {

        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance( KeyManagerFactory.getDefaultAlgorithm(),
                                                                             keyStore.getProvider() );
        keyManagerFactory.init( new KeyStoreBuilderParameters(
                Builder.newInstance( keyStore, new KeyStore.PasswordProtection( privateKeyPassword.toCharArray() ) ) ) );
        return keyManagerFactory;
    }

    /**
     * Creates the factory for {@link TrustManager}s.
     * 
     * <p>
     * The factory will provide simple trust for each trusted certificate in the given <code>keyStore</code>.<br>
     * No additional optional PKIX validation is performed on the trust path.
     * </p>
     * 
     * @param keyStore
     *            The {@link KeyStore} that provides the certificates of the trusted Certificate Authorities.
     * 
     * @return A {@link TrustManagerFactory}.
     * 
     * @throws NoSuchAlgorithmException
     * @throws KeyStoreException
     * @throws InvalidAlgorithmParameterException
     */
    protected static TrustManagerFactory createTrustManagerFactory(KeyStore keyStore)
            throws NoSuchAlgorithmException, KeyStoreException, InvalidAlgorithmParameterException {

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(
                                                                                   TrustManagerFactory.getDefaultAlgorithm(),
                                                                                   keyStore.getProvider() );
        PKIXParameters pkixParameters = new PKIXParameters( keyStore );
        trustManagerFactory.init( new CertPathTrustManagerParameters( pkixParameters ) );
        return trustManagerFactory;
    }

}
