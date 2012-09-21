package chap12;

import chap9.StoneObject.AccessException;

public class OptStoneObject {
	public static class AccesExceptino extends Exception {}
	protected OptClassInfo classInfo;
	protected Object[] fields;
	public OptStoneObject(OptClassInfo ci, int size) {
		classInfo = ci;
		fields = new Object[size];
	}
	public Object read(String name) throws AccessException {
		Integer i = classInfo.fieldIndex(name);
		if (i != null)
			return fields[i];
		else {
			i = classInfo.methodIndex(name);
			if (i != null)
				return method(i);
		}
		throw new AccessException();
	}
	public void write(String name, Object value) throws AccessException {
		Integer i = classInfo.fieldIndex(name);
		if (i == null)
			throw new AccessException();
		else
			fields[i] = value;
	}
	public Object read(int index) {
		return fields[index];
	}
	public void write(int index, Object value) {
		fields[index] = value;
	}
	public Object method(int index) {
		return classInfo.method(this, index);
	}
}