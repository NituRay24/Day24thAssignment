import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.*;
public class UC10 {
    public static void basedOnCustomerType(ArrayList<Hotel> hotelsList) throws InvalidEntryException {

        Scanner scanner = new Scanner(System.in);
        Hotel hotelbestRate = null;
        ArrayList<Hotel> hotels = new ArrayList<>();

        Map<Integer,String> days = new HashMap<>();
        String[] day = {"Sun","Mon","Tues","Wed","Thurs","Fri","Sat"};

        LocalDate localDate = LocalDate.of(2021, 8, 10);
        java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        int a = dayOfWeek.getValue();

        LocalDate dateBefore = LocalDate.of(2021, Month.SEPTEMBER, 10);
        LocalDate dateAfter = LocalDate.of(2021, Month.SEPTEMBER, 11);
        long noOfDays = ChronoUnit.DAYS.between(dateBefore, dateAfter);

        // Store date With its day
        int i = 10;
        int Total = (int) (noOfDays + i + 1);
        while ( i != Total){
            int j = a;
            days.put(i, day[j]);
            i++;
            if(j == 6)
                a = 0;
            a++;
        }

        // Store WeekDays and WeekEnds in separately
        int count1 = 0;
        int count2 = 0;

        for (Map.Entry<Integer, String> entry : days.entrySet()) {
            String day1 = entry.getValue();
            if(day1.equals(day[0]) || day1.equals(day[1]) || day1.equals(day[2]) || day1.equals(day[3]) || day1.equals(day[4]))
                count1++;
            else
                count2++;
        }

        System.out.println("Enter the Customer Category");
        System.out.println("Press 1 - Reword");
        System.out.println("Press 2 - Regular");
        int option = scanner.nextInt();

        if(option == 1){

            // getHotel of Minimum Per Day for WeekEnds and WeekDays
            Hotel hotelcheap1 = hotelsList.stream().filter(x -> x.customerType == Hotel.Customer.REWORD).min(Comparator.comparingInt(Hotel::getWeekDayRate)).get();
            Hotel hotelcheap2 = hotelsList.stream().filter(x -> x.customerType == Hotel.Customer.REWORD).max(Comparator.comparingInt(Hotel::getWeekEndRate)).get();

            hotels.add(hotelcheap1);
            hotels.add(hotelcheap2);

            // Finding the BestRated hotel with cheapRate
            hotelbestRate = hotels.stream().max(Comparator.comparingInt(Hotel::getRating)).get();

        }
        else
            // For Invalid Entries Exception will be throwed
            try {
                throw new InvalidEntryException("\nYour are Regular customer . So Not allowed to access the reword customer Benifits");
            }
            catch (InvalidEntryException e){
                System.out.println("Please choose correct One");
            }

        System.out.println("\nCheapest Hotel = " +hotelbestRate.getHotelName());
        System.out.println("Total Rate     = " + ((hotelbestRate.getWeekDayRate() * count1) + (hotelbestRate.getWeekEndRate() * count2)));
    }

}
