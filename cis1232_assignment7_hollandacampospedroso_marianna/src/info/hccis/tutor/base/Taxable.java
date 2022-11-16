package info.hccis.tutor.base;

/**
 * Interface for classes which have tax amounts
 *
 * @author bjmac
 * @since 20210325
 */
public interface Taxable {

    public static final double TAX_PERCENTAGE_STUDENT = 0.15;
    public static final double TAX_PERCENTAGE_NON_STUDENT = 0.2;

    public double calculateTaxAmount();
}
