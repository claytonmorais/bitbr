package br.com.bitbr.util;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;

/**
 * Classe utilitária para manipuluação do objeto Collection<?> utlizando a api commons beans utils da apache
 *
 */
public final class GenericCollectionUtils {

	/** 
	 * Remove o elemento pelo valor do atributo
	 * @param col lista a ser manipulada
	 * @param propertyValue valor da propriedade
	 * @param propertyName nome da propriedade
	 */
	public static final void removeByProperty(Collection<?> col,
			Object propertyValue, String propertyName) {
		BeanPropertyPredicate predicate = new BeanPropertyPredicate(propertyValue,
				propertyName, true);
		CollectionUtils.filter(col, predicate);
	}

	/**
	 * Remove o elemento da lista passando o objeto como parametro
	 * @param col lista a ser manipulada
	 * @param bean bean informado
	 * @param propertyName nome da propriedade para consulta
	 */
	public static final void removeByBean(Collection<?> col, Object bean,
			String propertyName) {
		BeanPredicate predicate = new BeanPredicate(bean, propertyName, true);
		CollectionUtils.filter(col, predicate);
	}

	/**
	 * Retém o elemento pelo valor do atributo
	 * @param col lista a ser manipulada
	 * @param propertyValue valor da propriedade
	 * @param propertyName nome da propriedade
	 */	
	public static final void retainByProperty(Collection<?> col,
			Object propertyValue, String propertyName) {
		BeanPropertyPredicate predicate = new BeanPropertyPredicate(propertyValue,
				propertyName);
		CollectionUtils.filter(col, predicate);
	}

	/**
	 * Retém o elemento da lista passando o objeto como parametro
	 * @param col lista a ser manipulada
	 * @param bean bean informado
	 * @param propertyName nome da propriedade para consulta
	 */	
	public static final void retainByBean(Collection<?> col, Object bean,
			String propertyName) {
		BeanPredicate predicate = new BeanPredicate(bean, propertyName);
		CollectionUtils.filter(col, predicate);
	}

	/**
	 * Consulta o elemento pelo valor do atributo
	 * @param col lista a ser manipulada
	 * @param propertyValue valor da propriedade
	 * @param propertyName nome da propriedade
	 */
	public static final Object findByProperty(Collection<?> col,
			Object propertyValue, String propertyName) {
		BeanPropertyPredicate predicate = new BeanPropertyPredicate(propertyValue,
				propertyName);
		return CollectionUtils.find(col, predicate);
	}

	/**
	 * Consulta o elemento da lista passando o objeto como parametro
	 * @param col lista a ser manipulada
	 * @param bean bean informado
	 * @param propertyName nome da propriedade para consulta
	 */	
	public static final Object findByBean(Collection<?> col, Object bean,
			String propertyName) {
		BeanPredicate predicate = new BeanPredicate(bean, propertyName);
		return CollectionUtils.find(col, predicate);
	}

	/**
	 * Verifica se contém o elemento pelo valor do atributo
	 * @param col lista a ser manipulada
	 * @param propertyValue valor da propriedade
	 * @param propertyName nome da propriedade
	 */	
	public static final boolean containsByProperty(Collection<?> col,
			Object propertyValue, String propertyName) {
		return findByProperty(col, propertyValue, propertyName) != null;
	}

	/**
	 * Verifica se contém o elemento da lista passando o objeto como parametro
	 * @param col lista a ser manipulada
	 * @param bean bean informado
	 * @param propertyName nome da propriedade para consulta
	 */		
	public static final boolean containsByBean(Collection<?> col, Object bean, String propertyName) {
		return findByBean(col, bean, propertyName) != null;
	}
	
	/**
	 * Seleciona os elementos pelo valor do atributo
	 * @param col lista a ser manipulada
	 * @param propertyValue valor da propriedade
	 * @param propertyName nome da propriedade
	 */
	public static final Collection<?> selectByProperty(Collection<?> col,
			Object propertyValue, String propertyName) {
		BeanPropertyPredicate predicate = new BeanPropertyPredicate(propertyValue,
				propertyName);
		return CollectionUtils.select(col, predicate);
	}

	/**
	 * Seleciona os elementos da lista passando o objeto como parametro
	 * @param col lista a ser manipulada
	 * @param bean bean informado
	 * @param propertyName nome da propriedade para consulta
	 */	
	public static final Collection<?> selectByBean(Collection<?> col, Object bean,
			String propertyName) {
		BeanPredicate predicate = new BeanPredicate(bean, propertyName);
		return CollectionUtils.select(col, predicate);
	}
	

	/**
	 * Para cada objeto retornado em uma iteracao ele pega <code>property</code>
	 * no objeto e coloca como chave em um TreeMap e o objeto retornado na
	 * iteracao vai para um TreeSet que eh valor da chave. Importante implementar
	 * a interface <code>java.lang.Comparable</code> nos objetos para que a
	 * ordenacao das colecoes seja consistente. <br>
	 * 
	 * @param it
	 * @param property
	 * @return mapa ordenado
	 */
	public static Map<Object,Object> createMapWithArrayValue(Iterator<Object> it, String property,
			Comparator<Object> comparator) {

		Map<Object,Object>  mapa = null;
		if (comparator == null)
			mapa = new TreeMap<Object,Object>();
		else
			mapa = new TreeMap<Object,Object>(comparator);

		while (it.hasNext()) {
			Object value = it.next();
			Object key = GenericBeanUtils.getProperty(value, property);

			Set<Object> s = null;
			if ((s = (Set<Object>) mapa.get(key)) != null) {
				s.add(value);
			} else {
				s = new TreeSet<Object>();
				s.add(value);
				mapa.put(key, s);
			}
		}

		return mapa;
	}

	public static final String printMap(Map<Object, Object> map, String mapDesc) {
		if (map == null)
			return "null = { null }";
		ByteArrayOutputStream bout = new ByteArrayOutputStream();
		MapUtils.debugPrint(new PrintStream(bout), mapDesc, map);
		return bout.toString();
	}
	
}
