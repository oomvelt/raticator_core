package raticator;


public interface LineProtocolParser {

    DataNode parseLine(String line) throws IllegalArgumentException;

}
