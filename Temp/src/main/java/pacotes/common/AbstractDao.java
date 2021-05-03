package pacotes.common;

import java.sql.Connection;

import pacotes.util.jdbc.config.JDBCConfig;


/**
 *
 * @author Tiago M
 */
public abstract class AbstractDao extends JDBCConfig{
	
	public AbstractDao() {
		 new JDBCConfig();
	}
}