package raticator;


import com.google.gson.Gson;

public class vOneParser implements LineProtocolParser {

    private Gson g;

    public vOneParser(){
        this.g = new Gson();
    }

    @Override
    public DataNode parseLine(String line) throws IllegalArgumentException {
        // for this, it looks like this:
        // 0.1:{"t":2678,"y":3.99,"p":3.12,"r":-22.62,"X":-10,"Y":2965,"Z":-796}

        line = line.trim();

        String parts[] = line.split(":", 2); // chop off front part

        if(! parts[0].equals("0.1")) {
            throw new IllegalArgumentException("Not a 0.1 line!");
        }

        DataNode dn = g.fromJson(parts[1], DataNode.class);

        return dn;

    }
}
