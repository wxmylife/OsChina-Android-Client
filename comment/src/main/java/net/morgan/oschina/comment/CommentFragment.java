package net.morgan.oschina.comment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import net.morgan.oschina.base.BaseFragment;
import net.morgan.oschina.base.dao.UserInfo;
import net.morgan.oschina.common.moduleinterface.module.comment.CommentIntent;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class CommentFragment extends BaseFragment {

    private TextView name;
    private TextView age;
    private static final int REQUEST_CODE = 0x100;


    public static CommentFragment newInstance(Object... args) {
        return new CommentFragment();
    }


    @Override
    public View getContentView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
        Bundle savedInstanceState) {
        return inflater.inflate(R.layout.comment_fragment_main, null);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        name = findViewById(R.id.comment_fragment_main_name);
        age = findViewById(R.id.comment_fragment_main_age);
        final UserInfo userInfo = new UserInfo();
        userInfo.setAge(16);
        userInfo.setName("张三");
        findViewById(R.id.comment_fragment_main_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommentIntent.launchComment(getActivity(), REQUEST_CODE, userInfo);
            }
        });
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && data != null) {
            UserInfo info = (UserInfo) data.getSerializableExtra("data");
            name.setText(info.getName());
            age.setText(info.getAge() + "");

        }
    }
}