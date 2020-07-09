package com.hnak.elastic.rest.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestClientConfig extends AbstractFactoryBean<RestHighLevelClient> {

	private RestHighLevelClient restHighLevelClient;

	@Override
	public Class<RestHighLevelClient> getObjectType() {
		return RestHighLevelClient.class;
	}

	@Override
	protected RestHighLevelClient createInstance() throws Exception {
		// TODO Auto-generated method stub
		return buildClient();
	}

	@Override
	public boolean isSingleton() {
		return false;
	}

	private RestHighLevelClient buildClient() {
		try {
			restHighLevelClient = new RestHighLevelClient(RestClient.builder(new HttpHost("localhost", 9200, "http")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return restHighLevelClient;
	}

	@Override
	public void destroy() {
		try {
			if (restHighLevelClient != null) {
				restHighLevelClient.close();
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

}
