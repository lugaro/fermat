package com.bitdubai.android_core.app;


import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.bitdubai.android_core.app.common.version_1.sessions.SubAppSessionManager;
import com.bitdubai.android_core.app.common.version_1.sessions.WalletSessionManager;
import com.bitdubai.fermat_android_api.engine.FermatApplicationSession;
import com.bitdubai.fermat_android_api.engine.FermatFragmentFactory;
import com.bitdubai.fermat_api.AndroidCoreManager;
import com.bitdubai.fermat_api.layer.osa_android.broadcaster.AndroidCoreUtils;
import com.bitdubai.fermat_core.FermatSystem;
import java.io.Serializable;
import java.util.HashMap;

/**
 * Reformated by Matias Furszyfer
 */

/**
 * This class, is created by the Android OS before any Activity. That means its constructor is run before any other code
 * written by ourselves.
 *
 * -- Luis.
 */


public class ApplicationSession extends MultiDexApplication implements Serializable,FermatApplicationSession {

    /**
     * Application states
     */
    public static final int STATE_NOT_CREATED=0;
    public static final int STATE_STARTED=1;
    public static final int STATE_STARTED_DESKTOP=2;

    /**
     *  Fermat platform
     */

    private FermatSystem fermatSystem;

    /**
     * Sub App session Manager
     */

    private SubAppSessionManager subAppSessionManager;

    /**
     * Wallet session manager
     */

    private WalletSessionManager walletSessionManager;

    /**
     *  Application state
     */
    public static int applicationState=STATE_NOT_CREATED;

    /**
     *  SubApps fragment factories
     */
    private HashMap<String,FermatFragmentFactory> subAppsFragmentfFactories;




    /**
     *  Application session constructor
     */

    public ApplicationSession() {
        super();

        fermatSystem = FermatSystem.getInstance();
        subAppSessionManager=new SubAppSessionManager();
        walletSessionManager = new WalletSessionManager();

    }


    /**
     *  Method to get the fermat system
     * @return FermatSystem
     */
    public FermatSystem getFermatSystem() {
        return fermatSystem;
    }

    /**
     * Method to get subAppSessionManager which can manipulate the active session of subApps
     * @return SubAppSessionManager
     */

    public SubAppSessionManager getSubAppSessionManager(){
        return subAppSessionManager;
    }

    /**
     * Method to get subWalletSessionManager which can manipulate the active session of wallets
     * @return WalletSessionManager
     */

    public WalletSessionManager getWalletSessionManager(){
        return walletSessionManager;
    }

    /**
     *  Method to change the application state from services or activities
     *
     * @param applicationState  is an application state constant from ApplicationSession class
     */

    public void changeApplicationState(int applicationState){
        this.applicationState=applicationState;
    }

    /**
     * Method to get the application state from services or activities
     *
     * @return application state constant from ApplicationSession class
     */

    public int getApplicationState(){
        return applicationState;
    }

    /**
     *  Add supApp fragment factory
     */
    public void addSubAppFragmentFactory(String subAppType,FermatFragmentFactory fermatSubAppFragmentFactory){
        subAppsFragmentfFactories.put(subAppType,fermatSubAppFragmentFactory);
    }

    @Override
    public void onTerminate(){
        super.onTerminate();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        MultiDex.install(this);
    }


}