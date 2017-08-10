package net.morgan.oschina.app;

import com.alibaba.android.arouter.launcher.ARouter;
import net.morgan.oschina.base.BaseApplication;
import net.morgan.oschina.base.LG;
import net.morgan.oschina.common.moduleinterface.config.ModuleOptions;
import net.morgan.oschina.common.moduleinterface.provider.ICommentProvider;
import net.morgan.oschina.common.moduleinterface.provider.IHomeProvider;
import net.morgan.oschina.common.moduleinterface.provider.ISearchProvider;
import net.morgan.oschina.common.moduleinterface.provider.ITweetProvider;
import net.morgan.oschina.common.moduleinterface.provider.IUserProvider;
import net.morgan.oschina.common.moduleinterface.router.ModuleManager;

/**
 * Created by wxmylife on 2017/8/8.
 */

public class CustomApplication extends BaseApplication {

    @Override public void onCreate() {
        super.onCreate();
        initARouter();
    }

    private void initARouter() {
        if (LG.isDebug){
            ARouter.openLog();
            ARouter.openDebug();
            ARouter.printStackTrace();
        }

        ARouter.init(this);
        ModuleOptions.ModuleBuilder builder=new ModuleOptions.ModuleBuilder(this)
            .addModule(IUserProvider.USER_MAIN_SERVICE,IUserProvider.USER_MAIN_SERVICE)
            .addModule(IHomeProvider.HOME_MAIN_SERVICE,IHomeProvider.HOME_MAIN_SERVICE)
            .addModule(ICommentProvider.COMMENT_MAIN_SERVICE,ICommentProvider.COMMENT_MAIN_SERVICE)
            .addModule(ISearchProvider.SEARCH_MAIN_SERVICE,ISearchProvider.SEARCH_MAIN_SERVICE)
            .addModule(ITweetProvider.TWEET_MAIN_SERVICE,ITweetProvider.TWEET_MAIN_SERVICE);

        ModuleManager.getInstance().init(builder.build());
    }

}
