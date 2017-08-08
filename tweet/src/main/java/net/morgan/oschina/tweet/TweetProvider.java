package net.morgan.oschina.tweet;

import android.content.Context;
import android.support.v4.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import net.morgan.oschina.base.moduleinterface.provider.ITweetProvider;

import static net.morgan.oschina.base.moduleinterface.provider.ITweetProvider.TWEET_MAIN_SERVICE;

/**
 * Created by wxmylife on 2017/4/21.
 */
@Route(path = TWEET_MAIN_SERVICE)
public class TweetProvider implements ITweetProvider {

    @Override
    public Fragment newInstance(Object... args) {
        return TweetFragment.newInstance(args);
    }

    @Override
    public void init(Context context) {

    }
}
