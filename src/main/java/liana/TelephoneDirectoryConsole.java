package liana;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import static liana.Query.Type.ADD;

/**
 * Created with IntelliJ IDEA.
 * User: lia
 * Date: 24.09.13
 * Time: 22:56
 * To change this template use File | Settings | File Templates.
 */
public class TelephoneDirectoryConsole {

    public static void main(String[] args) {
        TelephoneDirectory telephoneDirectory = new TelephoneDirectory();
        QueryInterpretator interpretator = new QueryInterpretator(System.in, System.out, telephoneDirectory);
        interpretator.eval();
    }
}
