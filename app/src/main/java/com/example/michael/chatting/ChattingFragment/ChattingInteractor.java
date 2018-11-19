package com.example.michael.chatting.ChattingFragment;

import com.example.michael.chatting.Manager.SocketIOManager;
import com.example.michael.chatting.Model.MessageModel;
import com.github.nkzawa.emitter.Emitter;

public class ChattingInteractor implements ChattingContract.Interactor {
    public final String chatEventName = "chat";
    @Override
    public void sendMessage(MessageModel stringMessage) {
        SocketIOManager.getInstance().emitToSocket(chatEventName, stringMessage.getText());
    }

    @Override
    public void establishChattingConnection(Emitter.Listener listener) {
        SocketIOManager.getInstance().addListener(listener, chatEventName);
    }
}
