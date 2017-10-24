
package br.com.bitbr.util;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.Predicate;

public class BeanPropertyPredicate implements Predicate {

	private Object property;
	private String propertyName;
	private boolean reverse;

	public BeanPropertyPredicate(Object property, String propertyName) {
		this.property = property;
		this.propertyName = propertyName;
	}

	public BeanPropertyPredicate(Object property, String propertyName, boolean reverse) {
		this(property, propertyName);
		this.reverse = reverse;
	}

	/**
	 * @see org.apache.commons.collections.Predicate#evaluate(java.lang.Object)
	 */
	public boolean evaluate(Object input) {

		Object inputProp = null;
		try {
			inputProp = PropertyUtils.getProperty(input, propertyName);
		} catch (Exception ex) {
			throw new RuntimeException("Problemas usando PropertyUtils.getProperty",
					ex);
		}

		if (reverse)
			return !property.equals(inputProp);
		else
			return property.equals(inputProp);
	}

}
