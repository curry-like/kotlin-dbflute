package com.example.dbflute.cbean.nss;

import com.example.dbflute.cbean.cq.CustomerCQ;

/**
 * The nest select set-upper of customer.
 * @author DBFlute(AutoGenerator)
 */
public class CustomerNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final CustomerCQ _query;
    public CustomerNss(CustomerCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * user by my user_name, named 'user'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public UserNss withUser() {
        _query.xdoNss(() -> _query.queryUser());
        return new UserNss(_query.queryUser());
    }
}
