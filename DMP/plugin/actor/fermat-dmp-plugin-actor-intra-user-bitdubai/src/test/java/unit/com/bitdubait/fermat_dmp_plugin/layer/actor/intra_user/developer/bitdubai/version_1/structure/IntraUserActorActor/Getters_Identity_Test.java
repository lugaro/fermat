package unit.com.bitdubait.fermat_dmp_plugin.layer.actor.intra_user.developer.bitdubai.version_1.structure.IntraUserActorActor;

import com.bitdubai.fermat_api.layer.dmp_actor.intra_user.enums.ContactState;
import com.bitdubai.fermat_api.layer.dmp_identity.intra_user.exceptions.CantShowProfileImageException;
import com.bitdubai.fermat_api.layer.osa_android.file_system.PluginFileSystem;
import com.bitdubai.fermat_dmp_plugin.layer.actor.intra_user.developer.bitdubai.version_1.structure.IntraUserActorActor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.fest.assertions.api.Assertions.assertThat;

/**
 * Created by natalia on 24/08/15.
 */
public class Getters_Identity_Test {

    IntraUserActorActor intraUserActor;

    String name;
    String publicKey;

    byte[] profileImage;
    long registrationDate;
    ContactState contactState;

    @Mock
    private PluginFileSystem mockPluginFileSystem;

    @Before
    public void setUpVariable1(){

        name = "alias";
        publicKey= "publicKey";
        profileImage = new byte[10];
        registrationDate = 12653;
        contactState = ContactState.CONNECTED;

        intraUserActor = new IntraUserActorActor(name,publicKey, profileImage,registrationDate,contactState );

    }

    @Test
    public void GetNameAreEquals(){
        assertThat(intraUserActor.getName()).isEqualTo(name);
    }

    @Test
    public void GetPublicKeyAreEquals(){
        assertThat(intraUserActor.getPublicKey()).isEqualTo(publicKey);
    }

    @Test
    public void GetProfileImage_AreEquals() throws CantShowProfileImageException {
        assertThat(intraUserActor.getProfileImage()).isEqualTo(profileImage);
    }

    @Test
    public void GetRegistrationDateAreEquals(){
        assertThat(intraUserActor.getContactRegistrationDate()).isEqualTo(registrationDate);
    }

    @Test
    public void GetContactStateAreEquals()  {
        assertThat(intraUserActor.getContactState()).isEqualTo(contactState);
    }
}


