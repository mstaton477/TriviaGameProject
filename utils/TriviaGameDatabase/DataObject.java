package TriviaGameDatabase;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Patrick
 */
public abstract class DataObject extends DataFactory {

    protected final String dataTable = "";
    protected int id = 0;
    protected String uuid;
    protected String name = "";
    protected String active = "1";
    protected Timestamp lastUpdated = null;

    public DataObject() {
        this.setUuid(DataObject.generateUuid());
    }

    public DataObject loadById(int _id) {
        HashMap<String, String> map = new HashMap<>();
        map.put("id", Integer.toString(_id));
        return this.loadByCondition(map);
    }

    public DataObject loadByUuid(String _uuid) {
        HashMap<String, String> map = new HashMap<>();
        map.put("uuid", _uuid);
        return this.loadByCondition(map);
    }

    public DataObject loadByCondition(String _name, String _value) {
        HashMap<String, String> map = new HashMap<>();
        map.put(_name, _value);
        return this.loadByCondition(map);
    }

    public Boolean save() {
        // Has this object already been created?
        if (this.id == 0) {
            try {
                return DataStoreAdapter.createObject(this);
            } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchFieldException ex) {
                Logger.getLogger(DataObject.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                // This is an existing object in the database, just update the object.
                return DataStoreAdapter.updateObject(this);
            } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchFieldException ex) {
                Logger.getLogger(DataObject.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public int delete(String _id) {
        try {
            return DataStoreAdapter.deleteObject(_id, this.getDataTable());
        } catch (IllegalArgumentException | IllegalAccessException | InvocationTargetException | NoSuchFieldException | SQLException ex) {
            Logger.getLogger(DataObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public ArrayList sortTable(String _parameterSortedBy) throws NoSuchFieldException, IllegalAccessException, SQLException {
        ArrayList _sortedList = new ArrayList();
        return DataStoreAdapter.sortDataTable(this.getDataTable(), _parameterSortedBy, _sortedList);
    }


    protected static String generateUuid() {
        return UUID.randomUUID().toString();
    }

// ================================ GETTERS ====================================

    public String getName() {
        return this.name;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getId() {
        return this.id;
    }

// ================================ SETTERS ====================================

    public void setName(String _name) {
        this.name = _name;
    }

    public void setUuid(String _uuid) {
        this.uuid = _uuid;
    }

    public void setId(int _id) {
        this.id = _id;
    }

}
