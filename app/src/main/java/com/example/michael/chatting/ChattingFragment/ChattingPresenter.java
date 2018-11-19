package com.example.michael.chatting.ChattingFragment;

import com.example.michael.chatting.Model.MessageModel;


public class ChattingPresenter implements ChattingContract.Presenter {
    private ChattingContract.View mChattingView;
    private ChattingContract.Interactor mChattingInteractor;
    private String userName = "TBD"; // TODO to be implemented

    ChattingPresenter(ChattingContract.View chattingView, ChattingContract.Interactor chattingInteractor) {
        mChattingView = chattingView;
        mChattingInteractor = chattingInteractor;
    }

    @Override
    public void sendMessage(String stringMessage) {
        mChattingInteractor.sendMessage(new MessageModel(userName, stringMessage));
    }

    @Override
    public void onCreate() {
        mChattingInteractor.establishChattingConnection(args -> {
            if (args.length == 1 && args[0] instanceof String ) {   //TODO update websocket + if statement with name implementation
                String text = (String) args[0];
                mChattingView.showNewMessage(new MessageModel(userName, text));
            }
        });
    }

    @Override
    public void onDestroy() {

    }
}
