package is.ru.honn.rufan.domain;

/**
 * Created by arnarkari on 20/09/15.
 *
 * @author arnarkari
 */
public class Position {

    private int positionId;
    private String name;
    private String abbreviation;
    private int sequence;

    public Position() {
    }

    public Position(int positionId, String name, String abbreviation, int sequence) {
        this.positionId = positionId;
        this.name = name;
        this.abbreviation = abbreviation;
        this.sequence = sequence;
    }
}
