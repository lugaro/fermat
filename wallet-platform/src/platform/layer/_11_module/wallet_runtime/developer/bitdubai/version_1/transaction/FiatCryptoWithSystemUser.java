package platform.layer._11_module.wallet_runtime.developer.bitdubai.version_1.transaction;

import platform.layer._1_definition.money.CryptoMoney;
import platform.layer._1_definition.money.FiatMoney;
import platform.layer._11_module.wallet_runtime.developer.bitdubai.version_1.account.Account;

/**
 * Created by ciencias on 22.12.14.
 */
public class FiatCryptoWithSystemUser implements TransactionWithSystemUser, FiatCryptoTransaction {

    private Account mAccount;

    private FiatMoney mFiatMoney;
    private CryptoMoney mCryptoMoney;


}
