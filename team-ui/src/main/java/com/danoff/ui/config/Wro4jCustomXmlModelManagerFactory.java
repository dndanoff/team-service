package com.danoff.ui.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ro.isdc.wro.manager.factory.ConfigurableWroManagerFactory;
import ro.isdc.wro.model.factory.WroModelFactory;
import ro.isdc.wro.model.factory.XmlModelFactory;

public class Wro4jCustomXmlModelManagerFactory extends ConfigurableWroManagerFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(Wro4jCustomXmlModelManagerFactory.class);

	final private Properties props;

	public Wro4jCustomXmlModelManagerFactory(Properties props) {
		this.props = props;
	}

	@Override
	protected Properties newConfigProperties() {
		return props;
	}

	@Override
	protected WroModelFactory newModelFactory() {
		LOGGER.debug("loading from /wro.xml");
		return new XmlModelFactory() {
			@Override
			protected InputStream getModelResourceAsStream() throws IOException {
				String resourceLocation = "/wro.xml";
				LOGGER.info("Loading resource {}", resourceLocation);
				final InputStream stream = getClass().getResourceAsStream(resourceLocation);

				if (stream == null) {
					throw new IOException("Invalid resource requested: " + resourceLocation);
				}

				return stream;
			}
		};
	}

}