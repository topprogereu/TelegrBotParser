
import bot.MyAutoParserBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Main  {
    public static void main(String[] args) {
        start();
    }
    public static void start()
    {
        ApiContextInitializer.init();
        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new MyAutoParserBot());
        }
        catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
