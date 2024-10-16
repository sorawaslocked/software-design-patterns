package behavioral.handlers;

public abstract class Handler {
    private Handler next;

    public static Handler link(Handler first, Handler... chain) {
        Handler head = first;

        for (Handler next : chain) {
            head.next = next;
            head = next;
        }

        return first;
    }

    public abstract boolean handle();

    protected boolean handleNext() {
        if (next == null) {
            return true;
        }

        return next.handle();
    }
}
