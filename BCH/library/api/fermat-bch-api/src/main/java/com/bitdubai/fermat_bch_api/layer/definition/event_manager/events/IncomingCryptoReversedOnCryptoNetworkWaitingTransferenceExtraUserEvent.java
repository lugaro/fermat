package com.bitdubai.fermat_bch_api.layer.definition.event_manager.events;

import com.bitdubai.fermat_bch_api.layer.definition.event_manager.enums.EventType;

/**
 * Created by rodrigo on 2015.07.08..
 */
public class IncomingCryptoReversedOnCryptoNetworkWaitingTransferenceExtraUserEvent extends AbstractFermatCryptoEvent {

    public IncomingCryptoReversedOnCryptoNetworkWaitingTransferenceExtraUserEvent(){
        super(EventType.INCOMING_CRYPTO_REVERSED_ON_CRYPTO_NETWORK_WAITING_TRANSFERENCE_EXTRA_USER);
    }
}
