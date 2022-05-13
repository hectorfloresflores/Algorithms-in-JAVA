package com.certification;





import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

class Hola {
    public static VERB getVerb(PE_PARAM peParam) {
        Optional<String> verb = Arrays.stream(peParam.name().split("_")).findFirst();
        /*System.out.format("verb: %s  param: %s", verb.get(), );*/

        return Arrays.stream(VERB.values()).filter(verb1 -> {
            /*System.out.println(verb1.name().equals(verb.get()));*/
            return verb1.name().equals(verb.get());
        }).findFirst().get();
    }

    public static PE_ACTION getActionStep(PE_PARAM peParam) {
        String peAction = peParam.name().split("_",2)[1];
        return Arrays.stream(PE_ACTION.values()).filter(v -> {
            return v.name().equals(peAction);
        }).findFirst().get();
    }
    enum VERB {
        CREATE,
        DELETE
    }

    enum PE_ACTION {
        PRIVATE_ENDPOINT,
        RCE,
        SCAN_PROXY
    }

    enum PE_PARAM {
        CREATE_PRIVATE_ENDPOINT,
        CREATE_RCE,
        CREATE_SCAN_PROXY,
        DELETE_PRIVATE_ENDPOINT,
        DELETE_RCE,
        DELETE_SCAN_PROXY
    }
     static String name1 = "hell";
        }
public class Main {
      static String name = "hell";

        String ll;

      public static void main(String[] args) throws Exception {
          //String s = Hola.PE_PARAM.CREATE_PRIVATE_ENDPOINT.name().split("_", 2)[1];
          System.out.println(Hola.getActionStep(Hola.PE_PARAM.CREATE_PRIVATE_ENDPOINT));
          System.out.println(Hola.getActionStep(Hola.PE_PARAM.CREATE_RCE));
          System.out.println(Hola.getActionStep(Hola.PE_PARAM.CREATE_SCAN_PROXY));
          System.out.println(Hola.getActionStep(Hola.PE_PARAM.DELETE_PRIVATE_ENDPOINT));
          System.out.println(Hola.getActionStep(Hola.PE_PARAM.DELETE_RCE));
          System.out.println(Hola.getActionStep(Hola.PE_PARAM.DELETE_SCAN_PROXY));
          System.out.println(Hola.getActionStep(null));




          //System.out.println(CollectionUtils.isNotEmpty());


      }


  }
