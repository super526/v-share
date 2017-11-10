package com.supan.vshare.controller;

import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.supan.vshare.common.constants.SeedConst;
import com.supan.vshare.common.utils.RestClient;
import com.supan.vshare.common.utils.StringCovert;
import com.supan.vshare.dto.response.SeedResp;
import com.supan.vshare.model.DomainInfo;
import com.supan.vshare.service.DomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * excel 文件导入
 *
 * @author supan
 * @Date 2017/11/9 19:22
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Slf4j
@RestController
public class DomainController {

    private static final int DEFAULT_SHEET_IDX = 0;
    private static final int STYLE_ROW_INDEX = 2;
    private static final int SHEET_ROW_INDEX = 0;
    private static final int WORKBOOK_SHEET_INDEX = 0;
    private static final int SHEET_TITLE_ROW = 1;
    @Autowired
    private DomainService domainService;
    /**
     * excel模版文件路径
     */
    @Value("${domain.excel.template.dir}")
    protected String templtPath;
    /**
     * 页面对应--excel模版
     */
    private static final String tmpltName = SeedConst.REPORT_EXCEL_TEMPLATE;

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public SeedResp upload(@RequestParam("file") MultipartFile file) throws Exception {
        /**获取上传excel的域名数据*/
        log.info("开始执行::DomainController.upload()方法");
        //创建Excel
        Workbook wb = WorkbookFactory.create(file.getInputStream());
        //创建表格sheet
        Sheet sheet = wb.getSheetAt(DEFAULT_SHEET_IDX);
        Iterator<Row> itDataRow = sheet.rowIterator();
        List<String> list = Lists.newArrayList();
        // 对每行进行处理 从第一行开始读取excel数据
        while (itDataRow.hasNext()) {
            Row dataRow = itDataRow.next();
            //获取每行的第一列单元格
            Cell cell = dataRow.getCell(0);
            if (null == cell || StringUtils.isBlank(cell.getStringCellValue())) {
                break;
            }
            list.add(cell.getStringCellValue());
        }
        List<DomainInfo> domainInfos = list.stream().map(item -> {
            DomainInfo info = new DomainInfo();
            item = item.replace(" ","");
            info.setDomainName(item);
            //发送http请求到nic.wang域名请求接口，获取返回数据
            String strVal = RestClient.getDomainInfoByDoName(item);
            //解析返回的域名信息数据，转换成--域名对象
            info = StringCovert.setDomainInfo(info, strVal);
            return info;
        }).collect(Collectors.toList());
        log.info("开始执行::DomainService.Save()方法");
        /**再次导入时，删除原导入域名数据*/
        domainService.deleteAll();
        domainService.save(domainInfos);
        log.info("开始执行::DomainService.Save()结束");
        return SeedResp.success(domainInfos);
    }

    /**
     * excel导出-功能
     * DomainInfo domainInfo = new DomainInfo("北京中医网.商城", "苏攀", "2017-02-22 12:12:12", "2017-02-22 12:12:12");
     **/
    @GetMapping(value = "/export")
    public void export(HttpServletRequest request,
                       HttpServletResponse response) throws Exception {

        List<DomainInfo> queryList = domainService.findAll();
        log.info("开始执行::EffectPriceController.export()方法,参数:{}", new Gson().toJson(queryList));
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            response.reset();
            // 火狐
            if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
                response.addHeader("Content-Disposition",
                        "attachment; filename=\"" + new String("商城域名报表".getBytes("GB2312"), "ISO-8859-1")
                                + ".xlsx" + "\"");
            }
            // IE及其他
            else {
                response.addHeader("Content-Disposition",
                        "attachment; filename=\"" + URLEncoder.encode("商城域名报表", "utf-8") + ".xlsx" + "\"");
            }
            response.setContentType("application/vnd.ms-excel");
            // 取得相应模板文件
            File tmpltFile = FileUtils.getFile(templtPath + tmpltName + SeedConst.EXCEL_SUFFIX);
            // 声明一个工作薄
            Workbook workBook = WorkbookFactory.create(new FileInputStream(tmpltFile));
            // 获取模板sheet表格
            Sheet sheet = workBook.getSheetAt(WORKBOOK_SHEET_INDEX);
            //获取第一行
            Row styleRow = sheet.getRow(SHEET_ROW_INDEX);
            //获取表格sheet的行单元格格式
            CellStyle cellStyle = styleRow.getCell(STYLE_ROW_INDEX).getCellStyle();
            if (!CollectionUtils.isEmpty(queryList)) {
                //第一行为标题行
                int titleRowNum = SHEET_TITLE_ROW;
                //设置数据行,从第2行开始写入数据
                for (int rowNum = titleRowNum; rowNum < queryList.size() + titleRowNum; rowNum++) {
                    DomainInfo info = queryList.get(rowNum - titleRowNum);
                    //创建数据行，起始行为第2行
                    Row row = sheet.createRow(rowNum);
                    //为数据行--单元格设置数据
                    this.createCell(row, 0, info.getDomainName(), cellStyle);
                    this.createCell(row, 1, info.getRegistrName(), cellStyle);
                    this.createCell(row, 2, info.getRegistrDate(), cellStyle);
                    this.createCell(row, 3, info.getExpiryDate(), cellStyle);
                }
            }
            workBook.write(response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            log.error("DomainController.export()方法异常:", e);
            writer.write(new Gson().toJson(SeedResp.fail("导出异常").toString()).toString());
            response.flushBuffer();
        }
    }

    // 创建单元格，并设置值，和单元格样式
    private void createCell(Row row, Integer index, String value, CellStyle cellStyle) {
        Cell cell = row.createCell(index);
        cell.setCellValue(value);
        cell.setCellStyle(cellStyle);
    }
}
