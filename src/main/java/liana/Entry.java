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
}
