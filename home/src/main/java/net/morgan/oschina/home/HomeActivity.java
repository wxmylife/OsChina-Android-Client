package net.morgan.oschina.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Toast;
import com.alibaba.android.arouter.facade.annotation.Route;
import java.util.HashMap;
import java.util.Map;
import net.morgan.oschina.base.BaseActivity;
import net.morgan.oschina.base.LG;
import net.morgan.oschina.common.moduleinterface.module.search.SearchService;
import net.morgan.oschina.common.moduleinterface.module.tweet.TweetService;
import net.morgan.oschina.common.moduleinterface.module.user.UserService;
import net.morgan.oschina.common.moduleinterface.provider.IHomeProvider;
import net.morgan.oschina.common.moduleinterface.provider.ISearchProvider;
import net.morgan.oschina.common.moduleinterface.provider.ITweetProvider;
import net.morgan.oschina.common.moduleinterface.provider.IUserProvider;
import net.morgan.oschina.common.moduleinterface.router.ModuleManager;

/**
 * Created by wxmylife on 2017/4/20.
 */
@Route(path = IHomeProvider.HOME_ACT_HOME)
public class HomeActivity extends BaseActivity {

    private int currentPosition = -1;
    private Map<String, Fragment> mFragments;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mFragments = new HashMap<>();
        selectedTab(getIntent().getIntExtra(IHomeProvider.HOME_TABTYPE, 0));
    }


    public void onClickTab(View view) {
        int id = view.getId();
        if (id == R.id.home_tab_module1) {
            selectedTab(0);
        } else if (id == R.id.home_tab_module2) {
            selectedTab(1);
        } else if (id == R.id.home_tab_module3) {
            selectedTab(2);
        }
    }

    public void selectedTab(int position) {
        if (currentPosition == position)
            return;
        switch (position) {
            case 0:
                selectFragment(ITweetProvider.TWEET_KEY_FRAGMENT);
                break;
            case 1:
                selectFragment(ISearchProvider.SEARCH_KEY_FRAGMENT);
                break;
            case 2:
                //
                if (ModuleManager.getInstance().hasModule(IUserProvider.USER_MAIN_SERVICE)) {
                    selectFragment(IUserProvider.USER_KEY_FRAGMENT);
                }
                // else if (ModuleManager.getInstance().hasModule(IModule5Provider.MODULE5_MAIN_SERVICE)) {
                //     Module5Intent.launchModule5(new UserInfo("王五", 18));
                // }
                break;
        }
        currentPosition = position;
    }

    private void selectFragment(String key) {
        Fragment fragment;
        fragment = mFragments.get(key);
        String msg;
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        hideFragment(beginTransaction);
        if (fragment == null) {
            if (ITweetProvider.TWEET_KEY_FRAGMENT.equals(key)) {
                fragment = TweetService.getTweetFragment();
                msg = "tweet模块";
            } else if (ISearchProvider.SEARCH_KEY_FRAGMENT.equals(key)) {
                fragment = SearchService.getSearchFragment();
                msg = "search模块";
            } else if (IUserProvider.USER_KEY_FRAGMENT.equals(key)) {
                fragment = UserService.getUserFragment();
                msg = "module3模块";
            } else {
                return;
            }
            if (fragment == null) {
                if (LG.isDebug) {
                    Toast.makeText(this, "没有" + msg, Toast.LENGTH_SHORT).show();
                }
                beginTransaction.commit();
                return;
            }
            mFragments.put(key, fragment);
            beginTransaction.add(R.id.home_content_fragment, fragment);
        } else {
            beginTransaction.show(fragment);
        }
        beginTransaction.commit();
    }

    private void hideFragment(FragmentTransaction beginTransaction) {
        for (Map.Entry<String, Fragment> item : mFragments.entrySet()) {
            beginTransaction.hide(item.getValue());
        }
    }

    //一般而言需要这样子传递，Activity不涉及到具体逻辑处理，除非是全局性的
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (Map.Entry<String, Fragment> item : mFragments.entrySet()) {
            Fragment fragment = item.getValue();
            fragment.onActivityResult(requestCode, resultCode, data);
        }
    }
}
