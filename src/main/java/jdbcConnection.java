import java.io.FileInputStream;
import java.io.IOException;
import java.io.Console;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class jdbcConnection
{
	static Connection _conn = null;

    public static Connection getConnection() {
		Properties _props = new Properties();
		Console _scan = System.console();
		FileInputStream _fis = null;
		
		try {
			_fis = new FileInputStream(_scan.readLine("path to properties file : "));
			_props.load(_fis);

			// load the Driver Class
			Class.forName(_props.getProperty("db.DRIVER_CLASS"));

			// create the connection now
			_conn = DriverManager.getConnection(_props.getProperty("db.URL"),
					_props.getProperty("db.USERNAME"),
					_props.getProperty("db.PASSWORD"));
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return _conn;
	}

	public void queryConnection() throws SQLException, IOException
    {
        PreparedStatement _ps = _conn.prepareStatement("select SYSDATE from dual");
        ResultSet _rs = _ps.executeQuery();
         
        while (_rs.next())
        {
            // do the thing you do
        }
        _rs.close();
        _ps.close();
    }

    public static void main(String[] args) 
    {
        jdbcConnection _plug = new jdbcConnection();
		_plug.getConnection();
		try {
		_plug.queryConnection();
		} catch (IOException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
    }
}
