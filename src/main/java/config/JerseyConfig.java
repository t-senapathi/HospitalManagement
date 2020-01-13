package config;

import global.coda.hms.api.DoctorApi;
import global.coda.hms.api.PatientApi;
import org.glassfish.jersey.server.ResourceConfig;

/**
 * The type Jersey config.
 */
public class JerseyConfig extends ResourceConfig {
	/**
	 * Instantiates a new Jersey config.
	 */
	public JerseyConfig() {
		register(PatientApi.class);
		register(DoctorApi.class);
	}

}
