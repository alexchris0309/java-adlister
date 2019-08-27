import java.sql.*;

import com.mysql.cj.jdbc.Driver;

import java.util.ArrayList;
import java.util.List;


public class MySQLAdsDao implements Ads {
    private Connection connection;




//    constructor

    public MySQLAdsDao() throws SQLException {
        DriverManager.registerDriver(new Driver());
        this.connection = DriverManager.getConnection(
                Config.getUrl(),
                Config.getUsername(),
                Config.getPassword()

        );
    }


    @Override
    public List<Ad> all() throws SQLException {


        Statement statement = connection.createStatement();
        String queryString = "SELECT * FROM ads";
        ResultSet results = statement.executeQuery(queryString);

        return generateAds(results);

    }


//    creating the ad array list with the ad objects;
    private List<Ad> generateAds(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extracted(rs));

        }
        return ads;

    }

//    this is creating ad object

    private Ad extracted(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getInt("id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }



    @Override
    public Long insert(Ad ad) throws SQLException {
        Statement statement = connection.createStatement();
        String adding = String.format("INSERT INTO ads (user_id, title, description) VALUES (%d, '%s', '%s')", ad.getUserId(), ad.getTitle(), ad.getDescription());
        long queue = statement.executeUpdate(adding);
        return queue;
    }


}
