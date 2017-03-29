package org.tutorial.javajasperreport;

import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.tutorial.javajasperreport.conn.ConnectionUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.OutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;

/**
 * Pass parameters and connection Database information to report from Java
 * 
 * @author DatLT
 *
 */
public class JavaCallJasperReport {

	public static void main(String[] args) throws JRException, ClassNotFoundException, SQLException {
		String reportSrcFile = "D:/E-BOOKS/workspace_WEB/HelloJasperReport/FirstJasperReport.jrxml";
		// Compile source file
		JasperReport jasperReport = JasperCompileManager.compileReport(reportSrcFile);
		Connection conn = ConnectionUtils.getConnection();

		// Parameters to pass to report
		Map<String, Object> parameters = new HashMap<String, Object>();
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);

		// Create output folder
		File outDir = new File("C:/jasperoutput");
		outDir.mkdirs();

		// PDF exportor
		JRPdfExporter exporter = new JRPdfExporter();
		ExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
		// ExporterInput
		exporter.setExporterInput(exporterInput);
		// ExporterOutput
		OutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
				"C:/jasperoutput/FirstJasperReport.pdf");
		// Output
		exporter.setExporterOutput(exporterOutput);

		//
		SimplePdfExporterConfiguration configuration = new SimplePdfExporterConfiguration();
		exporter.setConfiguration(configuration);
		exporter.exportReport();

		System.out.print("Done!");
	}

}
