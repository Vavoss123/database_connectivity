public class Group {
    private int groupId;
    private int groupSize;
    private String name;
    private String contactPerson;

    // Constructors
    public Group() {}

    public Group(int groupId, int groupSize, String name, String contactPerson) {
        this.groupId = groupId;
        this.groupSize = groupSize;
        this.name = name;
        this.contactPerson = contactPerson;
    }

    // Getters and Setters
    public int getGroupId() { return groupId; }
    public void setGroupId(int groupId) { this.groupId = groupId; }

    public int getGroupSize() { return groupSize; }
    public void setGroupSize(int groupSize) { this.groupSize = groupSize; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getContactPerson() { return contactPerson; }
    public void setContactPerson(String contactPerson) { this.contactPerson = contactPerson; }
}
