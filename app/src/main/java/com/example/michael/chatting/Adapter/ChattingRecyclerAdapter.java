package com.example.michael.chatting.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.michael.chatting.Model.MessageModel;
import com.example.michael.chatting.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChattingRecyclerAdapter extends RecyclerView.Adapter {

    private List<MessageModel> messageModelList = new ArrayList<>();

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View chatCell = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_cell, viewGroup, false);
        return new ChatMessageViewHolder(chatCell);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if (viewHolder instanceof ChatMessageViewHolder) {
            ((ChatMessageViewHolder) viewHolder).bindData(messageModelList.get(i));
        }
    }

    @Override
    public int getItemCount() {
        return messageModelList.size();
    }

    public void addMessage(MessageModel messageModel) {
        messageModelList.add(messageModel);
    }

    public class ChatMessageViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.messageName)
        public TextView mNameTextView;

        @BindView(R.id.messageText)
        public TextView mMessaageTextView;

        public ChatMessageViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindData(MessageModel messageModel) {
            mNameTextView.setText(messageModel.getName());
            mMessaageTextView.setText(messageModel.getText());
        }
    }
}
