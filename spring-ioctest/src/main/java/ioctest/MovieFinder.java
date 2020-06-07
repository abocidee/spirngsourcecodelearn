package ioctest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MovieFinder {
	@Autowired
	private Test2 test2;
}
