package com.certification;


import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

class Hola{
     static String name1 = "hell";
        }
public  abstract class Main extends Hola{
      static String name = "hell";

        String ll;

      public static void main(String[] args) throws Exception {


          String backupId = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date());

          Boolean siple = new SimpleDateFormat("yyyyMMdd-HHmmss")
                  .parse(backupId).before(Date.from(Instant.now().minus(3, ChronoUnit.SECONDS)));

          System.out.println(siple);


      }


  }
