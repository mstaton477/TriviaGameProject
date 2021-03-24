package DataBasePrototype;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public interface DBTranslatorInterface {
    public abstract int createObject(Map<String,String> _keyValuePairs, String _table) throws IOException;

    public abstract HashMap<String, Object> readObject(Map<String,String> _keyValuePairs, String _table);

    public abstract Boolean updateObject(Map<String,String> _keyValuePairs, String _uuid, String _table);

    public abstract Boolean deleteObject(String uuid);

}
