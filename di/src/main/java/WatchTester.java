public class WatchTester {
    private Watch watch;

    public void setWatch(Watch watch) {
        this.watch = watch;
    }

    public void run() {
        System.out.println("getDate() returns " + watch.getDate());
        System.out.println("getTime() returns " + watch.getTime());
    }
}
