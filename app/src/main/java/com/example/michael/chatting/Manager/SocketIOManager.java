package com.example.michael.chatting.Manager;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

import java.net.URISyntaxException;

public class SocketIOManager {
    private static SocketIOManager socketIOManager = null;
    private static String webHostURL = "https://node-multiplayer-activity.herokuapp.com/";
    private Socket mSocket;

    private SocketIOManager() {
        try {
            mSocket = IO.socket(webHostURL);
            mSocket.connect();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    public static SocketIOManager getInstance() {
        if (socketIOManager == null) {
            socketIOManager = new SocketIOManager();
        }
        return socketIOManager;
    }

    public void cleanManager() {
        mSocket.disconnect();
        mSocket.off();
    }

    public void addListener(Emitter.Listener listener, String eventName) {
        mSocket.on(eventName, listener);
    }

    public void emitToSocket(String event, Object... args) {
        mSocket.emit(event, args);
    }
}
