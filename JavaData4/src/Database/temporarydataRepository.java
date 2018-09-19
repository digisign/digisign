package Database;

import java.sql.SQLException;
import java.util.List;

public interface temporarydataRepository {
	
	
	List<TemporayCourseSubject> findAlltemporaryCS();

	void inserttemporaryCS(TemporayCourseSubject temporarycs);


	
}
