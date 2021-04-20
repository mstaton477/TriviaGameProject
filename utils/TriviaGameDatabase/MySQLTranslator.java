package TriviaGameDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLTranslator implements DBTranslatorInterface {
    private static String db_URL = "jdbc:mysql://localhost:3306/playerdata";
    private static String db_Username = "root";
    private static String db_Password = "750463832";
    Connection conn = null;
    Statement statement = null;
    PreparedStatement pStatement = null;
    ResultSet resultSet = null;

    // Change this to true to just print out the queries and not execute them.
    private static final Boolean TEST_MODE = false;

    public MySQLTranslator() {
        // Initialize the connection at start-up.
        if (!MySQLTranslator.TEST_MODE) {
            this.connect();
        } else {
            System.out.println("==== TEST MODE ACTIVE: CHANGE TEST MODE PROPERTY TO EXECUTE ======");
        }
    }


    /**
     * Generates a MySQL specific string for saving objects to the database.
     * @param _keyValuePairs
     * @param _table
     * @return int
     */
    @Override
    public int createObject(Map<String, String> _keyValuePairs, String _table) {
        String query =  "INSERT INTO " + _table;
        String names = "(";
        String values = "VALUES (";
        for (Map.Entry<String, String> entry : _keyValuePairs.entrySet()){
            names+=  " `" + entry.getKey() + "`, ";
            values+= " '" + entry.getValue() + "', ";
        }
        // Trim off the last comma.
        names = names.substring(0, names.length() - 2);
        values = values.substring(0, values.length() - 2);
        names+= ") ";
        values+= ")";
        query+= names + values;
        // Execute the query.
        int newKey = this.executeInsert(query);
        if (newKey == -1) {
            System.out.println("Database Error: Could not create new record");
            return 0;
        }
        return newKey;
    }


    /**
     * This helper function runs the query given by the above method.
     * @TODO - See if we can consolidate this method with the other helper methods
     * below.
     * @param query
     * @return
     */
    private int executeInsert(String query){
        if (MySQLTranslator.TEST_MODE){
            System.out.println(query);
            return 3;
        }

        int key = -1;
        try {
            this.statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet result = statement.getGeneratedKeys();
            if (result.next()){
                key = result.getInt(1);
            }
        } catch (SQLException ex) {
            System.out.println("Query Error: " + ex.getMessage());
            Logger.getLogger(DataStoreAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        return key;
    }


    /**
     * Generates a MySQL query for updating an object to the database.
     * @param _keyValuePairs
     * @param _uuid
     * @param _table
     * @return Boolean
     */
    @Override
    public Boolean updateObject(Map<String,String> _keyValuePairs, String _uuid, String _table) {
        String query =  "UPDATE " + _table + " SET ";
        //iterate over map
        String updates = "";
        for (Map.Entry<String, String> entry : _keyValuePairs.entrySet()){
            updates+= " `" + entry.getKey() + "` = \"" + entry.getValue() + "\",";
        }
        //shed off the last comma
        updates = updates.substring(0, updates.length()-1);
        query = query + updates + " WHERE `uuid` = '" + _uuid + "'";
        return this.executeUpdate(query);
    }


    /**
     * This helper method runs the query generated by the updateObject method.
     * @param query
     */
    private Boolean executeUpdate(String query){
        if (MySQLTranslator.TEST_MODE){
            System.out.println(query);
            return true;
        }

        int result = 0;
        try {
            result = statement.executeUpdate(query, Statement.NO_GENERATED_KEYS);
        } catch (SQLException ex) {
            System.out.println("Query Error: " + ex.getMessage());
            Logger.getLogger(DataStoreAdapter.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Result returns the number of rows affected. If no rows were affected,
        // the return false.
        return (result > 0);
    }
    


        /**
         * Reads an object from the database given a set of conditionals in name-value
         * pair format. This is an overloaded readObject method that, by default, doesn't load deleted objects.
         * @TODO - Implement this method.
         * @param _keyValuePairs
         * @return
         */
    @Override
    public HashMap<String, Object> readObject(Map<String,String> _keyValuePairs, String _table) {
         return this.readObject(_keyValuePairs, _table, true);
    }

    /**
     * Same as above except allows the option of reading deleted objects from the database.
     * @param _keyValuePairs
     * @param _table
     * @param _deleted whether to load deleted objects.
     * @return
     */
   public HashMap<String, Object> readObject(Map<String,String> _keyValuePairs, String _table, boolean _deleted) {
        // Start the query.
        String query =  "SELECT * FROM " + _table + " WHERE ";
        // Initialize the condition string.
        String condition = "";
        // Iterate over map.
        for (Map.Entry<String, String> entry : _keyValuePairs.entrySet()){
            condition+= " `" + entry.getKey() + "` = \"" + entry.getValue() + "\" AND";
        }
        if (_deleted) {
            // Then we'll ignore the active=1 condition and just shed off the last AND
            condition = condition.substring(0, condition.length()-3);
        } else {
            // We'll add the condition that the object must be active.
            condition+= " `active` = 1";
        }
        // Combine the query with the condition.
        query = query + condition;
        // Initialize a object to store the results.
        HashMap<String, Object> returnData = new HashMap();
        ResultSet results = this.runQuery(query);
        // Create a flag for judging if the result set is empty.
        boolean isEmpty = true;
        try {
            while (results.next()) {
                isEmpty = false;
                ResultSetMetaData data = results.getMetaData();
                int count = data.getColumnCount();
                for (int i = 1; i <= count; i++) {
                    String columnName = data.getColumnName(i);
                    returnData.put(columnName, results.getObject(i));
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySQLTranslator.class.getName()).log(Level.SEVERE, null, ex);
        }
        // Close the statement connection.
        if (isEmpty) {
            // No results were loaded, return null.
            return null;
        }
        return returnData;
    }

    protected ResultSet runQuery(String query){
        if (MySQLTranslator.TEST_MODE){
            System.out.println(query);
            return null;
        }
        else {
            ResultSet result = null;
            try {
                result = statement.executeQuery(query);
            } catch (SQLException ex) {
                System.out.println("Query Error: " + ex.getMessage());
            }
            return result;
        }
    }

    /**
     *
     * @param _identifier
     * @param _table
     * @return
     * @throws SQLException
     */
    @Override
    public int deleteObject(String _identifier, String _table) throws SQLException {
        String query = "UPDATE " + _table + " SET active=0 WHERE id = " +_identifier;
        pStatement = conn.prepareStatement(query);
        int rowsDeleted = pStatement.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("A user was deleted successfully!");
        }
        return 1;
    }

    /**
     * This method sorts a table in a database and returns an arraylist of maps with the objects from the table
     * @param _table
     * @param _orderByParameter
     * @param _sortedList
     */

    public ArrayList sortTable(String _table, String _orderByParameter, ArrayList _sortedList) throws SQLException {

        try {
            statement = conn.createStatement();
            String query = "SELECT playerScore, name, id,gameDifficulty, gameLength,  category FROM " + _table + " ORDER BY " + _orderByParameter + " DESC ";
            resultSet = statement.executeQuery(query);
            //A loop that gets the properties of each row in the database and stores them in an Arraylist of Hashmaps in Descending order
            while (resultSet.next()) {
                ResultSetMetaData data = resultSet.getMetaData();
                int count = data.getColumnCount();
                for (int j = 1; j <= count-5; j++) {
                    HashMap playerProperties = new HashMap();
                    for(int i = 1; i <=6; i++){
                        String columnName = data.getColumnName(i);
                        playerProperties.put(columnName, resultSet.getObject(i));
                    }
                    _sortedList.add(playerProperties);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return _sortedList;
    }

    private void connect() {
        try {
            String host = db_URL;
            this.conn = DriverManager.getConnection(host, MySQLTranslator.db_Username, MySQLTranslator.db_Password);
            this.statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println("No Connection to DB: " + ex.getMessage());
        }
    }
}
