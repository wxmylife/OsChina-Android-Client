package net.morgan.oschina.home.debug;

import com.alibaba.android.arouter.launcher.ARouter;
import net.morgan.oschina.base.BaseApplication;
import net.morgan.oschina.base.LG;
import net.morgan.oschina.base.moduleinterface.config.ModuleOptions;
import net.morgan.oschina.base.moduleinterface.provider.IHomeProvider;
import net.morgan.oschina.base.moduleinterface.router.ModuleManager;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class HomeDebugApplication  extends BaseApplication {
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
            .addModule(IHomeProvider.HOME_MAIN_SERVICE, IHomeProvider.HOME_MAIN_SERVICE);
        ModuleManager.getInstance().init(builder.build());
    }
}