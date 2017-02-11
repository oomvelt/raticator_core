package raticator;


import com.google.gson.Gson;

@Deprecated
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
            throw new IllegalArgumentException("Not a 0.1 line!: " + line);
        }

        V1DataNode dn = g.fromJson(parts[1], V1DataNode.class);

        return dn.toDataNode();

    }


    private class V1DataNode {

            // 0.1:{"t":2678,"y":3.99,"p":3.12,"r":-22.62,"X":-10,"Y":2965,"Z":-796}

            public int t;
            public float y;
            public float p;
            public float r;

            public int X;
            public int Y;
            public int Z;

            public V1DataNode (int t, int y, int p, int r, int X, int Y, int Z) {

                this.t = t;
                this.y = y;
                this.p = p;
                this.r = r;
                this.X = X;
                this.Y = Y;
                this.Z = Z;
            }

            public DataNode toDataNode(){
                DataNode dn = new DataNode();
                dn.ypr = dn.new YPR((float) this.y, (float) this.p, (float) this.r);
                dn.acceleration =  dn.new Acceleration(this.X, this.Y, this.Z);

                return dn;

            }
    }
}
