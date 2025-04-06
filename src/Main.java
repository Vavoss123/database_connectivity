import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Timestamp start = Timestamp.valueOf("2025-04-06 12:00:00");
        Timestamp end = Timestamp.valueOf("2025-04-06 14:00:00");
        Date date = Date.valueOf("2025-04-06");

        // 1. Create Venue
        //Venue venue = new Venue(0, "Main Hall", 200, "Concert", "Modern hall with premium acoustics.");
        //VenueDAO.insertVenue(venue);

        // --- R: Read all venues
        List<Venue> venues = VenueDAO.getAllVenues();
        venues.forEach(System.out::println);

        // --- U: Update venue
        Venue updatedVenue = new Venue(0, "Main Hall",  374, "Concert", "Modern hall with premium acoustics.");
        VenueDAO.updateVenue(updatedVenue);

        // --- D: Delete venue
        // VenueDAO.deleteVenue(1);

        // 2. Create Performance
        //Performance performance = new Performance(0, "Spring Gala", "An evening of music and dance.", "Concert", start, end, 1);
        //PerformanceDAO.insertPerformance(performance);

        // --- R
        //Performance p = PerformanceDAO.getPerformanceById(1);
        //System.out.println(p);

        // --- U
        //Performance updatedPerformance = new Performance(0, "Summer Gala", "Updated event desc", "Opera", start, end, 1);
        //PerformanceDAO.updatePerformance(updatedPerformance);

        // --- D
        // PerformanceDAO.deletePerformance(1);

        // 3. Create Client
        //Clients client = new Clients("C001", "Nova Events", "Clara Oswald", "clara@nova.com", "07700900000",
        // "123 High Street", "London", "NW1 2AB", "Nova Billing", "billing@nova.com");
        //ClientsDAO.insertClient(client);

        // --- R
        //Clients retrievedClient = ClientsDAO.getClientById("C001");
        //System.out.println(retrievedClient);

        // --- U
        //retrievedClient.setContactName("Clara O.");
        //ClientsDAO.updateClient(retrievedClient);

        // --- D
        // ClientsDAO.deleteClient("C001");

        // 4. Create Booking
        //Booking booking = new Booking(0, "C001", 1, now, date, date, 150.0, 2);
        //BookingDAO.insertBooking(booking);

        // --- R
        //Booking retrievedBooking = BookingDAO.getBookingById(1);
        //System.out.println(retrievedBooking);

        // --- U
        //booking.setTotalCost(180.0);
        //BookingDAO.updateBooking(booking);

        // --- D
        // BookingDAO.deleteBooking(1);

        // 5. Create Seat
        //Seat seat = new Seat(0, 1, "A", 10, true);
        //SeatDAO.insertSeat(seat);

        // --- R
        Seat retrievedSeat = SeatDAO.getSeatById(1);
        System.out.println(retrievedSeat);

        // --- U
        //seat.setRowLabel("B");
        //SeatDAO.updateSeat(seat);

        // --- D
        // SeatDAO.deleteSeat(1);

        // 6. Create Discount
        //Discount discount = new Discount(0, "Early Bird", 10.0, Date.valueOf("2025-04-01"), Date.valueOf("2025-04-07"));
        //DiscountDAO.insertDiscount(discount);

        // --- R
        //Discount retrievedDiscount = DiscountDAO.getDiscountById(1);
        //System.out.println(retrievedDiscount);

        // --- U
        //discount.setDiscountRate(15.0);
        //DiscountDAO.updateDiscount(discount);

        // --- D
        // DiscountDAO.deleteDiscount(1);

        // 7. Create Ticket
        //Ticket ticket = new Ticket(0, 1, 1, 75.00, 1, now);
        //TicketDAO.insertTicket(ticket);

        // --- R
        //Ticket retrievedTicket = TicketDAO.getTicketById(1);
        //System.out.println(retrievedTicket);

        // --- U
        //ticket.setPrice(85.00);
        //TicketDAO.updateTicket(ticket);

        // --- D
        // TicketDAO.deleteTicket(1);

        // 8. Create Review
        //Review review = new Review(0, 1, "C001", 5, "Outstanding show!", now);
        //ReviewDAO.insertReview(review);

        // --- R
        //Review retrievedReview = ReviewDAO.getReviewById(1);
        //System.out.println(retrievedReview);

        // --- U
        //review.setComment("Excellent and immersive!");
        //ReviewDAO.updateReview(review);

        // --- D
        // ReviewDAO.deleteReview(1);

        // 9. Create Revenue
        //Revenue revenue = new Revenue(0, 1, 150.0, now);
        //RevenueDAO.insertRevenue(revenue);

        // --- R
        //Revenue retrievedRevenue = RevenueDAO.getRevenueById(1);
        //System.out.println(retrievedRevenue);

        // --- U
        //revenue.setTotalAmount(175.0);
        //RevenueDAO.updateRevenue(revenue);

        // --- D
        // RevenueDAO.deleteRevenue(1);

        // 10. Create Film
        //Film film = new Film(0, 1, 120, "Paramount", 1000.0);
        //FilmDAO.insertFilm(film);

        // --- R
        //Film retrievedFilm = FilmDAO.getFilmById(1);
        //System.out.println(retrievedFilm);

        // --- U
        //film.setRuntime(130);
        //FilmDAO.updateFilm(film);

        // --- D
        // FilmDAO.deleteFilm(1);

        System.out.println("\n✅ CRUD test completed!");
    }
}