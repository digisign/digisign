package Database;

import java.util.List;

public interface CourseRepository {

	List<Course> findAllCourse();

	void insertCourse(Course course);
}
