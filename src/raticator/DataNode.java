package raticator;

/**
 * Created by jt on 05/02/2017.
 */
public class DataNode {

    // 0.1:{"t":2678,"y":3.99,"p":3.12,"r":-22.62,"X":-10,"Y":2965,"Z":-796}

    public int t;
    public float y;
    public float p;
    public float r;

    public float X;
    public float Y;
    public float Z;

    public DataNode (int t, int y, int p, int r, int X, int Y, int Z) {

        this.t = t;
        this.y = y;
        this.p = p;
        this.r = r;
        this.X = X;
        this.Y = Y;
        this.Z = Z;

    }

}
