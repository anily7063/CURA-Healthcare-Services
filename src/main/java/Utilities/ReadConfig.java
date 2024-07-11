package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
    Properties pro;
    public ReadConfig(){
        String workingDirectory =System.getProperty("user.dir");
        File src =new File(workingDirectory +"\\src\\main\\resources\\config\\object.properties");
        try{
            FileInputStream fis=new FileInputStream(src);
            pro=new Properties();
            pro.load(fis);
        }catch (Exception e){
            System.out.println("Exception is" +e.getMessage());
        }
    }
    public String getApplicationURL(){
        String url= pro.getProperty("baseURL");
        return url;
    }
    public String getUserName(){
        String usrname=pro.getProperty("username");

        return usrname;
    }
    public String getPassword(){
        String pswd=pro.getProperty("password");
        return pswd;

    }
}
