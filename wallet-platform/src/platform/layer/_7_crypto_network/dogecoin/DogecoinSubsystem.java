package platform.layer._7_crypto_network.dogecoin;

import platform.layer._7_crypto_network.CantStartSubsystemException;
import platform.layer._7_crypto_network.CryptoNetworkService;
import platform.layer._7_crypto_network.CryptoNetworkSubsystem;

/**
 * Created by ciencias on 30.12.14.
 */
public class DogecoinSubsystem implements CryptoNetworkSubsystem {
    @Override
    public void start() throws CantStartSubsystemException {
        throw new CantStartSubsystemException();
    }

    @Override
    public CryptoNetworkService getCryptoNetwork() {
        return null;
    }
}
