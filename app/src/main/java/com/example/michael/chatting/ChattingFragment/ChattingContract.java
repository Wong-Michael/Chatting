package com.example.michael.chatting.ChattingFragment;

import com.example.michael.chatting.Model.MessageModel;
import com.github.nkzawa.emitter.Emitter;

public class ChattingContract {

    interface View {
        void showNewMessage(MessageModel messageModel);
    }

    interface Presenter {
        void sendMessage(String stringMessage);
        void onCreate();
        void onDestroy();
    }

    interface Interactor {
        void sendMessage(MessageModel stringMessage);
        void establishChattingConnection(Emitter.Listener listener);
    }
}
