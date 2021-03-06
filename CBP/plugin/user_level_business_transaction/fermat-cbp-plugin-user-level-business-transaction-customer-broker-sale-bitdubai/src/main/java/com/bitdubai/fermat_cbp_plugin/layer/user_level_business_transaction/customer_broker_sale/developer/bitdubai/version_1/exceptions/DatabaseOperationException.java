package com.bitdubai.fermat_cbp_plugin.layer.user_level_business_transaction.customer_broker_sale.developer.bitdubai.version_1.exceptions;

import com.bitdubai.fermat_api.FermatException;

/**
 * Created by franklin on 17/11/15.
 */
public class DatabaseOperationException extends FermatException {
    public static final String DEFAULT_MESSAGE = "There was an error trying to execute a database operation.";

    public DatabaseOperationException(String message, Exception cause, String context, String possibleReason) {
        super(message, cause, context, possibleReason);
    }
}