package cz.aura.interview.jpa.mediaLibrary.testSupport;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class JPABaseDAOImpl implements BaseDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void executeUpdate(final String sql, final Object... params) {
		final Query query = entityManager.createQuery(sql);
		setUpParams(query, params);
		query.executeUpdate();
	}

	private void setUpParams(final Query query, final Object... params) {
		int index = 1;
		for (final Object object : params) {
			query.setParameter(index, object);
			index++;
		}
	}


}
