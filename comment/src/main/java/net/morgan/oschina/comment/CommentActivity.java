package net.morgan.oschina.comment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.alibaba.android.arouter.facade.annotation.Route;
import net.morgan.oschina.base.BaseActivity;
import net.morgan.oschina.base.dao.UserInfo;

import static net.morgan.oschina.base.moduleinterface.provider.ICommentProvider.COMMENT_ACT_MAIN;

/**
 * Created by wxmylife on 2017/8/8.
 */


@Route(path = COMMENT_ACT_MAIN)
public class CommentActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.comment_main_activity);
        TextView textView = (TextView) findViewById(R.id.comment_activity_main_tv);
        UserInfo info = (UserInfo) getIntent().getSerializableExtra("data");
        if (info != null) {
            Toast.makeText(this, "从其他模块传递过来的数据显示",Toast.LENGTH_SHORT).show();
            textView.setText("姓名是：" + info.getName() + "\n" + "年龄是:" + info.getAge());
        }
    }

    public void onClickBtn(View view) {
        UserInfo info = new UserInfo();
        info.setName("李四");
        info.setAge(14);
        Intent back = new Intent();
        back.putExtra("data", info);
        setResult(Activity.RESULT_OK, back);
        finish();
    }
}
