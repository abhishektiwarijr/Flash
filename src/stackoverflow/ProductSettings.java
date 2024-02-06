package stackoverflow;

public class ProductSettings {
    private boolean isTreasuryInfoEnabled;
    private boolean isTreasurySwiftInfoEnabled;
    private boolean isTreasuryExecutionControlEnabled;
    private boolean isAcceptEnabled;

    public ProductSettings setIsTreasuryInfoEnabled(boolean isTreasuryInfoEnabled) {
        this.isTreasuryInfoEnabled = isTreasuryInfoEnabled;
        return this;
    }

    public boolean getIsTreasuryInfoEnabled() {
        return isTreasuryInfoEnabled;
    }

    public ProductSettings setIsTreasurySwiftInfoEnabled(boolean isTreasurySwiftInfoEnabled) {
        this.isTreasurySwiftInfoEnabled = isTreasurySwiftInfoEnabled;
        return this;
    }

    public ProductSettings setIsTreasuryExecutionControlEnabled(boolean isTreasuryExecutionControlEnabled) {
        this.isTreasuryExecutionControlEnabled = isTreasuryExecutionControlEnabled;
        return this;
    }

    public ProductSettings setIsAcceptEnabled(boolean isAcceptEnabled) {
        this.isAcceptEnabled = isAcceptEnabled;
        return this;
    }

    public boolean getIsAcceptEnabled() {
        return isAcceptEnabled;
    }
}
