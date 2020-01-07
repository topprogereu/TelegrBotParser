package service;

import model.ExchangeRate;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ExchangeRateWorker {
    public static String getExchangeRateNow()
    {

        String course = "";
        try {
            URL url = new URL("https://api.privatbank.ua/p24api/pubinfo?json&exchange&coursid=5");
            URLConnection con = url.openConnection();
            InputStream inputStream = con.getInputStream();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
            }
            System.out.println(stringBuilder);

            ObjectMapper objectMapper = new ObjectMapper();
            ExchangeRate[] exchangeRates = objectMapper.readValue(url,ExchangeRate[].class);

            for (ExchangeRate x : exchangeRates)
                course += (x + "\n");


        }
        catch(Exception e )
        {
            System.out.println("Problem with connect to API PB.UA");
        }
//
//        ObjectMapper mapper = new ObjectMapper();
//        String str = "{\"ccy\":\"USD\",\"base_ccy\":\"UAH\",\"buy\":\"25.70000\",\"sale\":\"26.10000\"}";
//        try
//        {
//            ExchangeRate exchangeRate = mapper.readValue(str,ExchangeRate.class);
//            System.out.println(exchangeRate.toString());
//        }
//        catch(Exception e )
//        {
//            System.out.println("Error parse JSON");
//        }
        return course;
    }
}
