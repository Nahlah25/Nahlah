package Javautilty;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class getjavautility {
public int getRandomnumber() {
	Random ran=new Random();
	int randomcount=ran.nextInt(1000);
	return randomcount;}
public String getcurrentdate() {
	Date date=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("MM-dd-yyyy");
	String currentdate=sim.format(date);
return currentdate;
	
}
public String togetreqdate(int days) {
	Date date=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
	sim.format(date);
	Calendar cal=sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, days);
	String datereq=sim.format(cal.getTime());
	return datereq;}


}
