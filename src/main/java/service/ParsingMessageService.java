package service;
import dao.*;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public class ParsingMessageService {

    //private DbWorker dbWorker = new DbWorkerImpl();

    public static void parseMessage(Update update)
    {
        String mess_from_tlg = update.getMessage().getText();

        if(mess_from_tlg.equals("/start"))
        {

        }

        if(mess_from_tlg.equals("Поиск на Autoria"))
        {

        }

        if(mess_from_tlg.equals("Поиск на RST"))
        {

        };
    }

    public static SendMessage getAnswerMessage()
    {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Всегда один ответ");
        sendMessage.setChatId("424368769");
        return sendMessage;
    }

}
