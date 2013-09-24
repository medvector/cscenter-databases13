package liana;

/**
 * Created with IntelliJ IDEA.
 * User: lia
 * Date: 24.09.13
 * Time: 23:01
 * To change this template use File | Settings | File Templates.
 */
public class Query {
    public enum Type {
        ADD,
        DELETE,
        GET,
        UPDATE
    }

    private String key;
    private Type type;
    private Entry entry;

    public Query(Type type, String key, Entry entry) {
        this.key = key;
        this.type = type;
        this.entry = entry;
    }

    public String getKey() {
        return key;
    }

    public Type getType() {
        return type;
    }

    public Entry getEntry() {
        return entry;
    }
}
