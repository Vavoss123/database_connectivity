public class Venue {
    private int venueId;
    private String name;
    private int capacity;
    private String venueType;
    private String description;

    public Venue(int venueId, String name, int capacity, String venueType, String description) {
        this.venueId = venueId;
        this.name = name;
        this.capacity = capacity;
        this.venueType = venueType;
        this.description = description;
    }

    // Getters and setters
    public int getVenueId() { return venueId; }
    public void setVenueId(int venueId) { this.venueId = venueId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String getVenueType() { return venueType; }
    public void setVenueType(String venueType) { this.venueType = venueType; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
}
