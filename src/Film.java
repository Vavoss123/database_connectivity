public class Film {
    private int filmId;
    private int performanceId;
    private int runtime;
    private String distributor;
    private double cost;

    // Constructors
    public Film() {}

    public Film(int filmId, int performanceId, int runtime, String distributor, double cost) {
        this.filmId = filmId;
        this.performanceId = performanceId;
        this.runtime = runtime;
        this.distributor = distributor;
        this.cost = cost;
    }

    // Getters and Setters
    public int getFilmId() { return filmId; }
    public void setFilmId(int filmId) { this.filmId = filmId; }

    public int getPerformanceId() { return performanceId; }
    public void setPerformanceId(int performanceId) { this.performanceId = performanceId; }

    public int getRuntime() { return runtime; }
    public void setRuntime(int runtime) { this.runtime = runtime; }

    public String getDistributor() { return distributor; }
    public void setDistributor(String distributor) { this.distributor = distributor; }

    public double getCost() { return cost; }
    public void setCost(double cost) { this.cost = cost; }
}
