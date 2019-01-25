package com.example.dbflute.cbean.nss;

import com.example.dbflute.cbean.cq.UserCQ;

/**
 * The nest select set-upper of user.
 * @author DBFlute(AutoGenerator)
 */
public class UserNss {

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    protected final UserCQ _query;
    public UserNss(UserCQ query) { _query = query; }
    public boolean hasConditionQuery() { return _query != null; }

    // ===================================================================================
    //                                                                     Nested Relation
    //                                                                     ===============
    /**
     * With nested relation columns to select clause. <br>
     * customer by user_name, named 'customerAsOne'.
     * @return The set-upper of more nested relation. {...with[nested-relation].with[more-nested-relation]} (NotNull)
     */
    public CustomerNss withCustomerAsOne() {
        _query.xdoNss(() -> _query.queryCustomerAsOne());
        return new CustomerNss(_query.queryCustomerAsOne());
    }
}
