package net.kosinak.network;

public class Package {

    public String TYPE;
    public String OWNER;
    public String DEST;
    public String MESSAGE;
    public String KEY;

    public Package(String TYPE, String OWNER, String DEST, String MESSAGE, String KEY) {
        this.TYPE = TYPE;
        this.OWNER = OWNER;
        this.DEST = DEST;
        this.MESSAGE = MESSAGE;
        this.KEY = KEY;
    }

    @Override
    public String toString() {
        return '{' +
                "\"TYPE\":\"" + TYPE + '\"' +
                ",\"OWNER\":\"" + OWNER + '\"' +
                ",\"DEST\":\"" + DEST + '\"' +
                ",\"MESSAGE\":\"" + MESSAGE + '\"' +
                ",\"KEY\":\"" + KEY + '\"' +
                '}';
    }
}
