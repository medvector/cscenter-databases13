package liana;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: lia
 * Date: 24.09.13
 * Time: 21:33
 * To change this template use File | Settings | File Templates.
 */
public class TelephoneDirectory {
    private Map<String, Entry> data = new HashMap<String, Entry>();

    public boolean add(String nickname, Entry entry) {
        if (data.containsKey(nickname)) {
            return false;
        }
        data.put(nickname, entry);
        return true;
    }

    public Entry get(String nickname) {
        if (!data.containsKey(nickname)) {
            return null;
        }
        return data.get(nickname);
    }

    public boolean delete(String nickname) {
        if (!data.containsKey(nickname)) {
            return false;
        }
        data.remove(nickname);
        return true;
    }

    public boolean update(String nickname, Entry entry) {
        if (!data.containsKey(nickname)) {
            return false;
        }
        data.put(nickname, entry);
        return true;
    }

    public static TelephoneDirectory fromFile(String name) {
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        try {
            QueryInterpretator loader = new QueryInterpretator(new FileInputStream(name), null, telephoneDirectory, false);
            loader.eval();
        } catch (FileNotFoundException e) {
            File file = new File(name);
            try {
                file.createNewFile();
            } catch (IOException e1) {
                System.err.println("Can't create DB file");
            }
        }
        return telephoneDirectory;
    }
}
