package ph.edu.dlsu;

import acm.program.ConsoleProgram;
import acm.util.MediaTools;

import java.applet.AudioClip;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main extends ConsoleProgram {

    private MainCanvas canvas;

    List<Integer> symptomsPhysical = new ArrayList<>(); //contains user's list of sickness/es
    String doctor; // holds the chosen doctor of the user

    LocalDate date = null; // holds current date
    String newDate; // holds the date picked for appointment then adds +7 days to it
    String dayAndTime = null; //reads from the doctors.txt file the day and time (doctor's working hours)

    int counter = 0;  //checks in history.txt if doctor already had an appointment
                          // (for the variables: date and newDate)

    String userEmail = null; // contains user's e-mail address

    public void run() {
        canvas = new MainCanvas();
        setSize(1000, 700);
        setTitle("ON CALL: VIRTUAL DOCTOR");
        add(canvas);

        soundBGM();
        canvas.homescreen();
        displayIntro();
        consultation();
    }

    // introductory message for the user
    private void displayIntro() {
        println("WELCOME TO ON CALL VIRTUAL DOCTOR, WHERE YOUR SYMPTOMS REGARDING YOUR CURRENT PHYSICAL OR MENTAL STATE IS EVALUATED!");
        println("\nAS THE CURRENT PANDEMIC FORCES PEOPLE TO TRANSITION TO A WORK-FROM-HOME SETUP AS MEANS OF DECREASING THE TRANSMISSION OF THE COVID-19 VIRUS, THE MANIFESTATION OF PHYSICAL OR MENTAL PROBLEMS FROM THIS SETUP MAY SET ON THE USER.");
        println("\n\nDISCLAIMER: ON CALL VIRTUAL DOCTOR’S DATA IS BASED ON SURFACE LEVEL RESEARCH, AND NO EXPERT WAS CONSULTED ON THE SYMPTOMS, DIAGNOSIS, AND PRESCRIPTIONS. IF THE USER’S PAIN IS OF A HIGH INTENSITY, OR IF THE SYMPTOM IS NOT PRESENT WITHIN THE PROGRAM, IT IS BEST TO CONSULT AN ACTUAL PHYSICIAN.");
        print("\nPRESS ENTER TO CONTINUE...");
        readLine();
    }

    // menu
    private void consultation() {
        canvas.clear();
        canvas.canvasConsultation();
        clearConsole();
        println("ON CALL VIRTUAL DOCTOR: Refer to the right screen\n");
        println("1.) Physical Pain");
        println("2.) Mental/Emotional Pain");
        println("3.) Exit");
        int x = readInt("Choice: ");

        pick(x);
    }

    //duration per slide
    private void delay() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    // actions depending on choice picked from menu is executed here
    private void pick(int x) {

        //for physical pain
        if (x == 1) {
            boolean outerLoop = true;
            String outerString;
            do {
                println("\nWhich among the sicknesses below are you exactly feeling?");
                println("Refer to the right screen. Input the numbers one at a time after the slideshow.");

                canvas.canvasPhysical1();
                delay();
                canvas.canvasPhysical2();
                delay();
                canvas.canvasPhysical3();
                delay();
                canvas.canvasPhysical4();
                delay();
                canvas.canvasPhysical5();
                delay();
                canvas.canvasPhysical6();
                delay();
                canvas.canvasPhysical7();
                delay();
                canvas.canvasPhysical8();
                delay();
                canvas.canvasPhysical9();
                delay();

                canvas.homescreen();

                // ask if user wants to repeat the slideshow of physical sicknesses
                outerString = readLine("\nWould you like to repeat the slideshow? [Y/N]: ");
                if (outerString.equals("N") || outerString.equals("n")) {
                    outerLoop = false;
                }

                else if (outerString.equals("Y") || outerString.equals("y")) {
                    pick(1);
                }

                else {
                    String stringInner;
                    boolean innerLoop = true;
                    do {
                        stringInner = readLine("Please input either 'Y' or 'N': ");
                        if (stringInner.equals("Y") || stringInner.equals("y")) {
                            pick(1);
                        }

                        else {
                            outerLoop = false;
                            innerLoop = false;
                        }
                    } while (innerLoop);
                }
            } while (outerLoop);

            // '0' as the end the input of sicknesses
            println("\nInput the number '0' after inputting all sicknesses applicable to you.");
            int secondX;

            // displays sickness on console that is assigned a number
            do {
                secondX = readInt("\nInput sickness: ");
                if (secondX == 0) {
                    break;
                }
                secondPickPhysical(secondX);

                if (secondX == 1) {
                    canvas.canvasPhysical1();
                }
                else if (secondX == 2) {
                    canvas.canvasPhysical2();
                }
                else if (secondX == 3) {
                    canvas.canvasPhysical3();
                }
                else if (secondX == 4) {
                    canvas.canvasPhysical4();
                }
                else if (secondX == 5) {
                    canvas.canvasPhysical5();
                }
                else if (secondX == 6) {
                    canvas.canvasPhysical6();
                }
                else if (secondX == 7) {
                    canvas.canvasPhysical7();
                }
                else if (secondX == 8) {
                    canvas.canvasPhysical8();
                }
                else if (secondX == 9) {
                    canvas.canvasPhysical9();
                }
                else {
                    canvas.homescreen();
                }
            } while (secondX != 0);

            // makes the user enter symptoms if the list is emoty
            if (symptomsPhysical.size() == 0) {
                println("List is empty. Please pick the sickness at least you are closest to feeling.");
                pick(1);
            }

            // print list of sicknesses
            println("\nHere is a list of all the input sickness/es (with their corresponding number assignments):");
            println(symptomsPhysical);
            finalizeList();
        }

        // for mental pain
        if (x == 2) {
            mental();
            endProgram();
        }

        // exit the program
        if (x == 3) {
            System.exit(0);
        }
    }

    //checks validity of input of user in the list of sicknesses
    private void secondPickPhysical(int secondX) {
        if (secondX >= 10 || secondX < 1) {
            println("Please input a number within the range.");
        }
        else if (!symptomsPhysical.contains(secondX)) {
            symptomsPhysical.add(secondX);
        }
        else {
            println("Sickness has already been selected before.");
        }
    }

    // finalizes list of sicknesses
    private void finalizeList() {
        String finalize = readLine("Are you sure with your list? [Y/N]: ");

        if (finalize.equals("N") || finalize.equals("n") || (finalize.equals("Y") || finalize.equals("y"))) {
            potentialEditPhysicalList(finalize);
        }
        else {
            String last;
            boolean lastBool = true;
            do {
                last = readLine("Please input either 'Y' or 'N': ");
                if (last.equals("N") || last.equals("n") || (last.equals("Y") || last.equals("y"))) {
                    lastBool = false;
                    potentialEditPhysicalList(last);
                }
            } while (lastBool);
        }
    }

    // if the user is sure of his/her list:
    // next step to either book an appointment online
    // or view suggestions from the program after finalizing list

    // if the user isn't sure of his/her list:
    // user is transferred to another method
    private void potentialEditPhysicalList(String finalize) {

        // if user is sure with the list, it will proceed to booking a doctor online or to view suggestions from the program with what else can be done
        if (finalize.equals("Y") || finalize.equals("y")) {
            canvas.scanning();
            println("Press enter to continue.");
            readLine();

            int answer;
            boolean boolAnswer = true;

            do {
                clearConsole();
                answer = readInt("Would you like to book your online doctor to be met virtually? Or would you like us to give a couple of suggestions for your current condition?\n[Input '1' to book online; Input '2' to view suggestions]: ");
                if (answer == 1) {
                    clearConsole();
                    bookPhysical();
                    boolAnswer = false;
                }
                else if (answer == 2) {
                    suggestionsPhysical();
                    boolAnswer = false;
                }
            } while(boolAnswer);
        }
        else {
            editPhysicalList();
        }
    }

    //edits list by either deleting or replacing a number
    private void editPhysicalList() {
        int dr = readInt("\nWould you like to delete or replace a number?\n[Input '1' if you would like to delete a number; Input '2' if you would like to replace a number]: ");

        if (dr == 1) {
            int delete;
            do {
                delete = readInt("What number would you like to delete?: ");
            } while (!symptomsPhysical.contains(delete));

            //deletes that integer in the list
            symptomsPhysical.remove(new Integer(delete));

            //displays updated list after deletion
            println("Updated list: ");
            println(symptomsPhysical);

            if (symptomsPhysical.size() == 0) {
                println("List is empty. Please pick the sickness at least you are closest to feeling.");
                pick(1);
            }
            finalizeList();
        }

        else if (dr == 2) {
            int replace;

            do {
                replace = readInt("What number would you like to replace?: ");
            } while (!symptomsPhysical.contains(replace));

            int replace2;
            do {
                replace2 = readInt("What number would you like to replace to the selected symptom?: ");
            } while ((replace == replace2) || (replace2 < 1 || replace2 > 9));

            //replaces numbers chosen
            symptomsPhysical.set(symptomsPhysical.indexOf(replace), replace2);

            //displays updated list
            println("Updated list: ");
            println(symptomsPhysical);

            if (symptomsPhysical.size() == 0) {
                println("List is empty. Please pick the sickness at least you are closest to feeling.");
                pick(1);
            }
            finalizeList();
        }
        else {
            editPhysicalList();
        }
    }

    // booking of online appointment
    private void bookPhysical() {
        println("LIST OF AVAILABLE DOCTORS:");
        try (BufferedReader br = new BufferedReader(new FileReader("assets/doctors.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //display profiles of doctors in canvas
        canvas.clear();
        canvas.Doc1();
        delay();
        canvas.clear();

        canvas.Doc2();
        delay();
        canvas.clear();

        canvas.Doc3();
        delay();
        canvas.clear();

        canvas.Doc4();
        delay();
        canvas.clear();

        canvas.Doc5();
        delay();
        canvas.clear();

        canvas.Doc6();
        delay();
        canvas.clear();

        canvas.Doc7();
        delay();
        canvas.clear();

        canvas.Doc8();
        delay();
        canvas.clear();

        canvas.Doc9();
        delay();
        canvas.clear();

        canvas.Doc10();
        delay();
        canvas.clear();

        canvas.Doc11();
        delay();
        canvas.clear();

        canvas.Doc12();
        delay();
        canvas.clear();

        canvas.Doc13();
        delay();
        canvas.clear();

        canvas.Doc14();
        delay();
        canvas.clear();

        canvas.Doc15();
        delay();
        canvas.clear();

        canvas.Doc16();
        delay();
        canvas.clear();

        canvas.Doc17();
        delay();
        canvas.clear();

        canvas.Doc18();
        delay();
        canvas.clear();

        canvas.Doc19();
        delay();
        canvas.clear();

        canvas.Doc20();
        delay();
        canvas.clear();

        canvas.Doc21();
        delay();
        canvas.clear();

        canvas.Doc22();
        delay();
        canvas.clear();

        canvas.Doc23();
        delay();
        canvas.clear();
        canvas.homescreen();

        doctor = readLine("\nEnter name of doctor you find it the most convenient to consult with [Example: Dr. J-em Pareja]: ");

        // stores all doctors in a list with "NAME: " as an indicator
        try (Stream<String> stream = Files.lines(Paths.get("assets/doctors.txt"))) {
            List<String> availableList = stream.filter(str->str.startsWith("NAME: ")).map(s->s.split("NAME: ")[1]).collect(Collectors.toList());

            if (availableList.contains(doctor)) {

                // shows pictures of respective doctors along with some vital information about themselves on canvas
                if (doctor.equalsIgnoreCase("Dr. John Cruz")) {
                    canvas.Doc1();
                }

                if (doctor.equalsIgnoreCase("Dr. Adrien Chan")) {
                    canvas.Doc2();
                }

                if (doctor.equalsIgnoreCase("Dr. John Cruz")) {
                    canvas.Doc3();
                }

                if (doctor.equalsIgnoreCase("Dr. Anna Lopez")) {
                    canvas.Doc4();
                }

                if (doctor.equalsIgnoreCase("Dr. Geraldine Sy")) {
                    canvas.Doc5();
                }

                if (doctor.equalsIgnoreCase("Dr. Jennifer Tan")) {
                    canvas.Doc6();
                }

                if (doctor.equalsIgnoreCase("Dr. Alexander San Juan")) {
                    canvas.Doc7();
                }

                if (doctor.equalsIgnoreCase("Dr. Sally Ong")) {
                    canvas.Doc8();
                }

                if (doctor.equalsIgnoreCase("Dr. Gayle Yap")) {
                    canvas.Doc9();
                }

                if (doctor.equalsIgnoreCase("Dr. Charles Ng")) {
                    canvas.Doc10();
                }

                if (doctor.equalsIgnoreCase("Dr. Xander Sales")) {
                    canvas.Doc11();
                }

                if (doctor.equalsIgnoreCase("Dr. Ian Villarin")) {
                    canvas.Doc12();
                }

                if (doctor.equalsIgnoreCase("Dr. Hillary Mallari")) {
                    canvas.Doc13();
                }

                if (doctor.equalsIgnoreCase("Dr. Simon Ang")) {
                    canvas.Doc14();
                }

                if (doctor.equalsIgnoreCase("Dr. Mina Santos")) {
                    canvas.Doc15();
                }

                if (doctor.equalsIgnoreCase("Dr.  James Young")) {
                    canvas.Doc16();
                }

                if (doctor.equalsIgnoreCase("Dr. Sadie Co")) {
                    canvas.Doc17();
                }

                if (doctor.equalsIgnoreCase("Dr. Victoria Mojares")) {
                    canvas.Doc18();
                }

                if (doctor.equalsIgnoreCase("Dr. Andrew Gomez")) {
                    canvas.Doc19();
                }

                if (doctor.equalsIgnoreCase("Dr. Alexa Hernandez")) {
                    canvas.Doc20();
                }

                if (doctor.equalsIgnoreCase("Dr. Anna Yang")) {
                    canvas.Doc21();
                }

                if (doctor.equalsIgnoreCase("Dr. Stephanie Yu")) {
                    canvas.Doc22();
                }

                if (doctor.equalsIgnoreCase("Dr. Justine Reyes")) {
                    canvas.Doc23();
                }

                //displays date and time today, and the chosen doctor
                Date OGdate = new Date();
                println("TODAY'S DATE AND TIME: " + OGdate);
                println("\nSchedule of " + doctor + ":");

                //reads through doctors.txt file
                try (BufferedReader br = new BufferedReader(new FileReader("assets/doctors.txt"))) {
                    String line;
                    int count = 0;
                    int firstSpace;
                    int secondSpace;
                    String confirm;

                    //gets the schedule of the corresponding doctor from doctors.txt file
                    while ((line = br.readLine()) != null) {
                        if (line.contains(doctor)) {
                            count++;
                        }

                        //if line contains either of the days of the week,
                        //it gets the future date with respect to that day of the week
                        if (count == 3) {
                            if (line.contains("Sunday")) {
                                date = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
                                firstSpace = line.indexOf(' ');
                                secondSpace = line.indexOf(' ', firstSpace);
                                dayAndTime = line.substring(secondSpace);

                                //if history.txt contains the name of the doctor booked in this run, counter is accumulated
                                String lines = null;
                                try (BufferedReader brr = new BufferedReader(new FileReader("assets/history.txt"))) {
                                    while ((lines = brr.readLine()) != null) {
                                        if (lines.contains(doctor)) {
                                            counter++;
                                        }
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                //if file is empty or no occurrence of doctor from history.txt file
                                File file = new File("assets/history.txt");
                                if ((file.length() == 1) || (counter == 0)) {
                                    break;
                                }
                                else {
                                    //method is done in class checkHistory
                                    history.checkHistory(doctor, newDate);
                                }
                                break;
                            }

                            //if line contains either of the days of the week,
                            //it gets the future date with respect to that day of the week
                            else if (line.contains("Monday")) {
                                date = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.MONDAY));
                                firstSpace = line.indexOf(' ');
                                secondSpace = line.indexOf(' ', firstSpace);
                                dayAndTime = line.substring(secondSpace);

                                String lines = null;
                                try (BufferedReader brr = new BufferedReader(new FileReader("assets/history.txt"))) {
                                    while ((lines = brr.readLine()) != null) {
                                        if (lines.contains(doctor)) {
                                            counter++;
                                        }
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                //if file is empty or no occurrence of doctor from history.txt file
                                File file = new File("assets/history.txt");
                                if ((file.length() == 1) || (counter == 0)) {
                                    break;
                                }
                                else {
                                    //method is done in class checkHistory
                                    history.checkHistory(doctor, newDate);
                                }
                                break;
                            }

                            //if line contains either of the days of the week,
                            //it gets the future date with respect to that day of the week
                            else if (line.contains("Tuesday")) {
                                date = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
                                firstSpace = line.indexOf(' ');
                                secondSpace = line.indexOf(' ', firstSpace);
                                dayAndTime = line.substring(secondSpace);

                                String lines = null;
                                try (BufferedReader brr = new BufferedReader(new FileReader("assets/history.txt"))) {
                                    while ((lines = brr.readLine()) != null) {
                                        if (lines.contains(doctor)) {
                                            counter++;
                                        }
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                //if file is empty or no occurrence of doctor from history.txt file
                                File file = new File("assets/history.txt");
                                if ((file.length() == 1) || (counter == 0)) {
                                    break;
                                }
                                else {
                                    //method is done in class checkHistory
                                    history.checkHistory(doctor, newDate);
                                }
                                break;
                            }

                            //if line contains either of the days of the week,
                            //it gets the future date with respect to that day of the week
                            else if (line.contains("Wednesday")) {
                                date = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
                                firstSpace = line.indexOf(' ');
                                secondSpace = line.indexOf(' ', firstSpace);
                                dayAndTime = line.substring(secondSpace);

                                String lines = null;
                                try (BufferedReader brr = new BufferedReader(new FileReader("assets/history.txt"))) {
                                    while ((lines = brr.readLine()) != null) {
                                        if (lines.contains(doctor)) {
                                            counter++;
                                        }
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                //if file is empty or no occurrence of doctor from history.txt file
                                File file = new File("assets/history.txt");
                                if ((file.length() == 1) || (counter == 0)) {
                                    break;
                                }
                                else {
                                    //method is done in class checkHistory
                                    history.checkHistory(doctor, newDate);
                                }
                                break;
                            }

                            //if line contains either of the days of the week,
                            //it gets the future date with respect to that day of the week
                            else if (line.contains("Thursday")) {
                                date = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.THURSDAY));
                                firstSpace = line.indexOf(' ');
                                secondSpace = line.indexOf(' ', firstSpace);
                                dayAndTime = line.substring(secondSpace);

                                String lines = null;
                                try (BufferedReader brr = new BufferedReader(new FileReader("assets/history.txt"))) {
                                    while ((lines = brr.readLine()) != null) {
                                        if (lines.contains(doctor)) {
                                            counter++;
                                        }
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                //if file is empty or no occurrence of doctor from history.txt file
                                File file = new File("assets/history.txt");
                                if ((file.length() == 1) || (counter == 0)) {
                                    break;
                                }
                                else {
                                    //method is done in class checkHistory
                                    history.checkHistory(doctor, newDate);
                                }
                                break;
                            }

                            //if line contains either of the days of the week,
                            //it gets the future date with respect to that day of the week
                            else if (line.contains("Friday")) {
                                date = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
                                firstSpace = line.indexOf(' ');
                                secondSpace = line.indexOf(' ', firstSpace);
                                dayAndTime = line.substring(secondSpace);

                                String lines = null;
                                try (BufferedReader brr = new BufferedReader(new FileReader("assets/history.txt"))) {
                                    while ((lines = brr.readLine()) != null) {
                                        if (lines.contains(doctor)) {
                                            counter++;
                                        }
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                //if file is empty or no occurrence of doctor from history.txt file
                                File file = new File("assets/history.txt");
                                if ((file.length() == 1) || (counter == 0)) {
                                    break;
                                }
                                else {
                                    //method is done in class checkHistory
                                    history.checkHistory(doctor, newDate);
                                }
                                break;
                            }

                            //if line contains either of the days of the week,
                            //it gets the future date with respect to that day of the week
                            else if (line.contains("Saturday")) {
                                date = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.SATURDAY));
                                firstSpace = line.indexOf(' ');
                                secondSpace = line.indexOf(' ', firstSpace);
                                dayAndTime = line.substring(secondSpace);

                                String lines = null;
                                try (BufferedReader brr = new BufferedReader(new FileReader("assets/history.txt"))) {
                                    while ((lines = brr.readLine()) != null) {
                                        if (lines.contains(doctor)) {
                                            counter++;
                                        }
                                    }
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                //if file is empty or no occurrence of doctor from history.txt file
                                File file = new File("assets/history.txt");
                                if ((file.length() == 1) || (counter == 0)) {
                                    break;
                                }
                                else {
                                    //method is done in class checkHistory
                                    history.checkHistory(doctor, newDate);
                                }
                                break;
                            }
                        }
                        else if (count > 0) {
                            count++;
                        }
                    }

                    //after reading through doctors.txt file
                    File file = new File("assets/history.txt");

                    //if file is empty or no occurrence of doctor in history.txt file,
                    //it print out the nearest date with respect to the day the doctor is available
                    if ((file.length() == 1) || (counter == 0)) {
                        println(date + dayAndTime);
                    }

                    //if doctor has already been booked before, it gets the latest date,
                    //and adds +7 days as this would be the next possible date the doctor would be available
                    else {
                        println(history.checkHistory(doctor, newDate) + dayAndTime);
                    }

                    //confirms online booking
                    boolean confirmation = true;
                    do {
                        confirm = readLine("Confirm booking? [Y/N]: ");

                        if (confirm.equals("Y") || confirm.equals("y")) {
                            paymentPhysical();
                            confirmation = false;
                        } else if (confirm.equals("N") || confirm.equals("n")) {
                            bookPhysical();
                            confirmation = false;
                        } else {
                            println("Please input either 'Y' or 'N'.");
                        }
                    } while (confirmation);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                bookPhysical();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    CheckHistory history = new CheckHistory();

    // online payment
    private void paymentPhysical() {

        String moa = null; // holds mode of payment
        String number = null; // holds bank account number of user
        try (BufferedReader br = new BufferedReader(new FileReader("assets/doctors.txt"))) {
            String line;
            int count = 0;
            String amount = null;
            String email = null;
            String online = null;

            //gets the email address, platform, and rate of the corresponding doctor
            while ((line = br.readLine()) != null) {
                if (line.contains(doctor)) {
                    count++;
                }
                //gets the rate of the corresponding doctor
                if (count == 5) {
                    amount = line.substring(10);
                }
                //gets the platform of the corresponding doctor
                if (count == 4) {
                    online = line;
                }
                //gets the e-mail address of the corresponding doctor
                if (count == 2) {
                    email = line;
                }
                if (count > 0) {
                    count++;
                }
            }

            println("\nYou may contact " + doctor + " through:");
            println(email);
            println(online);
            println("RATE: " + amount);

            boolean bank = true;
            do {
                //display bank icons on canvas
                int mode = readInt("\nWhat will be your mode of payment?\n[Input '1' for BDO; Input '2' for PayMaya; Input '3' for GCash]: ");
                if (mode == 1) {
                    moa = "BDO"; // length: 12
                    canvas.clear();
                    canvas.canvasBDO();
                    number = readLine("Enter account number: ");

                    if (number.length() == 12) {
                        bank = false;
                    }

                    else {
                        println("Account numbers in " + moa + " are 12 digits in length.");
                    }
                }
                else if (mode == 2) {
                    moa = "PAYMAYA"; // length: 16
                    canvas.clear();
                    canvas.canvasPayMaya();
                    number = readLine("Enter account number: ");

                    if (number.length() == 16) {
                        bank = false;
                    }

                    else {
                        println("Account numbers in " + moa + " are 16 digits in length.");
                    }
                }
                else if (mode == 3) {
                    moa = "GCASH"; // length: 13
                    canvas.clear();
                    canvas.canvasGCash();
                    number = readLine("Enter account number: ");

                    if (number.length() == 13) {
                        bank = false;
                    }

                    else {
                        println("Account numbers in " + moa + " are 13 digits in length.");
                    }
                }
            } while (bank);

            double total1, total2, total3;
            int payment;
            payment = readInt("\nFor installments, would you like to pay it every two or three months? [2/3]: ");

            //if user wished to pay twice
            if (payment == 2) {
                total1 = readDouble("Enter amount of cash for the first installment (IN PHP): ");
                total2 = readDouble("Enter amount of cash for the second installment (IN PHP): ");

                PPhysical ep = new PPhysical();

                //if total cash is insufficient (method is done in PPhysical class)
                if (ep.overallTotal(total1, total2) < Double.parseDouble(amount)) {
                    clearConsole();
                    println("Sorry, you have insufficient cash.\n");
                    canvas.clear();
                    canvas.homescreen();

                    String shiftSuggest;
                    boolean bool = true;

                    //provides another choice for the user
                    do {
                        shiftSuggest = readLine("Would you like to read our provided suggestions instead? [Y/N]: ");

                        if (shiftSuggest.equals("Y") || shiftSuggest.equals("y")) {
                            suggestionsPhysical();
                            bool = false;
                        }
                        else if (shiftSuggest.equals("N") || shiftSuggest.equals("n")) {
                            canvas.homescreen();
                            endProgram();
                        }
                        else {
                            println("Please input either 'Y' or 'N'.");
                        }
                    } while (bool);
                }

                //if user's cash is sufficient
                else {
                    clearConsole();
                    canvas.clear();
                    canvas.homescreen();

                    //enter username for formality and records
                    boolean user = true;
                    String confirm = null;
                    do {
                        userEmail = readLine("Please enter your e-mail address: ");

                        confirm = readLine("Is " + userEmail + " your e-mail address? [Y/N]: ");
                        if (confirm.equals("Y") || confirm.equals("y")) {
                            user = false;
                        }

                    } while (user);

                    clearConsole();

                    //writes to history.txt file the doctor, the day of appointment by the user's e-mail address
                    File file = new File("assets/history.txt");
                    if ((file.length() == 1) || (counter == 0)) {
                        File filee = new File("assets/history.txt");
                        FileWriter fr = new FileWriter(filee, true);
                        fr.write(doctor + "\n");
                        fr.write(date + dayAndTime + "\n");
                        fr.write(userEmail + "\n");
                        fr.close();

                        FileWriter fileWriterr = new FileWriter("assets/receipt.txt");
                        fileWriterr.write(doctor + "\n");
                        fileWriterr.write(date + dayAndTime + "\n");
                        fileWriterr.write(moa + " ACCOUNT NUMBER: " + number + "\n");
                        fileWriterr.write("TOTAL AMOUNT (IN PHP): " + amount + "\n");
                        double change = Double.parseDouble(amount) - ep.overallTotal(total1, total2);
                        fileWriterr.write("CHANGE (IN PHP): " + change + "\n");
                        fileWriterr.close();
                    }
                    else {
                        File filee = new File("assets/history.txt");
                        FileWriter fr = new FileWriter(filee, true);
                        fr.write(doctor + "\n");
                        fr.write(history.checkHistory(doctor, newDate) + dayAndTime + "\n");
                        fr.write(userEmail + "\n");
                        fr.close();

                        FileWriter fileWriterr = new FileWriter("assets/receipt.txt");
                        fileWriterr.write(doctor + "\n");
                        fileWriterr.write(history.checkHistory(doctor, newDate) + dayAndTime + "\n");
                        fileWriterr.write(moa + " ACCOUNT NUMBER: " + number + "\n");
                        fileWriterr.write("TOTAL AMOUNT (IN PHP): " + amount + "\n");
                        double change = Double.parseDouble(amount) - ep.overallTotal(total1, total2);
                        fileWriterr.write("CHANGE (IN PHP): " + change + "\n");
                        fileWriterr.close();
                    }

                    //prints the receipt
                    println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n****************************************************************************************************");
                    try (BufferedReader brr = new BufferedReader(new FileReader("assets/receipt.txt"))) {
                        String lines;
                        while ((lines = brr.readLine()) != null) {
                            println(lines);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    println("****************************************************************************************************");

                    // CLOSES PROGRAM
                    endProgram();
                }
            }

            else if (payment == 3) {
                total1 = readDouble("Enter amount of cash for the first installment (IN PHP): ");
                total2 = readDouble("Enter amount of cash for the second installment (IN PHP): ");
                total3 = readDouble("Enter amount of cash for the third installment (IN PHP): ");

                //if total cash is insufficient (method is done in PPhysical class)
                PPhysical ep = new PPhysical();
                if (ep.overallTotal(total1, total2, total3) < Double.parseDouble(amount)) {
                    clearConsole();
                    println("Sorry, you have insufficient cash.\n");
                    canvas.clear();
                    canvas.homescreen();

                    String shiftSuggest;
                    boolean bool = true;

                    do {
                        shiftSuggest = readLine("Would you like to read our provided suggestions instead? [Y/N]: ");

                        if (shiftSuggest.equals("Y") || shiftSuggest.equals("y")) {
                            suggestionsPhysical();
                            bool = false;
                        }
                        else if (shiftSuggest.equals("N") || shiftSuggest.equals("n")) {
                            canvas.homescreen();
                            endProgram();
                        }
                        else {
                            println("Please input either 'Y' or 'N'.");
                        }
                    } while (bool);
                }

                //if user's cash is sufficient
                else {
                    clearConsole();
                    canvas.clear();
                    canvas.homescreen();

                    //enter username for formality and records
                    boolean user = true;
                    String confirm = null;
                    do {
                        userEmail = readLine("Please enter your e-mail address: ");

                        confirm = readLine("Is " + userEmail + " your e-mail address? [Y/N]: ");
                        if (confirm.equals("Y") || confirm.equals("y")) {
                            user = false;
                        }

                    } while (user);

                    clearConsole();

                    //writes to history.txt file the doctor, the day of appointment by the user's e-mail address
                    File file = new File("assets/history.txt");
                    if ((file.length() == 1) || (counter == 0)) {
                        File filee = new File("assets/history.txt");
                        FileWriter fr = new FileWriter(filee, true);
                        fr.write(doctor + "\n");
                        fr.write(date + dayAndTime + "\n");
                        fr.write(userEmail + "\n");
                        fr.close();

                        FileWriter fileWriterr = new FileWriter("assets/receipt.txt");
                        fileWriterr.write(doctor + "\n");
                        fileWriterr.write(date + dayAndTime + "\n");
                        fileWriterr.write(moa + " ACCOUNT NUMBER: " + number + "\n");
                        fileWriterr.write("TOTAL AMOUNT (IN PHP): " + amount + "\n");
                        double change = Double.parseDouble(amount) - ep.overallTotal(total1, total2);
                        fileWriterr.write("CHANGE (IN PHP): " + change + "\n");
                        fileWriterr.close();
                    }
                    else {
                        File filee = new File("assets/history.txt");
                        FileWriter fr = new FileWriter(filee, true);
                        fr.write(doctor + "\n");
                        fr.write(history.checkHistory(doctor, newDate) + dayAndTime + "\n");
                        fr.write(userEmail + "\n");
                        fr.close();

                        FileWriter fileWriterr = new FileWriter("assets/receipt.txt");
                        fileWriterr.write(doctor + "\n");
                        fileWriterr.write(history.checkHistory(doctor, newDate) + dayAndTime + "\n");
                        fileWriterr.write(moa + " ACCOUNT NUMBER: " + number + "\n");
                        fileWriterr.write("TOTAL AMOUNT (IN PHP): " + amount + "\n");
                        double change = Double.parseDouble(amount) - ep.overallTotal(total1, total2);
                        fileWriterr.write("CHANGE (IN PHP): " + change + "\n");
                        fileWriterr.close();
                    }

                    //prints the receipt
                    println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n****************************************************************************************************");
                    try (BufferedReader brr = new BufferedReader(new FileReader("assets/receipt.txt"))) {
                        String lines;
                        while ((lines = brr.readLine()) != null) {
                            println(lines);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    println("****************************************************************************************************");

                    // CLOSES PROGRAM
                    endProgram();
                }
            }
            else {
                paymentPhysical();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //if number contains in the user's list
    private void suggestionsPhysical() {
        clearConsole();
        canvas.disclaimer();
        delay();
        if (symptomsPhysical.contains(1)) {
            canvas.clear();
            canvas.canvasS1();
            delay();

            canvas.clear();
            canvas.canvasSPrescription();
            delay();
        }

        if (symptomsPhysical.contains(2)) {
            canvas.clear();
            canvas.canvasS2();
            delay();

            canvas.clear();
            canvas.canvasSPrescription();
            delay();
        }

        if (symptomsPhysical.contains(3)) {
            canvas.clear();
            canvas.canvasS3();
            delay();

            canvas.clear();
            canvas.canvasSPrescription();
            delay();
        }

        if (symptomsPhysical.contains(4)) {
            canvas.clear();
            canvas.canvasS4();
            delay();

            canvas.clear();
            canvas.canvasSPrescription();
            delay();
        }

        if (symptomsPhysical.contains(5)) {
            canvas.clear();
            canvas.canvasS5();
            delay();

            canvas.clear();
            canvas.canvasSPrescription();
            delay();
        }

        if (symptomsPhysical.contains(6)) {
            canvas.clear();
            canvas.canvasS6();
            delay();

            canvas.clear();
            canvas.canvasSPrescription();
            delay();
        }

        if (symptomsPhysical.contains(7)) {
            canvas.clear();
            canvas.canvasS7();
            delay();

            canvas.clear();
            canvas.canvasSPrescription();
            delay();
        }

        if (symptomsPhysical.contains(8)) {
            canvas.clear();
            canvas.canvasS8();
            delay();

            canvas.clear();
            canvas.canvasSPrescription();
            delay();
        }

        if (symptomsPhysical.contains(9)) {
            canvas.clear();
            canvas.canvasS9();
            delay();

            canvas.clear();
            canvas.canvasSPrescription();
            delay();
        }
        canvas.disclaimer();

        // CLOSES PROGRAM
        endProgram();
    }

    //provides a slideshow for the user that contains useful information
    private void mental() {
        canvas.clear();
        canvas.disclaimer();
        delay();

        canvas.clear();
        canvas.canvasMental1();
        delay();

        canvas.clear();
        canvas.canvasMental2();
        delay();

        canvas.clear();
        canvas.canvasMental3();
        delay();

        canvas.clear();
        canvas.canvasCope1();
        delay();

        canvas.clear();
        canvas.canvasCope2();
        delay();

        canvas.clear();
        canvas.canvasNPrescription();
        delay();

        canvas.clear();
        canvas.hotline();
        delay();
    }

    //ending message for the user
    private void endProgram() {
        println("\n\nThank you for using our program! We hope you fare well!");
        print("\nPress enter to exit program... ");
        readLine();
        System.exit(0);
    }

    //background music while program is running
    private void soundBGM() {
        AudioClip hornClip = MediaTools.loadAudioClip("assets/pokecenter.wav");
        hornClip.play();
    }

    public   static   void  main (String[] args)  {
        new Main().start(args);
    }
}