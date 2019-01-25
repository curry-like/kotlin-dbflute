package com.example.dbflute.bsentity.dbmeta;

import java.util.List;
import java.util.Map;

import org.dbflute.Entity;
import org.dbflute.optional.OptionalEntity;
import org.dbflute.dbmeta.AbstractDBMeta;
import org.dbflute.dbmeta.info.*;
import org.dbflute.dbmeta.name.*;
import org.dbflute.dbmeta.property.PropertyGateway;
import org.dbflute.dbway.DBDef;
import com.example.dbflute.allcommon.*;
import com.example.dbflute.exentity.*;

/**
 * The DB meta of customer. (Singleton)
 * @author DBFlute(AutoGenerator)
 */
public class CustomerDbm extends AbstractDBMeta {

    // ===================================================================================
    //                                                                           Singleton
    //                                                                           =========
    private static final CustomerDbm _instance = new CustomerDbm();
    private CustomerDbm() {}
    public static CustomerDbm getInstance() { return _instance; }

    // ===================================================================================
    //                                                                       Current DBDef
    //                                                                       =============
    public String getProjectName() { return DBCurrent.getInstance().projectName(); }
    public String getProjectPrefix() { return DBCurrent.getInstance().projectPrefix(); }
    public String getGenerationGapBasePrefix() { return DBCurrent.getInstance().generationGapBasePrefix(); }
    public DBDef getCurrentDBDef() { return DBCurrent.getInstance().currentDBDef(); }

    // ===================================================================================
    //                                                                    Property Gateway
    //                                                                    ================
    // -----------------------------------------------------
    //                                       Column Property
    //                                       ---------------
    protected final Map<String, PropertyGateway> _epgMap = newHashMap();
    { xsetupEpg(); }
    protected void xsetupEpg() {
        setupEpg(_epgMap, et -> ((Customer)et).getId(), (et, vl) -> ((Customer)et).setId(cti(vl)), "id");
        setupEpg(_epgMap, et -> ((Customer)et).getLastName(), (et, vl) -> ((Customer)et).setLastName((String)vl), "lastName");
        setupEpg(_epgMap, et -> ((Customer)et).getFirstName(), (et, vl) -> ((Customer)et).setFirstName((String)vl), "firstName");
        setupEpg(_epgMap, et -> ((Customer)et).getUserName(), (et, vl) -> ((Customer)et).setUserName((String)vl), "userName");
    }
    public PropertyGateway findPropertyGateway(String prop)
    { return doFindEpg(_epgMap, prop); }

    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    protected final Map<String, PropertyGateway> _efpgMap = newHashMap();
    { xsetupEfpg(); }
    @SuppressWarnings("unchecked")
    protected void xsetupEfpg() {
        setupEfpg(_efpgMap, et -> ((Customer)et).getUser(), (et, vl) -> ((Customer)et).setUser((OptionalEntity<User>)vl), "user");
    }
    public PropertyGateway findForeignPropertyGateway(String prop)
    { return doFindEfpg(_efpgMap, prop); }

    // ===================================================================================
    //                                                                          Table Info
    //                                                                          ==========
    protected final String _tableDbName = "customer";
    protected final String _tableDispName = "customer";
    protected final String _tablePropertyName = "customer";
    protected final TableSqlName _tableSqlName = new TableSqlName("customer", _tableDbName);
    { _tableSqlName.xacceptFilter(DBFluteConfig.getInstance().getTableSqlNameFilter()); }
    public String getTableDbName() { return _tableDbName; }
    public String getTableDispName() { return _tableDispName; }
    public String getTablePropertyName() { return _tablePropertyName; }
    public TableSqlName getTableSqlName() { return _tableSqlName; }

