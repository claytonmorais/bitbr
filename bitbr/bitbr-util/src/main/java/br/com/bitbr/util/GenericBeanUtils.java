package br.com.bitbr.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.MapUtils;

public final class GenericBeanUtils {

	/** 
	 * Identico a <code>PropertyUtils.getProperty(obj, property)</code> mas sem as excessoes.
	 * 
	 * @param obj
	 * @param property
	 * @return o
	 */
	public static final Object getProperty(Object obj, String property) {
		try {
			return PropertyUtils.getProperty(obj, property);
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}

	public static final void copyProperties(Object to, Object from) {
		try {
			BeanUtils.copyProperties(to, from);
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}

	}

	public static final Map<?, ?> describe(Object o) {
		try {
			return BeanUtils.describe(o);
		} catch (Exception ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}
	
	public static final String printBean(Object o) {
		if (o == null)
			return "null = { null }";
		String clazzName = o.getClass().getName();
		Map<?, ?> propertyMap = GenericBeanUtils.describe(o);
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		MapUtils.debugPrint(new PrintStream(bout), clazzName, propertyMap);
		return bout.toString();
	}
	
}
