//$Id: CollectionInterceptor.java 7700 2005-07-30 05:02:47Z oneovthafew $
package mapping.interceptor;

import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class CollectionInterceptor extends EmptyInterceptor {

	public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, Type[] types) {
		( (User) entity ).getActions().add("updated"); //$NON-NLS-1$
		return false;
	}

	public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types) {
		( (User) entity ).getActions().add("created"); //$NON-NLS-1$
		return false;
	}

}
