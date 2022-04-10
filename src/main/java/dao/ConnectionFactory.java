package dao;

import javax.servlet.ServletContext;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionFactory {

    private static Connection connection = null;
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "root";
    private static final String PORT = "5432";
    private static final String DATABASE_NAME = "javaEETestDb";
    private static final String HOST = "localhost";
    private static String URL = "jdbc:postgresql://"+HOST+":"+PORT+"/"+DATABASE_NAME;
    private static Logger LOGGER = Logger.getLogger(ConnectionFactory.class.getName());

    public static Connection getConnection(){
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
                if (connection !=null) LOGGER.log(Level.INFO," connexion avec la base de donné reusie ");
                else  LOGGER.log(Level.SEVERE," Echec de la connexion a la base de donné ");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static Connection getConnection(ServletContext context){
        if (connection == null) {
            try {
                String url = context.getInitParameter("URL");
                String user = context.getInitParameter("USER");
                String password = context.getInitParameter("PASSWORD");
                System.out.println(" User =  "+user);
                System.out.println(" password =  "+password);
                connection = DriverManager.getConnection(url,user,password);
                if (connection !=null) LOGGER.log(Level.INFO," ================ CONNEXION AVEC LA BASE DE DONNE REUSSIE ============== ");
                else  LOGGER.log(Level.SEVERE," ================== ECHEC DE LA CONNEXION AVEC LA BASE DE DONNE ================= ");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    static {
        try {
            Class.forName("org.postgresql.Driver");
            LOGGER.log(Level.INFO," ================ DRIVER LOADED ============== ");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            LOGGER.log(Level.SEVERE," ================ {0} ============== ",e.getCause());
        }
    }

}