    // ===================================================================================
    //                                                                         Column Info
    //                                                                         ===========
    protected final ColumnInfo _columnId = cci("id", "id", null, null, Integer.class, "id", null, true, false, true, "INT", 10, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnLastName = cci("last_name", "last_name", null, null, String.class, "lastName", null, false, false, true, "VARCHAR", 45, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnFirstName = cci("first_name", "first_name", null, null, String.class, "firstName", null, false, false, true, "VARCHAR", 45, 0, null, null, false, null, null, null, null, null, false);
    protected final ColumnInfo _columnUserName = cci("user_name", "user_name", null, null, String.class, "userName", null, false, false, true, "VARCHAR", 45, 0, null, null, false, null, null, "user", null, null, false);

    /**
     * id: {PK, NotNull, INT(10)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnId() { return _columnId; }
    /**
     * last_name: {NotNull, VARCHAR(45)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnLastName() { return _columnLastName; }
    /**
     * first_name: {NotNull, VARCHAR(45)}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnFirstName() { return _columnFirstName; }
    /**
     * user_name: {UQ, NotNull, VARCHAR(45), FK to user}
     * @return The information object of specified column. (NotNull)
     */
    public ColumnInfo columnUserName() { return _columnUserName; }

    protected List<ColumnInfo> ccil() {
        List<ColumnInfo> ls = newArrayList();
        ls.add(columnId());
        ls.add(columnLastName());
        ls.add(columnFirstName());
        ls.add(columnUserName());
        return ls;
    }

    { initializeInformationResource(); }

    // ===================================================================================
    //                                                                         Unique Info
    //                                                                         ===========
    // -----------------------------------------------------
    //                                       Primary Element
    //                                       ---------------
    protected UniqueInfo cpui() { return hpcpui(columnId()); }
    public boolean hasPrimaryKey() { return true; }
    public boolean hasCompoundPrimaryKey() { return false; }

    // -----------------------------------------------------
    //                                        Unique Element
    //                                        --------------
    public UniqueInfo uniqueOf() { return hpcui(columnUserName()); }

    // ===================================================================================
    //                                                                       Relation Info
    //                                                                       =============
    // cannot cache because it uses related DB meta instance while booting
    // (instead, cached by super's collection)
    // -----------------------------------------------------
    //                                      Foreign Property
    //                                      ----------------
    /**
     * user by my user_name, named 'user'.
     * @return The information object of foreign property. (NotNull)
     */
    public ForeignInfo foreignUser() {
        Map<ColumnInfo, ColumnInfo> mp = newLinkedHashMap(columnUserName(), UserDbm.getInstance().columnUserName());
        return cfi("user_customer_fk", "user", this, UserDbm.getInstance(), mp, 0, org.dbflute.optional.OptionalEntity.class, true, false, false, false, null, null, false, "customerAsOne", false);
    }

    // -----------------------------------------------------
    //                                     Referrer Property
    //                                     -----------------

    // ===================================================================================
    //                                                                        Various Info
    //                                                                        ============

    // ===================================================================================
    //                                                                           Type Name
    //                                                                           =========
    public String getEntityTypeName() { return "com.example.dbflute.exentity.Customer"; }
    public String getConditionBeanTypeName() { return "com.example.dbflute.cbean.CustomerCB"; }
    public String getBehaviorTypeName() { return "com.example.dbflute.exbhv.CustomerBhv"; }

    // ===================================================================================
    //                                                                         Object Type
    //                                                                         ===========
    public Class<Customer> getEntityType() { return Customer.class; }

    // ===================================================================================
    //                                                                     Object Instance
    //                                                                     ===============
    public Customer newEntity() { return new Customer(); }

    // ===================================================================================
    //                                                                   Map Communication
    //                                                                   =================
    public void acceptPrimaryKeyMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptPrimaryKeyMap((Customer)et, mp); }
    public void acceptAllColumnMap(Entity et, Map<String, ? extends Object> mp)
    { doAcceptAllColumnMap((Customer)et, mp); }
    public Map<String, Object> extractPrimaryKeyMap(Entity et) { return doExtractPrimaryKeyMap(et); }
    public Map<String, Object> extractAllColumnMap(Entity et) { return doExtractAllColumnMap(et); }
}
