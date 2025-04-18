import java.util.Iterator;
import java.util.NoSuchElementException;
public class HobbemounIterator extends Object implements Iterator<Hobbemoun> {
    private Hobbemoun nextHobbemoun;
    private HobbemounTree tree;

    public HobbemounIterator(HobbemounTree tree) {
        this.tree = tree;
        this.nextHobbemoun = tree.getWeakest();
    }

    @Override
    public boolean hasNext() {
        return nextHobbemoun != null;
    }

    @Override
    public Hobbemoun next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more Hobbemoun in the iterator.");
        }
        Hobbemoun current = nextHobbemoun;
        nextHobbemoun = tree.next(current);
        return current;
    }
}