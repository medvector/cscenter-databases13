package liana;

/**
 * Created with IntelliJ IDEA.
 * User: lia
 * Date: 24.09.13
 * Time: 21:50
 * To change this template use File | Settings | File Templates.
 */
public class Entry {
    private String fullName;
    private String telephoneNumber;

    public Entry(String fullName, String telephoneNumber) {
        this.fullName = fullName;
        this.telephoneNumber = telephoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public static Entry parse(String line) {
        String[] tokens = line.split(" ");
        int n = tokens.length;
        if (n < 2) {
            throw new IllegalArgumentException("Some arguments are missing");
        }
        String telephone = tokens[n - 1];
        StringBuilder builder = new StringBuilder(tokens[0]);
        for (int i = 1; i < n - 1; i++) {
            builder.append(' ');
            builder.append(tokens[i]);
        }
        return new Entry(builder.toString(), telephone);
    }
}
