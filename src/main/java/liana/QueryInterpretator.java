package liana;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: lia
 * Date: 27.09.13
 * Time: 0:19
 * To change this template use File | Settings | File Templates.
 */
public class QueryInterpretator {
    public static final String DB_FILE_NAME = "database";
    BufferedReader input;
    PrintWriter output;
    PrintWriter dbWriter;
    TelephoneDirectory td;
    boolean isSavable;

    public QueryInterpretator(InputStream is, OutputStream os,
                              TelephoneDirectory td, boolean isSavable) {
        this.input = new BufferedReader(new InputStreamReader(is));
        this.output = new PrintWriter(os, true);
        this.td = td;
        this.isSavable = isSavable;
        if (isSavable) {
            try {
                this.dbWriter = new PrintWriter(new FileWriter(DB_FILE_NAME, true));
            } catch (IOException e) {
                System.err.println("Something wrong with database file");
            }
        }
    }

    private void print(String line) {
        if (output != null) {
            output.println(line);
        }
    }

    public void eval() {
        print("Enter queries:");
        try {
            String line = null;
            while ((line = input.readLine()) != null) {
                Query q;
                try {
                    q = Query.parse(line);
                } catch (IllegalArgumentException iae) {
                    print(iae.getMessage());
                    continue;
                }
                switch (q.getType()) {
                    case ADD:
                        if (!td.add(q.getKey(), q.getEntry())) {
                            print("Addition is not successful");
                            continue;
                        }
                        break;
                    case GET:
                        Entry res = td.get(q.getKey());
                        if (res == null) {
                            print("Getting isn't successful");
                            continue;
                        } else {
                            print(res.toString());
                        }
                        break;
                    case UPDATE:
                        if (!td.update(q.getKey(), q.getEntry())) {
                            print("Updating is not successful");
                            continue;
                        }
                        break;
                    case DELETE:
                        if (!td.delete(q.getKey())) {
                            print("Deleting is not successful");
                            continue;
                        }
                        break;
                }
                if (isSavable && dbWriter != null) {
                    dbWriter.println(line);
                }
            }
        } catch (IOException e) {
            System.err.println("Something wrong with console: " + e);
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                // close silently
            }
            if (output != null) {
                output.close();
            }
            if (dbWriter != null) {
                dbWriter.close();
            }
        }
    }

}
