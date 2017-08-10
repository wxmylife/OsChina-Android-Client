package net.morgan.oschina.user.debug.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import net.morgan.oschina.base.BaseActivity;
import net.morgan.oschina.common.moduleinterface.module.user.UserService;
import net.morgan.oschina.user.R;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class UserDebugActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_debug_activity);
        Fragment module1 = UserService.getUserFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.user_debug_content, module1)
            .commitAllowingStateLoss();
    }
}
