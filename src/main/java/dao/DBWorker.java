package dao;

import org.telegram.telegrambots.meta.api.objects.Message;

public interface DBWorker {

      public void addTransactionFromUser(Message message );

      public int checkScenarioFlag(Message message);

      public boolean checkUserRights(Message message);

      public void setScenarioFlag(Message message, int scenario_flag);
}

