package org.tutorial.javajasperreport;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

public class PdfFromXmlFile {

	public static void main(String[] args) throws JRException, IOException {
		JasperReport jasperReport = JasperCompileManager
				.compileReport("C:/jasperreport/StyledTextReport.jrxml");
		
		// List of parameters
		Map<String, Object> parameters = new HashMap<String, Object>();
		// DataSource
		JRDataSource dataSource = new JREmptyDataSource();
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
		// File out
		File outDir = new File("C:/jasperoutput");
		outDir.mkdirs();

		// Run report and export to PDF file
		JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/jasperoutput/StyledTextReport.pdf");

		System.out.println("Done!");
	}

}
