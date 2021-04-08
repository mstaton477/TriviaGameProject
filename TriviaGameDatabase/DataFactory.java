package TriviaGameDatabase;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DataFactory {
    protected final String dataTable = "";

    /**
     * This method dynamically iterates over the calling class and all parent classes
     * and builds a HashMap of the name-value pairs of the properties meant to be saved to
     * the database. Stored properties include properties that are not static, not final, and
     * not public.
     * @return
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public Map getProperties() throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        // A transport data object for name-value pairs.
        Map<String,String> pairs = new HashMap<>();
        // Find out what the calling class is.
        Class<?> thisClass = this.getClass();
        // Iterate up through the chain of inherited clases until we hit a generic Object class.
        while (!thisClass.getName().equals("java.lang.Object")) {
            // Demonstrates moving up the chain of objects/
            System.out.println(thisClass.getName());
            // Get the fields of this class.
            Field[] fields = thisClass.getDeclaredFields();
            // Iterate through each.
            for(Field field : fields) {
                // Grab the name of this class property.
                String fieldName = field.getName();
                // Grab the modifiers that describe this property.
                int mods = field.getModifiers();
                // Make sure that this field is neither static, public or final.
                if (Modifier.isPublic(mods) || Modifier.isStatic(mods)|| Modifier.isFinal(mods)) {
                    // Shows which field is next.
                    System.out.println("-------- " + fieldName + ": Ignoring Field");
                    continue;
                }
                // If this is a boolean, make convert to an int.
                if (field.getType().toString().equals("boolean")) {
                    System.out.println("-------- " + fieldName + ": Converting from Boolean");
                    String fieldValue = (field.get(this).equals(true) ? "1" : "0");
                    pairs.put(fieldName, fieldValue);
                } else {
                    System.out.println("-------- " + fieldName + ": Adding Field");
                    // Grab this field's value and cast it as a string.
                    String fieldValue = field.get(this).toString();
                    // Add the name value pair to the map.
                    pairs.put(fieldName, fieldValue);
                }
            }
            // Move to the next parent class.
            thisClass = thisClass.getSuperclass();
        }
        // Return the hashmap of name-value pairs.
        return pairs;
    }

    /**
     * Similar to getProperties, this method dynamically iterates over a class and all of its
     * parent classes and sets the value of those properties to the corresponding value in the
     * HashMap that is returned from the database connector class.
     * This process assumes that the column name of the persistent data is the same as the property
     * name in the class.
     * @param _pairs
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    public void setProperties(HashMap _pairs) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
        // Grab the class type for this object.
        Class<?> thisClass = this.getClass();
        // Iterate up through the chain of inherited clases until we hit a generic Object class.
        while (!thisClass.getName().equals("java.lang.Object")) {
            // Get a list of fields for this class.
            Field[] fields = thisClass.getDeclaredFields();
            // Iterate through each.
            for(Field f : fields) {
                // Get the name of the field. This should correspond to the name of the name-value pairs.
                String fieldName = f.getName();
                // Get any modifiers for this property.
                int mods = f.getModifiers();
                // Make sure this property is neither static, public of final.
                if (!Modifier.isPublic(mods) && !Modifier.isStatic(mods) && !Modifier.isFinal(mods)) {
                    // Get the class type of this property.
                    Class type = f.getType();
                    // Find the class type and grab the associated setter to set the value.
                    if (type.toString().equals("int")) {
                        int fieldValue = (int) _pairs.get(fieldName);
                        f.setInt(this, fieldValue);
                    } else if (type.toString().equals("String")) {
                        String fieldValue = (String)_pairs.get(fieldName);
                        f.set(this, fieldValue);
                    } else if (type.toString().equals("double")) {
                        double fieldValue = (double)_pairs.get(fieldName);
                        f.setDouble(this, fieldValue);
                    }else if (type.toString().equals("float")) {
                        float fieldValue = (float)_pairs.get(fieldName);
                        f.setFloat(this, fieldValue);
                    }else if (type.toString().equals("char")) {
                        char fieldValue = (char)_pairs.get(fieldName);
                        f.setChar(this, fieldValue);
                    }else if (type.toString().equals("long")) {
                        long fieldValue = (long)_pairs.get(fieldName);
                        f.setLong(this, fieldValue);
                    } else if (type.toString().equals("short")) {
                        short fieldValue = (short)_pairs.get(fieldName);
                        f.setShort(this, fieldValue);
                    }else if (type.toString().equals("byte")) {
                        byte fieldValue = (byte)_pairs.get(fieldName);
                        f.setByte(this, fieldValue);
                    } else {
                        // Try a generic object type if it is not primitive. It should be primitive.
                        Object fieldValue = _pairs.get(fieldName);
                        f.set(this, fieldValue);
                    }
                }
            }
            // Iterate to the next parent class.
            thisClass = thisClass.getSuperclass();
        }
    }

    /**
     * This game factory method generates blank objects based on the class type given.
     * @param _class
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static Object objectFactory(String _class) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Class thisClass = Class.forName(_class);
        Object thisObject = thisClass.newInstance();
        thisClass.cast(thisObject);
        return thisObject;
    }

    /**
     * This game factory overloaded method generates new blank objects of the given type,
     * and then populates this object with the given name-value pairs loaded from the database.
     * @param _class
     * @param _data
     * @return
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws IllegalArgumentException
     * @throws InvocationTargetException
     */
    public static Object objectFactory(String _class, HashMap<String, Object> _data) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        // Generate a Class object based on the class name (ie. actors.Zombies);
        Class thisClass = Class.forName(_class);
        // Create an empty instance of this class.
        Object thisObject = thisClass.newInstance();
        // Create an array of class objects to represent the parameters for the setProperties method.
        Class[] params = new Class[1];
        params[0] = HashMap.class;
        // Create a method object based on the method name and list of parameters.
        Method thisMethod = thisClass.getMethod("setProperties", params);
        // Invoke the setProperties method.
        thisMethod.invoke(thisObject, _data);
        // Return the generic object.
        return thisObject;
    }

    /**
     * Returns the datatTable property value for any given class. Helpful for saving and reading
     * the database.
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    public String getDataTable() throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException {
        Class<?> thisClass = this.getClass();
        Field field = thisClass.getDeclaredField("dataTable");
        return field.get(this).toString();
    }

    /**
     * Returns the class name of this object.
     * @return
     */
    public String getClassName() {
        return this.getClass().getName();
    }

    /**
     * Generic method for loading an object's data by any given condition.
     * @param _data
     * @return
     */
    public TriviaGameDatabase.DataObject loadByCondition(HashMap<String, String> _data) {
        try {
            // Given an empty object, this method fills this object with data from the database.
            return DataStoreAdapter.readObject(_data, this.getDataTable(), this.getClassName());
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException | ClassNotFoundException | InstantiationException | NoSuchMethodException | InvocationTargetException ex) {
            Logger.getLogger(DataObject.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }
}
