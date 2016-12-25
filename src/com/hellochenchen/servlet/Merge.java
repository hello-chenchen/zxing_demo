/**  
 * Project Name:demo  
 * File Name:merge.java  
 * Package Name:com.hellochenchen.servlet  
 * Date:2016年12月25日下午6:43:21  
 * Copyright (c) 2016, hello_chenchen@163.com All Rights Reserved.  
 *  
*/  
  
package com.hellochenchen.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hellochenchen.util.UploadFileUtil;
import com.google.zxing.WriterException;
import com.hellochenchen.util.MergeImgUtil;
import com.hellochenchen.util.QRCodeUtil;

/**  
 * ClassName:Merge <br/>  
 * Function: TODO ADD FUNCTION. <br/>  
 * Reason:   TODO ADD REASON. <br/>  
 * Date:     2016年12月25日 下午6:43:21 <br/>  
 * @author   hello_chenchen  
 * @version    
 * @since    JDK 1.8.0_111
 * @see        
 */
public class Merge extends HttpServlet{
    
    public Merge(){
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          
        // TODO Auto-generated method stub  
        List<String> fileNameList = new ArrayList<String>();
        UploadFileUtil uploadfiles = new UploadFileUtil();
        fileNameList = uploadfiles.UploadFiles(req);
        String filePath1 = fileNameList.get(0);
        String filePath2 = fileNameList.get(1);
        
        MergeImgUtil mergeimage = new MergeImgUtil();
        String mergeFilePath = mergeimage.MergeImages(filePath1, filePath2);
        QRCodeUtil qrcode = new QRCodeUtil();
        try {
            qrcode.createQRCode(mergeFilePath, resp.getOutputStream());
        } catch (WriterException e) {
            e.printStackTrace();
        }

        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          
        // TODO Auto-generated method stub  
        doGet(req, resp);
    }
    
    

}
  
