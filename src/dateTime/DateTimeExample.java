package dateTime;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class DateTimeExample {
    public static void main(String[] args) {
        // класс Date()
        Date date = new Date();
        Date other = new Date();
        date.after(other); // boolean
        date.before(other); // boolean
        date.compareTo(other); // int
        System.out.println(date);

        SimpleDateFormat dateFormat =
                new SimpleDateFormat("День: dd Месяц: MM Год: yyyy HH:mm");
        System.out.println(dateFormat.format(date));

        Calendar calendar = new GregorianCalendar();
        Calendar calendar1 = new GregorianCalendar(2019, Calendar.APRIL, 12);
        // увеличение
        calendar1.add(Calendar.DAY_OF_MONTH, 2);
        // уменьшение
        calendar1.add(Calendar.MONTH, -3);

        System.out.println(calendar1.get(Calendar.MONTH));
        System.out.println(calendar1.getTime());


        // Java 8 Date Time API
//        LocalDate, LocalTime, LocalDateTime, Period, Duration
        System.out.println("Java 8 Date Time API");
        System.out.println("LocalDate");
        LocalDate dateNow = LocalDate.now();
        System.out.println(dateNow);

        // DateTimeException:
//        LocalDate someDate = LocalDate.of(2019, Month.JUNE, 56);
//        System.out.println(someDate);

        LocalDate someDate = LocalDate.of(2019, Month.JUNE, 15);
        System.out.println(someDate);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        String strDate = "14/04/2018";

        LocalDate parseDate = LocalDate.parse(strDate, dateTimeFormatter);
        System.out.println(parseDate);

        System.out.println(dateNow.plusDays(1));
        System.out.println(dateNow.plusMonths(12));
        System.out.println(dateNow.plusYears(3));

        System.out.println(LocalDate.now().minusDays(45));
        System.out.println(LocalDate.now().minusMonths(3));
        System.out.println(LocalDate.now().minusYears(7));

        System.out.println(LocalDate.now().minus(2, ChronoUnit.DAYS));

        DayOfWeek dayOfWeek = LocalDate.parse("2018-07-12").getDayOfWeek();
        System.out.println(dayOfWeek);

        int dayOfMonth = LocalDate.parse("2018-07-12").getDayOfMonth();
        System.out.println(dayOfMonth);


        boolean isAfter = LocalDate.parse("2018-07-12").isAfter(LocalDate.parse("2019-07-12"));
        boolean isBefore = LocalDate.now().isBefore(LocalDate.parse("2019-07-12"));
        boolean isEqual = LocalDate.now().isEqual(LocalDate.parse("2019-07-12"));


        List<LocalDate> dates = LocalDate.now()
                .datesUntil(LocalDate.parse("2025-06-12")).collect(Collectors.toList());
        System.out.println(dates);




        // LocalTime
        LocalTime timeNow = LocalTime.now();
        System.out.println(timeNow);

        LocalTime setTime = LocalTime.of(6, 39);
        System.out.println(setTime);

        LocalTime setTime2 = LocalTime.parse("12:10");
        System.out.println(setTime2);

        System.out.println(timeNow.plusSeconds(78));
        System.out.println(timeNow.plusMinutes(78));
        System.out.println(timeNow.plusHours(78));

        System.out.println(timeNow.plus(23, ChronoUnit.SECONDS));

        int hours = LocalTime.parse("04:45").getHour();
        int minute = LocalTime.parse("04:45").getMinute();

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonth().getDisplayName(TextStyle.FULL, Locale.FRANCE));

//        Period
        LocalDate startDate = LocalDate.parse("2016-04-12");
        System.out.println(startDate);
        LocalDate finaleDate = startDate.plus(Period.ofDays(12));
        System.out.println(finaleDate);

        List between = Period.between(finaleDate, startDate).getUnits();
        System.out.println(between);
        long between2 = ChronoUnit.DAYS.between(finaleDate, startDate);

//        Duration
        LocalTime localTime = LocalTime.of(7, 23);
        LocalTime localTime1 = localTime.plus(Duration.ofMinutes(23));

        long timeB = Duration.between(localTime, localTime1).toMinutes();
        long timeB2 = ChronoUnit.SECONDS.between(localTime, localTime1);

        Set<String> allZone = ZoneId.getAvailableZoneIds();
        System.out.println(allZone);

        ZoneId zoneId = ZoneId.of("America/Cuiaba");









    }
}
