public abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem() {
        title = "Unknown";
        daysLate = 0;
    }

    public LibraryItem(String title, int daysLate) {
        this();
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public abstract long calculateFine();
}

class BookItem extends LibraryItem {
    public BookItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public long calculateFine() {
        return daysLate * 2L;
    }
}

class DVDItem extends LibraryItem {
    public DVDItem(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public long calculateFine() {
        if (daysLate == 0) {
            return 0;
        } else {
            return 10 + (daysLate * 5L);
        }
    }
}

