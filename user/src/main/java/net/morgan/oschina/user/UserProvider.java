package net.morgan.oschina.user;

import android.content.Context;
import android.support.v4.app.Fragment;
import com.alibaba.android.arouter.facade.annotation.Route;
import net.morgan.oschina.common.moduleinterface.provider.IUserProvider;

import static net.morgan.oschina.common.moduleinterface.provider.IUserProvider.USER_MAIN_SERVICE;

/**
 * Created by wxmylife on 2017/4/21.
 */
@Route(path = USER_MAIN_SERVICE)
public class UserProvider implements IUserProvider {
    @Override
        public Fragment newInstance(Object... args) {
            return UserFragment.newInstance(args);
        }

    @Override public void init(Context context) {

    }
}
