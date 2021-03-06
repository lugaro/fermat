package com.bitdubai.fermat_cht_plugin.layer.sub_app_module.chat_community.developer.bitdubai.version_1.structure;


import com.bitdubai.fermat_api.layer.actor_connection.common.enums.ConnectionState;
import com.bitdubai.fermat_api.layer.osa_android.location_system.Location;
import com.bitdubai.fermat_cht_api.layer.actor_connection.utils.ChatActorConnection;
import com.bitdubai.fermat_cht_api.layer.actor_network_service.utils.ChatExposingData;
import com.bitdubai.fermat_cht_api.layer.sup_app_module.interfaces.chat_actor_community.interfaces.ChatActorCommunityInformation;

import java.util.List;
import java.util.UUID;

/**
 * Created by Eleazar (eorono@protonmail.com) on 3/04/16.
 */

public class ChatActorCommunitySubAppModuleInformationImpl implements ChatActorCommunityInformation {

    private final String publicKey;
    private final String alias    ;
    private final byte[] image    ;
    private final ConnectionState connectionState;
    private final UUID connectionId;
    private final String country  ;
    private final String state    ;
    private final String city     ;
    private final String status;
    private final Location location;

    public ChatActorCommunitySubAppModuleInformationImpl(final String publicKey,
                                                         final String alias,
                                                         final byte[] image,
                                                         final ConnectionState connectionState,
                                                         final UUID connectionId,
                                                         final String status,
                                                         final String country,
                                                         final String state,
                                                         final String city,
                                                         final Location location) {

        this.publicKey          = publicKey      ;
        this.alias              = alias          ;
        this.image              = image          ;
        this.connectionState    = connectionState;
        this.connectionId       = connectionId   ;
        this.status             = status         ;
        this.country             = country         ;
        this.state             = state         ;
        this.city             = city         ;
        this.location             = location         ;
    }


    public ChatActorCommunitySubAppModuleInformationImpl(final ChatActorConnection exposingData) {

        this.publicKey = exposingData.getPublicKey();
        this.alias     = exposingData.getAlias()    ;
        this.image     = exposingData.getImage()    ;
        this.connectionState = exposingData.getConnectionState();
        this.connectionId = exposingData.getConnectionId();
        this.status = exposingData.getStatus();
        this.country = exposingData.getCountry();
        this.state = exposingData.getState();
        this.city = exposingData.getCity();
        this.location = null;
    }

    public ChatActorCommunitySubAppModuleInformationImpl(ChatExposingData ced) {
        this.publicKey = ced.getPublicKey();
        this.alias = ced.getAlias();
        this.image = ced.getImage();
        this.connectionState= null;
        this.connectionId=null;
        this.status=ced.getStatus();
        this.country = ced.getCountry();
        this.state = ced.getState();
        this.city = ced.getCity();
        this.location = ced.getLocation();
    }

    public ChatActorCommunitySubAppModuleInformationImpl(ChatActorCommunityInformation record) {
        this.publicKey = record.getPublicKey();
        this.alias = record.getAlias();
        this.image = record.getImage();
        this.connectionState = record.getConnectionState();
        this.connectionId = null;
        this.status=record.getStatus();
        this.country = record.getCountry();
        this.state = record.getState();
        this.city = record.getCity();
        this.location = record.getLocation();


    }


    @Override
    public String getPublicKey() {
        return publicKey;
    }

    @Override
    public String getAlias() {
        return alias;
    }

    @Override
    public byte[] getImage() { return image; }

    @Override
    public List listAlias() {
        return null;
    }

    @Override
    public ConnectionState getConnectionState() {
        return this.connectionState;
    }

    @Override
    public UUID getConnectionId() {
        return this.connectionId;
    }

    public String getStatus() {
        return status;
    }
    public String getCity() {
        return city;
    }
    public String getCountry() {
        return country;
    }
    public String getState() {
        return state;
    }
    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "ChatActorCommunitySubAppModuleInformationImpl{" +
                "publicKey='" + publicKey + '\'' +
                ", alias='" + alias + '\'' +
                ", connectionState='" + connectionState + '\'' +
                ", connectionId='" + connectionId + '\'' +
                ", image=" + (image != null) + '\'' +
                ", status=" + (status) + '\'' +
                ", country=" + (country) + '\'' +
                ", state=" + (state) + '\'' +
                ", city=" + (city) + '\'' +
                ", location=" + (location!=null) +
                '}';
    }
}
