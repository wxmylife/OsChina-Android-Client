package net.morgan.oschina.common.moduleinterface.module.user;

import android.support.v4.app.Fragment;
import net.morgan.oschina.common.moduleinterface.provider.IUserProvider;
import net.morgan.oschina.common.moduleinterface.router.ModuleManager;
import net.morgan.oschina.common.moduleinterface.router.ServiceManager;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class UserService {

    private static boolean hasModule() {
        return ModuleManager.getInstance().hasModule(IUserProvider.USER_MAIN_SERVICE);
    }

    public static Fragment getUserFragment(Object... args) {
        if (!hasModule()) return null;
        return ServiceManager.getInstance().getUserProvider().newInstance(args);
    }


}
