package com.example.michael.chatting.ChattingFragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.michael.chatting.Adapter.ChattingRecyclerAdapter;
import com.example.michael.chatting.Model.MessageModel;
import com.example.michael.chatting.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A placeholder fragment containing a simple view.
 */
public class ChattingFragment extends Fragment implements ChattingContract.View {
    private static final String TAG = ChattingFragment.class.getSimpleName();
    private ActivityFragmentInteractor mActivityFragmentInteractor = null;
    private ChattingContract.Presenter mChattingPresenter;
    private ChattingRecyclerAdapter mChattingRecyclerAdapter;

    @BindView(R.id.recyclerViewChat)
    public RecyclerView chatRecyclerView;
    @BindView(R.id.buttonMessage)
    public ImageButton mButtonMessage;
    @BindView(R.id.inputMessage)
    public EditText mInputMessage;

    public ChattingFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ActivityFragmentInteractor) {
            mActivityFragmentInteractor = (ActivityFragmentInteractor) context;
        } else {
            throw new RuntimeException("Present activity does not implement ActivityFragmentInteractor");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chatting, container, false);
        ButterKnife.bind(this, view);

        mChattingRecyclerAdapter = new ChattingRecyclerAdapter();
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        chatRecyclerView.setLayoutManager(mLayoutManager);
        chatRecyclerView.setItemAnimator(new DefaultItemAnimator());
        chatRecyclerView.setAdapter(mChattingRecyclerAdapter);

        mChattingPresenter = new ChattingPresenter(this, new ChattingInteractor());
        mChattingPresenter.onCreate();

        // Lambda Function to shorten code
        mButtonMessage.setOnClickListener(
                (buttonView) -> mChattingPresenter.sendMessage(mInputMessage.getText().toString())
        );

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        mActivityFragmentInteractor.changeToolbarTitle("Chat Room");
    }

    @Override
    public void showNewMessage(MessageModel messageModel) {
        getActivity().runOnUiThread(() -> {
            mChattingRecyclerAdapter.addMessage(messageModel);
            mChattingRecyclerAdapter.notifyItemInserted(mChattingRecyclerAdapter.getItemCount());
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mChattingPresenter.onDestroy();
    }

    public interface ActivityFragmentInteractor {
        void changeToolbarTitle(String titleString);
    }
}
