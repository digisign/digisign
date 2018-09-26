package Database;

import java.util.List;

public interface ContactRepository {
	
  

	List<Contact> findAllContact();

	void insertContact(Contact contact);

	
	

}
