package net.morgan.oschina.tweet.debug;

import com.alibaba.android.arouter.launcher.ARouter;
import net.morgan.oschina.base.BaseApplication;
import net.morgan.oschina.base.LG;
import net.morgan.oschina.common.moduleinterface.config.ModuleOptions;
import net.morgan.oschina.common.moduleinterface.provider.IHomeProvider;
import net.morgan.oschina.common.moduleinterface.provider.ITweetProvider;
import net.morgan.oschina.common.moduleinterface.router.ModuleManager;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class TweetDebugApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initARouter();
    }

    private void initARouter() {
        if (LG.isDebug) {
            ARouter.openLog();
            ARouter.openDebug();
            ARouter.printStackTrace();
        }
        ARouter.init(this);
        ModuleOptions.ModuleBuilder builder = new ModuleOptions.ModuleBuilder(this)
            .addModule(IHomeProvider.HOME_MAIN_SERVICE, IHomeProvider.HOME_MAIN_SERVICE)
            .addModule(ITweetProvider.TWEET_MAIN_SERVICE, ITweetProvider.TWEET_MAIN_SERVICE);
        ModuleManager.getInstance().init(builder.build());
    }
}
