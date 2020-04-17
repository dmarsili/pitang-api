package br.com.danielmarsili.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

/**
 * The Class ApplicationUtils.
 */
public class ApplicationUtils {

	private ApplicationUtils() {
	    throw new IllegalStateException("Utility class");
	  }

	/**
	 * Map bean.
	 *
	 * @param <T>        the generic type
	 * @param toMap      the to map
	 * @param clazzToMap the clazz to map
	 * @return the t
	 */
	public static <T> T mapBean(final Object toMap, final Class<T> clazzToMap) {
		if (toMap == null) {
			return null;
		}
		Mapper mapper = DozerBeanMapperBuilder.buildDefault();
		return mapper.map(toMap, clazzToMap);
	}

	/**
	 * Map beans.
	 *
	 * @param <T>      the generic type
	 * @param <U>      the generic type
	 * @param source   the source
	 * @param destType the dest type
	 * @return the list
	 */
	public static <T, U> List<U> mapBeans(final List<T> source, final Class<U> destType) {
		if (source == null) {
			return Collections.emptyList();
		}
		final List<U> dest = new ArrayList<>();
		source.stream().forEach(s -> dest.add(mapBean(s, destType)));
		return dest;
	}
}
