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

    public static void main(String[] args) throws FileNotFoundException {
        TelephoneDirectory telephoneDirectory = TelephoneDirectory.fromFile(QueryInterpretator.DB_FILE_NAME);
        QueryInterpretator interpretator = new QueryInterpretator(System.in, System.out,
                telephoneDirectory, true);
        interpretator.eval();

    }
}
