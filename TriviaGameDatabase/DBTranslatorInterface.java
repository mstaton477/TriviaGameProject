package TriviaGameDatabase;

/**
 * The DBConnectorInterface interface describes the methods that must be implemented for
 * any database class that is expected to work with this system.
 * The basic CRUD operations are detailed below, but more advanced features,
 * including loading by name, uuid, id or type can be added.
 * @author Patrick
 */

import java.util.HashMap;
import java.util.Map;


public interface DBTranslatorInterface {

    public abstract int createObject(Map<String,String> _keyValuePairs, String _table);

    public abstract HashMap<String, Object> readObject(Map<String,String> _keyValuePairs, String _table);

    public abstract Boolean updateObject(Map<String,String> _keyValuePairs, String _uuid, String _table);

    public abstract Boolean deleteObject(String uuid, String _table);

    //public abstract Boolean sortTable(String _table, String _sortingParameter);

}
