package DataBasePrototype;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TextFileTranslator implements DBTranslatorInterface {
    public int createObject(Map<String, String> _keyValuePairs, String _table) throws IOException {
        File file = new File("TestDatabase.txt");
        BufferedWriter bf = null;
       try {
            bf = new BufferedWriter(new FileWriter(file));
            for (Map.Entry<String, String> entry : _keyValuePairs.entrySet()){
                bf.write(entry.getKey()+ " = " + entry.getValue()+ " | ");
            }
            bf.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bf.close();
            }
            catch (Exception e){

            }
        }
        return 0;
    }
    public HashMap<String, Object> readObject(Map<String,String> _keyValuePairs, String _table, boolean _deleted){
        HashMap<String, Object> returnData = new HashMap();
        try {
            Scanner in = new Scanner(new FileReader("TestDatabase.txt"));
            while(in.hasNextLine())
                System.out.println(in.nextLine());

        }
        catch(Exception e){}
        return returnData;
    }
    public HashMap<String, Object> readObject(Map<String,String> _keyValuePairs, String _table){
        return this.readObject(_keyValuePairs, _table, false);
    }

    public Boolean updateObject(Map<String,String> _keyValuePairs, String _uuid, String _table){
        return true;
    }

    public Boolean deleteObject(String uuid) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
