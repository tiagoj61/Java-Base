package pacotes.util.jdbc.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
*
* @author Tiago M
*/
public class JDBCProperties {

	 private static final Properties properties;
	    
	    static {
	        properties = getPropertiesFile();
	    }
	    
	    private static Properties getPropertiesFile() {
	        final Properties props = new Properties();
	        try {
	            final InputStream resourceAsStream = JDBCProperties.class.getClassLoader().getResourceAsStream("jdbc.properties");
	            if (resourceAsStream == null) {
	                throw new RuntimeException("Arquivo não encontrado", new FileNotFoundException());
	            }
	            props.load(resourceAsStream);
	        }
	        catch (IOException exception) {
	            throw new RuntimeException("Arquivo não encontrado", exception);
	        }
	        return props;
	    }
	    
	    public static String get(final String propriedade) {
	        return JDBCProperties.properties.getProperty(propriedade);
	    }
	}
