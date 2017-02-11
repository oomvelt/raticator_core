package raticator;


import com.google.gson.Gson;

public class vTwoParser implements LineProtocolParser {

    private Gson g;

    public vTwoParser(){
        this.g = new Gson();
    }

    @Override
    public DataNode parseLine(String line) throws IllegalArgumentException {
        // heavily based on the v1 parser...

        // for this, it looks like this:

        // 0.2:{"time":1548084,"ypr":{"y":88.91,"p":1.02,"r":0.60},"acceleration":{"x":32,"y":-10,"r":-85}}

        line = line.trim();

        String parts[] = line.split(":", 2); // chop off front part

        if(! parts[0].equals("0.2")) {
            throw new IllegalArgumentException("Not a 0.2 line!: " + line);
        }

        DataNode dn = g.fromJson(parts[1], DataNode.class);

        return dn;

    }
}
