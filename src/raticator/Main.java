package raticator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.List;

public class Main {

    private static class TestRigCallback implements StateChangeCallback {

        public void StateChanged(RatState newState) {

            System.out.println("The rat's state has changed. It is now: " + newState);

        }
    }

    public static void main(String[] args) {

        System.out.println("Eraticator Test Rig - Commandline");

        if(args.length ==0 ) {
            System.err.println("You must provide at least one argument - the file path of the test data");
            return;
        }

        String target = args[0];
        System.out.println(target);

        TestRigCallback trc = new TestRigCallback();

        System.out.println("Picking behaviour script and initalising with testrig callback.");

        Behaviour beh = new SimpleBehaviour();
        beh.setup(trc);

        System.out.println("Picking Data Parser ");

        //LineProtocolParser lpp = new vOneParser();
        LineProtocolParser lpp = new vTwoParser();

        System.out.println("Behaviour configured with test rig callback...");

        System.out.println("Loading Sample file");

        try (BufferedReader br = new BufferedReader(new FileReader(target))) {
            String line;
            while ((line = br.readLine()) != null) {
                try {
                    DataNode dn = lpp.parseLine(line);

                    beh.feedEntry(dn);

                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

        } catch (Exception e) {
            System.out.println("There was a fundamental error in the program - bombing out");
            System.out.println(e);
        }

        System.out.println("Sample run finished!");

    }


}

