package com.bitdubai.wallet_platform_core.layer._10_network_service.bank_notes;

import com.bitdubai.wallet_platform_api.Plugin;
import com.bitdubai.wallet_platform_api.layer._10_network_service.CantStartSubsystemException;
import com.bitdubai.wallet_platform_api.layer._10_network_service.NetworkSubsystem;
import com.bitdubai.wallet_platform_core.layer._10_network_service.bank_notes.developer.bitdubai.DeveloperBitDubai;

/**
 * Created by loui on 17/02/15.
 */
public class BankNotesSubsystem implements NetworkSubsystem {

    Plugin plugin;

    @Override
    public Plugin getPlugin() {
        return plugin;
    }

    @Override
    public void start() throws CantStartSubsystemException {
        /**
         * I will choose from the different Developers available which implementation to use. Right now there is only
         * one, so it is not difficult to choose.
         */

        try {
            DeveloperBitDubai developerBitDubai = new DeveloperBitDubai();
            plugin = developerBitDubai.getPlugin();
        }
        catch (Exception e)
        {
            System.err.println("Exception: " + e.getMessage());
            throw new CantStartSubsystemException();
        }
    }

}
