package config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.telegram.telegrambots.meta.api.objects.Message;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLEngine {

    private static SQLEngine instance = null;
    private static HikariDataSource ds = null;

    private SQLEngine()
    {

    }

    public static HikariDataSource getDs() {
        return ds;
    }

    public static SQLEngine getInstance()
    {
        System.out.println("getInstance()");
        if (instance == null)
            instance = new SQLEngine();
        return instance;
    }

    public void checkUserRights()
    {
        try{
            Connection con = DataSource.getConnection();
        }
        catch (Exception e){
        }

    }


    // TODO Save text russian correctly
    public void addTransactionFromUser(Message message )
    {
        try {
            Connection con = DataSource.getConnection();
            String sql = "insert into users_transaction(tlg_id, first_name, date_using_bot,message_text) values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setLong(1,message.getFrom().getId());
            ps.setString(2,message.getFrom().getFirstName());
            ps.setLong(3,message.getDate());
            //ps.setString(4,message.getText());
            ps.setString(4,"test");
            ps.execute();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void checkScenarioFlag(Message message)
    {
        try
        {
            Connection con  = DataSource.getConnection();
            String query = "";
            PreparedStatement ps = con.prepareStatement(query);
            ps.execute();
        }
        catch(Exception e)
        {

        }
    }



}
