package com.bitdubai.fermat_cht_api.layer.middleware.interfaces;

import com.bitdubai.fermat_api.layer.all_definition.common.system.interfaces.FermatManager;
import com.bitdubai.fermat_api.layer.all_definition.components.enums.PlatformComponentType;
import com.bitdubai.fermat_cht_api.all_definition.exceptions.CantDeleteChatException;
import com.bitdubai.fermat_cht_api.all_definition.exceptions.CantDeleteContactException;
import com.bitdubai.fermat_cht_api.all_definition.exceptions.CantDeleteMessageException;
import com.bitdubai.fermat_cht_api.all_definition.exceptions.CantGetChatException;
import com.bitdubai.fermat_cht_api.all_definition.exceptions.CantGetContactException;
import com.bitdubai.fermat_cht_api.all_definition.exceptions.CantGetMessageException;
import com.bitdubai.fermat_cht_api.all_definition.exceptions.CantGetNetworkServicePublicKeyException;
import com.bitdubai.fermat_cht_api.all_definition.exceptions.CantNewEmptyChatException;
import com.bitdubai.fermat_cht_api.all_definition.exceptions.CantNewEmptyContactException;
import com.bitdubai.fermat_cht_api.all_definition.exceptions.CantNewEmptyMessageException;
import com.bitdubai.fermat_cht_api.all_definition.exceptions.CantSaveChatException;
import com.bitdubai.fermat_cht_api.all_definition.exceptions.CantSaveContactException;
import com.bitdubai.fermat_cht_api.all_definition.exceptions.CantSaveMessageException;
import com.bitdubai.fermat_cht_api.all_definition.exceptions.CantSendNotificationNewIncomingMessageException;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * Created by miguel payarez (miguel_payarez@hotmail.com) on 29/12/15.
 * Update by Manuel Perez on 08/01/2016 (fix naming conventions)
 */
public interface MiddlewareChatManager extends FermatManager{

    //Documentar
    List<Chat> getChats() throws CantGetChatException;

    Chat getChatByChatId(UUID chatId) throws CantGetChatException;

    Chat newEmptyInstanceChat() throws CantNewEmptyChatException;

    void saveChat(Chat chat) throws CantSaveChatException;

    void deleteChat(Chat chat) throws CantDeleteChatException;

    List<Message> getMessages() throws CantGetMessageException;

    List<Message> getMessageByChatId(UUID chatId) throws CantGetMessageException;

    Message getMessageByMessageId(UUID messageId) throws CantGetMessageException;

    Message newEmptyInstanceMessage() throws CantNewEmptyMessageException;

    void saveMessage(Message message) throws CantSaveMessageException;

    void deleteMessage(Message message) throws CantDeleteMessageException;

    List<Contact> getContacts() throws CantGetContactException;

    Contact getContactByContactId(UUID contactId) throws CantGetContactException;

    Contact newEmptyInstanceContact() throws CantNewEmptyContactException;

    void saveContact(Contact contact) throws CantSaveContactException;

    void deleteContact(Contact contact) throws CantDeleteContactException;

    List<Contact> discoverActorsRegistered() throws CantGetContactException;

    void notificationNewIncomingMessage(
            String publicKey,
            String tittle,
            String body) throws CantSendNotificationNewIncomingMessageException;

    String getNetworkServicePublicKey() throws CantGetNetworkServicePublicKeyException;

    /**
     * This method return a HashMap with the possible self identities.
     * The HashMap contains a Key-value like PlatformComponentType-ActorPublicKey.
     * If there no identities created in any platform, this hashMaps contains the public chat Network
     * Service.
     * @return
     */
    HashMap<PlatformComponentType, String> getSelfIdentities();
}
