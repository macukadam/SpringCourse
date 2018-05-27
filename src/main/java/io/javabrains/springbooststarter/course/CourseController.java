package io.javabrains.springbooststarter.course;
 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbooststarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value="/topics/{id}/courses", method= RequestMethod.GET)
	public List<Course> getAllCoursees(@PathVariable String id) {
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping(value="/topics/{topicid}/courses/{id}", method= RequestMethod.GET)
	public Course getCourse(@PathVariable String id) {
		return courseService.getCourse(id);
	}
	
	@RequestMapping(value="/topics/{topicid}/courses", method=RequestMethod.POST)
	public void addCourse(@RequestBody Course course, @PathVariable String topicid) {
		course.setTopic(new Topic(topicid,"",""));
		courseService.addCourse(course);
	}
	
	@RequestMapping(value="/topics/{topicid}/courses/{id}", method=RequestMethod.POST)
	public void updateCourse(@PathVariable String topicid, @RequestBody Course course) {
		course.setTopic(new Topic(topicid,"",""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(value="/topics/{topicid}/courses/{id}", method=RequestMethod.DELETE)
	public void deleteCourse(@PathVariable String id) {
		courseService.deleteCourse(id);
	}
}	