package com.example.qq_lxr9y18r;  
  
import java.io.File;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.Map;  
import android.app.Activity;  
import android.os.Bundle;  
import android.os.Environment;  
import android.os.Handler;  
import android.os.Message;  
import android.view.View;  
import android.widget.Toast;  
  
/** 
 * 通过httpClient批量上传文件 
 * @author jph 
 * Date：2014.10.09   
 */  
public class Test extends Activity {  
    private ArrayList<File>files;  
    private Map<String, String>params;  
    Handler mHandler=new Handler(){  
        @Override  
        public void handleMessage(Message msg) {  
            // TODO Auto-generated method stub  
            switch (msg.what) {  
            case UploadService.UPLOAD_SUCCESS:  
                Toast.makeText(Test.this, "上传成功", Toast.LENGTH_LONG).show();  
                break;            
            }  
            super.handleMessage(msg);  
        }         
    };  
    @Override  
    protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.activity_test);       
        files=new ArrayList<File>();  
        params=new HashMap<String, String>();  
          
    }  
    public void upload(View v) {  
        files.clear();  
        params.clear();  
        File file=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/1.jpg");  
        File file2=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/2.jpg");  
        File file3=new File(Environment.getExternalStorageDirectory().getAbsolutePath()+"/3.jpg"); 
        files.add(file);  
        files.add(file2);  
        files.add(file3);  
        StringBuffer sbFileTypes=new StringBuffer();  
        for (File tempFile:files) {  
            String fileName=tempFile.getName();  
            sbFileTypes.append(getFileType(fileName));            
        }  
        params.put("fileTypes",sbFileTypes.toString());  
        params.put("method", "upload");  
        UploadService uploadService=new UploadService(mHandler);  
        uploadService.uploadFileToServer(params, files);  
    }  
    /** 
     * 获取文件的类型 
     * @param fileName ：文件名 
     * @return 文件类型 
     */  
    private String getFileType(String fileName) {  
        // TODO Auto-generated method stub  
        return fileName.substring(fileName.lastIndexOf("."), fileName.length());  
    }  
}  