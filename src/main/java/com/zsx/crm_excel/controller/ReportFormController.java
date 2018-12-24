package com.zsx.crm_excel.controller;

import com.zsx.crm_excel.pojo.UserInfo;
import com.zsx.crm_excel.service.UserInfoService;
import com.zsx.crm_excel.utils.ExcelUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.List;

@Controller
@RequestMapping(value = "/export")
public class ReportFormController{

    @Resource
    private UserInfoService userInfoService;

    /**
     * 导出报表
     * @return
     */
    @RequestMapping(value = "/excel")
    @ResponseBody
    public void export(String beginDate, String endDate, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //获取数据
        List<UserInfo> list = userInfoService.getUserInfoByTime(beginDate,endDate);

        //excel标题
        String[] title = {"id","姓名","电话","其他","标签","来源url","时间"};

        //excel文件名
        String fileName = "推广用户转化记录表"+System.currentTimeMillis()+".xls";

        //sheet名
        String sheetName = "推广用户转化记录表";
        String content[][] = new String[list.size()][title.length];
        for (int i = 0; i < list.size(); i++) {
            UserInfo userInfo = list.get(i);
//            System.out.println(userInfo);
            content[i][0] = userInfo.getId().toString();
            content[i][1] = userInfo.getName().toString();
            content[i][2] = userInfo.getTel().toString();
            content[i][3] = userInfo.getQita().toString();
            content[i][4] = userInfo.getTag().toString();
            content[i][5] = userInfo.getOrigin().toString();
            content[i][6] = DateFormat.getDateInstance().format(Long.parseLong(userInfo.getTime()) * 1000).toString();
        }

        //创建HSSFWorkbook
        HSSFWorkbook wb = ExcelUtil.getHSSFWorkbook(sheetName, title, content, null);

        //响应到客户端
        try {
            this.setResponseHeader(response, fileName);
            OutputStream os = response.getOutputStream();
            wb.write(os);
            os.flush();
            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //发送响应流方法
    public void setResponseHeader(HttpServletResponse response, String fileName) {
        try {
            try {
                fileName = new String(fileName.getBytes(),"ISO8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            response.setContentType("application/octet-stream;charset=ISO8859-1");
            response.setHeader("Content-Disposition", "attachment;filename="+ fileName);
            response.addHeader("Pargam", "no-cache");
            response.addHeader("Cache-Control", "no-cache");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
