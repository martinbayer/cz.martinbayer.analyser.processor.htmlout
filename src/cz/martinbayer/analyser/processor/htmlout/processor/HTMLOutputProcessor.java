package cz.martinbayer.analyser.processor.htmlout.processor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.util.JAXBSource;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.e4.core.services.log.Logger;
import org.osgi.framework.FrameworkUtil;

import cz.martinbayer.analyser.impl.ConcreteE4LogsisLog;
import cz.martinbayer.analyser.processor.htmlout.Activator;
import cz.martinbayer.analyser.processor.htmlout.model.XMLE4LogsisLog;
import cz.martinbayer.analyser.processor.htmlout.model.XMLE4LogsisLogData;
import cz.martinbayer.analyser.processors.types.OutputProcessor;

public class HTMLOutputProcessor extends OutputProcessor<ConcreteE4LogsisLog> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3253139226567433220L;

	private static Logger log = Activator.getLogger();
	private XMLE4LogsisLogData<XMLE4LogsisLog> data;
	private File selectedFile;

	@Override
	protected void process() {
		data = new XMLE4LogsisLogData<>();
		if (logData != null) {
			for (ConcreteE4LogsisLog l : logData.getLogRecords()) {
				if (!l.isRemoved()) {
					data.addLogRecord(new XMLE4LogsisLog(l));
				}
			}
		}
	}

	@Override
	protected void createOutput() {
		JAXBContext context;
		try {
			context = JAXBContext.newInstance(XMLE4LogsisLog.class,
					XMLE4LogsisLogData.class);
			JAXBSource source = new JAXBSource(context, data);

			TransformerFactory tFactory = TransformerFactory.newInstance();
			URL xslTemplateUrl = FileLocator.find(
					FrameworkUtil.getBundle(HTMLOutputProcessor.class),
					new Path("resources/html_logs_table.xsl"), null);
			Source xslDoc = new StreamSource(xslTemplateUrl.openStream());
			OutputStream htmlFile = new FileOutputStream(this.selectedFile);

			Transformer transformer = tFactory.newTransformer(xslDoc);
			transformer.transform(source, new StreamResult(htmlFile));

			log.info("Results saved to XML file "
					+ this.selectedFile.getAbsolutePath());
		} catch (JAXBException | IOException | TransformerException e) {
			log.error(e, "Unable to save result as XML file "
					+ this.selectedFile.getAbsolutePath());
		}
	}

	@Override
	public void init() {
		// nothing needed to be initialized
	}

	public void setOutputFile(File selectedFile) {
		this.selectedFile = selectedFile;
	}

	@Override
	protected StringBuffer isSubProcessorValid() {
		if (this.selectedFile == null || !this.selectedFile.exists()) {
			return new StringBuffer("No output file selected for processor: ")
					.append(getName());
		}
		return null;
	}
}