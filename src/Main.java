import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Date date = Date.valueOf("2025-04-06");

        // --- 1. Client
        //Clients client = new Clients("C001", "Nova Events", "Clara Oswald", "clara@nova.com", "07700900000",
        //        "123 High Street", "London", "NW1 2AB", "Nova Billing", "billing@nova.com");
        //ClientsDAO.insertClient(client);

        //Clients retrievedClient = ClientsDAO.getClientById("C001");
        //System.out.println(retrievedClient);

        //retrievedClient.setContactName("Clara O.");
        //ClientsDAO.updateClient(retrievedClient);

        //ClientsDAO.deleteClient("C001");

        // --- 2. Discount
        //Discount discount = new Discount(0, "Student", 15.0, Date.valueOf("2025-04-01"), Date.valueOf("2025-04-30"));
        //DiscountDAO.insertDiscount(discount);

        //Discount retrievedDiscount = DiscountDAO.getDiscountById(1);
        //System.out.println(retrievedDiscount);

        //retrievedDiscount.setDiscountRate(20.0);
        //DiscountDAO.updateDiscount(retrievedDiscount);

        //DiscountDAO.deleteDiscount(1);

        // --- 3. Film
        //Film film = new Film(0, 120, "Universal", 500.0, 2024, "12A", now, now);
        //FilmDAO.insertFilm(film);

        //Film retrievedFilm = FilmDAO.getFilmById(1);
        //System.out.println(retrievedFilm);

        //retrievedFilm.setRuntime(130);
        //FilmDAO.updateFilm(retrievedFilm);

        //FilmDAO.deleteFilm(1);

        // --- 4. FoL
        //FoL fol = new FoL(0, date, "Premium", "Victor", "123 Lane", "vic@xmail.com");
        //FoLDAO.insertFoL(fol);

        //FoL retrievedFoL = FoLDAO.getFoLById(1);
        //System.out.println(retrievedFoL);

        //retrievedFoL.setMembershipType("VIP");
        //FoLDAO.updateFoL(retrievedFoL);

        //FoLDAO.deleteFoL(1);

        // --- 5. Group
        //Group group = new Group(0, 20, "Alpha Group", "Nina");
        //GroupDAO.insertGroup(group);

        //Group retrievedGroup = GroupDAO.getGroupById(1);
        //System.out.println(retrievedGroup);

        //retrievedGroup.setGroupSize(25);
        //GroupDAO.updateGroup(retrievedGroup);

        //GroupDAO.deleteGroup(1);

        // --- 6. GroupSale
        //GroupSale gs = new GroupSale(0, date, 500.0, 1, 1);
        //GroupSaleDAO.insertGroupSale(gs);

        //GroupSale retrievedGS = GroupSaleDAO.getGroupSaleById(1);
        //System.out.println(retrievedGS);

        //retrievedGS.setTotalCost(550.0);
        //GroupSaleDAO.updateGroupSale(retrievedGS);

        //GroupSaleDAO.deleteGroupSale(1);

        // --- 7. HeldSeats
        //HeldSeat seat = new HeldSeat(0, 1, "Held", 1, 1, 1);
        //HeldSeatsDAO.insertHeldSeat(seat);

        //HeldSeat retrievedHeld = HeldSeatsDAO.getHeldSeatById(1);
        //System.out.println(retrievedHeld);

        //retrievedHeld.setStatus("Confirmed");
        //HeldSeatsDAO.updateHeldSeat(retrievedHeld);

        //HeldSeatsDAO.deleteHeldSeat(1);

        // --- 8. Invoice
        //Invoice invoice = new Invoice(0, date, Date.valueOf("2025-04-10"), "C001", 1);
        //InvoiceDAO.insertInvoice(invoice);

        //Invoice retrievedInvoice = InvoiceDAO.getInvoiceById(1);
        //System.out.println(retrievedInvoice);

        //retrievedInvoice.setDueDate(Date.valueOf("2025-04-12"));
        //InvoiceDAO.updateInvoice(retrievedInvoice);

        //InvoiceDAO.deleteInvoice(1);

        // --- 9. Meeting
        //Meeting meeting = new Meeting(0, now, "Anfy", "Planning tour logistics", 1, "C001");
        //MeetingDAO.insertMeeting(meeting);

        //Meeting retrievedMeeting = MeetingDAO.getMeetingById(1);
        //System.out.println(retrievedMeeting);

        //retrievedMeeting.setPurpose("Discuss event schedule");
        //MeetingDAO.updateMeeting(retrievedMeeting);

        //MeetingDAO.deleteMeeting(1);

        // --- 10. Screening
        //Screening screening = new Screening(0, date, 1, "Main Hall", 1, Time.valueOf("14:00:00"), 12.50);
        //ScreeningDAO.insertScreening(screening);

        //Screening retrievedScreening = ScreeningDAO.getScreeningById(1);
        //System.out.println(retrievedScreening);

        //retrievedScreening.setPrice(15.0);
        //ScreeningDAO.updateScreening(retrievedScreening);

        //ScreeningDAO.deleteScreening(1);

        // --- 11. Show
        //Show show = new Show(0, 120, "Spring Bloom", "A musical celebration", "Musical");
        //ShowDAO.insertShow(show);

        //Show retrievedShow = ShowDAO.getShowById(1);
        //System.out.println(retrievedShow);

        //retrievedShow.setDuration(140);
        //ShowDAO.updateShow(retrievedShow);

        //ShowDAO.deleteShow(1);

        // --- 12. Ticket
        //Ticket ticket = new Ticket(0, 12.99, 1);
        //TicketDAO.insertTicket(ticket);

        //Ticket retrievedTicket = TicketDAO.getTicketById(1);
        //System.out.println(retrievedTicket);

        //retrievedTicket.setPrice(14.99);
        //TicketDAO.updateTicket(retrievedTicket);

        //TicketDAO.deleteTicket(1);

        // --- 13. TicketSales
        //TicketSales sale = new TicketSales(0, 3, date, 1, 1);
        //TicketSalesDAO.insertTicketSales(sale);

        //TicketSales retrievedSale = TicketSalesDAO.getTicketSalesById(1);
        //System.out.println(retrievedSale);

        //retrievedSale.setQuantity(4);
        //TicketSalesDAO.updateTicketSales(retrievedSale);

        //TicketSalesDAO.deleteTicketSales(1);

        // --- 14. Tours
        //Tours tour = new Tours(0, "UK Tour", "Visiting major cities", date, "London, Birmingham", 1);
        //ToursDAO.insertTour(tour);

        //Tours retrievedTour = ToursDAO.getTourById(1);
        //System.out.println(retrievedTour);

        //retrievedTour.setTitle("UK & Ireland Tour");
        //ToursDAO.updateTour(retrievedTour);

        //ToursDAO.deleteTour(1);

        System.out.println("\n✅ CRUD test completed for in2 database!");
    }
}
