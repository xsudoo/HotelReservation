import java.util.Arrays;

public class Room {

    private int number;
    private BedType[] bed;

    public Room(int number, BedType[] bed) {
        this.number = number;
        this.bed = bed;
    }

    @Override
    public String toString() {
        return "Room{" +
                "number=" + number +
                ", bed=" + Arrays.toString(bed) +
                '}';
    }

    public String getInfo(){
        return String.format("Dodano nowy pokoj nr : %d %s", this.number, Arrays.toString(this.bed));
    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BedType[] getBed() {
        return bed;
    }

    public void setBed(BedType[] bed) {
        this.bed = bed;
    }
}
