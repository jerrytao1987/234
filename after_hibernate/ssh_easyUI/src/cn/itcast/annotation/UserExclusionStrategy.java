package cn.itcast.annotation;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;

public class UserExclusionStrategy implements ExclusionStrategy {
	
	private final Class<?> typeToExclude;
	
	public UserExclusionStrategy(Class<?> typeToExclude) {
		this.typeToExclude = typeToExclude;
	}

	@Override
	public boolean shouldSkipField(FieldAttributes f) {
		
		return f.getAnnotation(MyExclude.class) != null;
	}

	@Override
	public boolean shouldSkipClass(Class<?> clazz) {
		// TODO Auto-generated method stub
		return (clazz == typeToExclude);
	}

}
