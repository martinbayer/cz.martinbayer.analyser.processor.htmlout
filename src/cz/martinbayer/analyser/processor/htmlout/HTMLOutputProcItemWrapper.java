package cz.martinbayer.analyser.processor.htmlout;

import javax.inject.Inject;

import org.eclipse.e4.core.contexts.IEclipseContext;
import org.eclipse.swt.events.MouseEvent;

import cz.martinbayer.analyser.impl.ConcreteE4LogsisLog;
import cz.martinbayer.analyser.processor.htmlout.paletteitem.HTMLOutputProcPaletteItem;
import cz.martinbayer.analyser.processor.htmlout.processor.HTMLOutputProcLogic;
import cz.martinbayer.analyser.processors.IProcessorItemWrapper;
import cz.martinbayer.analyser.processors.IProcessorLogic;
import cz.martinbayer.analyser.processors.IProcessorsPaletteItem;

public class HTMLOutputProcItemWrapper implements
		IProcessorItemWrapper<ConcreteE4LogsisLog> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1866711599665054824L;
	private HTMLOutputProcLogic logic;
	private HTMLOutputProcPaletteItem paletteItem;

	@Override
	public IProcessorLogic<ConcreteE4LogsisLog> getProcessorLogic() {
		if (logic == null) {
			logic = new HTMLOutputProcLogic();
		}
		return logic;
	}

	@Override
	public IProcessorsPaletteItem getProcessorPaletteItem() {
		if (paletteItem == null) {
			paletteItem = new HTMLOutputProcPaletteItem();
		}
		return paletteItem;
	}

	@Override
	public void mouseDoubleClicked(MouseEvent e) {
		paletteItem.openDialog(logic);
	}

	@Override
	public IProcessorItemWrapper<ConcreteE4LogsisLog> getInstance() {
		return new HTMLOutputProcItemWrapper();
	}

	@Inject
	public void setContext(IEclipseContext ctx) {
		Activator.setEclipseContext(ctx);
	}
}
