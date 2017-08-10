package net.morgan.oschina.base.moduleinterface.provider;

/**
 * Created by wxmylife on 2017/4/21.
 */

public interface ISearchProvider extends IFragmentProvider {
    //服务
    String SEARCH_MAIN_SERVICE = "/search/main/service";
    //作为Fragment被添加时候的key
    String SEARCH_KEY_FRAGMENT = "search_key_fragment";
}
