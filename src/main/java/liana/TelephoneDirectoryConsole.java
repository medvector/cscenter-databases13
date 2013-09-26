package liana;

import java.io.*;

import static liana.Query.Type.ADD;

/**
 * Created with IntelliJ IDEA.
 * User: lia
 * Date: 24.09.13
 * Time: 22:56
 * To change this template use File | Settings | File Templates.
 */
public class TelephoneDirectoryConsole {


    private static void info() {
        System.out.println("TELEPHONE DIRECTORY");
        System.out.println("queries:\n"
                + "add <nickname> <fullname> <telephone>\n"
                + "get <nickname>\n"
                + "update <nickname> <fullname> <telephone>\n"
                + "delete <nickname>");
    }

    public static void main(String[] args) throws FileNotFoundException {
        info();
        TelephoneDirectory telephoneDirectory = TelephoneDirectory.fromFile(QueryInterpretator.DB_FILE_NAME);
        QueryInterpretator interpretator = new QueryInterpretator(System.in, System.out,
                telephoneDirectory, true);
        interpretator.eval();

    }
}
