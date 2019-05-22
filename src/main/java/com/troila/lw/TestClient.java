package com.troila.lw;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class TestClient {

	/**
	 * 調用被first-114（eureka集群）管理的first-person的接口服務
	 * @param args
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static void main(String[] args) throws ClientProtocolException, IOException {
		//創建默認的HttpClient
		CloseableHttpClient httpclient = HttpClients.createDefault();
		//調用6次服務并輸出結果
		for(int i=0; i<6; i++) {
			//調用get方法請求服務。當然也可以調用post方法，前提是你的服務端得提供post的接口
			HttpGet httpget = new HttpGet("http://localhost:8082/router");
			//獲取響應
			HttpResponse response = httpclient.execute(httpget);
			//根據響應解析出字符串
			System.out.println(EntityUtils.toString(response.getEntity()));
		}
	}

}
