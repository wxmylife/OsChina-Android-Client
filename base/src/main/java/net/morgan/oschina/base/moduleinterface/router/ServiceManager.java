package net.morgan.oschina.base.moduleinterface.router;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import net.morgan.oschina.base.moduleinterface.provider.ICommentProvider;
import net.morgan.oschina.base.moduleinterface.provider.IHomeProvider;
import net.morgan.oschina.base.moduleinterface.provider.ISearchProvider;
import net.morgan.oschina.base.moduleinterface.provider.ITweetProvider;
import net.morgan.oschina.base.moduleinterface.provider.IUserProvider;

/**
 * Created by wxmylife on 2017/4/21.
 */

public class ServiceManager {
    //服务注入看自己的具体实现
    //自动注入
    @Autowired
    IUserProvider userProvider;

    @Autowired
    IHomeProvider homeProvider;

    //可以不使用@Autowired，手动发现服务
    ICommentProvider commentProvider;
    ISearchProvider searchProvider;
    ITweetProvider tweetProvider;



    public ServiceManager() {
        ARouter.getInstance().inject(this);
    }

    private static final class ServiceManagerHolder {
        private static final ServiceManager instance = new ServiceManager();
    }

    public static ServiceManager getInstance() {
        return ServiceManagerHolder.instance;
    }


    public IUserProvider getUserProvider() {
        return userProvider;
    }


    public IHomeProvider getHomeProvider() {
        return homeProvider;
    }



    public ICommentProvider getCommentProvider() {
        return  commentProvider != null ? commentProvider : (commentProvider = ((ICommentProvider) ModuleRouter.newInstance(ICommentProvider.COMMENT_MAIN_SERVICE).navigation()));
    }

    public ISearchProvider getSearchProvider() {
        return searchProvider != null ? searchProvider : (searchProvider = ((ISearchProvider) ModuleRouter.newInstance(ISearchProvider.SEARCH_MAIN_SERVICE).navigation()));
    }

    public ITweetProvider getTweetProvider() {
        return tweetProvider != null ? tweetProvider : (tweetProvider = ((ITweetProvider) ModuleRouter.newInstance(ITweetProvider.TWEET_MAIN_SERVICE).navigation()));
    }

}
