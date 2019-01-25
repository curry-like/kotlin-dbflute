package com.example.dbflute.bsbhv.loader;

import java.util.List;

import org.dbflute.bhv.*;
import com.example.dbflute.exbhv.*;
import com.example.dbflute.exentity.*;

/**
 * The referrer loader of user as TABLE. <br>
 * <pre>
 * [primary key]
 *     user_name
 *
 * [column]
 *     user_name, encoded_password
 *
 * [sequence]
 *     
 *
 * [identity]
 *     
 *
 * [version-no]
 *     
 *
 * [foreign table]
 *     customer(AsOne)
 *
 * [referrer table]
 *     customer
 *
 * [foreign property]
 *     customerAsOne
 *
 * [referrer property]
 *     
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public class LoaderOfUser {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected List<User> _selectedList;
    protected BehaviorSelector _selector;
    protected UserBhv _myBhv; // lazy-loaded

    // ===================================================================================
    //                                                                   Ready for Loading
    //                                                                   =================
    public LoaderOfUser ready(List<User> selectedList, BehaviorSelector selector)
    { _selectedList = selectedList; _selector = selector; return this; }

    protected UserBhv myBhv()
    { if (_myBhv != null) { return _myBhv; } else { _myBhv = _selector.select(UserBhv.class); return _myBhv; } }

    // ===================================================================================
    //                                                                    Pull out Foreign
    //                                                                    ================
    protected LoaderOfCustomer _foreignCustomerAsOneLoader;
    public LoaderOfCustomer pulloutCustomerAsOne() {
        if (_foreignCustomerAsOneLoader == null)
        { _foreignCustomerAsOneLoader = new LoaderOfCustomer().ready(myBhv().pulloutCustomerAsOne(_selectedList), _selector); }
        return _foreignCustomerAsOneLoader;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public List<User> getSelectedList() { return _selectedList; }
    public BehaviorSelector getSelector() { return _selector; }
}
