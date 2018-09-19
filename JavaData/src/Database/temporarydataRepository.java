package Database;

import java.util.List;

public interface temporarydataRepository {
	
	List<temporarydata> findAlltemporarydata();

	void inserttemporarydata(temporarydata temporarydata);



	
}
