package dao;

import com.zaxxer.hikari.HikariDataSource;
import config.DataSource;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLEngine implements DBWorker {

    public DataSource ds = null;
    public static SQLEngine sqlEngine = null;

    private SQLEngine() {
        DataSource.getInstance();
    }

    public static SQLEngine getInstance() {
        if (sqlEngine == null)
            sqlEngine = new SQLEngine();
        return sqlEngine;
    }

    public boolean checkUserRights(Message message) {
        try (Connection con = ds.getConnection()){
            String query = "select * from users_rights where tlg_id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,message.getFrom().getId());
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                return true;
            }
        } catch (Exception e) {
            System.out.println("Возникло исключение");
        }
        return false;

    }

    @Override
    public void setScenarioFlag(Message message, int scenario_flag) {
        {
            try(Connection con = ds.getConnection()) {
                String query = "insert into telegram.users_scenario  values (?,?,?,?);";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1,message.getFrom().getId());
                ps.setInt(2,scenario_flag);
                ps.setLong(3, message.getDate());
                ps.setString(4, "test");
                ps.execute();
            } catch (Exception e) {
                System.out.println("Возникло исключение");
            }
        }
    }

        // TODO Save text russian correctly
        public void addTransactionFromUser (Message message )
        {
            try (Connection con = ds.getConnection()){
                String sql = "insert into users_transaction(tlg_id, first_name, date_using_bot,message_text) values (?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setLong(1, message.getFrom().getId());
                ps.setString(2, message.getFrom().getFirstName());
                ps.setLong(3, message.getDate());
                //ps.setString(4,message.getText());
                ps.setString(4, "test");
                ps.execute();
            } catch (SQLException e) {
                System.out.println("Возникло исключение");
            }
        }

        public int checkScenarioFlag (Message message)
        {
            try (Connection con = ds.getConnection()) {
                String query = "select number_of_scenario from users_scenario where tlg_id = ? ";
                PreparedStatement ps = con.prepareStatement(query);
                ps.setInt(1,message.getFrom().getId());
                ResultSet rs = ps.executeQuery();
                while(rs.next())
                {
                    return rs.getInt("number_of_scenario");
                }
                ps.execute();

            } catch (Exception e) {
                System.out.println("Возникло исключение");
            }
            return 0;
        }

}
