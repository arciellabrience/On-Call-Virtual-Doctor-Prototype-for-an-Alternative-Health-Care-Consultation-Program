package ph.edu.dlsu;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class CheckHistory {

    private int lastLineNum = 0;
    private String lines;
    private int i = 0;

    private int j = 0;
    private String sub = null;

    private SimpleDateFormat sdf;
    private Calendar c;

    public String checkHistory(String doctor, String newDate) {
        try (BufferedReader brr = new BufferedReader(new FileReader("assets/history.txt"))) {
            while ((lines = brr.readLine()) != null) {
                i++;
                if (lines.contains(doctor)) {
                    lastLineNum = i;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        lastLineNum += 1;

        try (BufferedReader brr = new BufferedReader((new FileReader("assets/history.txt")))) {
            while ((lines = brr.readLine()) != null) {
                j++;
                if (j == (lastLineNum)) {
                    sub = lines.substring(0, 10);

                    // specify date format
                    sdf = new SimpleDateFormat("yyyy-MM-dd");
                    c = Calendar.getInstance();

                    try {
                        // set the date to the last date from the chosen doctor in history.txt
                        c.setTime(sdf.parse(sub));

                    } catch (ParseException e){
                        e.printStackTrace();
                    }

                    c.add(Calendar.DAY_OF_MONTH, 7);

                    // new date
                    newDate = sdf.format(c.getTime());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newDate;
    }
}