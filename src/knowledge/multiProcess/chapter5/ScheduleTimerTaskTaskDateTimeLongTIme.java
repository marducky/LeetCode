package knowledge.multiProcess.chapter5;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class ScheduleTimerTaskTaskDateTimeLongTIme {
    static public class MyTask extends TimerTask {
        @Override
        public void run() {
            System.out.println("run!Timeis :" + new Date());
        }
    }

    public static void main(String[] args) {
        try {
            MyTask task = new MyTask();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String dateString = "2018-1-10 15:16:10";
            Timer timer = new Timer();
            Date dateRef = sdf.parse(dateString);
            System.out.println("String time " + dateRef.toLocaleString() + " now time " + new Date().toLocaleString());
            timer.schedule(task, dateRef, 4000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
