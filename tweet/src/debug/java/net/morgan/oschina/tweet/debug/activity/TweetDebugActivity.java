package net.morgan.oschina.tweet.debug.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import net.morgan.oschina.base.BaseActivity;
import net.morgan.oschina.base.moduleinterface.module.tweet.TweetService;
import net.morgan.oschina.tweet.R;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class TweetDebugActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tweet_debug_activity);
        Fragment module1 = TweetService.getTweetFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.tweet_debug_content, module1)
            .commitAllowingStateLoss();
    }
}
