package br.com.bitbr.util;


import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.Predicate;

public class BeanPredicate implements Predicate {

	private Object bean;
	private String property;
	private boolean reverse;
 
	public BeanPredicate(Object bean, String property) {
		this.bean = bean;
		this.property = property;
	}

	public BeanPredicate(Object bean, String property, boolean reverse) {
		this(bean, property);
		this.reverse = reverse;
	}

	/**
	 * @see org.apache.commons.collections.Predicate#evaluate(java.lang.Object)
	 */
	public boolean evaluate(Object input) {

		Object inputProp = null;
		Object prop = null;
		try {
			inputProp = PropertyUtils.getProperty(input, property);
			prop = PropertyUtils.getProperty(bean, property);
		} catch (Exception ex) {
			throw new RuntimeException("Problemas usando PropertyUtils.getProperty",
					ex);
		}

		if (reverse)
			return !prop.equals(inputProp);
		else
			return prop.equals(inputProp);
	}

}
