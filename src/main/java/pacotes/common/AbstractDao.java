package main.java.pacotes.common;

import main.java.pacotes.util.jdbc.config.JDBCConfig;


/**
 *
 * @author Tiago M
 */
public abstract class AbstractDao extends JDBCConfig{
	
	public AbstractDao() {
		 new JDBCConfig();
	}
}