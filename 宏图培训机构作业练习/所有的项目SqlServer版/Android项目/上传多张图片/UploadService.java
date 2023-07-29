package com.example.qq_lxr9y18r;

import java.io.File;  
import java.io.IOException;  
import java.util.ArrayList;  
import java.util.Map;  
import org.apache.http.HttpEntity;  
import org.apache.http.HttpResponse;  
import org.apache.http.client.ClientProtocolException;  
import org.apache.http.client.HttpClient;  
import org.apache.http.client.methods.HttpPost;  
import org.apache.http.entity.mime.HttpMultipartMode;  
import org.apache.http.entity.mime.MultipartEntityBuilder;  
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.qq_lxr9y18r.constant.URI_IP;

import android.os.Handler;  
   
/** 
 * ����HttpClient�ϴ��ļ�,֧�ֶ��ļ��ϴ� 
 * @author jph 
 * Date:2014.10.09 
 */  
public class UploadService {  
    private static String url=URI_IP.URI+"Android_Service/QQ/fuwuqi";  
//  private static String url="http://10.110.6.58:8080/ServerForUpload/ServletForUpload";  
    public static final int UPLOAD_SUCCESS=0x123;  
    public static final int UPLOAD_FAIL=0x124;  
    private Handler handler;  
    public UploadService(Handler handler) {  
        // TODO Auto-generated constructor stub  
        this.handler=handler;  
    }     
    /** 
     * @param params �����������������ĵķ�������method�磺��upload���� 
     * �����ϴ����ļ�����fileTypes�磺��.jpg.png.docx�� 
     * @param files Ҫ�ϴ����ļ����� 
     */  
    public void uploadFileToServer(final Map<String, String> params, final ArrayList<File>files) {  
        // TODO Auto-generated method stub    
        new Thread(new Runnable() {           
            @Override  
            public void run() {  
                // TODO Auto-generated method stub  
                try {  
                     if (uploadFiles(url,params,files)) {  
                        handler.sendEmptyMessage(UPLOAD_SUCCESS);//֪ͨ���߳����ݷ��ͳɹ�  
                    }else {  
                        //�����ݷ��͸�������ʧ��  
                    }  
                } catch (Exception e) {  
                    // TODO Auto-generated catch block  
                    e.printStackTrace();  
                }                 
            }  
        }).start();  
    }  
    /** 
     * @param url servlet�ĵ�ַ 
     * @param params Ҫ���ݵĲ��� 
     * @param files Ҫ�ϴ����ļ� 
     * @return true if upload success else false 
     * @throws ClientProtocolException 
     * @throws IOException 
     */  
    private boolean uploadFiles(String url,Map<String, String>params,ArrayList<File>files) throws ClientProtocolException, IOException {  
        HttpClient client=new DefaultHttpClient();// ����һ���ͻ��� HTTP ����   
        HttpPost post = new HttpPost(url);//���� HTTP POST ����    
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();  
//      builder.setCharset(Charset.forName("uft-8"));//��������ı����ʽ  
        builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);//�������������ģʽ  
        int count=0;  
        for (File file:files) {  
//          FileBody fileBody = new FileBody(file);//���ļ�ת����������FileBody  
//          builder.addPart("file"+count, fileBody);  
            builder.addBinaryBody("file"+count, file);  
            count++;  
        }         
        builder.addTextBody("method", params.get("method"));//�����������  
        builder.addTextBody("fileTypes", params.get("fileTypes"));//�����������  
        HttpEntity entity = builder.build();// ���� HTTP POST ʵ��        
        post.setEntity(entity);//�����������  
        HttpResponse response = client.execute(post);// �������� �������������Ӧ  
        if (response.getStatusLine().getStatusCode()==200) {  
            return true;  
        }  
        return false;         
    }  
}  