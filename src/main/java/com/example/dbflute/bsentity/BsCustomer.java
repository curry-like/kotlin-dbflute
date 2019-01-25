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
 * The entity of customer as TABLE. <br>
 * <pre>
 * [primary-key]
 *     id
 *
 * [column]
 *     id, last_name, first_name, user_name
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
 *     user
 *
 * [referrer table]
 *     
 *
 * [foreign property]
 *     user
 *
 * [referrer property]
 *     
 *
 * [get/set template]
 * /= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =
 * Integer id = entity.getId();
 * String lastName = entity.getLastName();
 * String firstName = entity.getFirstName();
 * String userName = entity.getUserName();
 * entity.setId(id);
 * entity.setLastName(lastName);
 * entity.setFirstName(firstName);
 * entity.setUserName(userName);
 * = = = = = = = = = =/
 * </pre>
 * @author DBFlute(AutoGenerator)
 */
public abstract class BsCustomer extends AbstractEntity implements DomainEntity {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    /** The serial version UID for object serialization. (Default) */
    private static final long serialVersionUID = 1L;

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    /** id: {PK, NotNull, INT(10)} */
    protected Integer _id;

    /** last_name: {NotNull, VARCHAR(45)} */
    protected String _lastName;

    /** first_name: {NotNull, VARCHAR(45)} */
    protected String _firstName;

    /** user_name: {UQ, NotNull, VARCHAR(45), FK to user} */
    protected String _userName;

    // ===================================================================================
    //                                                                             DB Meta
    //                                                                             =======
    /** {@inheritDoc} */
    public DBMeta asDBMeta() {
        return DBMetaInstanceHandler.findDBMeta(asTableDbName());
    }

    /** {@inheritDoc} */
    public String asTableDbName() {
        return "customer";
    }

    // ===================================================================================
    //                                                                        Key Handling
    //                                                                        ============
    /** {@inheritDoc} */
    public boolean hasPrimaryKeyValue() {
        if (_id == null) { return false; }
        return true;
    }

    /**
     * To be unique by the unique column. <br>
     * You can update the entity by the key when entity update (NOT batch update).
     * @param userName : UQ, NotNull, VARCHAR(45), FK to user. (NotNull)
     */
    public void uniqueBy(String userName) {
        __uniqueDrivenProperties.clear();
        __uniqueDrivenProperties.addPropertyName("userName");
        setUserName(userName);
    }

    // ===================================================================================
    //                                                                    Foreign Property
    //                                                                    ================
    /** user by my user_name, named 'user'. */
    protected OptionalEntity<User> _user;

    /**
     * [get] user by my user_name, named 'user'. <br>
     * Optional: alwaysPresent(), ifPresent().orElse(), get(), ...
     * @return The entity of foreign property 'user'. (NotNull, EmptyAllowed: when e.g. null FK column, no setupSelect)
     */
    public OptionalEntity<User> getUser() {
        if (_user == null) { _user = OptionalEntity.relationEmpty(this, "user"); }
        return _user;
    }

    /**
     * [set] user by my user_name, named 'user'.
     * @param user The entity of foreign property 'user'. (NullAllowed)
     */
    public void setUser(OptionalEntity<User> user) {
        _user = user;
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
        if (obj instanceof BsCustomer) {
            BsCustomer other = (BsCustomer)obj;
            if (!xSV(_id, other._id)) { return false; }
            return true;
        } else {
            return false;
        }
    }

    @Override
    protected int doHashCode(int initial) {
        int hs = initial;
        hs = xCH(hs, asTableDbName());
        hs = xCH(hs, _id);
        return hs;
    }

    @Override
    protected String doBuildStringWithRelation(String li) {
        StringBuilder sb = new StringBuilder();
        if (_user != null && _user.isPresent())
        { sb.append(li).append(xbRDS(_user, "user")); }
        return sb.toString();
    }
    protected <ET extends Entity> String xbRDS(org.dbflute.optional.OptionalEntity<ET> et, String name) { // buildRelationDisplayString()
        return et.get().buildDisplayString(name, true, true);
    }

    @Override
    protected String doBuildColumnString(String dm) {
        StringBuilder sb = new StringBuilder();
        sb.append(dm).append(xfND(_id));
        sb.append(dm).append(xfND(_lastName));
        sb.append(dm).append(xfND(_firstName));
        sb.append(dm).append(xfND(_userName));
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length());
        }
        sb.insert(0, "{").append("}");
        return sb.toString();
    }

    @Override
    protected String doBuildRelationString(String dm) {
        StringBuilder sb = new StringBuilder();
        if (_user != null && _user.isPresent())
        { sb.append(dm).append("user"); }
        if (sb.length() > dm.length()) {
            sb.delete(0, dm.length()).insert(0, "(").append(")");
        }
        return sb.toString();
    }

    @Override
    public Customer clone() {
        return (Customer)super.clone();
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    /**
     * [get] id: {PK, NotNull, INT(10)} <br>
     * @return The value of the column 'id'. (basically NotNull if selected: for the constraint)
     */
    public Integer getId() {
        checkSpecifiedProperty("id");
        return _id;
    }

    /**
     * [set] id: {PK, NotNull, INT(10)} <br>
     * @param id The value of the column 'id'. (basically NotNull if update: for the constraint)
     */
    public void setId(Integer id) {
        registerModifiedProperty("id");
        _id = id;
    }

    /**
     * [get] last_name: {NotNull, VARCHAR(45)} <br>
     * @return The value of the column 'last_name'. (basically NotNull if selected: for the constraint)
     */
    public String getLastName() {
        checkSpecifiedProperty("lastName");
        return _lastName;
    }

    /**
     * [set] last_name: {NotNull, VARCHAR(45)} <br>
     * @param lastName The value of the column 'last_name'. (basically NotNull if update: for the constraint)
     */
    public void setLastName(String lastName) {
        registerModifiedProperty("lastName");
        _lastName = lastName;
    }

    /**
     * [get] first_name: {NotNull, VARCHAR(45)} <br>
     * @return The value of the column 'first_name'. (basically NotNull if selected: for the constraint)
     */
    public String getFirstName() {
        checkSpecifiedProperty("firstName");
        return _firstName;
    }

    /**
     * [set] first_name: {NotNull, VARCHAR(45)} <br>
     * @param firstName The value of the column 'first_name'. (basically NotNull if update: for the constraint)
     */
    public void setFirstName(String firstName) {
        registerModifiedProperty("firstName");
        _firstName = firstName;
    }

    /**
     * [get] user_name: {UQ, NotNull, VARCHAR(45), FK to user} <br>
     * @return The value of the column 'user_name'. (basically NotNull if selected: for the constraint)
     */
    public String getUserName() {
        checkSpecifiedProperty("userName");
        return _userName;
    }

    /**
     * [set] user_name: {UQ, NotNull, VARCHAR(45), FK to user} <br>
     * @param userName The value of the column 'user_name'. (basically NotNull if update: for the constraint)
     */
    public void setUserName(String userName) {
        registerModifiedProperty("userName");
        _userName = userName;
    }
}
