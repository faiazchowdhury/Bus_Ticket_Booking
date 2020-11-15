package com.example.busticketbooking;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Array;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.concurrent.Semaphore;
import java.util.prefs.Preferences;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.transform.Result;

public class BackgroundWorker extends AsyncTask<String,Void,String>{
    Context context;
    public static String route,time,coach,date,total_price,chosen_seats,temp_num,temp_nezt;
    String page="";
    String arr="";
    int price;
    double refund=0;
    public BackgroundWorker(Context ctx) {
        context=ctx;
    }

    @Override
    protected String doInBackground(String... voids) {
        String urllogin="http://10.0.2.2/PHP%20files/login.php";
        String urlregister="http://10.0.2.2/PHP%20files/register.php";
        String urlseat="http://10.0.2.2/PHP%20files/seats.php";
        String urlseatcheck="http://10.0.2.2/PHP%20files/check_seats.php";
        String urlpay="http://10.0.2.2/PHP%20files/paid.php";
        String urlviewticket="http://10.0.2.2/PHP%20files/view_ticket.php";
        String urlcancel="http://10.0.2.2/PHP%20files/cancel.php";
        String urlticketfinder="http://10.0.2.2/PHP%20files/find_ticket.php";
        if(voids[0]=="login"){
            page="login";
            String email=voids[1];
            String pass=voids[2];
            try {
                URL url=new URL(urllogin);
                HttpURLConnection htp= (HttpURLConnection) url.openConnection();
                htp.setRequestMethod("POST");
                htp.setDoInput(true);
                htp.setDoOutput(true);



                OutputStream out=htp.getOutputStream();
                OutputStreamWriter ow=new OutputStreamWriter(out);
                BufferedWriter bw=new BufferedWriter(ow);
                String en= URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");
                bw.write(en);
                bw.flush();
                out.close();

                InputStream inputStream=htp.getInputStream();
                InputStreamReader isr=new InputStreamReader(inputStream,"UTF-8");
                BufferedReader br=new BufferedReader(isr);
                String output=br.readLine();
                br.close();
                inputStream.close();
                htp.disconnect();
                info inf=new info();
                inf.email=email;
                return output;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(voids[0]=="register"){
            String email=voids[1];
            String pass=voids[2];
            String num=voids[3];
            String name=voids[4];
            page="register";
            try {
                URL url=new URL(urlregister);
                HttpURLConnection htp= (HttpURLConnection) url.openConnection();
                htp.setRequestMethod("POST");
                htp.setDoOutput(true);

                OutputStream out=htp.getOutputStream();
                OutputStreamWriter os=new OutputStreamWriter(out);
                BufferedWriter bw=new BufferedWriter(os);
                String data=URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8")+"&"
                        +URLEncoder.encode("num","UTF-8")+"="+URLEncoder.encode(num,"UTF-8")+"&"
                        +URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8");
                bw.write(data);
                bw.flush();
                out.close();
                InputStream inputStream = htp.getInputStream();
                inputStream.close();
                htp.disconnect();
                info inf=new info();
                inf.email=email;
                return "Welcome "+ name;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (voids[0]=="seats") {
            page="seats";
            info inf=new info();
            String email=inf.email;
            date=voids[1];
            time=voids[2];
            coach=voids[3];
            route=voids[4];

            if(route.equals("Dhaka-Khulna") || route.equals("Khulna-Dhaka")){
                price=900;
            }else{if(route.equals("Dhaka-Sylhet") || route.equals("Sylhet-Dhaka")){
                price=600;
            }else{if(route.equals("Dhaka-Rajshahi") || route.equals("Rajshahi-Dhaka")){
                price=800;
            }else{if(route.equals("Chottogram-Dhaka") || route.equals("Dhaka-Chottogram")){
                price=1000;

            }}}}
            try {
                URL url=new URL(urlseat);
                HttpURLConnection htp= (HttpURLConnection) url.openConnection();
                htp.setRequestMethod("POST");
                htp.setDoInput(true);
                htp.setDoOutput(true);


                OutputStream out=htp.getOutputStream();
                OutputStreamWriter outputStreamWriter=new OutputStreamWriter(out);
                BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
                String data=URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("date","UTF-8")+"="+URLEncoder.encode(date,"UTF-8")+"&"
                        +URLEncoder.encode("time","UTF-8")+"="+URLEncoder.encode(time,"UTF-8")+"&"
                        +URLEncoder.encode("coach","UTF-8")+"="+URLEncoder.encode(coach,"UTF-8")+"&"
                        +URLEncoder.encode("route","UTF-8")+"="+URLEncoder.encode(route,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                out.close();
                InputStream is=htp.getInputStream();

                InputStreamReader inputStreamReader=new InputStreamReader(is,"UTF-8");
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                arr=bufferedReader.readLine();
                return "non";
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(voids[0].equals("check_seats")){
            page="check_seats";
            info in=new info();
            String email=in.email;
            chosen_seats=voids[1];
            total_price=voids[2];
            try {
                URL url=new URL(urlseatcheck);
                HttpURLConnection htp= (HttpURLConnection) url.openConnection();
                htp.setRequestMethod("POST");
                htp.setDoInput(true);
                htp.setDoOutput(true);



                OutputStream out=htp.getOutputStream();
                OutputStreamWriter outputStreamWriter=new OutputStreamWriter(out);
                BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
                String data=URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("date","UTF-8")+"="+URLEncoder.encode(date,"UTF-8")+"&"
                        +URLEncoder.encode("time","UTF-8")+"="+URLEncoder.encode(time,"UTF-8")+"&"
                        +URLEncoder.encode("coach","UTF-8")+"="+URLEncoder.encode(coach,"UTF-8")+"&"
                        +URLEncoder.encode("route","UTF-8")+"="+URLEncoder.encode(route,"UTF-8")+"&"
                        +URLEncoder.encode("seats","UTF-8")+"="+URLEncoder.encode(chosen_seats,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                out.close();
                InputStream inputStream=htp.getInputStream();
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String s=bufferedReader.readLine();
                bufferedReader.close();
                inputStream.close();
                htp.disconnect();
                return s;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(voids[0].equals("payment_made")){
            page="payment_made";
            info inf=new info();
            String email=inf.email;
            temp_num=voids[1];
            temp_nezt=String.valueOf(total_price);
            try {
                URL url=new URL(urlpay);
                HttpURLConnection htp= (HttpURLConnection) url.openConnection();
                htp.setRequestMethod("POST");
                htp.setDoOutput(true);

                OutputStream outputStream=htp.getOutputStream();
                OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
                String data=URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("date","UTF-8")+"="+URLEncoder.encode(date,"UTF-8")+"&"
                        +URLEncoder.encode("time","UTF-8")+"="+URLEncoder.encode(time,"UTF-8")+"&"
                        +URLEncoder.encode("coach","UTF-8")+"="+URLEncoder.encode(coach,"UTF-8")+"&"
                        +URLEncoder.encode("route","UTF-8")+"="+URLEncoder.encode(route,"UTF-8")+"&"
                        +URLEncoder.encode("seats","UTF-8")+"="+URLEncoder.encode(chosen_seats,"UTF-8")+"&"
                        +URLEncoder.encode("number","UTF-8")+"="+URLEncoder.encode(temp_num,"UTF-8")+"&"
                        +URLEncoder.encode("price","UTF-8")+"="+URLEncoder.encode(temp_nezt,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                outputStream.close();

                InputStream inputStream=htp.getInputStream();
                InputStreamReader inputStreamReader=new InputStreamReader(inputStream,"UTF-8");
                BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
                String s=bufferedReader.readLine();
                bufferedReader.close();
                inputStream.close();
                htp.disconnect();
                return s;

            } catch (IOException e) {
                Log.i("Hell", " here4");
                e.printStackTrace();
            }
        }
        if(voids[0].equals("view_ticket")||voids[0].equals("cancellation")){
            if(voids[0].equals("cancellation")){
                page="cancellation";
            }
            else{
                page="view_ticket";
            }
            info inf=new info();
            String email=inf.email;
            try {
                URL url=new URL(urlviewticket);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream out=httpURLConnection.getOutputStream();
                OutputStreamWriter ow=new OutputStreamWriter(out);
                BufferedWriter bw=new BufferedWriter(ow);
                String en= URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8");
                bw.write(en);
                bw.flush();
                out.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                InputStreamReader isr=new InputStreamReader(inputStream,"UTF-8");
                BufferedReader br=new BufferedReader(isr);
                String g=br.readLine();
                br.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return g;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        if(voids[0].equals("cancel_ticket")){
            page="cancel_ticket";
            String ticket_no=voids[1];
            String refund=voids[2];
            info inf=new info();
            String email=inf.email;
            String num=voids[3];
            try {
                URL url=new URL(urlcancel);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);


                OutputStream outputStream=httpURLConnection.getOutputStream();
                OutputStreamWriter outputStreamWriter=new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
                String data=URLEncoder.encode("email","UTF-8")+"="+URLEncoder.encode(email,"UTF-8")+"&"
                        +URLEncoder.encode("refund","UTF-8")+"="+URLEncoder.encode(refund,"UTF-8")+"&"
                        +URLEncoder.encode("number","UTF-8")+"="+URLEncoder.encode(num,"UTF-8")+"&"
                        +URLEncoder.encode("ticket_no","UTF-8")+"="+URLEncoder.encode(ticket_no,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                outputStream.close();

                InputStream inputStream = httpURLConnection.getInputStream();
                inputStream.close();
                httpURLConnection.disconnect();

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(voids[0].equals("viewing")){
            page="viewing";
            String ticket=voids[1];
            try {
                URL url=new URL(urlticketfinder);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream out=httpURLConnection.getOutputStream();
                OutputStreamWriter ow=new OutputStreamWriter(out);
                BufferedWriter bw=new BufferedWriter(ow);
                String en= URLEncoder.encode("ticket","UTF-8")+"="+URLEncoder.encode(ticket,"UTF-8");
                bw.write(en);
                bw.flush();
                out.close();

                InputStream inputStream=httpURLConnection.getInputStream();
                InputStreamReader isr=new InputStreamReader(inputStream,"UTF-8");
                BufferedReader br=new BufferedReader(isr);
                String []g=br.readLine().split(" - ");
                br.close();
                inputStream.close();
                httpURLConnection.disconnect();
                route=g[0];
                coach=g[1];
                date=g[2];
                time=g[3];
                temp_nezt=g[4];
                temp_num=g[5];
                chosen_seats=g[6];
                return ticket;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return null;
    }
    @Override
    protected void onPostExecute(String s){
        if(page.equals("login")){
            page="";
            if(s.equals("true")){
                Intent in=new Intent(context,HomePage.class);
                context.startActivity(in);
            }
            else{
                Toast.makeText(context,"Email or Password Incorrect!" ,Toast.LENGTH_SHORT).show();
            }
        }
        if(page.equals("register")){
            page="";
            Intent in=new Intent(context,HomePage.class);
            Toast.makeText(context,s,Toast.LENGTH_SHORT).show();
            context.startActivity(in);
        }
        if(page.equals("seats")){
            page="";
            Intent in=new Intent(context,Seats.class);
            in.putExtra("seat_no",arr);
            in.putExtra("per_price",price);
            //Log.i("Hell", String.valueOf(price)+" here");
            context.startActivity(in);
        }
        if(page.equals("check_seats")){
            if(s.equals("run again")){
                page="seats";
            }
            else{
                page="";
                Intent in=new Intent(context,Payment.class);
                in.putExtra("chosen_seats",chosen_seats);
                in.putExtra("price",total_price);
                in.putExtra("date",date);
                in.putExtra("time",time);
                in.putExtra("coach",coach);
                in.putExtra("route",route);
                context.startActivity(in);
            }
        }
        if(page.equals("payment_made")||page.equals("viewing")){
            info inf=new info();
            String email=inf.email;
            Intent in=new Intent(context,ticket.class);
            in.putExtra("pemail",email);
            in.putExtra("pdate",date);
            in.putExtra("ptime",time);
            in.putExtra("pcoach",coach);
            in.putExtra("proute",route);
            in.putExtra("pnum",temp_num);
            in.putExtra("ticket_id",s);
            in.putExtra("pprice",temp_nezt);
            in.putExtra("pseats",chosen_seats);
            context.startActivity(in);
        }
        if(page.equals("view_ticket")){
            page="";
            Intent in=new Intent(context,Ticket_viewer.class);
            in.putExtra("info",s);
            context.startActivity(in);
        }
        if(page.equals("cancellation")){
            page="";
            Intent in=new Intent(context,Cancellation.class);
            in.putExtra("info1",s);
            context.startActivity(in);
        }
        if(page.equals("cancel_ticket")){
            page="";
            Intent in=new Intent(context,HomePage.class);
            context.startActivity(in);
        }
    }

}
