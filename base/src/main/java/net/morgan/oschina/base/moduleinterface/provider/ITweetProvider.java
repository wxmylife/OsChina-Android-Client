package net.morgan.oschina.base.moduleinterface.provider;

/**
 * Created by wxmylife on 2017/4/21.
 */

public interface ITweetProvider extends IFragmentProvider {
    //服务
    String TWEET_MAIN_SERVICE = "/tweet/main/service";
    //作为Fragment被添加时候的key
    String TWEET_KEY_FRAGMENT = "tweet_key_fragment";
}
