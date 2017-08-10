package net.morgan.oschina.app;

import com.alibaba.android.arouter.launcher.ARouter;
import net.morgan.oschina.base.BaseApplication;
import net.morgan.oschina.base.LG;
import net.morgan.oschina.base.moduleinterface.config.ModuleOptions;
import net.morgan.oschina.base.moduleinterface.provider.IHomeProvider;
import net.morgan.oschina.base.moduleinterface.provider.IUserProvider;
import net.morgan.oschina.base.moduleinterface.router.ModuleManager;

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
            .addModule(IUserProvider.HOME_MAIN_SERVICE,IUserProvider.HOME_MAIN_SERVICE)
            .addModule(IHomeProvider.HOME_MAIN_SERVICE,IHomeProvider.HOME_MAIN_SERVICE);

        ModuleManager.getInstance().init(builder.build());
    }

}
