package raticator;


public class SimpleBehaviour implements Behaviour {
    private StateChangeCallback myCallback = null;

    private RatState currentState;

    private float oldY;



    public void setup(StateChangeCallback sc) {
        this.myCallback = sc;

        this.currentState = RatState.STATIONARY;

        this.oldY = (float) 0.0;
    }



    public void feedEntry (DataNode dn) {
        //System.out.println(dn.y);

        if( oldY - dn.y > 1 || dn.y - oldY > 1) {
            // assume mving
            this.setState(RatState.MOVING);

        } else {
            // assume stationary
            this.setState(RatState.STATIONARY);
        }

        this.oldY = dn.y;

    }

    private void setState(RatState state) {
        // only action on a state change
        if (this.currentState != state) {
            this.currentState = state;
            this.myCallback.StateChanged(state);
        }
    }
}