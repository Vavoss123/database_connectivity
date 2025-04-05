import java.sql.Timestamp;

public class Review {
    private int reviewId;
    private int performanceId;
    private String companyId;  // updated to match varchar(11)
    private int rating;
    private String comment;
    private Timestamp reviewDate;

    // Constructors
    public Review() {}

    public Review(int reviewId, int performanceId, String companyId, int rating, String comment, Timestamp reviewDate) {
        this.reviewId = reviewId;
        this.performanceId = performanceId;
        this.companyId = companyId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    // Getters and Setters
    public int getReviewId() { return reviewId; }
    public void setReviewId(int reviewId) { this.reviewId = reviewId; }

    public int getPerformanceId() { return performanceId; }
    public void setPerformanceId(int performanceId) { this.performanceId = performanceId; }

    public String getCompanyId() { return companyId; }
    public void setCompanyId(String companyId) { this.companyId = companyId; }

    public int getRating() { return rating; }
    public void setRating(int rating) { this.rating = rating; }

    public String getComment() { return comment; }
    public void setComment(String comment) { this.comment = comment; }

    public Timestamp getReviewDate() { return reviewDate; }
    public void setReviewDate(Timestamp reviewDate) { this.reviewDate = reviewDate; }
}
