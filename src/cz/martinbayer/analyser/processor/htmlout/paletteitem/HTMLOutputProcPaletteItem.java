package cz.martinbayer.analyser.processor.htmlout.paletteitem;

import org.eclipse.swt.widgets.Display;

import cz.martinbayer.analyser.processor.htmlout.processor.HTMLOutputProcLogic;
import cz.martinbayer.analyser.processor.htmlout.processor.gui.HTMLOutputProcessorConfigDialog;
import cz.martinbayer.analyser.processor.htmlout.processor.gui.HTMLOutputProcessorConfigDialogModel;
import cz.martinbayer.analyser.processors.BasicProcessorPaletteItem;

public class HTMLOutputProcPaletteItem extends BasicProcessorPaletteItem {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3645758629361883292L;
	private static final String LABEL = "HTML output processor";
	private HTMLOutputProcessorConfigDialogModel model = new HTMLOutputProcessorConfigDialogModel();

	public HTMLOutputProcPaletteItem() {
		imagePath = "images/icon.png";
		disabledImagePath = "images/icon_dis.png";
	}

	@Override
	public String getLabel() {
		return LABEL;
	}

	public void openDialog(HTMLOutputProcLogic logic) {
		HTMLOutputProcessorConfigDialog dialog = new HTMLOutputProcessorConfigDialog(
				Display.getDefault().getActiveShell(), logic, model);
		dialog.open();
	}
}
