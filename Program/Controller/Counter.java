package Program.Controller;

public class Counter implements AutoCloseable {
    /**
     * Класс счетчика
     */
    private int count = 0;

    public void add() {
        count++;
    }

    public int getCount() {
        return count;
    }

    @Override
    public void close() throws Exception {
        if (count == 0)
            throw new Exception("Счетчик не был увеличен, или ресурс не был закрыт.");
    }
}