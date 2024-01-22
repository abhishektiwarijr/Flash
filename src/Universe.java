import java.util.ArrayList;
import java.util.List;

class Universe implements Cloneable {
    public Universe() {}
    private List<String> galaxies = new ArrayList<String >();
    private List<String> stars = new ArrayList<String >();

    @Override
    public Universe clone() {
        try {
            Universe clone = (Universe) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}