package bot;

import config.SQLEngine;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import service.AutoRiaService;
import service.EmailSender;
import service.ExchangeRateWorker;

import java.util.ArrayList;
import java.util.List;

public class MyAutoParserBot extends TelegramLongPollingBot {

    private SQLEngine sqlEngine = SQLEngine.getInstance();

    public void onUpdateReceived(Update update) {
        try {
            if (update.hasMessage()) {
                Message message = update.getMessage();
                if (message.hasText() || message.hasLocation()) {
                    handleIncomingMessage(message);
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "bot.MyAutoParserBot";
    }

    public String getBotToken() {
        return "817526596:AAHIB9_-KnUhYWhFqdgeXsUo2TdPAzu1AHo";
    }

    private static boolean isCommandForOther(String text) {
        boolean isSimpleCommand = text.equals("/start") || text.equals("/help") || text.equals("/stop");
        boolean isCommandForMe = text.equals("/start@UaAutoParser_bot") || text.equals("/help@UaAutoParser_bot") || text.equals("/stop@UaAutoParser_bot");
        return text.startsWith("/") && !isSimpleCommand && !isCommandForMe;
    }

    public void handleIncomingMessage(Message message) throws TelegramApiException {

        // TODO Проверяем сценарий в БД
        sqlEngine.addTransactionFromUser(message);
        SendMessage sendMessage = new SendMessage();

        if (message.getText().equals("/start")) {
            sendMessage.setText("Без понтов, без рекламы, чисто пользуйся и хорошего настроения)");
            sendMessage.setChatId(message.getChatId());

            List<KeyboardRow> arr = new ArrayList<KeyboardRow>();
            KeyboardRow firstKeyboardRow = new KeyboardRow();
            KeyboardRow thirdKeyboardRow = new KeyboardRow();

            firstKeyboardRow.add("Поиск на Autoria");
            firstKeyboardRow.add("Поиск на Rst");
            thirdKeyboardRow.add("Поиск запчастей по WIN-коду");
            thirdKeyboardRow.add("Курс валют");
            //keyboardRow.add(keyboardButton3);
            arr.add(firstKeyboardRow);
            //arr.add(secondKeyboardRow);
            arr.add(thirdKeyboardRow);

            ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setKeyboard(arr);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(true);

            sendMessage.setReplyMarkup(replyKeyboardMarkup);
        }
        if(message.getText().equals("Курс валют"))
        {
            String tmp_str = ExchangeRateWorker.getExchangeRateNow();
            sendMessage.setText(tmp_str);
            sendMessage.setChatId(message.getChatId());
        }
        if(message.getText().equals("Поиск на Autoria"))
        {
            AutoRiaService.getAverageCoastAboutAuto();
            sendMessage.setText("Не реализовано");
            sendMessage.setChatId(message.getChatId());
        }
        if(message.getText().equals("Поиск на Rst"))
        {
            sendMessage.setText("Не реализовано");
            sendMessage.setChatId(message.getChatId());
        }
        if(message.getText().equals("Поиск запчастей по WIN-коду"))
        {
            sendMessage.setText("Не реализовано");
            sendMessage.setChatId(message.getChatId());
        }
        if(message.getText().equals("Отправка на email"))
        {
            sendMessage.setText("Не реализовано");
            sendMessage.setChatId(message.getChatId());
            EmailSender emailSender = new EmailSender("topprogereu@gmail.com","iqurjxupjpgborvt");
            emailSender.send("Hi","test","topprogereu@gmail.com","Pavel.Kosinskij@privatbank.ua");
        }


        execute(sendMessage);
    }




    public void addMyKeyBoard(SendMessage sendMessage)
    {
//        List<KeyboardRow> keyboardRows = new ArrayList<KeyboardRow>();
//        keyboardRows.add(new KeyboardRow().setText("Поиск на Autoria"))

        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        List <KeyboardRow> keyboardRows = new ArrayList<KeyboardRow>();
        KeyboardRow f_row = new KeyboardRow();
        f_row.add(new KeyboardButton("Поиск на Autoria"));
        KeyboardRow two_row = new KeyboardRow();
        f_row.add(new KeyboardButton("Поиск на Rst"));
        keyboardRows.add(f_row);
        keyboardRows.add(two_row);
        replyKeyboardMarkup.setKeyboard(keyboardRows);

        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        System.out.println("Добавили обьект клавиатуры");
//        replyKeyboardMarkup.setKeyboard(button1);
//        sendMessage.setReplyMarkup()
    }


}


