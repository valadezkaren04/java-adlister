import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection;

    public MySQLAdsDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException error) {
            throw new RuntimeException("Error conecting to the database");
        }
    }

    @Override
    public List<Ad> all() {
        List<Ad> allAds = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String showAds = "SELECT * FROM ads";
            ResultSet rs = statement.executeQuery(showAds);

            while (rs.next()) {
                allAds.add(new Ad(
                        rs.getLong("id"),
                        rs.getLong("user_id"),
                        rs.getString("title"),
                        rs.getString("description")
                ));
            }
            return allAds;

        } catch (SQLException error) {
            throw new RuntimeException("ERROR retrieving all ads.");
        }

    }

    @Override
    public Long insert(Ad ad) {
        try {
            Statement statement = connection.createStatement();
            String insertAd = "INSERT INTO ads (user_id, title, description) VALUES ("
                    + ad.getUserId() + ", "
                    + "'" + ad.getTitle() + "',"
                    + "'" + ad.getDescription() + "')";
            statement.executeUpdate(insertAd, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = statement.getGeneratedKeys();
            rs.next();
            return rs.getLong(1);

        } catch (SQLException error) {
            throw new RuntimeException("COuld not insert ad successfully");
        }
    }
}
