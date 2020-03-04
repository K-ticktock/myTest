package com.demo.test.test1.jasperReport;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.*;
import net.sf.jasperreports.engine.util.JRLoader;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportExporter {
    /**
     * 获取打印报表
     */
    public static void exportReport(HttpServletRequest request, HttpServletResponse response, String reportId,
                                    String exportMode, Map parameterMap, List dataList, String downloadFileName) throws Exception {
        try {
            if (dataList == null) {
            }
            ServletContext servletContext = request.getSession().getServletContext();
//            File jasperFile = new File(servletContext.getRealPath("/resources/"+reportId + ".jasper"));
            File jasperFile = new File("/Users/jiaozheng/Desktop/CSII/"+reportId + ".jasper");
            if (!jasperFile.exists())
                throw new IOException("Report file can't be found");

            if (parameterMap == null)
                parameterMap = new HashMap();
            //ireport3.0用这个
            // JasperReport jasperReport = (JasperReport)JRLoader.loadObject(jasperFile.getPath());
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperFile);
            JasperPrint jasperPrint = null;

            JRDataSource source = new JRBeanCollectionDataSource(dataList);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameterMap, source);


            if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0)
                downloadFileName = new String(downloadFileName.getBytes("UTF-8"), "ISO8859-1");// firefox浏览器
            else if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0)
                downloadFileName = new String(downloadFileName.getBytes("gb2312"), "ISO8859-1");// IE浏览器

            if (ReportExportMode.EXP_PDF_MODE.equalsIgnoreCase(exportMode)) {
                exportPdf(response, jasperPrint, downloadFileName);
            } else if (ReportExportMode.EXP_EXCEL_MODE.equalsIgnoreCase(exportMode)) {
                exportExcel(response, jasperPrint, downloadFileName);
            } else if ("word".equals(exportMode)) {
                exportWord(response, jasperPrint, downloadFileName);
            } else if ("rtf".equals(exportMode)) {
                exportRTF(response, jasperPrint, downloadFileName);
            } else if ("html".equals(exportMode)) {
                exportHtml(response, jasperPrint, downloadFileName);
            }
        } finally {
        }
    }

    /**
     * pdf导出
     */
    private static void exportPdf(HttpServletResponse response, JasperPrint jasperPrint, String downloadFileName)
            throws JRException, IOException {
        ServletOutputStream ouputStream = response.getOutputStream();

        try {
            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);

            response.setContentType("application/pdf;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + downloadFileName + ".pdf");
            exporter.exportReport();
            ouputStream.flush();
        } finally {
            try {
                ouputStream.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * excel导出
     */
    private static void exportExcel(HttpServletResponse response, JasperPrint jasperPrint, String downloadFileName)
            throws JRException, IOException {
        ServletOutputStream ouputStream = response.getOutputStream();

        try {
            JRXlsExporter exporter = new JRXlsExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, ouputStream);
            response.setContentType("application/vnd_ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + downloadFileName + ".xls");
            exporter.exportReport();
            ouputStream.flush();
        } finally {
            try {
                ouputStream.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * 导出word
     */
    private static void exportWord(HttpServletResponse response, JasperPrint jasperPrint, String downloadFileName)
            throws JRException, IOException {
        ServletOutputStream ouputStream = response.getOutputStream();

        try {
            JRExporter exporter = new JRRtfExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, ouputStream);

            response.setContentType("application/msword;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + downloadFileName + ".doc");
            exporter.exportReport();
            ouputStream.flush();
        } finally {
            try {
                ouputStream.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * 导出RTF
     */
    private static void exportRTF(HttpServletResponse response, JasperPrint jasperPrint, String downloadFileName)
            throws JRException, IOException {
        ServletOutputStream ouputStream = response.getOutputStream();

        try {
            JRExporter exporter = new JRRtfExporter();
            exporter.setParameter(JRXlsExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRXlsExporterParameter.OUTPUT_STREAM, ouputStream);

            response.setContentType("application/rtf;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + downloadFileName + ".rtf");
            exporter.exportReport();
            ouputStream.flush();
        } finally {
            try {
                ouputStream.close();
            } catch (Exception e) {
            }
        }
    }

    /**
     * 导出html
     */
    private static void exportHtml(HttpServletResponse response, JasperPrint jasperPrint, String downloadFileName)
            throws JRException, IOException {
        ServletOutputStream ouputStream = response.getOutputStream();

        try {
            JRHtmlExporter exporter = new JRHtmlExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
            exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "UTF-8");
            exporter.setParameter(JRHtmlExporterParameter.IS_USING_IMAGES_TO_ALIGN, Boolean.FALSE);
            response.setContentType("text/html;charset=utf-8");
            exporter.exportReport();
            ouputStream.flush();
        } finally {
            try {
                ouputStream.close();
            } catch (Exception e) {
            }
        }
    }
}

