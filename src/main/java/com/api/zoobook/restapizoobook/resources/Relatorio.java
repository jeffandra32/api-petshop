package com.api.zoobook.restapizoobook.resources;


import com.api.zoobook.restapizoobook.reports.EmployeeReport;
import com.api.zoobook.restapizoobook.repositores.EmployeeRepository;
import com.api.zoobook.restapizoobook.services.ReportService;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/v2/")
public class Relatorio {

    private final EmployeeRepository employeeRepository;
    private final ReportService reportService;

    @Autowired
    public Relatorio(final EmployeeRepository employeeRepository, final ReportService reportService){
        this.employeeRepository = employeeRepository;
        this.reportService = reportService;
    }

    @GetMapping
    public String getHome(){
        return "redirect:/employeeReport.pdf";
    }

    @GetMapping(value = "/relatorioCliente.pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    @ResponseBody
    public HttpEntity<byte[]> getEmployeeReportPdf(final HttpServletResponse response) throws JRException, IOException, ClassNotFoundException {
        final EmployeeReport report = new EmployeeReport(employeeRepository.findAll());
        final byte[] data = reportService.getReportPdf(report.getReport());

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_PDF);
        header.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=employeeReport.pdf");
        header.setContentLength(data.length);

        return new HttpEntity<byte[]>(data, header);
    }


    @GetMapping(value = "/relatorioCliente.xlsx", produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    @ResponseBody
    public HttpEntity<byte[]> getEmployeeReportXlsx(final HttpServletResponse response) throws JRException, IOException, ClassNotFoundException {
        final EmployeeReport report = new EmployeeReport(employeeRepository.findAll());
        final byte[] data = reportService.getReportXlsx(report.getReport());

        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"));
        header.set(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=employeeReport.xlsx");
        header.setContentLength(data.length);

        return new HttpEntity<byte[]>(data, header);
    }
}
