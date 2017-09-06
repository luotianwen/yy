package com.shifeng.util;

 
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.apache.log4j.Logger;
/**
 * 
*    
* 项目名称：mall   
* 类名称：SerializationUtil   
* 类描述： 序列化就是将一个对象转换为二进制的数据流。这样就可以进行传输，或者保存到文件中。如果一个类的对象要想实现序列化，就必须实现serializable接口。在此接口中没有任何的方法，此接口只是作为一个标识，表示本类的对象具备了序列化的能力而已。
*    	反序列化:将二进制数据流转换成相应的对象。
*  		如果想要完成对象的序列化，则还要依靠ObjectOutputStream和ObjectInputStream,前者属于序列化操作，而后者属于反序列化操作。
* 创建人：Win Zhong   
* 创建时间：2015年12月14日 上午10:13:42   
* 修改人：Win Zhong   
* 修改时间：2015年12月14日 上午10:13:42   
* 修改备注：   
* @version    
*
 */
public class SerializationUtil {
	static Logger logger = Logger.getLogger("SerializationUtil");
	
    /**
     * 序列化
     * @param object
     * @return
     */
    public static byte[] serialize(Object object) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baos);
            oos.writeObject(object);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
        	logger.error("将对象序列化为byte数组失败,请检查对象是否实现了序列化接口", e);
        }
        return null;
    }

    /**
     * 反序列化
     * 
     * @param bytes
     * @return
     */
    public static Object deserialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {

        }
        return null;
    }

}