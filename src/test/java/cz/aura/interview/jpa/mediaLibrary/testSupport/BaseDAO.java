package cz.aura.interview.jpa.mediaLibrary.testSupport;

public interface BaseDAO {

	void executeUpdate(String sql, Object... params);

}
