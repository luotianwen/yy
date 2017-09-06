package com.test;

public class ProviderMain {
    public static void main(String args[]){
    	//org.apache.log4j.LogManager.resetConfiguration();
        //org.apache.log4j.PropertyConfigurator.configure("src/test/resources/log4j.properties");
        com.alibaba.dubbo.container.Main.main(args);
       /* ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("classpath:/META-INF/spring/applicationContext-*.xml");
        context.start();
        synchronized (ProviderMain.class){
            while(true){
                try {
                    ProviderMain.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }*/
    }
}
