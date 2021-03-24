package DataBasePrototype;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DataStoreAdapter {
    private static final DBTranslatorInterface connector = new TextFileTranslator();

    /**
     * Given a DataBasePrototype.DataObject, this method translates that DataBasePrototype.DataObject into primitive
     * name-value pairs that can be used by a DBConnectorInterface class.
     * @param obj
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws NoSuchFieldException
     */
    public static Boolean createObject(DataObject obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, IOException {
        // Send name-value pairs to the connector class. This class should
        // return a generated id number.
        int id = connector.createObject(obj.getProperties(), obj.getDataTable());
        // Associate this new id number with the object that was just saved.
        obj.setId(id);
        // Return the true if we have an id number. false otherwise.
        return (id != 0);
    }
    public static DataObject readObject(Map <String, String> _map, String _table, String _class) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        // The Connector object returns a Hashmap of name-value pairs.
        HashMap<String, Object> results = connector.readObject(_map, _table);
        if (results == null) {
            return null;
        }
        try {
            // Here we create an object (cast as a generic DataBasePrototype.DataObject) and return it.
            return (DataObject) DataFactory.objectFactory(_class, results);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(DataStoreAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static Boolean updateObject(DataObject obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, IOException {
        return connector.updateObject(obj.getProperties(), obj.getUuid(), obj.getDataTable());
    }
    public static Boolean deleteObject(DataObject obj) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, NoSuchFieldException, IOException {
        obj.makeInactive();
        return DataStoreAdapter.updateObject(obj);
    }
}
