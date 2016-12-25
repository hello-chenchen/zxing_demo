/**  
 * Project Name:demo  
 * File Name:MergeImgUtil.java  
 * Package Name:com.hellochenchen.util  
 * Date:2016年12月25日下午7:42:39  
 * Copyright (c) 2016, hello_chenchen@163.com All Rights Reserved.  
 *  
*/  
  
package com.hellochenchen.util;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

/**  
 * ClassName:MergeImgUtil <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2016年12月25日 下午7:42:39 <br/>  
 * @author   hello_chenchen  
 * @version    
 * @since    JDK 1.8.0_111
 * @see        
 */
public class MergeImgUtil {

    public String MergeImages(String imgFilePath, String imgFilePath1)
    {
        String mergeFilePath = null;
        mergeFilePath = "D:\\demo\\demo3.jpg";
        try {
            InputStream image1 = new FileInputStream(imgFilePath);
            InputStream image2 = new FileInputStream(imgFilePath1);
            BufferedImage image3 = ImageIO.read(image1);
            BufferedImage image4 = ImageIO.read(image2);
            Graphics g=image3.getGraphics();
            g.drawImage(image4,280,280,80,80,null);
            OutputStream outImage=new FileOutputStream(mergeFilePath);
            JPEGImageEncoder enc=JPEGCodec.createJPEGEncoder(outImage);
            enc.encode(image3);
            image1.close();
            image2.close();
            outImage.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        
        return mergeFilePath;
    }
}
  
