package scan.test;
import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class sample {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
     System.out.println("Sample test1 ");
     CloseableHttpClient httpClient = HttpClients.createDefault();

     try {

         HttpGet request = new HttpGet("https://httpbin.org/get");

         // add request headers
         request.addHeader("custom-key", "mkyong");
         request.addHeader(HttpHeaders.USER_AGENT, "Googlebot");

         CloseableHttpResponse response = httpClient.execute(request);

         try {

            
             System.out.println(response.getProtocolVersion());              
             System.out.println(response.getStatusLine().getStatusCode());  
             System.out.println(response.getStatusLine().getReasonPhrase()); 
             System.out.println(response.getStatusLine().toString());       

             HttpEntity entity = response.getEntity();
             if (entity != null) {
                
                 String result = EntityUtils.toString(entity);
                 System.out.println(result);
             }

         } finally {
             response.close();
         }
     } finally {
         httpClient.close();
     }
     
     
     
	}

}
