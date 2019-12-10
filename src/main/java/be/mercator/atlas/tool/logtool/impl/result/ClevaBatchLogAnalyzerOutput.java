package be.mercator.atlas.tool.logtool.impl.result;

import java.util.ArrayList;
import java.util.List;

import be.mercator.atlas.tool.logtool.api.LogProcessorOutput;
import be.mercator.atlas.tool.logtool.impl.result.template.ClevaBatchLogAnalyzerOutputTemplate;

public class ClevaBatchLogAnalyzerOutput implements LogProcessorOutput {

	private List<ClevaBatchLogAnalyzerOutputTemplate> templates;

	/**
	 * 
	 * @return
	 */
	public List<ClevaBatchLogAnalyzerOutputTemplate> getTemplates() {

		if (this.templates == null) {
			this.templates = new ArrayList<>();
		}

		return this.templates;
	}
}
