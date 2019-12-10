package be.mercator.atlas.tool.logtool.impl.result.template;

public class ClevaBatchLogErrorTemplate {

	private String errorExample;

	private int errorCount;

	public ClevaBatchLogErrorTemplate() {
		super();
	}

	public ClevaBatchLogErrorTemplate(String errorExample, int errorCount) {
		super();
		this.errorExample = errorExample;
		this.errorCount = errorCount;
	}

	public String getErrorExample() {
		return errorExample;
	}

	public void setErrorExample(String errorExample) {
		this.errorExample = errorExample;
	}

	public int getErrorCount() {
		return errorCount;
	}

	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}

	@Override
	public String toString() {
		return "ClevaBatchLogErrorTemplate [errorExample=" + errorExample + ", errorCount=" + errorCount + "]";
	}

}
