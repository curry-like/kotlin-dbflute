package com.example.dbflute.bsentity;

import java.util.List;
import java.util.ArrayList;

import org.dbflute.Entity;
import org.dbflute.dbmeta.DBMeta;
import org.dbflute.dbmeta.AbstractEntity;
import org.dbflute.dbmeta.accessory.DomainEntity;
import org.dbflute.optional.OptionalEntity;
import com.example.dbflute.allcommon.DBMetaInstanceHandler;
import com.example.dbflute.exentity.*;

/**
 * The entity of user as TABLE. <br>
 * <pre>
 * [primary-key]
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
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * String userName = entity.getUserName();
 * String encodedPassword = entity.getEncodedPassword();
 * entity.setUserName(userName);
 * entity.setEncodedPassword(encodedPassword);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsUser extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** user_name: {PK, NotNull, VARCHAR(45)} */
    protected String _userName;

    /** encoded_password: {NotNull, VARCHAR(45)} */
    protected String _encodedPassword;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "user";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_userName == null) { return false; }
        return true;
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** customer by user_name, named 'customerAsOne'. */
    protected OptionalEntity<Customer> _customerAsOne;

    /**
     * [get] customer by user_name, named 'customerAsOne'.
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return the entity of foreign property(referrer-as-one) 'customerAsOne'. (NotNull, EmptyAllowed: when e.g. no data, no setupSelect)
     */
    public OptionalEntity<Customer> getCustomerAsOne() {
        if (_customerAsOne == null) { _customerAsOne = OptionalEntity.relationEmpty(this, "customerAsOne"); }
        return _customerAsOne;
    }

    /**
     * [set] customer by user_name, named 'customerAsOne'.
     * @param customerAsOne The entity of foreign property(referrer-as-one) 'customerAsOne'. (NullAllowed)
     */
    public void setCustomerAsOne(OptionalEntity<Customer> customerAsOne) {
        _customerAsOne = customerAsOne;
    }

    // ===================================================================================
    //                                                                   Referrer Property
    //                                                                   =================
    protected <ELEMENT> List<ELEMENT> newReferrerList() { // overriding to import
        return new ArrayList<ELEMENT>();
    }

    // ===================================================================================
    //                                                                      Basic Override
    //                                                                      ==============
    @Override
    protected boolean doEquals(Object obj) {
        if (obj instanceof BsUser) {
            BsUser other = (BsUser)obj;
            if (!xSV(_userName, other._userName)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _userName);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_customerAsOne != null && _customerAsOne.isPresent())
        { sb.append(li).append(xbRDS(_customerAsOne, "customerAsOne")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_userName));
        sb.append(dm).append(xfND(_encodedPassword));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_customerAsOne != null && _customerAsOne.isPresent())
        { sb.append(dm).append("customerAsOne"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public User clone() {
        return (User)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] user_name: {PK, NotNull, VARCHAR(45)} <br>
     * @return The value of the column 'user_name'. (basically NotNull if selected: for the constraint)
     */
    public String getUserName() {
        checkSpecifiedProperty("userName");
        return _userName;
    }

    /**
     * [set] user_name: {PK, NotNull, VARCHAR(45)} <br>
     * @param userName The value of the column 'user_name'. (basically NotNull if update: for the constraint)
     */
    public void setUserName(String userName) {
        registerModifiedProperty("userName");
        _userName = userName;
    }

    /**
     * [get] encoded_password: {NotNull, VARCHAR(45)} <br>
     * @return The value of the column 'encoded_password'. (basically NotNull if selected: for the constraint)
     */
    public String getEncodedPassword() {
        checkSpecifiedProperty("encodedPassword");
        return _encodedPassword;
    }

    /**
     * [set] encoded_password: {NotNull, VARCHAR(45)} <br>
     * @param encodedPassword The value of the column 'encoded_password'. (basically NotNull if update: for the constraint)
     */
    public void setEncodedPassword(String encodedPassword) {
        registerModifiedProperty("encodedPassword");
        _encodedPassword = encodedPassword;
    }
}
