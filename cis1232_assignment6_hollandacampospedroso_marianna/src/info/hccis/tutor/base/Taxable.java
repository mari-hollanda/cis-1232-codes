package info.hccis.tutor.base;

/**
 * Taxable interface
 *
 * @since 20210330
 * @author marianna hollanda
 */
public interface Taxable {

    public static final double TAX_PERCENTAGE_STUDENT = 0.15;
    public static final double TAX_PERCENTAGE_NON_STUDENT = 0.20;

    public abstract double calculateTaxAmount();

}
