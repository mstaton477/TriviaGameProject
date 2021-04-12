package TriviaGameDatabase;

/**
 *  The DataStore class acts as a intermediary between the system and the
 *  specific persistent data base type.
 *  @author Patrick
 */

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataStoreAdapter {

    private static final DBTranslatorInterface connector = new MySQLTranslator();

    /**
     * Given a DataObject, this method translates that DataObject into primitive
     * name-value pairs that can be used by a DBConnectorInterface class.
     * @param obj
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchFieldException
     */
    public static Boolean createObject(DataObject obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        // Send name-value pairs to the connector class. This class should
        // return a generated id number.
        int id = connector.createObject(obj.getProperties(), obj.getDataTable());
        // Associate this new id number with the object that was just saved.
        obj.setId(id);
        // Return the true if we have an id number. false otherwise.
        return (id != 0);
    }


    /**
     * Given a map of conditional statements, this method returns a single generic
     * DataObject instance with properties set to the returned data.
     * @param _map : The conditional name-value pairs (ie. name='John');
     * @param _table
     * @param _class
     * @return DataObject
     * @throws java.lang.ClassNotFoundException
     * @throws java.lang.InstantiationException
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.NoSuchMethodException
     */
    public static DataObject readObject(Map <String, String> _map, String _table, String _class) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // The Connector object returns a Hashmap of name-value pairs.
        HashMap<String, Object> results = connector.readObject(_map, _table);
        if (results == null) {
            return null;
        }
        try {
            // Here we create an object (cast as a generic DataObject) and return it.
            return (DataObject)DataFactory.objectFactory(_class, results);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DataStoreAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }


    /**
     * Updates an object already recorded in the database with new property values.
     * @param obj
     * @return Boolean
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     * @throws java.lang.NoSuchFieldException
     */
    public static Boolean updateObject(DataObject obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException {
        return connector.updateObject(obj.getProperties(), obj.getUuid(), obj.getDataTable());
    }


    /**
     * Deletes an object from the database.
     * Since we never want to actually delete records, we'll need to add an "active"
     * property to the base DataObject class. This implementation will then set
     * the active value to 0.
     * @param _id
     * @param _table
     * @return Boolean
     * @throws java.lang.IllegalAccessException
     * @throws java.lang.reflect.InvocationTargetException
     * @throws java.lang.NoSuchFieldException
     */
    public static int deleteObject(String _id, String _table) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, SQLException {
        return connector.deleteObject(_id, _table);
    }

    public static HashMap<String, Object> sortDataTable(String _table, String _parameterSortBy,HashMap<String, Object> _data) throws SQLException {
        return connector.sortTable(_table, _parameterSortBy, _data);
    }

}

