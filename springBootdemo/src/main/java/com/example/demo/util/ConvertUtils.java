package com.example.demo.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

/**对象转换，对象属性值复制工具类
 * 对象复制
 * */
public class ConvertUtils {
	/*对象转换,对象属性名相同时值可复制
	 * https://blog.csdn.net/sinat_29774479/article/details/75072964
	 * */
	public static<S,T> T convertTo(S source,T target){//S,T表示泛型，表示未知类型的对象，为了与Object区分
		if(source==null || target==null){
			return null;
		}
		BeanUtils.copyProperties(source, target);
		return target;
	}
	
	/*List复制,对象属性名相同时值可复制*/
	public static<S,T> List<T> convertTo(List<S> sources,Class<T> destionationClass) throws InstantiationException, IllegalAccessException{
		if(sources==null || sources.size()<=0){
			return null;
		}
		List<T> targets=new ArrayList<T>(sources.size());
		for(S subSource:sources){
			T target=destionationClass.newInstance();
			BeanUtils.copyProperties(subSource, target);
			targets.add(target);
		}
		
		return targets;
	}
	
	//忽视null值问题
	public static String[] getNullPropertyNames (Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<String>();
        for(java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) emptyNames.add(pd.getName());
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
	//忽视null值问题复制
    public static void copyPropertiesIgnoreNull(Object src, Object target){
        BeanUtils.copyProperties(src, target, getNullPropertyNames(src));
    }
	public static void main(String[] args) {
		
	}
}
