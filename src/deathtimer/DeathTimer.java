package deathtimer;
import java.util.Scanner;
import java.time.*;
import java.time.temporal.ChronoUnit;

public class DeathTimer {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int lifeExpectancy = 81;
                
        System.out.println("Enter hour of your birth (e.g 22)");
        int hourOfBirth = input.nextInt();
        
        System.out.println("Enter minute of your birth (0-59)");
        int minuteOfBirth = input.nextInt();
        
        System.out.println("Enter your day of birth (1-30/31)");
        int dayOfBirth = input.nextInt();
        
        System.out.println("Enter your month of birth (1-12 )");
        int monthOfBirth = input.nextInt();
        
        System.out.println("Enter your year of birth (e.g. 2002)");
        int yearOfBirth = input.nextInt();
        
        
        
        System.out.println("Do you smoke? (tobacco))");
        String smoker = input.next();
        
        if (smoker.equalsIgnoreCase("yes")) {
            lifeExpectancy -= 10;
        }
        
        System.out.println("Do you drink?");
        String drinker = input.next();
        
        if (drinker.equalsIgnoreCase("yes")) {
            lifeExpectancy -= 5;
        }
        
        System.out.println("Do you exercise regularly?");
        String exercise = input.next();
        
        if (exercise.equalsIgnoreCase("yes")) {
            lifeExpectancy += 5;
        } else if (exercise.equalsIgnoreCase("no")) {
            lifeExpectancy -= 5;
        }
        
        LocalDateTime deathDateTime = LocalDateTime.of(yearOfBirth+lifeExpectancy, monthOfBirth, dayOfBirth, hourOfBirth, minuteOfBirth);
        LocalDateTime currentDateTime = LocalDateTime.now();

        Instant deathInstant = deathDateTime.toInstant(ZoneOffset.UTC);
        Instant currentInstant = currentDateTime.toInstant(ZoneOffset.UTC);
              
        long seconds = ChronoUnit.SECONDS.between(currentInstant, deathInstant);
    
        long daysLeft = seconds / (3600 * 24);
        long remainder = seconds % (3600 * 24);
        
        long hoursLeft = remainder / 3600;
        remainder = remainder % 3600;
        
        long minutesLeft = remainder / 60;
        long secondsLeft = remainder % 60;
        
        System.out.println("You have " + daysLeft + " days, " + hoursLeft + " hours, " + minutesLeft + " minutes, and " + secondsLeft + " seconds left to live");
   
    }
    
    
}
