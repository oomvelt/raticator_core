package raticator;

public class DataNode {

    // 0.1:{"t":2678,"y":3.99,"p":3.12,"r":-22.62,"X":-10,"Y":2965,"Z":-796}
    // 0.2:{"time":1548084,"ypr":{"y":88.91,"p":1.02,"r":0.60},"acceleration":{"x":32,"y":-10,"r":-85}}



    public int time;
    public YPR ypr;
    public Acceleration acceleration;


    public DataNode(){}

    public DataNode (int time, YPR ypr, Acceleration acceleration) {

        this.time = time;
        this.ypr = ypr;
        this.acceleration = acceleration;

    }

    public class YPR {

        public float y;
        public float p;
        public float r;

        public YPR (float y, float p, float r) {
            this.y = y;
            this.p = p;
            this.r = r;
        }

    }

    public class Acceleration {
        public int x;
        public int y;
        public int z;

        public Acceleration(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
