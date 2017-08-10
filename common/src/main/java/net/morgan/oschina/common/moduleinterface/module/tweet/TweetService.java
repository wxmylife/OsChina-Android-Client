package net.morgan.oschina.common.moduleinterface.module.tweet;

import android.support.v4.app.Fragment;
import net.morgan.oschina.common.moduleinterface.provider.ITweetProvider;
import net.morgan.oschina.common.moduleinterface.router.ModuleManager;
import net.morgan.oschina.common.moduleinterface.router.ServiceManager;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class TweetService {
    private static boolean hasTweet() {
        return ModuleManager.getInstance().hasModule(ITweetProvider.TWEET_MAIN_SERVICE);
    }

    public static Fragment getTweetFragment(Object... args) {
        if (!hasTweet()) return null;
        return ServiceManager.getInstance().getTweetProvider().newInstance(args);
    }
}
