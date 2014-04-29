package cz.martinbayer.analyser.processor.htmlout.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import cz.martinbayer.analyser.impl.ConcreteE4LogsisLog;

@XmlRootElement(name = "logrecord")
public class XMLE4LogsisLog extends ConcreteE4LogsisLog {

	private ConcreteE4LogsisLog log;

	public XMLE4LogsisLog() {
	}

	public XMLE4LogsisLog(ConcreteE4LogsisLog log) {
		this.log = log;
		initData(this.log);
	}

	@XmlJavaTypeAdapter(DateAdapter.class)
	@Override
	public Date getEventDateTime() {
		// TODO Auto-generated method stub
		return super.getEventDateTime();
	}

	private void initData(ConcreteE4LogsisLog log) {
		setErrorMessage(log.getErrorMessage());
		setEventDateTime(log.getEventDateTime());
		setFileName(log.getFileName());
		setLine(log.getLine());
		setLogLevel(log.getLogLevel());
		setMessage(log.getMessage());
		setRemoved(log.isRemoved());
		setThreadName(log.getThreadName());
	}
}

class DateAdapter extends XmlAdapter<String, Date> {

	private SimpleDateFormat dateFormat = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm:ss.SSS");

	@Override
	public String marshal(Date v) throws Exception {
		return dateFormat.format(v);
	}

	@Override
	public Date unmarshal(String v) throws Exception {
		return dateFormat.parse(v);
	}

}