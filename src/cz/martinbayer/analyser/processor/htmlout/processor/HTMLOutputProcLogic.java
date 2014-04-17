package cz.martinbayer.analyser.processor.htmlout.processor;

import java.io.File;

import cz.martinbayer.analyser.impl.ConcreteE4LogsisLog;
import cz.martinbayer.analyser.processors.IProcessorLogic;
import cz.martinbayer.analyser.processors.types.LogProcessor;

public class HTMLOutputProcLogic implements IProcessorLogic<ConcreteE4LogsisLog> {

	private HTMLOutputProcessor processor;

	@Override
	public LogProcessor<ConcreteE4LogsisLog> getProcessor() {
		if (processor == null) {
			processor = new HTMLOutputProcessor();
		}
		return processor;
	}

	public void setOutputFile(File selectedFile) {
		((HTMLOutputProcessor) getProcessor()).setOutputFile(selectedFile);
	}

}
